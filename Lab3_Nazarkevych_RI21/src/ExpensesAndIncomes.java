import java.time.LocalDate;


class ExpensesAndIncomes {
    private double totalIncomes = 0;
    private double totalExpenses = 0;

    public void addRevenue(double amount) {
        totalIncomes += amount;
    }

    public void addExpense(double amount) {
        totalExpenses += amount;
    }

    public double getTotalIncomes() {
        return totalIncomes;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public double calculateProfit() {
        return totalIncomes - totalExpenses;
    }

    public double applySeasonalDiscount(double price, LocalDate date) {
        int month = date.getMonthValue();
        if (month == 3 || month == 11) {
            return price * 0.8;
        }
        return price;
    }
}