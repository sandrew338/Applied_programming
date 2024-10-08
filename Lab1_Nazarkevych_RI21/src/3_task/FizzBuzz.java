//third problem
public class FizzBuzz {
    public static void main(String[] args) {
        final int MAX_NUMBER = 100;
//        while (number <= MAX_NUMBER) {
//            System.out.print(number + " ");
//            if (number % 3 == 0 && number % 5 == 0) {
//                System.out.println("FizzBuzz");
//            } else if (number % 3 == 0) {
//                System.out.println("Fizz");
//
//            } else if (number % 5 == 0) {
//                System.out.println("Buzz");
//
//            } else
//                System.out.println("");
//            number++;
//        }
        for (int number = 1; number <= MAX_NUMBER; number++) {
            if (number % 3 == 0) {
                System.out.println("Fizz");

            } else if (number % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(number);
            }
        }

    }
}