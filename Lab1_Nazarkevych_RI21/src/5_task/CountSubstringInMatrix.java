public class CountSubstringInMatrix {
    public static void main(String[] args) {
        final String word = "apple";
        String matrix[][] = {{"apple", "pearson"},
                {"pear", "applepie"},
                {"wheat", "computer"}};
        System.out.println("The count of the word " + word + " is " + countSubstringInMatrix(matrix, word));
    }

    public static int countSubstringInMatrix(String[][] matrix, String regex) {
        var counter = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].contains(regex)) {
                    ++counter;
                }
            }
        }
        return counter;
    }
}
