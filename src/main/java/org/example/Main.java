package org.example;

public class Main {

    public static void main(String[] args) {
        IMath p = new MathProxy();
        System.out.println("4 + 2 = " + p.add(4, 2));
        System.out.println("4 - 2 = " + p.sub(4, 2));
        System.out.println("4 * 2 = " + p.mul(4, 2));
        System.out.println("4 / 2 = " + p.div(4, 2));
    }
}


interface IMath {

    public double add(double x, double y);

    public double sub(double x, double y);

    public double mul(double x, double y);

    public double div(double x, double y);
}


class Math implements IMath {

    public double add(double x, double y) {
        return x + y;
    }

    public double sub(double x, double y) {
        return x - y;
    }

    public double mul(double x, double y) {
        return x * y;
    }

    public double div(double x, double y) {
        if (y == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return x / y;
    }
}


class MathProxy implements IMath {

    private Math math;

    public double add(double x, double y) {
        lazyInitMath();
        return math.add(x, y);
    }

    public double sub(double x, double y) {
        lazyInitMath();
        return math.sub(x, y);
    }

    public double mul(double x, double y) {
        lazyInitMath();
        return math.mul(x, y);
    }

    public double div(double x, double y) {
        lazyInitMath();
        return math.div(x, y);
    }

    private void lazyInitMath() {
        if (math == null) {
            math = new Math();
        }
    }
}