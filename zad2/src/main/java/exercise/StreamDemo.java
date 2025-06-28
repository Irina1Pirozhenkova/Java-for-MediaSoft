package exercise;

import java.util.*;
import java.util.stream.*;

public class StreamDemo {

  public static void main(String[] args) {
    List<Car> fleet = List.of(
            new Car("A1", "Camry", "Toyota", 2021, 20_000, 2_300_000),
            new Car("A2", "Model 3", "Tesla", 2023, 15_000, 4_500_000),
            new Car("A3", "X5", "BMW", 2019, 80_000, 3_500_000),
            new Car("A4", "Niro EV", "Kia", 2024, 5_000, 3_800_000),
            new Car("A5", "Octavia", "Skoda", 2018, 55_000, 1_600_000)
    );

    List<Car> lowMileage = fleet.stream()
            .filter(c -> c.getMileage() < 50_000)
            .toList();

    List<Car> byPrice = lowMileage.stream()
            .sorted(Comparator.comparingDouble(Car::getPrice).reversed())
            .toList();

    System.out.println("Топ-3 дорогих:");
    byPrice.stream().limit(3).forEach(System.out::println);

    double avgMileage = fleet.stream()
            .mapToInt(Car::getMileage)
            .average()
            .orElse(0);
    System.out.printf("Средний пробег: %.0f км%n", avgMileage);

    Map<String, List<Car>> byMake = fleet.stream()
            .collect(Collectors.groupingBy(Car::getMake));
    System.out.println("Группировка по бренду: " + byMake.keySet());
  }
}
