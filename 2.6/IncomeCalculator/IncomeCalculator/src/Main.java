//импорт класса Scanner из библиотеки java.util
import java.util.Scanner;

//начало публичного класса Main
public class Main {

    //создание приватной статичной перенной minIncome типа int
    private static int minIncome = 200000;
    //создание приватной статичной перенной maxIncome типа int
    private static int maxIncome = 900000;

    //создание приватной статичной перенной officeRentCharge типа int
    private static int officeRentCharge = 140000;
    //создание приватной статичной перенной telephonyCharge типа int
    private static int telephonyCharge = 12000;
    //создание приватной статичной перенной internetAccessCharge типа int
    private static int internetAccessCharge = 7200;

    //создание приватной статичной перенной assistantSalary типа int
    private static int assistantSalary = 45000;
    //создание приватной статичной перенной financeManagerSalary типа int
    private static int financeManagerSalary = 90000;

    //создание приватной статичной перенной mainTaxPercent типа double
    private static double mainTaxPercent = 0.24;
    //создание приватной статичной перенной managerPercent типа double
    private static double managerPercent = 0.15;

    //создание приватной статичной перенной minInvestmentsAmount типа double
    private static double minInvestmentsAmount = 100000;

    //начало публичного статичного метода main
    public static void main(String[] args) {

        //расчет минимальной суммы дохода для инвестирования
        System.out.println("Минимальная сумма дохода для инвестирования: 500917");

        //создание цикла while с условием true (т.е. цикл бесконечен)
        while (true) {
            //вывод в консоль "Введите сумму доходов компании за месяц (от 200 до 900 тысяч рублей): "
            System.out.println("Введите сумму доходов компании за месяц " +
                "(от 200 до 900 тысяч рублей): ");
            /*создание объекта Scanner для считывания значений, введенных в консоль. Далее вызывается метод класса Scanner nextInt(), который считывает целые числа.
            После это целочисленное значение присваиваивается переменной income типа int*/
            int income = (new Scanner(System.in)).nextInt();

            //начало условного оператора if, в условии которого вызывается параметризированный метод checkIncomeRange(income), который возвращает переменную типа boolean
            if (!checkIncomeRange(income)) {
                //досрочное завершение текущей итерации цикла и переход к следующей итерации
                continue;
            }

            //создание переменной managerSalary типа double, которой присваивается результат произведения переменных income и managerPercent
            double managerSalary = income * managerPercent;
            /*создание переменной pureIncome типа double, которой присваивается результат вычитания переменных
            managerSalary и значения, результатом которого был вызов метода calculateFixedCharges() из переменной income*/
            double pureIncome = income - managerSalary -
                calculateFixedCharges();
            //создание переменной taxAmount типа double, которой присваивается результат произведения переменных mainTaxPercent и pureIncome
            double taxAmount = mainTaxPercent * pureIncome;
            //создание переменной pureIncomeAfterTax типа double, которой присваивается результат вычитания переменной taxAmount из pureIncome
            double pureIncomeAfterTax = pureIncome - taxAmount;

            //создание переменной canMakeInvestments типа boolean, которой присваивается булевый результат сравнения переменных pureIncomeAfterTax и minInvestmentsAmount
            boolean canMakeInvestments = pureIncomeAfterTax >=
                minInvestmentsAmount;

            //вывод в консоль выражения "Зарплата менеджера: " и значения переменной managerSalary
            System.out.println("Зарплата менеджера: " + managerSalary);
            /*вывод в консоль выражения "Общая сумма налогов: " и результат выполнения тернарного оператора (т.е. если taxAmount > 0 == true, то выводится значение переменной taxAmount,
            если taxAmount > 0 == false, то выводится 0)*/
            System.out.println("Общая сумма налогов: " +
                (taxAmount > 0 ? taxAmount : 0));
            /*вывод в консоль выражения "Компания может инвестировать: " и результат выполнения тернарного оператора (т.е. если canMakeInvestments == true, то выводится "да",
            если canMakeInvestments == false, то выводится "нет")*/
            System.out.println("Компания может инвестировать: " +
                (canMakeInvestments ? "да" : "нет"));
            //начало условного оператора if, в условии которого сравнивается значение переменной pureIncome и 0
            if (pureIncome < 0) {
                //вывод в консоль выражения "Бюджет в минусе! Нужно срочно зарабатывать!"
                System.out.println("Бюджет в минусе! Нужно срочно зарабатывать!");
            }
        }
    }

    //создание приватного статичного метода checkIncomeRange, который в качестве параметра принимает int income и возвращает значение типа boolean
    private static boolean checkIncomeRange(int income) {
        //начало условного оператора if, в условии которого сравниваются значения перенных income и minIncome
        if (income < minIncome) {
            //вывод в консоль выражения "Доход меньше нижней границы"
            System.out.println("Доход меньше нижней границы");
            //выход из метода и возврат значения false
            return false;
        }

        //начало условного оператора if, в условии которого сравниваются значения перенных income и minIncome
        if (income > maxIncome) {
            //вывод в консоль выражения "Доход выше верхней границы"
            System.out.println("Доход выше верхней границы");
            //выход из метода и возврат значения false
            return false;
        }
        //выход из метода и возврат значения true
        return true;
    }

    //создание приватного статичного метода calculateFixedCharges, который возвращает значение типа int
    private static int calculateFixedCharges() {
        //выход из метода и возврат суммы переменных officeRentCharge, telephonyCharge, internetAccessCharge, assistantSalary и financeManagerSalary
        return officeRentCharge +
            telephonyCharge +
            internetAccessCharge +
            assistantSalary +
            financeManagerSalary;
    }
}
