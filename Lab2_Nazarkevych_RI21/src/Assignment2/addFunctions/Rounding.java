package Assignment2.addFunctions;

import java.math.BigDecimal;

public class Rounding {
    private Rounding() {}

    public static BigDecimal roundNumber(double number) {
        BigDecimal result = new BigDecimal(number);
        result = result.setScale(2, BigDecimal.ROUND_HALF_UP);
        return result;
    }


}
