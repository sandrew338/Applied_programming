import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Hotel {
    private List<Cottage> cottages = new ArrayList<>();
    private List<Facility> hotelFacilities = new ArrayList<>();
    private double income = 0;
    private double expenses = 0;

    public void addFacilityToHotel(Facility facility) {
        hotelFacilities.add(facility);
    }

    public void addCottage(Cottage cottage) {
        cottages.add(cottage);
    }


    public void bookCottage(String client, Cottage cottage, String startDate, String endDate) throws BookingConflictException {
        if (!cottage.isAvailable(startDate, endDate)) {
            throw new BookingConflictException("Cottage is already booked for the selected dates.");
        }
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        Booking booking = new Booking(cottage, client, start, end);
        cottage.addBooking(booking);
        income += booking.calculateTotalCost();
    }

    public List<Facility> getAmenitiesInfo(Cottage cottage) {
        List<Facility> allFacilities = new ArrayList<>(cottage.getFacilities());
        allFacilities.addAll(hotelFacilities);
        return allFacilities;
    }

    public double calculateRevenueAndExpenses() {
        expenses = hotelFacilities.stream().mapToDouble(Facility::getCost).sum()
                + cottages.stream()
                .flatMap(c -> c.getFacilities().stream())
                .mapToDouble(Facility::getCost)
                .sum();
        double profit = income - expenses;

        return income - expenses;
    }

    public List<Cottage> getCottagesByFacility(String filter) {
        return cottages.stream()
                .filter(cottage ->
                        cottage.getFacilities().stream().anyMatch(f -> f.getName().equals(filter)))
                .collect(Collectors.toList());
    }

    public List<Cottage> getCottagesByCategory(String filter) {
        return cottages.stream()
                .filter(cottage -> cottage.getCategory().equals(filter))
                .collect(Collectors.toList());
    }

    public double getIncome() {
        return income;
    }

    public double getExpenses() {
        calculateRevenueAndExpenses();
        return expenses;
    }
    public double getProfit() {
        return income - expenses;
    }
}