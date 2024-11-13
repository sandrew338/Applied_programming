import java.util.*;
import java.util.stream.Collectors;

class Cottage {
    private String category;
    private int maxGuests;
    private double basePrice;
    private List<Facility> facilities = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public Cottage(String category, int maxGuests, double basePrice) {
        this.category = category;
        this.maxGuests = maxGuests;
        this.basePrice = basePrice;
    }

    public void addFacility(Facility facility) {
        facilities.add(facility);
    }

    public List<Facility> getFacilities() {
        return facilities;
    }

    public int getMaxGuests() {
        return maxGuests + facilities.stream().mapToInt(Facility::getGuestIncrease).sum();
    }

    public boolean isAvailable(String startDate, String endDate) {
        return bookings.stream().noneMatch(b -> b.overlaps(startDate, endDate));
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public List<String> getAvailableDates() {
        return bookings.stream().map(Booking::toString).collect(Collectors.toList());
    }

    public double getBasePrice() {
        return basePrice;
    }

    public String getCategory() {
        return category;
    }
}