package Q3;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author fahmihafiz
 */
public class Minefield {

    public static void main(String args[]) {
        int m = 5;
        int n = 7;

        char[][] minefield = generateRandomMinefield(m, n);
        System.out.println("Minefield:");
        displayMinefield(minefield);
        
        System.out.println("\nStart Journey:");
        displayMovement(minefield);
    }
    
    
    
    public static char[][] generateRandomMinefield(int m, int n) {
        char[][] field = new char[m][n];

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                field[x][y] = '0';
            }
        }

        Random random = new Random();

        for (int x = 0; x < m; x++) {
            int numMines = (int) (0.5 * n);

            for (int y = 0; y < numMines; y++) {
                boolean flag = true;
                while (flag) {
                    int randY = random.nextInt(n);
                    if (field[x][randY] != '*') {
                        field[x][randY] = '*'; // '*' indicates a mine
                        flag = false;
                    }
                }
            }
        }
        return field;
    }
    
     public static void displayMinefield(char[][] field) {
       
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }
     
    public static int startCheck(char[][] field) {
        ArrayList<Integer> dynamicArray = new ArrayList<>();

        for (int x = 0; x < field[0].length; x++) {
            if (field[0][x] != '*') {
                dynamicArray.add(x);
            }
        }

        Random random = new Random();
        int randomIndex = random.nextInt(dynamicArray.size());

        return dynamicArray.get(randomIndex);
    }
    
    public static void displayMovement(char[][] field) {
        int totoY = startCheck(field);
        int allyY = -1;
        
        int px = 0;
        int py = 0;

        for (int x = 0; x < field.length; x++) {
            int nextTotoY = totoY;

            if (totoY > 0 && field[x][totoY - 1] != '*') {
                nextTotoY = totoY - 1;
            } else if (totoY < field[0].length - 1 && field[x][totoY + 1] != '*') {
                nextTotoY = totoY + 1;
            }

            if (nextTotoY != totoY) {
                field[x][totoY] = 'T'; // 'T' represents Totoshka's movement
                System.out.println("\nStep " + (x + 1) + ": Totoshka moves");
                displayMinefield(field); // Display the minefield after Totoshka's movement

                try {
                    Thread.sleep(1000); // Delay for one second (1000 ms)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (allyY != -1) {
                    field[x][allyY] = '0'; // Set Ally's previous position back to '0'
                }

                allyY = totoY;
                totoY = nextTotoY; // Update Totoshka's current position
                if(x!=0){
                    field[px][py] = '0';
                }
                field[x][allyY] = 'A'; // 'A' represents Ally following Totoshka
                px = x;
                py = allyY;

                try {
                    Thread.sleep(1000); // Delay for one second (1000 ms)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }   
    
    }

}
