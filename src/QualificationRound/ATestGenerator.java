package QualificationRound;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class ATestGenerator {
  public static void main(String[] args) {
    test();
  }

  public static void generate() {
    Random r = new Random();
    StringBuilder stb;
    System.out.println(100);
    for(int i = 0; i < 100; i++){
      stb = new StringBuilder();
      int len = r.nextInt(102)+1;
      Random dr = new Random();
      for(int j = 1; j <= len; j++){
        int digit = dr.nextInt(10);
        stb.append(digit);
      }
      System.out.println(new BigInteger(stb.toString()));
    }
  }

  public static void test() {
    Scanner scan = new Scanner(System.in);
    for(int i = 0; i < 100; i++){
      String tcase[] = scan.nextLine().split(" ");
      BigInteger a = new BigInteger(tcase[2]);
      BigInteger b = new BigInteger(tcase[1]);
      BigInteger c = new BigInteger(tcase[0]);
      if(!a.add(b).equals(c)) System.out.println("FAILED");
    }
    System.out.println("DONE");
  }
}
