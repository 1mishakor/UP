package Misha.Week1.N8;

public class ComplexNumber {
    private final double real;
    private final double imaginary;

    public ComplexNumber() {
        real = 0.0;
        imaginary = 0.0;
    }

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    public static ComplexNumber add(ComplexNumber z1, ComplexNumber z2) {
        return new ComplexNumber(z1.real + z2.real, z1.imaginary + z2.imaginary);
    }

    public static ComplexNumber subtract(ComplexNumber z1, ComplexNumber z2) {
        return new ComplexNumber(z1.real - z2.real, z1.imaginary - z2.imaginary);
    }

    public static ComplexNumber multiply(ComplexNumber z1, ComplexNumber z2) {
        double _real = z1.real * z2.real - z1.imaginary * z2.imaginary;
        double _imaginary = z1.real * z2.imaginary + z1.imaginary * z2.real;
        return new ComplexNumber(_real, _imaginary);
    }

    public static ComplexNumber divide(ComplexNumber z1, ComplexNumber z2) {
        ComplexNumber output = multiply(z1, z2.conjugate());
        double div = Math.pow(z2.mod(), 2);
        return new ComplexNumber(output.real / div, output.imaginary / div);
    }

    public ComplexNumber conjugate() {
        return new ComplexNumber(this.real, -this.imaginary);
    }

    public double mod() {
        return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginary, 2));
    }

    public ComplexNumber square() {
        double _real = this.real * this.real - this.imaginary * this.imaginary;
        double _imaginary = 2 * this.real * this.imaginary;
        return new ComplexNumber(_real, _imaginary);
    }

    @Override
    public String toString() {
        String re = String.valueOf(this.real);
        String im = "";
        if (this.imaginary < 0)
            im = this.imaginary + "i";
        else
            im = "+" + this.imaginary + "i";
        return re + im;
    }
    @Override
    public final boolean equals(Object z) {
        if (!(z instanceof ComplexNumber a))
            return false;
        return (real == a.real) && (imaginary == a.imaginary);
    }
}