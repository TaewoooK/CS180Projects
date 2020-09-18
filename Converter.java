import java.util.Scanner;

/**
 * A program used for converting decimal numbers to binary numbers (two's complement).
 *
 * <p>Purdue University -- CS18000 -- Fall 2020 -- Live Coding</p>
 *
 * @author Logan Kulinski, lbk@purdue.edu
 * @version September 18, 2020
 * 
 * */
public final class Converter {
    /**
     * Prompts the user for the decimal number to convert, then displays it in binary (two's complement).
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner;
        int number;
        int absoluteValue;
        StringBuilder stringBuilder;
        int remainder;
        int base = 2;
        int multiple = 8;

        scanner = new Scanner(System.in);

        System.out.print("Enter a decimal number: ");

        while (!scanner.hasNextInt()) {
            if (!scanner.hasNextLine()) {
                return;
            } //end if

            System.out.println();

            System.out.println("Error: Invalid decimal number!");

            System.out.println();

            System.out.print("Enter a decimal number: ");

            scanner.nextLine();
        } //end while

        number = scanner.nextInt();

        absoluteValue = Math.abs(number);

        stringBuilder = new StringBuilder();

        while (absoluteValue != 0) {
            remainder = absoluteValue % base;

            stringBuilder.insert(0, remainder);

            absoluteValue /= base;
        } //end while

        if (stringBuilder.length() == 0) {
            stringBuilder.append("0");
        } //end if

        if (number < 0) {
            char bit;

            for (int i = 0; i < stringBuilder.length(); i++) {
                bit = stringBuilder.charAt(i);

                if (bit == '0') {
                    stringBuilder.setCharAt(i, '1');
                } else {
                    stringBuilder.setCharAt(i, '0');
                } //end if
            } //end for

            for (int i = stringBuilder.length() - 1; i >= 0; i--) {
                bit = stringBuilder.charAt(i);

                if (bit == '0') {
                    stringBuilder.setCharAt(i, '1');

                    break;
                } else {
                    stringBuilder.setCharAt(i, '0');
                } //end if
            } //end for

            if (stringBuilder.charAt(0) == '0') {
                stringBuilder.insert(0, '1');
            } //end if

            while ((stringBuilder.length() % multiple) != 0) {
                stringBuilder.insert(0, '1');
            } //end while
        } else {
            if (stringBuilder.charAt(0) == '1') {
                stringBuilder.insert(0, '0');
            } //end if

            while ((stringBuilder.length() % multiple) != 0) {
                stringBuilder.insert(0, '0');
            } //end while
        } //end if

        System.out.printf("(%d)_10 = (%s)_2%n", number, stringBuilder);
    } //main
}
