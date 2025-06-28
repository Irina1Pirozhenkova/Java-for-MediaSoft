package exercise;

import java.util.*;

public class HashSetDemo {
  public static void main(String[] args) {
    Set<Car> garage = new HashSet<>(List.of(
            new Car("VIN1", "Camry", "Toyota", 2020, 30_000, 2_000_000),
            new Car("VIN1", "Camry", "Toyota", 2020, 30_000, 2_000_000), // дубликат VIN
            new Car("VIN2", "X5", "BMW", 2022, 10_000, 6_000_000)
    ));

    garage.forEach(System.out::println);

    List<Car> sorted = new ArrayList<>(garage);
    Collections.sort(sorted);
    System.out.println("Сортировка по году: " + sorted);
  }
}
