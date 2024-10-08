//first problem
public class Converter {
    public static void main(String[] args) {

        System.out.println(convert(123456789));

    }

    public static String convert(int number) {
        String result = "";
        while (number != 0) {
            if (number % 2 == 0)//check if the last digit is pair
            {
                result = '0' + result;//add zero before whole result
            } else {
                result = '1' + result;//add one before whole result
            }
            number /= 2;
        }
        return result;
    }




}
