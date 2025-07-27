package com.company.inventory;

public class TaskManagerDemo {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        taskList.addTask(new Task(1, "Design Homepage", "Pending"));
        taskList.addTask(new Task(2, "Fix Login Bug", "In Progress"));
        taskList.addTask(new Task(3, "Deploy Release", "Completed"));

        System.out.println("All Tasks:");
        taskList.traverseTasks();

        System.out.println("\nSearching for Task ID 2:");
        Task found = taskList.searchTask(2);
        System.out.println(found != null ? found : "Not found");

        System.out.println("\nDeleting Task ID 1...");
        boolean deleted = taskList.deleteTask(1);
        System.out.println("Deleted: " + deleted);

        System.out.println("\nRemaining Tasks:");
        taskList.traverseTasks();
    }
}
