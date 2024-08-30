import java.util.Scanner;
import java.util.regex.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        // Currently runs on args, so make sure to configure args before running.
        // If you want to manually input the SSN un-comment the lines 15, 16, 17
        // and comment line 13
        String ssn = args[0];

        // Scanner scanner = new Scanner(System.in); // Create my scanner
        // System.out.printf("Enter SSN, YYYYMMDD-XXXX: ");
        // String ssn = scanner.nextLine();

        if(!ssn.contains("-") || ssn.length() != 13) {
            System.out.println("Wrong format");
        }
        String[] a = ssn.split("-");
        String a1 = a[0];
        String a2 = a[1];
        System.out.println(gender(a2) + ", age: " + age(a1));
    }

    public static int age(String a) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate birthdate = LocalDate.parse(a, formatter);
        LocalDate currentDate = LocalDate.now();
        int age = calculateAge(birthdate, currentDate);
        return age; 
    }

    public static int calculateAge(LocalDate birthdate, LocalDate currentDate) {
        if ((birthdate != null) && (currentDate != null)) {
            return Period.between(birthdate, currentDate).getYears();
        } else {
            return 0;
        }
    }

    public static String gender(String a) {
        String gender;
        char thirdLetter = a.charAt(2);
        int digit = thirdLetter - '0';
        if (digit % 2 == 0) {
            gender = "Female";
        } else {
            gender = "Male";
        }
        return gender;
    }
}