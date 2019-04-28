package QualificationRound;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class B {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int cases = Integer.parseInt(scan.nextLine());
    for(int t = 1; t <= cases; t++){
      int n = Integer.parseInt(scan.nextLine());
      String lydia = scan.nextLine();
      Graph g = new Graph(n);
      g.removeEdges(lydia);
      g.build();
      g.traverse();
      System.out.println("Case #"+t+": "+g.path);
    }
  }

  public static class Graph{
    ArrayList<Integer> g[];
    int n;
    HashMap<Integer, HashSet<Integer>> edgesToRemove;
    boolean seen[];
    StringBuilder path = new StringBuilder();
    boolean done = false;

    Graph(int n) {
      g = new ArrayList[n*n];
      this.n = n;
      this.seen = new boolean[n*n];
    }

    public void traverse() {
      for(int i = 0; i < n; i++){
        if(!seen[i]){
          dfs(i);
          if(done) break;
        }
      }
    }

    private void dfs(int u) {
      if(done) return;
      seen[u] = true;
      int ulen = g[u].size();
      for(int j = 0; j < ulen && !done; j++){
        int v = g[u].get(j);
        if(!seen[v]){
          path.append(edgeToCommand(u, v));
          if(u == n*n-1 || v == n*n-1) done = true;
          dfs(v);
        }
      }

    }

    private String edgeToCommand(int u, int v){
      if(v == u+1) return "E";
      else return "S";
    }

    public void removeEdges(String path) {
      int len = path.length();
      int si = 0, sj = 0, ei = 0, ej =0;
      HashMap<Integer, HashSet<Integer>> toRemove = new HashMap<>();
      for(int i = 0; i < len; i++){
        char c = path.charAt(i);
        if(c == 'S'){
          ei++;
        }
        if(c == 'E'){
          ej++;
        }
        int u = nodeNum(si, sj, n);
        int v = nodeNum(ei, ej, n);
        HashSet<Integer> uMap = toRemove.get(u);
        if(uMap == null) uMap = new HashSet();
        uMap.add(v);
        toRemove.put(u, uMap);
        si = ei;
        sj = ej;
      }
      this.edgesToRemove = toRemove;
    }

    public void build() {
      for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
          int u  = nodeNum(i,j,n);
          int vright = nodeNum(i,j+1,n);
          int vdown = nodeNum(i+1, j, n);
          g[u] = new ArrayList<>();
          if(edgesToRemove.containsKey(u)) {
            if(!edgesToRemove.get(u).contains(vright) && j+1 < n)
              g[u].add(vright);
            if(!edgesToRemove.get(u).contains(vdown) && i+1 < n)
              g[u].add(vdown);
          }else{
            if(j+1 < n)
              g[u].add(vright);
            if(i+1 < n)
            g[u].add(vdown);
          }
        }
      }
    }

    private int nodeNum(int i, int j, int n) {
      return i*n+j;
    }
  }
}
