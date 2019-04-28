package QualificationRound;

import java.util.Scanner;

public class BFast {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int cases = Integer.parseInt(scan.nextLine());
    for(int t = 1; t <= cases; t++){
      int n = Integer.parseInt(scan.nextLine());
      String lydia = scan.nextLine();
      int llen = lydia.length();
      StringBuilder path = new StringBuilder(llen);
      for(int j = 0; j < llen; j++) {
        path.append(lydia.charAt(j) == 'S' ? 'E' : 'S');
      }
      System.out.println("Case #"+t+ ": " + path);
    }
  }
}
