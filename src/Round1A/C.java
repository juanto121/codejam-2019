package Round1A;

import java.util.Scanner;

public class C {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int cases = Integer.parseInt(scan.nextLine());
    for(int t = 1; t <= cases; t++){
      String _s[] = scan.nextLine().split(" ");
      int r = Integer.parseInt(_s[0]);
      int c = Integer.parseInt(_s[1]);

      for(int i = 0; i < r; i++){
        for(int j = 0; j < c; j++){
          int starti = i;
          int startj = j;
          int seen = 0;
          for(int ii = 0; ii < r; ii++){
            for(int jj= 0; jj < c; jj++){
            }
          }
        }
      }

      System.out.println("Cases #"+t+": "+"POSSIBLE");
    }
  }
}
