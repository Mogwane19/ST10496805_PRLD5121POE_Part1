import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login loginSystem = new Login();

        System.out.println("=== USER REGISTRATION ===");
        
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        System.out.print("Enter Cell Phone Number (e.g. +27838968976): ");
        String cellPhone = scanner.nextLine();

        // Attempt Registration
        String registrationResult = loginSystem.registerUser(username, password, cellPhone, firstName, lastName);
        System.out.println("\n" + registrationResult);

        // Perform login if registration requirements met
        if (loginSystem.checkUserName(username) && loginSystem.checkPasswordComplexity(password) && loginSystem.checkCellPhoneNumber(cellPhone)) {
            System.out.println("\n=== USER LOGIN ===");
            System.out.print("Enter Username: ");
            String loginUsername = scanner.nextLine();

            System.out.print("Enter Password: ");
            String loginPassword = scanner.nextLine();

            boolean isAuthenticated = loginSystem.loginUser(loginUsername, loginPassword);
            System.out.println(loginSystem.returnLoginStatus(isAuthenticated));
        }

        scanner.close();
    }
}