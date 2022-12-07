import java.util.Scanner;


public class Stepen {

    public static void printMatrix(int mat[][], int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int n, mat[][] = new int[20][20];

        do {
            n = myObj.nextInt();
        } while (n < 2 || n >= 20);

        int trans[][] = new int[20][20];
        int rot[][] = new int[20][20];
        int s[][] = new int[20][20];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = myObj.nextInt();
            }
        }

        printMatrix(mat, n);

        /// transp

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                trans[j][i] = mat[i][j];
            }
        }

        ///	System.out.println("Transponovana matrica: ");
        printMatrix(trans, n);

        /// rotate za 90

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rot[j][n - i - 1] = trans[i][j];
            }
        }

        ///	System.out.println("Rotirana matrica: ");
        printMatrix(rot, n);

        /// horizontala

        for (int i = 0; i < n; i++) {
            for (int j = 0, k = n - 1; j < k; j++, k--) {
                int t = rot[j][i];
                rot[j][i] = rot[k][i];
                rot[k][i] = t;
            }
        }

        ///	System.out.println("Horizontalna matrica: ");
        printMatrix(rot, n);

        /// oko sporedne

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int temp = rot[n - j - 1][n - i - 1];
                rot[n - j - 1][n - 1 - i] = rot[i][j];
                rot[i][j] = temp;
            }
        }

        ///		System.out.println("Sporedna dijagonala matrica: ");
        printMatrix(rot, n);


    }
}
