package read;

import entity.Guest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputService {

    public static final String NAME_OPERATION = "n";
    public static final String LAST_NAME_OPERATION = "l";
    public static final String FIRST_NAME_OPERATION = "f";
    public static final String PHONE_OPERATION = "p";
    public static final String EMAIL_OPERATION = "e";
    public static final String UNKNOWN_OPERATION = "-1";

    private Scanner scanner = new Scanner(System.in);

    public Guest readGuest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("We are adding a new guest...");
        System.out.println("Enter the last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter the first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter the e-mail address: ");
        String email = scanner.nextLine();
        System.out.println("Enter the phone number (format = +407xx xxx xxx)");
        String phoneNumber = scanner.nextLine();
        return new Guest(lastName, firstName, email, phoneNumber);
    }

    public Operation readOperationWithSplitName() {
        System.out.println("Type '" + LAST_NAME_OPERATION + "'" +
                " for last name '" + FIRST_NAME_OPERATION + "'" +
                " for first name, '" + PHONE_OPERATION + "'" +
                " for phone number or '" + EMAIL_OPERATION + "'" +
                " for e-mail address: ");
        String option = scanner.nextLine();
        switch (option) {
            case LAST_NAME_OPERATION:
                System.out.println("Enter the new last name: ");
                String lastName = scanner.nextLine();
                return new Operation(LAST_NAME_OPERATION, buildParameters(lastName));
            case FIRST_NAME_OPERATION:
                System.out.println("Enter the new first name: ");
                String firstName = scanner.nextLine();
                return new Operation(FIRST_NAME_OPERATION, buildParameters(firstName));
            case EMAIL_OPERATION:
                System.out.println("Enter the new e-mail address: ");
                String email = scanner.nextLine();
                return new Operation(EMAIL_OPERATION, buildParameters(email));
            case PHONE_OPERATION:
                System.out.println("Enter the new phone number: ");
                String phoneNumber = scanner.nextLine();
                return new Operation(PHONE_OPERATION, buildParameters(phoneNumber));
            default:
                return new Operation(UNKNOWN_OPERATION, null);

        }
    }

    public Operation readOperation() {
        System.out.println("Type '" + NAME_OPERATION + "'" +
                " for last name and first name, '" + PHONE_OPERATION + "'" +
                " for phone number or '" + EMAIL_OPERATION + "'" +
                " for e-mail address: ");
        String option = scanner.nextLine();
        switch (option) {
            case NAME_OPERATION:
                System.out.println("Enter the last name: ");
                String lastName = scanner.nextLine();
                System.out.println("Enter the first name: ");
                String firstName = scanner.nextLine();
                return new Operation(NAME_OPERATION, buildParameters(lastName, firstName));
            case EMAIL_OPERATION:
                System.out.println("Enter the e-mail address: ");
                String email = scanner.nextLine();
                return new Operation(EMAIL_OPERATION, buildParameters(email));
            case PHONE_OPERATION:
                System.out.println("Enter the phone number: ");
                String phoneNumber = scanner.nextLine();
                return new Operation(PHONE_OPERATION, buildParameters(phoneNumber));
            default:
                return new Operation(UNKNOWN_OPERATION, null);

        }
    }


    private List<String> buildParameters(String... args) {
        return new ArrayList<>(Arrays.asList(args));
    }
}
