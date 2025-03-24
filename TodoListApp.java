import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String taskName;
    boolean isCompleted;

    public Task(String taskName) {
        this.taskName = taskName;
        this.isCompleted = false;
    }

    @Override
    public String toString() {
        return taskName + " - " + (isCompleted ? "Completed" : "Not Completed");
    }
}

class TaskManager {
    private ArrayList<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(String taskName) {
        tasks.add(new Task(taskName));
    }

    public void markTaskCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).isCompleted = true;
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i + ". " + tasks.get(i));
            }
        }
    }
}

public class TodoListApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        int choice;

        do {
            System.out.println("\nTo-Do List Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. Remove Task");
            System.out.println("4. List All Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter task name: ");
                    String taskName = scanner.nextLine();
                    taskManager.addTask(taskName);
                    break;
                case 2:
                    taskManager.listTasks();
                    System.out.print("Enter task index to mark as completed: ");
                    int indexComplete = scanner.nextInt();
                    taskManager.markTaskCompleted(indexComplete);
                    break;
                case 3:
                    taskManager.listTasks();
                    System.out.print("Enter task index to remove: ");
                    int indexRemove = scanner.nextInt();
                    taskManager.removeTask(indexRemove);
                    break;
                case 4:
                    taskManager.listTasks();
                    break;
                case 5:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
