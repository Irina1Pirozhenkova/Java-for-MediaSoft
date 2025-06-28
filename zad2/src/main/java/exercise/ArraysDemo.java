package exercise;

import java.time.Year;
import java.util.Arrays;
import java.util.Random;

public class ArraysDemo {

  public static void main(String[] args) {
    int[] years = new Random()
            .ints(50, 2000, 2026)   // верхняя граница исключается
            .toArray();

    // а) выводим годы выпуска
    System.out.println("Все авто: " + Arrays.toString(years));

    // б) машины моложе 2015 г.
    System.out.print("После 2015-го: ");
    Arrays.stream(years)
            .filter(y -> y > 2015)
            .forEach(y -> System.out.print(y + " "));
    System.out.println();

    // в) средний возраст парка
    int currentYear = Year.now().getValue();
    double avgAge = Arrays.stream(years)
            .map(y -> currentYear - y)
            .average()
            .orElse(0);
    System.out.printf("Средний возраст = %.2f лет%n", avgAge);
  }
}
