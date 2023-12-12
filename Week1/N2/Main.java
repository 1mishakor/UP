package Misha.Week1.N2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputAction = new Scanner(System.in);
        System.out.println("Введите запрос для вывода данных о продуктах:");
        System.out.println("a) список товаров для заданного наименования;\n" +
                "b) список товаров для заданного наименования, цена которых не превосходит заданную;\n" +
                "c) список товаров, срок хранения которых больше заданного.\n\n");
        System.out.print("Ввод: ");
        String i = inputAction.nextLine();
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Product(1, "Молоко", "123456789012", "Залейский_фермер", 50.5, (short) 8, 25));
        products.add(new Product(2, "Сыр", "123456789012", "Залейский_фермер", 41.5, (short) 5, 25));
        products.add(new Product(3, "Творог", "123456789012", "Залейский_фермер", 55.5, (short) 9, 25));
        products.add(new Product(4, "Колбаса", "123456789012", "Мясник", 50.0, (short) 6, 25));
        products.add(new Product(5, "Капчёная рыба", "123456789012", "Мясник", 100.0, (short) 6, 25));
        products.add(new Product(6, "Пельмени", "123456789012", "Мясник", 150.30, (short) 6, 25));
        products.add(new Product(7, "Яблоко", "123456789012", "Фруктовый_мир", 30.0, (short) 6, 25));
        products.add(new Product(8, "Хлеб", "123456789012", "Пекарь", 45.0, (short) 6, 25));
        products.add(new Product(9, "Шоколад", "123456789012", "Шоколадный_заяц", 220.50, (short) 6, 25));
        products.add(new Product(10, "Мороженной", "123456789012", "Залейский_фермер", 120.0, (short) 7, 25));
        switch (i) {
            case "a" -> {
                System.out.print("a) Ввдите наименование производителя: ");
                String a = inputAction.next();
                for (Product my : products) {
                    if (a.equals(my.getManufacturer())) {
                        System.out.println(my.toString());
                    }
                }
            }
            case "b" -> {
                System.out.print("b) Ввдите наименование производителя: ");
                String a1 = inputAction.next();
                System.out.print("Ввдите цену: ");
                Scanner in = new Scanner(System.in);
                double b = in.nextDouble();
                for (Product my : products) {
                    if (a1.equals(my.getManufacturer()) && b >= my.getPrice()) {
                        System.out.println(my.toString());
                    }
                }
            }
            case "c" -> {
                System.out.print("c) Ввдите срок хранения: ");
                short b2 = inputAction.nextShort();
                for (Product my : products) {
                    if (b2 < my.getShelfLife()) {
                        System.out.println(my.toString());
                    }
                }
            }
        }
    }
}
