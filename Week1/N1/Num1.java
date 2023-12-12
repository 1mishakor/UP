package Misha.Week1.N1;
public class Num1 {
    public static void main(String[] args) {
        int[][] p = {
                {1,2,3},
                {4,5,6},
                {7,8,9}};
        int[][] p1;
        System.out.println("Входная матрица:");
        for (int[] ints : p) {
            for (int j1 = 0; j1 < p.length; j1++) {
                System.out.print(ints[j1] + "\t");
            }
            System.out.println();
        }
        System.out.println("\n");
        System.out.println("Транспонированная Выходная матрица:");
        MatricesSquare ms = new MatricesSquare(p);
        p1= ms.transpose();
        for (int[] ints2 : p1) {
            for (int j2 = 0; j2 < p1.length; j2++) {
                System.out.print(ints2[j2] + "\t");
            }
            System.out.println();
        }
    }
}
