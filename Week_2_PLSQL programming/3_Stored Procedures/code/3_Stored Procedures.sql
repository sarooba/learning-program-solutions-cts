-- Enable output
SET SERVEROUTPUT ON;

-- Drop tables if they exist
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE Transactions';
  EXECUTE IMMEDIATE 'DROP TABLE Accounts';
  EXECUTE IMMEDIATE 'DROP TABLE Loans';
  EXECUTE IMMEDIATE 'DROP TABLE Customers';
  EXECUTE IMMEDIATE 'DROP TABLE Employees';
EXCEPTION
  WHEN OTHERS THEN NULL;
END;
/

-- 1. Create Tables

CREATE TABLE Customers (
  CustomerID NUMBER PRIMARY KEY,
  Name VARCHAR2(100),
  DOB DATE,
  Balance NUMBER,
  LastModified DATE
);

CREATE TABLE Accounts (
  AccountID NUMBER PRIMARY KEY,
  CustomerID NUMBER,
  AccountType VARCHAR2(20),
  Balance NUMBER,
  LastModified DATE,
  FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Transactions (
  TransactionID NUMBER PRIMARY KEY,
  AccountID NUMBER,
  TransactionDate DATE,
  Amount NUMBER,
  TransactionType VARCHAR2(10),
  FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);

CREATE TABLE Loans (
  LoanID NUMBER PRIMARY KEY,
  CustomerID NUMBER,
  LoanAmount NUMBER,
  InterestRate NUMBER,
  StartDate DATE,
  EndDate DATE,
  FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Employees (
  EmployeeID NUMBER PRIMARY KEY,
  Name VARCHAR2(100),
  Position VARCHAR2(50),
  Salary NUMBER,
  Department VARCHAR2(50),
  HireDate DATE
);

-- 2. Insert Sample Data

INSERT INTO Customers VALUES (1, 'John Doe', TO_DATE('1985-05-15', 'YYYY-MM-DD'), 1000, SYSDATE);
INSERT INTO Customers VALUES (2, 'Jane Smith', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 1500, SYSDATE);

INSERT INTO Accounts VALUES (1, 1, 'Savings', 1000, SYSDATE);
INSERT INTO Accounts VALUES (2, 2, 'Checking', 1500, SYSDATE);

INSERT INTO Transactions VALUES (1, 1, SYSDATE, 200, 'Deposit');
INSERT INTO Transactions VALUES (2, 2, SYSDATE, 300, 'Withdrawal');

INSERT INTO Loans VALUES (1, 1, 5000, 5, SYSDATE, ADD_MONTHS(SYSDATE, 60));

INSERT INTO Employees VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', TO_DATE('2015-06-15', 'YYYY-MM-DD'));
INSERT INTO Employees VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', TO_DATE('2017-03-20', 'YYYY-MM-DD'));

-- 3. Create Sequence for Transactions
BEGIN
  EXECUTE IMMEDIATE 'DROP SEQUENCE Transactions_seq';
EXCEPTION
  WHEN OTHERS THEN NULL;
END;
/

CREATE SEQUENCE Transactions_seq START WITH 3 INCREMENT BY 1;

-- 4. Procedure: ProcessMonthlyInterest

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
  FOR acc IN (
    SELECT AccountID, Balance FROM Accounts WHERE AccountType = 'Savings'
  ) LOOP
    UPDATE Accounts
    SET Balance = Balance + (acc.Balance * 0.01),
        LastModified = SYSDATE
    WHERE AccountID = acc.AccountID;

    INSERT INTO Transactions
    VALUES (
      Transactions_seq.NEXTVAL, acc.AccountID, SYSDATE,
      acc.Balance * 0.01, 'Interest'
    );

    DBMS_OUTPUT.PUT_LINE('Interest added to Account ' || acc.AccountID);
  END LOOP;
END;
/

-- 5. Procedure: UpdateEmployeeBonus

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
  p_dept IN VARCHAR2,
  p_bonus_percent IN NUMBER
) AS
BEGIN
  FOR emp IN (
    SELECT EmployeeID, Salary FROM Employees WHERE Department = p_dept
  ) LOOP
    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus_percent / 100)
    WHERE EmployeeID = emp.EmployeeID;

    DBMS_OUTPUT.PUT_LINE('Bonus updated for Employee ' || emp.EmployeeID);
  END LOOP;
END;
/

-- 6. Procedure: TransferFunds

CREATE OR REPLACE PROCEDURE TransferFunds (
  p_from_account IN NUMBER,
  p_to_account IN NUMBER,
  p_amount IN NUMBER
) AS
  v_balance NUMBER;
BEGIN
  SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_from_account FOR UPDATE;

  IF v_balance < p_amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance');
  END IF;

  UPDATE Accounts
  SET Balance = Balance - p_amount, LastModified = SYSDATE
  WHERE AccountID = p_from_account;

  UPDATE Accounts
  SET Balance = Balance + p_amount, LastModified = SYSDATE
  WHERE AccountID = p_to_account;

  INSERT INTO Transactions VALUES (Transactions_seq.NEXTVAL, p_from_account, SYSDATE, -p_amount, 'Transfer');
  INSERT INTO Transactions VALUES (Transactions_seq.NEXTVAL, p_to_account, SYSDATE, p_amount, 'Transfer');

  DBMS_OUTPUT.PUT_LINE('Transferred ' || p_amount || ' from Account ' || p_from_account || ' to ' || p_to_account);
END;
/

-- 7. Call the Procedures and Show Output

BEGIN
  -- Apply 1% interest to savings
  ProcessMonthlyInterest;

  -- Give 10% bonus to IT department
  UpdateEmployeeBonus('IT', 10);

  -- Transfer ₹500 from Account 2 to Account 1
  TransferFunds(2, 1, 500);
END;
/

-- 8. Show Final Balances (optional)
BEGIN
  FOR acc IN (SELECT AccountID, Balance FROM Accounts) LOOP
    DBMS_OUTPUT.PUT_LINE('Account ' || acc.AccountID || ' has balance: ' || acc.Balance);
  END LOOP;

  FOR emp IN (SELECT EmployeeID, Name, Salary FROM Employees) LOOP
    DBMS_OUTPUT.PUT_LINE('Employee ' || emp.EmployeeID || ' (' || emp.Name || ') has salary: ' || emp.Salary);
  END LOOP;
END;
/
