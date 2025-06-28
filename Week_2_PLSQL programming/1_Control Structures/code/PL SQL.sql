-- Enable output
SET SERVEROUTPUT ON;

-- Drop tables if they exist
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE Loans';
  EXECUTE IMMEDIATE 'DROP TABLE Customers';
EXCEPTION
  WHEN OTHERS THEN
    NULL;
END;
/

-- Create Customers table
CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE,
    IsVIP CHAR(1)
);

-- Create Loans table
CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER,
    InterestRate NUMBER,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

-- Insert sample customers
BEGIN
  INSERT INTO Customers VALUES (1, 'John Doe', TO_DATE('1950-05-15', 'YYYY-MM-DD'), 12000, SYSDATE, NULL);
  INSERT INTO Customers VALUES (2, 'Jane Smith', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 8000, SYSDATE, NULL);
END;
/

-- Insert sample loans
BEGIN
  INSERT INTO Loans VALUES (1, 1, 5000, 5, SYSDATE, SYSDATE + 20); -- Due soon
  INSERT INTO Loans VALUES (2, 2, 8000, 6, SYSDATE, ADD_MONTHS(SYSDATE, 6)); -- Not due soon
END;
/

-- PL/SQL block to print reminders for loans due in next 30 days
BEGIN
  FOR loan IN (
    SELECT l.LoanID, c.Name, l.EndDate
    FROM Loans l
    JOIN Customers c ON l.CustomerID = c.CustomerID
    WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE(
      'Reminder: Loan ' || loan.LoanID || 
      ' for ' || loan.Name || 
      ' is due on ' || TO_CHAR(loan.EndDate, 'DD-MON-YYYY')
    );
  END LOOP;
END;
/
