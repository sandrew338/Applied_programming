//ASK: Can I make these classes from task 6 and 7 on the one level?

import java.util.Scanner;

public class CurrencyConverter {
    //ASK: Is it ok to write list of exceptions here?
    //or in another file
    static private final Exception e = new Exception("Use this example/n100 UAH into USD");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            //Here I am parsing input into numbers and currencies
            String[] input_array = input.split(" ");
            if (!input_array[2].equals("into"))
                throw e;

            double result = convertCurrency(input_array[1], input_array[3], Integer.parseInt(input_array[0]));
            System.out.println(result);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        scanner.close();
    }

    //This is a method which returns number converting one currency into another one
    public static double convertCurrency(String currencyFrom, String currencyTo, double number) throws Exception {
        //double result = -1;
        if (currencyTo == currencyFrom) {
            return number;
        }
        double result = switch (currencyFrom) {
            case "UAH": {
                if (currencyTo.equals("USD")) {
                    yield number / ConstCurrencies.USD_IN_UAH;
                }
                if (currencyTo.equals("CAN")) {
                    yield number / ConstCurrencies.CAN_IN_UAH;
                }
            }

            case "USD": {
                if (currencyTo.equals("UAH")) {
                    yield number * ConstCurrencies.USD_IN_UAH;
                }
                if (currencyTo.equals("CAN")) {
                    double USD_in_UAH = number * ConstCurrencies.USD_IN_UAH;
                    yield USD_in_UAH / ConstCurrencies.CAN_IN_UAH;
                }
            }
            case "CAN": {
                if (currencyTo.equals("UAH")) {
                    yield number * ConstCurrencies.CAN_IN_UAH;
                }
                if (currencyTo.equals("USD")) {
                    double CAN_in_UAH = number * ConstCurrencies.CAN_IN_UAH;
                    yield CAN_in_UAH / ConstCurrencies.USD_IN_UAH;
                }
            }
            default:
                yield -1;
        };
        if (result < 0) {
            throw e;
        } else {
            return result;
        }
    }

}
