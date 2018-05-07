/**
 * Throwing two eggs from a building. Consider the previous question, 
 * but now suppose you only have two eggs, and your cost model is the 
 * number of throws. Devise a strategy to determine F such that the number 
 * of throws is at most 2 sqrt(√ N), then find a way to reduce the cost 
 * to ~c √ F for some constant c.
 * 
 * 
 * Solution to Part 1: To achieve 2 * sqrt(N), drop eggs at floors sqrt(N),
 *  2 * sqrt(N), 3 * sqrt(N), ..., sqrt(N) * sqrt(N). 
 * (For simplicity, we assume here that sqrt(N) is an integer.) 
 * Let assume that the egg broke at level k * sqrt(N). 
 * With the second egg you should then perform a linear search 
 * in the interval (k-1) * sqrt(N) to k * sqrt(N). 
 * In total you will be able to find the floor F in at most 2 * sqrt(N) trials.
 * 
 * Hint for Part 2: 1 + 2 + 3 + ... k ~ 1/2 k^2.
 * 按照第 1, 3, 6, 10,..., 1/2k^2 层顺序查找，一直到 1/2k^2 > F，
 * 随后在 [1/2k^2 - k, 1/2k^2] 范围中顺序查找
 * 
 */


import edu.princeton.cs.algs4.StdRandom;
public class ThrowTwoEggs
{
    private static int F;
    private static int broken_eggs;

    public static int getFloor(int buildingHigh) {
        int N = 2;
        int high = (int)(Math.sqrt(buildingHigh));
        int floor = N * high;
        if (floor == F) {
            broken_eggs++;
            return floor;
        }
        while (floor < F) {
            floor = (++N) * high;
        }
        broken_eggs++;
        int lo = (N-1) * high;
        int hi = floor;

        for (int i = lo; i <= hi; i++) {
            if (i == F) {
                broken_eggs++;
                return i;
            }
        }
        

        return -1;
    }

    

    public static void main(String[] args) {
        int buildingHigh = 100000;
        F = StdRandom.uniform(1, 100000);
        System.out.println("The floor 'F' is " + F);
        broken_eggs = 0;
        int floor = getFloor(buildingHigh);
        System.out.println("I found the floor is " + floor);
        System.out.println("And broke " + broken_eggs + " eggs.");
        System.out.println("---------------------");
        broken_eggs = 0;
        floor = getFloor2(buildingHigh);
        System.out.println("I found the floor is " + floor);
        System.out.println("And broke " + broken_eggs + " eggs.");
    }
}