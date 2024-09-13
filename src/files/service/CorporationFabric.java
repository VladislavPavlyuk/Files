package files.service;

import files.models.Corporation;

import java.util.Scanner;

public class CorporationFabric {
    public static void createCorporation() {

        Corporation corporation = new Corporation();
        corporation.loadEmployees();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. Edit Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Search Employee by Last Name");
            System.out.println("5. Display Employees by Age or Last Name Initial");
            System.out.println("6. Save and Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    corporation.addEmployee(scanner);
                    break;
                case 2:
                    corporation.editEmployee(scanner);
                    break;
                case 3:
                    corporation.deleteEmployee(scanner);
                    break;
                case 4:
                    corporation.searchEmployee(scanner);
                    break;
                case 5:
                    corporation.displayEmployees(scanner);
                    break;
                case 6:
                    corporation.saveEmployees();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
        }
    }
}
}
