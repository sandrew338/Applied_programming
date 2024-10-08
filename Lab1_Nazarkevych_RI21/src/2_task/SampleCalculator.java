//second problem

import java.util.Scanner;

public class SampleCalculator {

    public static void main(String[] args) {
        //ASK: Where to use try catch?
        //it works without it
        Scanner scanner = new Scanner(System.in);
        try {

            String expression = scanner.nextLine();
            System.out.println(calculate(expression));
         } catch (Exception e) {
           System.err.println("You can use such templates \n2 + 4 = ?, \n2 + 4 = , \n2 + 4.");

        }
        finally {
            scanner.close();
        }
    }

    public static String calculate(String expression) {
        String[] arrayWithOperands = expression.split(" ");
        int result_number = countWithOperator(arrayWithOperands);

        char last_char = expression.charAt(expression.length() - 1);
        if (last_char >= 48 && last_char <= 57) {
            return expression + " = " + result_number;
        } else if (last_char == '=' || last_char == '?') {
            return expression.substring(0, expression.length() - 1) + "= " + result_number;
        } else {
            throw new RuntimeException("Valid expression");
        }
    }

    public static int countWithOperator(String[] result) {
        int result_number;
        switch (result[1]) {
            case "+":
                result_number = Integer.parseInt(result[0]) + Integer.parseInt(result[2]);
                break;
            case "-":
                result_number = Integer.parseInt(result[0]) - Integer.parseInt(result[2]);
                break;
            case "*":
                result_number = Integer.parseInt(result[0]) * Integer.parseInt(result[2]);
                break;
            case "/":
                if (Integer.parseInt(result[2]) == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                result_number = Integer.parseInt(result[0]) / Integer.parseInt(result[2]);
                break;
            default:
                throw new RuntimeException("Invalid operator");
        }
        return result_number;
    }
}
