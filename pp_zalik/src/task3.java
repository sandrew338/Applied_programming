import java.util.ArrayList;
import java.util.List;

abstract class Transport {
    private String model;
    private double weight; // in tones
    private double pricePerTon;

    public Transport(String model, double pricePerTon, double weight) {
        this.model = model;
        this.pricePerTon = pricePerTon;
        this.weight = weight;
    }

    public abstract void deliver(String destination, double weight);

    public String getModel() {
        return model;
    }

    public double calculateRevenue(double weight) {
        return weight * pricePerTon;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPricePerTon() {
        return pricePerTon;
    }

    public void setPricePerTon(double pricePerTon) {
        this.pricePerTon = pricePerTon;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

}
class Truck  extends Transport {
    private double fuelEfficiency;

    public Truck(String model, double loadCapacity, double pricePerUnit, double fuelEfficiency) {
        super(model, loadCapacity, pricePerUnit);
        this.fuelEfficiency = fuelEfficiency;
    }

    public double getFuelEfficiency() {
        return fuelEfficiency;
    }

    @Override
    public void deliver(String destination, double weight) {
        System.out.println("Truck " + getModel() + " is delivering " + weight + " tons of goods to " + destination + ".");
    }

    public void showFuelUsage(double distance) {
        double fuelUsed = (fuelEfficiency / 100) * distance;
        System.out.println("Truck " + getModel() + " will use " + fuelUsed + " liters of fuel for " + distance + " km.");
    }
}
class Ship extends Transport {
    private int numOfDecks;

    public Ship(String model, double loadCapacity, double pricePerUnit, int numOfDecks) {
        super(model, loadCapacity, pricePerUnit);
        this.numOfDecks = numOfDecks;
    }

    public int getNumOfDecks() {
        return numOfDecks;
    }

    @Override
    public void deliver(String destination, double weight) {
        System.out.println("Ship " + getModel() + " is delivering " + weight + " tons of goods to " + destination + ".");
    }

    public void showDeckDetails() {
        System.out.println("Ship " + getModel() + " has " + numOfDecks + " transport decks.");
    }
}
class Airplane extends Transport {
    private double maxFlightHeight; // максимальна висота польоту у метрах

    public Airplane(String model, double loadCapacity, double pricePerUnit, double maxFlightHeight) {
        super(model, loadCapacity, pricePerUnit);
        this.maxFlightHeight = maxFlightHeight;
    }

    public double getMaxFlightHeight() {
        return maxFlightHeight;
    }

    @Override
    public void deliver(String destination, double weight) {
        System.out.println("Airplane " + getModel() + " is flying " + weight + " tons of goods to " + destination + ".");
    }

    public void displayFlightAltitude() {
        System.out.println("Airplane " + getModel() + " can fly at a maximum height of " + maxFlightHeight + " meters.");
    }
}
class Route {
    private String origin;
    private String destination;
    private List<Transport> transports;

    public Route(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
        this.transports = new ArrayList<>();
    }

    public void addTransport(Transport transport) {
        transports.add(transport);
    }

    public void deleteTransport(Transport transport) {
        transports.remove(transport);
    }

    public List<Transport> getTransports() {
        return transports;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }
}
class Report {
    private static final int SALARY_PER_TON = 50;
    public void generateReport(Route route) {
        System.out.println("Report for route from " + route.getOrigin() + " to " + route.getDestination());

        double totalRevenue = 0;
        double totalExpenses = 0; // Припустимо, що у нас є витрати на транспортування

        for (Transport transport : route.getTransports()) {
            double revenue = transport.calculateRevenue(transport.getWeight()); // Розрахунок доходу від перевезення
            totalRevenue += revenue;

            double expense = transport.getWeight() * SALARY_PER_TON;
            totalExpenses += expense;
            System.out.println("Transport: " + transport.getModel() +
                    ", Estimated Revenue: $" + revenue + ", Estimated Expenses: $" + expense);
        }

        System.out.println("Total Revenue: $" + totalRevenue);
        System.out.println("Total Expenses: $" + totalExpenses);
        System.out.println("Net Profit: $" + (totalRevenue - totalExpenses));
    }
}

class LogisticsManagement {
    private static final int DISTANCE = 500;
    private static final int WEIGHT = 10;

    public static void process() {
        try {
            Truck truck = new Truck("MAN", 20, 100, 15);
            Airplane airplane = new Airplane("Mriya", 100, 300, 12000);
            Ship ship = new Ship("Titanic", 2000, 150, 3);

            Route route = new Route("New York", "London");
            route.addTransport(truck);
            route.addTransport(airplane);
            route.addTransport(ship);

            Report revenueReport = new Report();
            revenueReport.generateReport(route);

            truck.showFuelUsage(DISTANCE);
            airplane.displayFlightAltitude();
            ship.showDeckDetails();

            if (route.getTransports().isEmpty()) {
                throw new NoTransportAvailableException("No transport options available for the route.");
            }

            if (truck.getWeight() < WEIGHT) {
                throw new InsufficientCapacityException("This delivery can't be done because of not enough truck's capacity.");
            }

        } catch (InsufficientCapacityException | NoTransportAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class InsufficientCapacityException extends Exception {
    public InsufficientCapacityException(String message) {
        super(message);
    }
}

class NoTransportAvailableException extends Exception {
    public NoTransportAvailableException(String message) {
        super(message);
    }
}


public class task3 {
    public static void main(String[] args) {
        LogisticsManagement.process();
    }

}

