import java.util.*;
import java.util.stream.Collectors;

class Pizza {
    private String name;
    private double price;
    public Pizza(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

public class task2 {
    public static void main(String[] args) {
        Set<Pizza> pizzas = new HashSet<>();
        pizzas.add(new Pizza("Margherita", 8.50));
        pizzas.add(new Pizza("Peperoni", 10.00));
        pizzas.add(new Pizza("Hawaiian", 9.50));
        pizzas.add(new Pizza("Veggie", 7.00));

        List<String> affordablePizzas = pizzas.stream().filter(pizza -> pizza.getPrice() <= 9.00)
                .sorted(Comparator.comparingDouble(pizza -> pizza.getPrice()))
                .map(pizza -> pizza.getName())
                .collect(Collectors.toList());

        System.out.println("Pizzas with prices less than 9: " + affordablePizzas);
    }
}
