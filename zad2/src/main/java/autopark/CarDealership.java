package autopark;

import java.util.*;
import java.util.stream.*;

public class CarDealership {
  private final Map<String, Car> inventory = new HashMap<>();
  private final Scanner scanner = new Scanner(System.in);

  /* 1. Добавить авто */
  public boolean addCar(Car car) {
    return inventory.putIfAbsent(car.getVin(), car) == null;
  }

  /* 2. Найти все машины производителя */
  public List<Car> findByMake(String make) {
    return inventory.values().stream()
            .filter(c -> c.getMake().equalsIgnoreCase(make))
            .toList();
  }

  /* 3. Средняя цена по типу */
  public double averagePriceByType(CarType type) {
    return inventory.values().stream()
            .filter(c -> c.getType() == type)
            .mapToDouble(Car::getPrice)
            .average()
            .orElse(0);
  }

  /* 4. Сортировка по году (новые→старые) */
  public List<Car> sortedByYear() {
    return inventory.values().stream()
            .sorted()          // Comparable<Car>
            .toList();
  }

  /* 5а. Кол-во машин каждого типа */
  public Map<CarType, Long> statsCountByType() {
    return inventory.values().stream()
            .collect(Collectors.groupingBy(Car::getType, Collectors.counting()));
  }

  /* 5б. Самая старая / новая машины */
  public Optional<Car> getOldest() {
    return inventory.values().stream()
            .min(Comparator.comparingInt(Car::getYear));
  }

  public Optional<Car> getNewest() {
    return inventory.values().stream()
            .max(Comparator.comparingInt(Car::getYear));
  }

  public void runMenu() {
    String choice;
    do {
      System.out.print("""
              
              1) Добавить авто
              2) Найти по бренду
              3) Средняя цена по типу
              4) Список по году выпуска
              5) Статистика
              0) Выход
              > """);
      choice = scanner.nextLine();
      switch (choice) {
        case "1" -> menuAddCar();
        case "2" -> menuFindByMake();
        case "3" -> menuAvgPrice();
        case "4" -> sortedByYear().forEach(System.out::println);
        case "5" -> menuStats();
      }
    } while (!"0".equals(choice));
  }

  /* --- вспомогательные private-методы меню (упрощённый ввод) --- */
  private void menuAddCar() {
    System.out.print("VIN: ");
    String vin = scanner.nextLine();
    System.out.print("Модель: ");
    String model = scanner.nextLine();
    System.out.print("Бренд: ");
    String make = scanner.nextLine();
    System.out.print("Год: ");
    int year = Integer.parseInt(scanner.nextLine());
    System.out.print("Пробег: ");
    int mileage = Integer.parseInt(scanner.nextLine());
    System.out.print("Цена: ");
    double price = Double.parseDouble(scanner.nextLine());
    System.out.print("Тип (SEDAN/SUV/...): ");
    CarType type = CarType.valueOf(scanner.nextLine().toUpperCase());

    boolean added = addCar(new Car(vin, model, make, year, mileage, price, type));
    System.out.println(added ? "Добавлено!" : "Такой VIN уже есть.");
  }

  private void menuFindByMake() {
    System.out.print("Бренд: ");
    String make = scanner.nextLine();
    findByMake(make).forEach(System.out::println);
  }

  private void menuAvgPrice() {
    System.out.print("Тип: ");
    CarType type = CarType.valueOf(scanner.nextLine().toUpperCase());
    System.out.printf("Средняя цена: %.0f ₽%n", averagePriceByType(type));
  }

  private void menuStats() {
    System.out.println("Количество по типам: " + statsCountByType());
    System.out.println("Самая новая: " + getNewest().orElse(null));
    System.out.println("Самая старая: " + getOldest().orElse(null));
  }
}
