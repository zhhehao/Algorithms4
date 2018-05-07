/**
 * 1.4.34
 */


import edu.princeton.cs.algs4.StdRandom;

public class HotOrCold {
    public static int MAX = 1000000;
    public static int guess_1(Game game) {

        int lo = 1; 
        int hi = MAX;
        int g1, g2;
        while (true) {
            if ((g1=game.guess(lo)) == 0) { 
                return lo;
            }
            if ((g2=game.guess(hi)) == 0) {
                return hi;
            }
            int mid = lo + (hi - lo) / 2;
            if (g2 == 100) {
                game.guess(mid);
                return mid;
            } else if (g2 > 0) {
                lo = mid;
            } else if (g2 < 0) {
                hi = mid;
            }
            
        }
    }

    // public static int guess_2(Game game) {
    //     int lo = 1;
    //     int hi = MAX;
    //     boolean flag = true;

    //     int lastGuess = lo;
    //     int guessResult = game.guess(1);
    //     if (guessResult == 0) return lo;
    //     int nowGuess = -1;
    //     while (lo < hi) {
    //         int mid = lo + (hi - lo) / 2;
    //         nowGuess = (lo + hi) - lastGuess;
    //         guessResult = game.guess(nowGuess);
    //         if (guessResult == 0) {
    //             break;
    //         }
    //         else if (guessResult == 1) {
    //             if (flag) 
    //                 lo = mid;
    //             else
    //                 hi = mid;
    //         } else {
    //             if (flag)
    //                 hi = mid;
    //             else
    //                 lo = mid;
    //         }
    //         flag = !flag;
    //         if (hi - lo <= 1) 
    //             break;
    //     }
    //     if (hi - lo <= 1) {
    //         if (game.guess(lo) == 0) 
    //             return lo;
    //         if (game.guess(hi) == 0)
    //          return hi;
    //     }
        
    //     return nowGuess;
    // }

    public static void main(String[] args) {
        int unknown_number = StdRandom.uniform(1, MAX);
        System.out.println("First guess: " + unknown_number);
        Game game = new Game(unknown_number);
        System.out.println("I guess the number is " + guess_1(game) +" in " + game.getCount() + "times.");

        // System.out.println("Second guess:" + unknown_number);
        // game = new Game(unknown_number);
        // System.out.println("I guess the number is " + guess_2(game) +" in " + game.getCount() + "times.");
    }
}

class Game
{
    private int number;
    private int lastGuess;
    private int count;
    Game(int N) {
        this.number = N;
        this.lastGuess = 2 * HotOrCold.MAX;
        this.count = 0;
    }

    int guess(int number) {
        count++;
        if (number == this.number) {
            return 0;
        }
        int newGuess = Math.abs(this.number - number);
        if (newGuess > lastGuess) {
            lastGuess = newGuess;
            return -1;
        }
        else if (newGuess < lastGuess) {
            lastGuess = newGuess;
            return 1;
        }
        else if (newGuess == lastGuess) {
            return 100;
        }
        return -2;
    }

    int getCount() {
        return count;
    }
}
