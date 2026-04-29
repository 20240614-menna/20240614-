import java.util.Scanner;

public class MainMVC {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== Employee System (MVC) =====");

        // ===== Store =====
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        Employee model = new Employee(id, name, email);
        EmployeeView view = new EmployeeView();
        EmployeeController controller =
                new EmployeeController(model, view);

        boolean running = true;

        while (running) {

            System.out.println("\n========== MENU ==========");
            System.out.println("1. Display Employee");
            System.out.println("2. Edit Employee");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                // ===== Display =====
                case 1:
                    System.out.println("\n--- Employee Data ---");
                    controller.view();
                    break;

                // ===== Edit =====
                case 2:
                    char again;

                    do {
                        System.out.println("\nWhat do you want to edit?");
                        System.out.println("1. ID");
                        System.out.println("2. Name");
                        System.out.println("3. Email");
                        System.out.print("Choose: ");

                        int option = sc.nextInt();
                        sc.nextLine();

                        switch (option) {
                            case 1:
                                System.out.print("Enter new ID: ");
                                int newId = sc.nextInt();
                                controller.setEmployeeId(newId);
                                break;

                            case 2:
                                System.out.print("Enter new Name: ");
                                String newName = sc.nextLine();
                                controller.setEmployeeName(newName);
                                break;

                            case 3:
                                System.out.print("Enter new Email: ");
                                String newEmail = sc.nextLine();
                                controller.setEmployeeEmail(newEmail);
                                break;

                            default:
                                System.out.println("Invalid choice");
                        }

                        // ===== Display After Edit =====
                        System.out.println("\nUpdated Data:");
                        controller.view();

                        System.out.print("\nEdit again? (y/n): ");
                        again = sc.next().charAt(0);
                        sc.nextLine();

                    } while (again == 'y' || again == 'Y');

                    break;

                case 3:
                    running = false;
                    System.out.println("\nThank you");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }

        sc.close();
    }
}
