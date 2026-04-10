import java.util.Scanner;

public class SpiralMatrix {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            if (!sc.hasNextInt()) return;
            int r = sc.nextInt();
            int c = sc.nextInt();

            int[][] matrix = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (sc.hasNextInt()) {
                        matrix[i][j] = sc.nextInt();
                    }
                }
            }

            int top = 0, bottom = r - 1;
            int left = 0, right = c - 1;

            boolean first = true;
            while (top <= bottom && left <= right) {
                // Top row: left to right
                for (int i = left; i <= right; i++) {
                    System.out.print((first ? "" : " ") + matrix[top][i]);
                    first = false;
                }
                top++;

                // Right column: top to bottom
                for (int i = top; i <= bottom; i++) {
                    System.out.print((first ? "" : " ") + matrix[i][right]);
                    first = false;
                }
                right--;

                // Bottom row: right to left
                if (top <= bottom) {
                    for (int i = right; i >= left; i--) {
                        System.out.print((first ? "" : " ") + matrix[bottom][i]);
                        first = false;
                    }
                    bottom--;
                }

                // Left column: bottom to top
                if (left <= right) {
                    for (int i = bottom; i >= top; i--) {
                        System.out.print((first ? "" : " ") + matrix[i][left]);
                        first = false;
                    }
                    left++;
                }
            }
            System.out.println();
        }
    }
}
