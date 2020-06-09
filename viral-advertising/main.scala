import java.util.Scanner;


object Solution {
    val stderr = System.err;

    /**
     * Given the number of times new customers are exposed to an ad
     * on social media, and a number of days, determine how many likes
     * the ad receives.
     *
     * We assume that half (rounded down) of all the people who see the ad
     * on any given day like it.
     * We also assume each person who likes the ad shares it with exactly 3
     * people who haven't yet seen the ad.
     *
     * @param exposures number of people who have seen the ad so far (but not yet shared it)
     * @param daysRemaining how many days are left before counting the likes
     * @return the number of likes after daysRemaining
     */
    def countLikes(exposures : Int, daysRemaining : Int) : Int = {
        if (daysRemaining <= 0) {
            0
        }
        else {
            // Scala's / operator automatically does `floor` when using integers
            val todaysLikes = exposures / 2; 
            val newExposures = todaysLikes * 3;

            todaysLikes + countLikes(newExposures, daysRemaining - 1)
        }
        
    }
    
    def main(args: Array[String]) {
        val in = new Scanner(System.in);
        val n = in.nextInt(); // number of days to wait before counting likes
        println(countLikes(5, n)); // Company only shares with 5 people to start.
    }
}
