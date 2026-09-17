import java.util.regex.Pattern;

public class Login {

    private String registeredUsername;
    private String registeredPassword;
    private String registeredCellPhone;
    private String firstName;
    private String lastName;

    // Default Constructor
    public Login() {}

    // Method to check username: contains '_' and is <= 5 characters
    public boolean checkUserName(String username) {
        return username != null && username.contains("_") && username.length() <= 5;
    }

    // Method to check password complexity:
    // >= 8 chars, contains uppercase, digit, and special character
    public boolean checkPasswordComplexity(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }

        return hasUpper && hasDigit && hasSpecial;
    }

    // Method to check cell phone number using regular expressions:
    // International code (e.g. +27) followed by digits, total length <= 10 (excluding code) or formatted correctly
    // Regex matches + and international format: ^\+\d{1,3}\d{7,10}$
    public boolean checkCellPhoneNumber(String cellPhone) {
        // Attributed code: Regex for international phone number validation
        String cellRegex = "^\\+\\d{1,3}\\d{7,10}$";
        return cellPhone != null && Pattern.matches(cellRegex, cellPhone);
    }

    // Registers the user and returns appropriate status messaging
    public String registerUser(String username, String password, String cellPhone, String firstName, String lastName) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber(cellPhone)) {
            return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        }

        // Save details if all validations pass
        this.registeredUsername = username;
        this.registeredPassword = password;
        this.registeredCellPhone = cellPhone;
        this.firstName = firstName;
        this.lastName = lastName;

        return "Username successfully captured.\nPassword successfully captured.\nCell number successfully added.";
    }

    // Verifies login credentials against stored details
    public boolean loginUser(String username, String password) {
        return username != null && password != null &&
               username.equals(this.registeredUsername) && 
               password.equals(this.registeredPassword);
    }

    // Returns the login status messaging
    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            return "Welcome " + firstName + " ," + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    // Getters for testing/verification
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
}