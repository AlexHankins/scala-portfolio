import java.util.Scanner;

object Solution {

    /**
     * Modulus function that only returns positive numbers.
     * Return a number in the range [0, mod).
     */
    def positiveMod(x : Int, mod : Int) = {
        val xPrime = x % mod;
        if (xPrime < 0) {
            xPrime + mod
        }
        else {
            xPrime
        }
    }
    
    /**
     * Helper function that takes advantage of modulus using zero-based
     * arithmetic.
     *
     * @param n  number of prisoners
     * @param m  number of candies
     * @param s  0-based index of which prisoner gets the first candy
     */
    def whoIsPoisonedZeroBased(n : Int, m : Int, ix : Int) : Int = {
        val mLastRound = positiveMod(m, n);
        positiveMod((ix + mLastRound - 1), n);
    }

    /**
     * Given the numbers of prisoners, the number of candies to be handed out,
     * and the first prisoner to receive a piece of candy, determine which
     * prisoner receives the last piece of candy (which is ~~poisoned~~
     * tastes awful).
     *
     * @param n  number of prisoners
     * @param m  number of candies
     * @param s  1-based index of which prisoner gets the first candy
     */
    def whoIsPoisonedOneBased(n : Int, m : Int, s : Int) : Int = {
        val zeroRes = whoIsPoisonedZeroBased(n, m, (s-1) % n);
        
        zeroRes + 1
    }
    
    def main(args: Array[String]) {
        // Takes input on stdin in this form:
        
        // t
        // n1 m1 s1
        // n2 m2 s2
        // ...
        // nt mt st

        // t is the total number of problems.
        // Each line after that describes a scenario 
        // with a given # of prisoners and candies.

        // Print result to stdout.

        val in = new Scanner(System.in);
        val t = in.nextInt();
        
        (1 to t).map(ignored => {
            var (n, m, s) = (in.nextInt(), in.nextInt(), in.nextInt());

            println(whoIsPoisonedOneBased(n, m, s));     
            
            0
        })
    }
}

