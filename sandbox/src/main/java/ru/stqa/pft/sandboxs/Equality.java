package ru.stqa.pft.sandboxs;


public class Equality {
  public static  void  main (String [] arqs) {
    String s1 = "firefox";
    String s2 = new String(s1);

    System.out.println(s1 == s2);
    System.out.println(s1.equals(s2));
  }
}
