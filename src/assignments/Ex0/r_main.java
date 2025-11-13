package assignments.Ex0;

import java.util.Scanner;

public class r_main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        long n = sc.nextLong();

        boolean p1 = Ex0.isPrime(n);

        if (p1) {
            System.out.println(n + " is prime ✅");
        } else {
            System.out.println(n + " is NOT prime ❌");
        }

        sc.close();

        //System.out.println(Ex0.getPrimePair(-1, 2));  // 11  (11,13)
        System.out.println(Ex0.getPrimePair(20, 754));  // 23  (23,29)
        System.out.println(Ex0.getClosestPrimePair(10, 100));// -1  (n invalid)
        System.out.println(Ex0.getMthClosestPrimePair(1000, 98));  // -1  (n invalid)


    }
}












//public class r_main {
  //  public static void main(String[] args) {
    //int num = 0  ;
    //Scanner sc = new Scanner(System.in);
      // System.out.print("Enter a natural number ");
        //long n = sc.nextLong();
        //boolean p1 = Ex0.isPrime(n);
    //}
//}