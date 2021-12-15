import core.*;
import core.Camera;

import java.util.Scanner;

public class RoadController {
    // Приватная статичная переменная passengerCarMaxWeight типа double
    private static double passengerCarMaxWeight = 3500.0; // kg
    // Приватная статичная переменная passengerCarMaxHeight типа int
    private static int passengerCarMaxHeight = 2000; // mm
    // Приватная статичная переменная controllerMaxHeight типа int
    private static int controllerMaxHeight = 4000; // mm

    // Приватная статичная переменная passengerCarPrice типа int
    private static int passengerCarPrice = 100; // RUB
    // Приватная статичная переменная cargoCarPrice типа int
    private static int cargoCarPrice = 250; // RUB
    // Приватная статичная переменная vehicleAdditionalPrice типа int
    private static int vehicleAdditionalPrice = 200; // RUB

    public static void main(String[] args) {
        System.out.println("Сколько автомобилей сгенерировать?");

        // Объявление объекта scanner типа Scanner
        Scanner scanner = new Scanner(System.in);
        // Переменная carsCount типа int
        int carsCount = scanner.nextInt();

        // Переменная-счетчик i типа int в цикле for
        for (int i = 0; i < carsCount; i++) {
            // Объявление объекта car типа Car
            Car car = Camera.getNextCar();
            System.out.println(car);

            //Пропускаем автомобили спецтранспорта бесплатно
            if (car.isSpecial) {
                openWay();
                continue;
            }

            //Проверяем высоту и массу автомобиля, вычисляем стоимость проезда
            int price = calculatePrice(car);
            if (price == -1) {
                continue;
            }

            System.out.println("Общая сумма к оплате: " + price + " руб.");
        }
    }

    /**
     * Расчёт стоимости проезда исходя из массы и высоты
     */
    private static int calculatePrice(Car car) {
        // Переменная carHeight типа int
        int carHeight = car.height;
        // Переменная price типа int
        int price = 0;
        if (carHeight > controllerMaxHeight) {
            blockWay("высота вашего ТС превышает высоту пропускного пункта!");
            return -1;
        } else if (carHeight > passengerCarMaxHeight) {
            // Переменная weight типа double
            double weight = car.weight;
            //Грузовой автомобиль
            if (weight > passengerCarMaxWeight) {
                price = passengerCarPrice;
                if (car.hasVehicle) {
                    price = price + vehicleAdditionalPrice;
                }
            }
            //Легковой автомобиль
            else {
                price = cargoCarPrice;
            }
        } else {
            price = passengerCarPrice;
        }
        return price;
    }

    /**
     * Открытие шлагбаума
     */
    private static void openWay() {
        System.out.println("Шлагбаум открывается... Счастливого пути!");
    }

    /**
     * Сообщение о невозможности проезда
     */
    private static void blockWay(String reason) {
        System.out.println("Проезд невозможен: " + reason);
    }
}