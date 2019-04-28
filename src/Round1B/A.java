package Round1B;

import java.util.Scanner;

public class A {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int cases = Integer.parseInt(scan.nextLine());
    for(int t = 1; t <= cases; t++) {
      String pq[] = scan.nextLine().split(" ");
      int p = Integer.parseInt(pq[0]);
      int q = Integer.parseInt(pq[1]) + 1;

      int xcount[] = new int[q];
      int ycount[] = new int[q];

      for(int pi = 0; pi < p; pi++) {
        String personi[] = scan.nextLine().split(" ");
        int x = Integer.parseInt(personi[0]);
        int y = Integer.parseInt(personi[1]);
        String direction = personi[2];
        switch (direction) {
          case "N":
            update(ycount, y, +1);
            break;
          case "S":
            update(ycount, y, -1);
            break;
          case "E":
            update(xcount, x, +1);
            break;
          case "W":
            update(xcount, x, -1);
            break;
        }
      }

      int maxX = -1;
      int maxY = -1;
      int maxiX = 0;
      int maxiY = 0;

      for(int i = 0; i < q; i++){
        if(xcount[i] > maxX) {
          maxX = xcount[i];
          maxiX = i;
        }
        if(ycount[i] > maxY) {
          maxY = ycount[i];
          maxiY = i;
        }
      }

      System.out.println("Case #"+t+": "+maxiX + " " + maxiY);
    }
  }

  private static int[] update(int[] count, int x, int direction) {
    int len = count.length;
    if(direction > 0) {
      for (int i = x + 1; i < len; i++) {
        count[i]++;
      }
    } else {
      for (int i = x-1; i >= 0; i--) {
        count[i]++;
      }
    }
    return count;
  }
}
