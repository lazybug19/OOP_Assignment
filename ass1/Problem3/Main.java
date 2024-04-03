package Q3;

import java.io.IOException;
import java.util.Scanner;

class CustomException extends Exception {
    public CustomException(String msgString) {
        super(msgString);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            stringInput();
        } catch (IOException e) {
            System.out.println("Caught exception: " + e);
            Throwable ogCause = e.getCause();
            if (ogCause != null) {
                System.out.println("Original cause: " + ogCause);
            }
        }
    }

    public static void stringInput() throws IOException {
        Scanner input = new Scanner(System.in);
        String inputLine = input.nextLine();
        input.close();

        try {
            if (inputLine.contains(" ")) {
                throw new CustomException("String contains more than one word");
            } else if (inputLine.equals(inputLine.toUpperCase())) {
                throw new CustomException("String is all capital letters");
            } else if (inputLine.equals(inputLine.toLowerCase())) {
                throw new CustomException("String is all small letters");
            } else {
                System.out.println("Entered string: " + inputLine);
            }
        } catch (CustomException e) {
            IOException ioExcep = new IOException("Chained Exception: Wrong Input taken");
            ioExcep.initCause(e);
            throw ioExcep;
        }
    }
}
