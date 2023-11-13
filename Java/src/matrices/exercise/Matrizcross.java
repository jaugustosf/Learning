package matrices.exercise;

import java.util.Locale;
import java.util.Scanner;

public class Matrizcross {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Specify the size of the matrix: ");
        int xPos = sc.nextInt();
        int yPos = sc.nextInt();

        int[][] matrix = new int[xPos][yPos];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println();
        System.out.println("Matriz:");
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.printf("number to search: \n");
        int numbSearch = sc.nextInt();

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == numbSearch){
                    System.out.printf("Position: %d:%d\n",i+1 , j+1);
                    if(j > 0){
                        System.out.printf("UP: %d\n", matrix[i-1][j]);
                    }
                    if(i < matrix.length - 1){
                        System.out.printf("DOWN: %d\n", matrix[i+1][j]);
                    }
                    if(j > 0){
                        System.out.printf("LEFT: %d\n", matrix[i][j-1]);
                    }
                    if(j < matrix[i].length - 1){
                        System.out.printf("RIGHT: %d\n", matrix[i][j+1]);
                    }
                }
            }
        }
        sc.close();
    }
}
