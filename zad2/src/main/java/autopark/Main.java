package autopark;

public class Main {
  public static void main(String[] args) {
    CarDealership shop = new CarDealership();

    shop.addCar(new Car("A1", "Camry", "Toyota", 2021, 20_000, 2_300_000, CarType.SEDAN));
    shop.addCar(new Car("A2", "Model 3", "Tesla", 2023, 15_000, 4_500_000, CarType.ELECTRIC));
    shop.addCar(new Car("A3", "X5", "BMW", 2019, 80_000, 3_500_000, CarType.SUV));

    shop.runMenu();
  }
}
