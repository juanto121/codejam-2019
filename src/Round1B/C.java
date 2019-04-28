package Round1B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(bf.readLine());
    for(int t = 1; t <= cases; t++){
      String nk[] = bf.readLine().split(" ");
      int n = Integer.parseInt(nk[0]);
      int k = Integer.parseInt(nk[1]);
      int c[] = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      int d[] = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      int rmqc[][] = process(c);
      int rmqd[][] = process(d);
      int countPossible = 0;

      for(int i = 0; i < n; i++){
        if(Math.abs(c[i]-d[i]) <= k) countPossible++;
      }

      for(int i = 0; i < n; i++){
        for(int j = i+1; j < n; j++){
          int maxc = query(rmqc, c, i, j);
          int maxd = query(rmqd, d, i, j);
          if(Math.abs(c[maxc]-d[maxd]) <= k) {
            countPossible++;
          }
        }
      }

      System.out.println("Case #"+t+": "+ countPossible);
    }

  }

  static int query(int rmq[][], int a[], int low, int high) {
    int k = log2(high-low); //length of the range
    int x = rmq[k][low];
    int y = rmq[k][high - (1<<k) + 1];
    return a[x] > a[y] ? x : y;
  }

  static int[][] process(int a[]) {
    int n = a.length;
    int rmq[][] = new int[log2(n) + 1][n];
    // fill all queries of range length equal to one element
    for(int i = 0; i < n; i++) rmq[0][i] = i;

    for(int k = 1; (1 << k) < n; ++k) {
      for(int i = 0; i + (1 << k) <= n; i++) {
        int x = rmq[k-1][i];
        int y = rmq[k-1][i+(1<<k-1)];
        rmq[k][i] = a[x] > a[y] ? x:y;
      }
    }

    return rmq;
  }

  static int log2(int n) {
    if(n<=0) throw new IllegalArgumentException();
    return 31 - Integer.numberOfLeadingZeros(n);
  }
}
