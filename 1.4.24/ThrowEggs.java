/**
 * Throwing eggs from a building. 
 * Suppose that you have an N-story building and plenty of eggs. 
 * Suppose also that an egg is broken if it is thrown off floor F or higher, 
 * and unbroken otherwise. First, devise a strategy to determine 
 * the value of F such that the number of broken eggs is ~ lg N 
 * when using ~ lg N throws, then find a way to reduce the cost to ~ 2 lg F when N is much larger than F.
 * 
 * Hint: binary search; repeated doubling and binary search.
 * 
 * 参考别人解答
    第一问：二分查找即可。

    第二问：

    按照第 1, 2, 4, 8,..., 2^k 层顺序查找，一直到 2^k > F，
    随后在 [2^(k - 1), 2^k] 范围中二分查找。

 */
import edu.princeton.cs.algs4.StdRandom;
public class ThrowEggs
{
    private static int F;
    private static int broken_eggs;
    public static int getFloor(int floor) {
        int lo = 1;
        int hi = floor;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid == F) {
                broken_eggs++;
                return mid;
            } else if (mid > F) {
                broken_eggs++;
                hi = mid;
            }
            else if (mid < F) {
                lo = mid;
            }
        }
        return -1;
    }

    public static int getFloor2(int floor) {
        int f = 1;
        if (f == F) {
            broken_eggs++;
            return f;
        }
        while (true) {
            f = (f << 1);
            if (f < F)
                continue;
            broken_eggs++;
            if (f == F) return f;
            if (f > F) break;
        }
        int lo = f >> 1;
        int hi = f;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid == F) {
                broken_eggs++;
                return mid;
            } else if (mid > F) {
                broken_eggs++;
                hi = mid;
            } else if (mid < F) {
                lo = mid;
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