package com.company.inventory;

public class EmployeeSystemDemo {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(10);

        manager.addEmployee(new Employee(1, "Alice", "Manager", 60000));
        manager.addEmployee(new Employee(2, "Bob", "Engineer", 45000));
        manager.addEmployee(new Employee(3, "Charlie", "Analyst", 40000));

        System.out.println("All Employees:");
        manager.listEmployees();

        System.out.println("\nSearching for Employee ID 2:");
        Employee found = manager.searchById(2);
        System.out.println(found != null ? found : "Not found");

        System.out.println("\nDeleting Employee ID 1...");
        boolean deleted = manager.deleteById(1);
        System.out.println("Deleted: " + deleted);

        System.out.println("\nEmployees after deletion:");
        manager.listEmployees();
    }
}
