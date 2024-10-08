//fourth problem

import java.util.Scanner;

public class CountOfSymbols {

    public static void main(String[] args) {
        int index = 0, indexForArray = 0;
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        PairOfValues[] listPairOfValues = new PairOfValues[input.length()];
        while (!input.isEmpty()) {
            int count = 0;
            char workingChar = input.charAt(0);
            index = input.indexOf(workingChar);

            while (index >= 0) {
                count++;
                index = input.indexOf(workingChar, index);
                input = input.replaceFirst(Character.toString(workingChar), "");


            }

            PairOfValues pair = new PairOfValues(workingChar, count-1);
            listPairOfValues[indexForArray] = pair;
            indexForArray++;


        }
        scanner.close();
        int i = 0;
        while (listPairOfValues[i] != null) {
            System.out.println(listPairOfValues[i].toString());
            i++;
        }
    }
}
