package academy.itk.task7;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamCollectorsExample {

    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );

        final var ordersGroupedByProductName = orders.stream()
                .collect(Collectors.groupingBy(Order::getProduct));
        System.out.println(ordersGroupedByProductName);

        final var orderWithCost = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getProduct, Collectors.summingDouble(Order::getCost)));
        System.out.println(orderWithCost);

        final var sortedOrders = orderWithCost.entrySet().stream()
                .sorted((el1, el2) ->
                        Double.compare(el2.getValue(), el1.getValue()))
                .toList();
        System.out.println(sortedOrders);

        final var orders3ProductSortedByCost = orders.stream()
                .sorted((el1, el2) ->
                        Double.compare(el2.getCost(), el1.getCost()))
                .limit(3)
                .toList();
        System.out.println(orders3ProductSortedByCost);

        final var orders3ProductSortedWithSum = orderWithCost.entrySet().stream()
                .sorted((el1, el2) ->
                        Double.compare(el2.getValue(), el1.getValue()))
                .limit(3)
                .toList();
        System.out.println(orders3ProductSortedWithSum);
    }
}
