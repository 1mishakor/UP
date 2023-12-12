package Misha.Week1.N8.Old;

import Misha.Week1.N8.ComplexNumber;

public class Main {
    public static void main(String[] args) {
// Default Complex Number 0+0i
        // 5+6i
        ComplexNumber c1 = new ComplexNumber(5,6);

        // 6-9i
        ComplexNumber c2 = new ComplexNumber(6,-9);

        ComplexNumber c1_plus_c2 = ComplexNumber.add(c1,c2);
        ComplexNumber c1_minus_c2 = ComplexNumber.subtract(c1,c2);
        ComplexNumber c1_into_c2 = ComplexNumber.multiply(c1,c2);
        ComplexNumber c1_by_c2 = ComplexNumber.divide(c1,c2);

        System.out.println(c1.toString()+" + "+c2.toString()+" = "+ c1_plus_c2.toString());
        System.out.println(c1.toString()+" - "+c2.toString()+" = "+ c1_minus_c2.toString());
        System.out.println(c1.toString()+" * "+c2.toString()+" = "+ c1_into_c2.toString());
        System.out.println(c1.toString()+" / "+c2.toString()+" = "+ c1_by_c2.toString());
    }
}
