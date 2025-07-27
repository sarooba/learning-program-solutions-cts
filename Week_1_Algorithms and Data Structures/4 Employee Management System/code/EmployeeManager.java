package com.company.inventory;

public class EmployeeManager {
    private final Employee[] employees;
    private int count;

    public EmployeeManager(int capacity) {
        employees = new Employee[capacity];
        count = 0;
    }

    public boolean addEmployee(Employee e) {
        if (count >= employees.length) return false;
        employees[count++] = e;
        return true;
    }

    public Employee searchById(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == id) return employees[i];
        }
        return null;
    }

    public boolean deleteById(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == id) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                return true;
            }
        }
        return false;
    }

    public void listEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public int getCount() {
        return count;
    }
}
