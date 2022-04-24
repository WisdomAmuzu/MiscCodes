//========================//
//  Eloquent JS Exercises //
//    Solutions in Java   //
//========================//

/**
 *
 * @author Sneaky
 */

public class EloquentJs {
    // My Solutions to the exercises in the EloquentJS book

    public void loopTriangle() {
        for(int i = 1; i <= 7; i++) {
            for(int j = 1; j <=i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    public void fizzBuzz() {
        for(int i = 1; i <= 100; i++) {
            if(i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if(i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            }
            else System.out.println(i);
        }
    }

    /**
     *
     * @param size the width and height of the board
     */
    public void chessBoard(int size) {
        for(int i = 0; i < size; i++) {
            if(i % 2 == 0) {
                System.out.println("# # # # ");
            }
            else System.out.println(" # # # #");
        }
        /* Alternate Solution
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(i % 2 == 0) {
                    if(j % 2 == 0) {
                        System.out.print(" ");
                    }
                    else System.out.print("#");
                }
                else {
                    if(j % 2 == 0) {
                        System.out.print("#");
                    }
                    else System.out.print(" ");
                }
            }
            System.out.println();
        }*/
    }
}
