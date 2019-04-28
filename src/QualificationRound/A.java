package QualificationRound;

import java.math.BigInteger;
import java.util.Scanner;

public class A {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int cases = Integer.parseInt(scan.nextLine());
    for(int t = 0; t < cases; t++){
      String n = scan.nextLine();
      int nlen = n.length();
      StringBuilder a = new StringBuilder();
      StringBuilder b = new StringBuilder();
      for(int i = nlen-1; i >= 0; i--){
        if(n.charAt(i) != '4'){
          a.append("0");
          b.append(n.charAt(i));
        }else{
          a.append("2");
          b.append("2");
        }
      }
      System.out.println("Case #"+(t+1)+": "+new BigInteger(a.reverse().toString())+" "+new BigInteger(b.reverse().toString()));
    }
  }
}
