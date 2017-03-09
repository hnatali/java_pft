package ru.stqa.pft.sandbox;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.sandboxs.Point;

public class PointTests {

  @Test
  public void testDistance() {
    Point point1 = new Point(3, 2);
    Point point2 = new Point(11, 8);
    Assert.assertEquals(point2.distance(point1), 10.0);
  }

  @Test
  public void testDistance1() {
    Point point1 = new Point(5, 8);
    Point point2 = new Point(5, 10);
    Assert.assertEquals(point2.distance(point1), 2.0);
  }
}