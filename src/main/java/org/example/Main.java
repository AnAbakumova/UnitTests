package org.example;

import java.util.Scanner;

public class Main {

    public static int benefit = 0;

    public static void main(String[] args) {
        int earnings = 0;    // доходы
        int spendings = 0;  //расходы

        Scanner scanner = new Scanner(System.in);

        while (true) {
            selectionMenu();
            String input = scanner.nextLine();
            if ("end".equals(input.toLowerCase())) {
                break;
            } else if ("1".equals(input)) {
                System.out.println("Введите сумму дохода:");
                int money = Integer.parseInt(scanner.nextLine());
                earnings += money;
            } else if ("2".equals(input)) {
                System.out.println("Введите сумму расхода:");
                int money = Integer.parseInt(scanner.nextLine());
                spendings += money;
            } else if ("3".equals(input)) {
                comparison(taxEarnings(earnings), taxEarningsMinusSpendings(earnings, spendings));
            } else {
                System.out.println("Такой операции нет");
            }
        }
        scanner.close();
        System.out.println("Программа завершена!");
    }


    public static void selectionMenu() {
        System.out.println("Выберите операцию и введите её номер:");
        System.out.println("1. Добавить новый доход");
        System.out.println("2. Добавить новый расход");
        System.out.println("3. Выбрать систему налогообложения");
        System.out.println("Для завершения работы программы введите ключевое слово \"end\"");
    }

    public static void comparison(int tax1, int tax2) {
        if (tax1>tax2) {
            benefit = tax1-tax2;
            System.out.println("Мы советуем вам УСН доходы минус расходы");
            System.out.println("Ваш налог составит: " + tax2 + " рублей");
            System.out.println("Налог на другой системе: " + tax1 + " рублей");
            System.out.println("Экономия: " + benefit + " рублей");
        } else if (tax2>tax1) {
            benefit = tax2-tax1;
            System.out.println("Мы советуем вам УСН доходы ");
            System.out.println("Ваш налог составит: " + tax1 + " рублей");
            System.out.println("Налог на другой системе: " + tax2 + " рублей");
            System.out.println("Экономия: " + benefit + " рублей");
        } else {
            System.out.println("При любой системе налогооблажения ваш налог составит: " + tax1 + " рублей");
        }
    }

    public static int taxEarnings(int earnings) {
        return earnings * 6 / 100;
    }

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }
}