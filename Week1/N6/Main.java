package Misha.Week1.N6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args){

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
            Circle circle = new Circle(new Point(x1,y1), new Point(x2,y2));
            String filePath = "C:\\Users\\ko-ma\\IdeaProjects\\UP_01_2STUD\\src\\Misha\\Week1\\N6\\MyFiles\\myfile.txt";
            String text = i+": "+circle.toString()+";\n\n";

            try {
                Files.write(Paths.get(filePath), text.getBytes(), StandardOpenOption.APPEND);
            }
            catch (IOException e) {
                System.out.println(e);
            }
            set.add(circle);
        }
            System.out.println("Размер массива:"+set.size());
    }
}
