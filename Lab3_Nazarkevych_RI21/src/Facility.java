class Facility {
    private String name;
    private String type; // "cottage" або "hotel"
    private double cost;
    private int guestIncrease;

    public Facility(String name, String type, double cost, int guestIncrease) {
        this.name = name;
        this.type = type;
        this.cost = cost;
        this.guestIncrease = guestIncrease;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public int getGuestIncrease() {
        return guestIncrease;
    }

    public String getType() {
        return type;
    }
}
