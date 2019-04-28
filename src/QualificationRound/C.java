package QualificationRound;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class C {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int cases = Integer.parseInt(scan.nextLine());
    for(int t = 1; t <= cases; t++){
      String desc[] = scan.nextLine().split(" ");
      int n = Integer.parseInt(desc[0]);
      int L = Integer.parseInt(desc[1]);
      String factors[] = scan.nextLine().split(" ");

      TreeSet<BigInteger> primes = new TreeSet<>();
      BigInteger facts[] = new BigInteger[L+1];

      BigInteger f0 = null, f1 = null;
      int foundDiff = 0;
      for(int i = 0; i < L-1; i++) {
        if(!factors[i].equals(factors[i+1])){
          f0 = new BigInteger(factors[i]);
          f1 = new BigInteger(factors[i+1]);
          foundDiff = i;
          break;
        }
      }

      BigInteger common = f0.gcd(f1);
      BigInteger firstFactor = f0.divide(common);
      primes.add(common);
      primes.add(firstFactor);
      facts[foundDiff] = firstFactor;
      facts[foundDiff+1] = common;


        for (int i = foundDiff + 1; i < L; i++) {
          BigInteger fi = new BigInteger(factors[i]).divide(common);
          primes.add(fi);
          facts[i + 1] = fi;
          common = fi;
        }

        for (int i = foundDiff - 1; i >= 0; i--) {
          BigInteger fi = new BigInteger(factors[i]).divide(firstFactor);
          primes.add(fi);
          facts[i] = fi;
          firstFactor = fi;
        }


      HashMap<String, String> dictionary = new HashMap<>();
      StringBuilder ans = new StringBuilder();
      Iterator<BigInteger> it = primes.iterator();
      int letter = 0;
      while(it.hasNext()){
        dictionary.put(it.next().toString(), String.valueOf((char)('A'+letter++)));
      }

      for(BigInteger f: facts){
        ans.append(dictionary.get(f.toString()));
      }

      System.out.println("Case #"+t+": "+ ans);

    }
  }
}
