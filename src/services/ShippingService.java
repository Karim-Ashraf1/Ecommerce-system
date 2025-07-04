package src.services;
import java.util.*;


public class ShippingService implements Shippable {
    private final String name;
    private final float weight;

    public ShippingService(String name, float weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String getName() { return name; }

    @Override
    public float getWeight() { return weight; }

    public static void ship(List<ShippingService> shippableItems) {
        float totalWeight = 0;

        // to store the count and weight and map it to it's shipping item
        Map<String, Integer> shippingItemsCount = new HashMap<>();
        Map<String, Float> shippingItemsWeight = new HashMap<>();

        // calculate the count and wight for each shipping item
        for (ShippingService item : shippableItems) {
            shippingItemsCount.put(item.getName(), shippingItemsCount.getOrDefault(item.getName(), 0) + 1);
            shippingItemsWeight.put(item.getName(), item.getWeight());
            totalWeight += item.getWeight();
        }

        printReceipt(shippingItemsCount, shippingItemsWeight, totalWeight);
    }

    public static void printReceipt(Map<String, Integer> shippingItemsCount, Map<String, Float> shippingItemsWeight, float totalWeight) { // the receipt layout is AI generated
        System.out.println("** Shipment notice **");

        for (String name : shippingItemsCount.keySet()) {
            int count = shippingItemsCount.get(name);
            float weight = shippingItemsWeight.get(name);
            System.out.printf("%-12s %7s\n", count + "x " + name, String.format("%.0fg", weight * 1000));
        }

        System.out.printf("Total package weight %.1fkg\n", totalWeight);
    }
}
