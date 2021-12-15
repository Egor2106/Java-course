package core;

public class Car {
    // Публичная переменная number типа String
    public String number;
    // Публичная переменная height типа int
    public int height;
    // Публичная переменная weight типа double
    public double weight;
    // Публичная переменная hasVehicle типа boolean
    public boolean hasVehicle;
    // Публичная переменная isSpecial типа boolean
    public boolean isSpecial;

    public String toString() {
        // Переменная special типа String
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : "";
        return "\n=========================================\n" +
            special + "Автомобиль с номером " + number +
            ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }
}