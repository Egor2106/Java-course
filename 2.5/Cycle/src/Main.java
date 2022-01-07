public class Main {
    public static void main(String[] args) {
        cycleFor();

        cycleWhile();
    }

    static void cycleFor() {
        for (int i = 200000; i <= 235000; i++) {
            if (i <= 210000 || i >= 220000)
                System.out.println("Билет № " + i);
        }
    }

    static void cycleWhile() {
        int i = 200000;
        while (i <= 235000) {
            if (i <= 210000 || i >= 220000)
                System.out.println("Билет № " + i);
            i++;
        }
    }
}
