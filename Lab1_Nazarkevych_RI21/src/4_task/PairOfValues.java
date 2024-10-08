public class PairOfValues {
    private char symbol;
    private int count;

    public PairOfValues(char symbol, int count) {
        this.symbol = symbol;
        this.count = count;
    }

    @Override
    public String toString() {
        return "PairOfValues [symbol=" + symbol + ", count=" + count + "]";
    }

}
