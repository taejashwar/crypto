import java.util.*;

public class playfair {
    public static String prepare_key(String key) {
        String preparedKey = key;
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            if (ch == 'J') {
                continue;
            }
            if (key.indexOf(ch) == -1) {
                preparedKey += ch;
            }
        }
        return preparedKey;
    }

    public static char[][] initialize_matrix(String key) {
        char[][] matrix = new char[5][5];
        int k = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = key.charAt(k++);
            }
        }
        return matrix;
    }

    public static int[] find_position(char ch, char[][] matrix) {
        int[] result = new int[2];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[i][j] == ch) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public static String encrypt(String text, char[][] matrix) {
        String encrypted_text = " ";
        for (int i = 0; i < text.length(); i += 2) {
            char first = text.charAt(i);
            char second = ' ';
            if (i + 1 < text.length()) {
                second = text.charAt(i + 1);
            } else {
                second = 'X';
            }

            int[] firstPosition = find_position(first, matrix);
            int[] secondPosition = find_position(second, matrix);

            int row1 = firstPosition[0];
            int col1 = firstPosition[1];
            int row2 = secondPosition[0];
            int col2 = secondPosition[1];

            if (row1 == row2) {
                encrypted_text += matrix[row1][(col1 + 1) % 5];
                encrypted_text += matrix[row2][(col2 + 1) % 5];
            } else if (col1 == col2) {
                encrypted_text += matrix[(row1 + 1) % 5][col1];
                encrypted_text += matrix[(row2 + 1) % 5][col2];
            } else {
                encrypted_text += matrix[row1][col2];
                encrypted_text += matrix[row2][col1];
            }
        }
        return encrypted_text;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the text to encrypt:");
        String text = sc.next().toUpperCase();

        System.out.println("Enter the key:");
        String key = prepare_key(sc.next().toUpperCase());

        char[][] matrix = initialize_matrix(key);

        System.out.println("The encrypted text is:" + encrypt(text, matrix));

        sc.close();
    }
}