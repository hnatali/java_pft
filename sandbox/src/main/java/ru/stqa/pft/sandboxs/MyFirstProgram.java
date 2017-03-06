package ru.stqa.pft.sandboxs;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Natalya");

    double l = 5;
    System.out.println("Площадь квадрата со стороной  " + l + " = " + area(l));

    double a = 4;
    double b = 6;
    System.out.println("Площадь прямоугольника со сторонами    " + a + " и " + b + " = " + area(a, b));
  }

  public static void hello(String somebodi) {
    System.out.println("Hello, " + somebodi + "!");
  }

  public static double area(double Len) {
    return Len * Len;
  }

  public static double area(double a, double b) {
    return  a*b;
  }

}
