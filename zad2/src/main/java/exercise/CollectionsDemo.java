package exercise;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionsDemo {

  public static void main(String[] args) {
    List<String> models = List.of(
            "Toyota Camry", "BMW X5", "Tesla Model 3",
            "BMW X5", "Audi A6", "Tesla Model Y", "Lada Niva"
    );

    // 1) удаляем дубликаты и сортируем в обратном алфавитном порядке
    Set<String> uniqueSorted = models.stream()
            .distinct()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toCollection(LinkedHashSet::new));

    // 2) замена Tesla → ELECTRO_CAR
    Set<String> prepared = uniqueSorted.stream()
            .map(m -> m.contains("Tesla") ? "ELECTRO_CAR" : m)
            .collect(Collectors.toCollection(LinkedHashSet::new));

    // вывод
    System.out.println(prepared);   // и это уже готовый Set
  }
}
