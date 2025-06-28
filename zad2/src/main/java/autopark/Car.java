package autopark;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
public class Car implements Comparable<Car> {
  private final String vin;
  private final String model;
  private final String make;     // производитель
  private final int year;
  private final int mileage;     // пробег в км
  private final double price;
  private final CarType type;

  // equals / hashCode только по VIN
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof exercise.Car)) return false;
    Car car = (Car) o;
    return vin.equals(car.vin);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vin);
  }

  // Comparable: новые выше старых
  @Override
  public int compareTo(Car other) {
    return Integer.compare(other.year, this.year); // DESC
  }

  @Override
  public String toString() {
    return "%s (%d), %.0f ₽".formatted(model, year, price);
  }
}
