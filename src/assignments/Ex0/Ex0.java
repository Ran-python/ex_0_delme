package assignments.Ex0;

import java.util.Scanner;

/**
 * This class is a basis for Ex0 (your first assigment),
 * The definition of the Ex0 can be found here: https://docs.google.com/document/d/1UtngN203ttQKf5ackCnXs4UnbAROZWHr/edit?usp=sharing&ouid=113711744349547563645&rtpof=true&sd=true
 * You are asked to complete the functions below amd may add additional functions if needed.

 */
public class Ex0 {
    public final static long ID = 323830208;// Do update your ID here

    /**
     * This function checks if n is a prime number.
     * Notes:
     * i) This code is very slow - make sure you improved it!
     * ii) Make sure to document your code
     *
     * @param n (Integer) - represented as long
     * @return true if and only if there is no integer (p) within the range of [2,n) which divides n.
     *
     */
    /**   pseudo code
     * // first case numbers that are in the 'sieve' array (n<=2000000)
     * if n < 2 → return false
     * if n ≤ LIMIT → return sieve[n]
     *
     *  fallback for numbers outside the 'sieve' array
     *    p=3
     *   while p * p <= n  //check until sqrt of n
     *   if n % p == 0
     *   return false         // found a divisor (not prime)
     *   p = p + 2                // skip even numbers
     *  end while
     *   return true
     */

        public static boolean isPrime(long n) {
            if (n < 2)
                return false;
            if (n <= LIMIT)
                return sieve[(int) n];

            if (n % 2 == 0)
                return false;
            boolean ans = true;
            long p = 3;
            while (ans && p * p <= n) {
                if (n % p == 0) {
                    ans = false;
                }
                p = p + 2;
            }
            return ans;
        }

    /// ////////////////////
    ///
    /**
     * This function finds the first prime integer (p1) >= start, for which p2=p1+n is also a prime number.
     *
     * @param start - a starting value from which p1 should be searched for.
     * @param n     - a positive (even) integer value.
     * @return the first prime number p1 such that: i) p1>=start, ii) p1+n is a prime number.
     * in case a wrong value is given to the function
     * (n<0 or n is an odd number) the function should return -1.
     *
     */
     /**  pseudo code
     *  if n < 2 or n is odd
     *      return -1
     *
     *  p1 = max(2, start)
     *  if p1 > 2 and p1 is even
     *      p1 = p1 + 1
     *
     *  while true
     *      if isPrime(p1) and isPrime(p1 + n)
     *          return p1       // found a prime pair
     *
     *      if p1 == 2
     *          p1 = p1 + 1
     *      else
     *          p1 = p1 + 2     // skip even numbers
     *  end while
     */

    public static long getPrimePair(long start, long n) {
        long ans = -1;
        if (n >= 2 && n % 2 == 0) {
            /// Add your code below ///

            long p1 = Math.max(2, start);
            if (p1 > 2 && p1 % 2 == 0) p1++;

            while (true) {
                if (isPrime(p1) && isPrime(p1 + n)) { ans = p1; break;
                }
                if (p1 == 2) p1++;
                else p1 += 2;
            }
        }
        return ans;
    }

            /// ////////////////// ///
    /**
     * This function compute the first prime number p1 for which:
     * i) p1 >= start (p1 is a prime number)
     * ii) p1+n==p2 ia a prime number.
     * iii) there are no prime numbers in the (p1,p2) range.
     *
     * @param start a positive integer which is the lower bound of p1.
     * @param n     - a positive even integer.
     * @return a prime number p1>=start that the following prime number is p1+n.
     */
     /**  pseudo code
     *  if n < 2 or n is odd
     *      return -1
     *  p1 = max(2, start)
     *  if p1 > 2 and p1 is even
     *      p1 = p1 + 1
     *
     *  while true
     *      if isPrime(p1) and isPrime(p1 + n)
     *          if no primes exist between p1 and p1 + n
     *              return p1
     *      if p1 = (p1 == 2) else p1 + 1 : p1 + 2
     */

    public static long getClosestPrimePair(long start, long n) {
        /// Add your code below ///

        long ans = -1;
        if (n >= 2 && n % 2 == 0) {
            long p1 = Math.max(2, start);
            if (p1 > 2 && p1 % 2 == 0) p1++;
            while (true) {
                if (isPrime(p1) && isPrime(p1 + n)) {
                    boolean check_if_following = true;
                    for (long i = p1 + 2; i < p1 + n; i += 2) {
                        if (isPrime(i)) {
                            check_if_following = false;
                            break;
                        }
                    }
                    if (check_if_following) {
                        ans = p1;
                        break;
                    }
                }
                if (p1 == 2) p1++;
                else p1 += 2;
                ;
            }
        }
        return ans;
    }
        /// ////////////////// ///



    /**
     * This function compute the m'th positive integer p1 for which:
     * i) p1 is a prime number.
     * ii) p1+n==p2 ia a prime number.
     * iii) there are no prime numbers in the (p1,p2) range.
     *
     * @param m a none negative integer.
     * @param n - a positive even integer.
     * @return a prime number p1>=start that the following prime number is p1+n.
     *
     */
     /**  pseudo code
     *  count = 0, p1 = 2
     *  while true
     *      if isPrime(p1) and isPrime(p1 + n)
     *          if no primes between p1 and p1 + n
     *              if count == m return p1
     *              else count++
     *    if p1 = (p1 == 2) else p1 + 1 : p1 + 2
     */

    public static long getMthClosestPrimePair(int m, long n) {
        if (m < 0 | n < 0 | n % 2 != 0) {
            System.err.println("Invalid input: got m=" + m + ", n=" + n + "  |  m should be >=0 & n should be a positive even integer ");
            return -1;
       }
        /// Add your code below ///
        long count = 0;
        long p1 = 2;
        while (true) {
            if (isPrime(p1) && isPrime(p1 + n)) {
                boolean check_if_following = true;
                for (long i = p1 + 2; i < p1 + n; i += 2) {
                    if (isPrime(i)) {
                        check_if_following = false;
                        break;
                    }
                }
                if (check_if_following) {
                    if (count == m) {
                        return p1;
                    }
                    count++;
                }
            }
            if (p1 == 2) p1++;
            else p1 += 2;
        }
    }

                      /// ////////////////// ///
    /// //////// Private Functions - you are welcome to add additional (private) functions below.
    /**
     * Builds a list of prime numbers using the Sieve of Eratosthenes algorithm.
     * The algorithm creates a boolean array called 'sieve' where each index represents a number.
     * Initially, all numbers ≥ 2 are marked as 'true' (possibly prime).
     * Then, for each prime number p starting from 2, the algorithm marks all multiples of p
     * as 'false' (not prime).
     *
     * The sieve is built once when the program starts.
     * This allows the program to check if a number ≤ LIMIT is prime instantly.
     *
     * pseudo code
     *  create boolean array sieve[0..limit]
     *     set all numbers from 2 to limit as true
     *
     *     for p from 2 to  sqrt limit:
     *         if sieve[p] is true:
     *             mark all multiples of p (from p*p to limit) as false
     *
     */

    private static final int LIMIT = 20000000;

    private static boolean[] sieve;
static {
    buildSieve(LIMIT);
}

private static void buildSieve(int limit) {
    sieve = new boolean[limit + 1];
    for (int i = 2; i <= limit; i++) sieve[i] = true;

    for (int p = 2; p * p <= limit; p++) {
        if (sieve[p]) {
            for (int j = p * p; j <= limit; j += p) {
                sieve[j] = false;
            }
        }
    }
}}
///