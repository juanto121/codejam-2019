package Round1A;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class A {

  public static boolean graph[][];
  public static boolean seen[];
  public static int matchL[];
  public static int matchR[];
  static int n;
  static int m;
  public static String words[];
  public static HashSet<String> seenWord;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int cases = Integer.parseInt(scan.nextLine());
    for(int t = 1; t <= cases; t++){

      int cnt=0;
      int nwords = Integer.parseInt(scan.nextLine());
      graph = new boolean[nwords][nwords];
      seen = new boolean[nwords];
      matchR = new int[nwords];
      matchL = new int[nwords];
      seenWord = new HashSet<>();
      Arrays.fill(matchL, -1);
      Arrays.fill(matchR, -1);
      n = nwords; m = nwords;

      words = new String[nwords];
      for(int i = 0; i < nwords; i++){
        words[i] = scan.nextLine();
      }

      for(int i = 0; i < nwords; i++){
        for(int j = i; j < nwords; j++){
          if(j==i)continue;
          if(hasSuffix(words[i], words[j])){
            graph[i][j] = true;
          }
        }
      }

      for(int i = 0; i < nwords; i++){
        Arrays.fill(seen, false);
        if(bpm(i)) cnt++;
      }

      System.out.println("Case #"+t+": "+cnt);
    }
  }

  static boolean hasSuffix(String w1, String w2){
    int lenw1 = w1.length();
    int lenw2 = w2.length();
    int min = lenw1 < lenw2 ? lenw1 : lenw2;
    for(int i = 0; i < min; i++){
      if(w1.charAt(lenw1-i-1) == w2.charAt(lenw2-i-1)) return true;
      else return false;
    }
    return false;
  }

  static boolean bpm(int u) {
    for(int v=0; v<n;v++)
      if (graph[u][v]) {
      if(seen[v]) continue;
      seen[v] = true;
      if( matchR[v]<0 || bpm( matchR[v] ) ){
        matchL[u] = v;
        matchR[v] = u;
        return true;
      }
    }
    return false;
  }
}
