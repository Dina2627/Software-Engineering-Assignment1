import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner num = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();
        int choice;

        while (true){

            System.out.println("-------------Menu--------------");
            System.out.println("1.Add Task");
            System.out.println("2.Show task");
            System.out.println("3.Edit task");
            System.out.println("4.Delete task");
            System.out.println("0.Exit");
            System.out.println("Enter your choice(0/1/2/3/4)\n");

             int f = num.nextInt();
             num.nextLine();

            switch(f){
                case 1:
                    System.out.println("Enter the task to add");
                    String task = num.nextLine();
                    tasks.add(task);
                    System.out.println("Task added: "+ task);
                    break;
                case 2:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks yet!");
                    } else {
                        System.out.println("\nYour Tasks:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i+1) + ". " + tasks.get(i));
                        }
                    }
                    break;
                case 3:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks to edit!");
                    } else {
                        System.out.println("\nYour Tasks:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i+1) + ". " + tasks.get(i));
                        }

                        System.out.print("Enter task number to edit: ");
                        int number = num.nextInt();
                        num.nextLine();

                        if (number > 0 && number <= tasks.size()) {
                            System.out.print("Enter new task: ");
                            String newTask = num.nextLine();
                            tasks.set(number-1, newTask);
                            System.out.println("Edited!");
                        } else {
                            System.out.println("Invalid number!");
                        }
                    }
                    break;

                case 4:
                    if (tasks.isEmpty()) {
                        System.out.println("📭 No tasks to delete!");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i+1) + ". " + tasks.get(i));
                        }
                        System.out.print("Enter task number to delete: ");
                        int number = num.nextInt();
                        num.nextLine();

                        if (number > 0 && number <= tasks.size()) {
                            tasks.remove(number-1);
                            System.out.println("Deleted!");
                        } else {
                            System.out.println("Invalid number!");
                        }
                    }
                    break;
                case 0:
                    System.out.println("Exit");
                    num.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }

        }

    }
}
