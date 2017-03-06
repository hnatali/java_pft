package ru.stqa.pft.sandboxs;


public class MySecondProgram {
  public static void main(String[] args) {
    Point point1 = new Point(1, 1);
    Point point2 = new Point(5, 5);
    System.out.println("Значение выражения = " + distance(point1, point2));

    System.out.println("Значение выражения = " + point1.distance(point2));
    System.out.println("Значение выражения = " + point1.distance(point1));
  }

  public static double distance(Point p1, Point p2) {
    return Math.sqrt((p2.x - p1.x)*(p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
  }
}
