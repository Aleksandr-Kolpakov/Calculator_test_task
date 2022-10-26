import java.util.Scanner;

public class Main {

    //-----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) throws ExecutionErrors {
        System.out.println(ExecutionErrors.startMessage);
        String input = new Scanner(System.in).nextLine().toUpperCase().trim();

        System.out.println(calc(input));
    }



    public static String calc(String input) throws ExecutionErrors {
        Calculator calculator = new Calculator(input);
        return calculator.getResult();
    }



}