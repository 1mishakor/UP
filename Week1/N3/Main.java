package Misha.Week1.N3;

import Misha.Week1.N6.Circle;
import Misha.Week1.N6.Point;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
/*
* Тут произведён показ работы HashCod и Equals.
* Для примера работы был выбран класс Circle.
* */
        Set<Circle> set = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов вводимого массива: ");
        int a = scanner.nextInt();
        System.out.println("Введите координаты точки.");
        double x1, x2, y1, y2;
        for (int i = 0; i < a; i++) {
            System.out.print("\tВведите x"+(i+1)+": ");
            x1=scanner.nextDouble();
            System.out.print("\tВведите x"+(i+2)+": ");
            x2=scanner.nextDouble();
            System.out.print("\tВведите y"+(i+1)+": ");
            y1=scanner.nextDouble();
            System.out.print("\tВведите y"+(i+2)+": ");
            y2=scanner.nextDouble();
            set.add(new Circle(new Misha.Week1.N6.Point(x1,y1),
                    new Point(x2,y2)));
        }

        System.out.println("Размер массива:"+set.size());

    }
}
