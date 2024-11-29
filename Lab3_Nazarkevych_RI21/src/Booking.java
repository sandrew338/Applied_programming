import java.time.LocalDate;

class Booking {
    private Cottage cottage;
    private String user;
    private LocalDate startDate;
    private LocalDate endDate;

    public Booking(Cottage cottage, String client, LocalDate startDate, LocalDate endDate) {
        this.cottage = cottage;
        this.user = client;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public boolean overlaps(String startDate, String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return (start.isBefore(this.endDate) && end.isAfter(this.startDate));
    }

    public double calculateTotalCost() {
        boolean lowSeason = startDate.getMonthValue() == 11 || startDate.getMonthValue() == 3;
        double discount = lowSeason ? 0.8 : 1.0;
        return cottage.getBasePrice() * discount;
    }

    @Override
    public String toString() {
        return "Booking: " + user + " from " + startDate + " to " + endDate;
    }
}