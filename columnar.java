import java.util.*;

public class columnar {
    public static String encrypt(String text, String key) {
        String encrypted_text = "";
        int key_length = key.length();
        int num_rows = (int) Math.ceil((double) text.length() / key_length);
        int padding = num_rows * key_length - text.length();

        for (int i = 0; i < padding; i++) {
            text += "x";
        }

        char[][] matrix = new char[num_rows][key_length];
        int k = 0;
        for (int i = 0; i < num_rows; i++) {
            for (int j = 0; j < key_length; j++) {
                matrix[i][j] = text.charAt(k);
                k++;
            }
        }

        int[] column_order = new int[key_length];
        for (int i = 0; i < key_length; i++) {
            char ch = key.charAt(i);
            column_order[i] = key.indexOf(ch);
        }

        for (int col = 0; col < column_order.length; col++) {
            for (int row = 0; row < num_rows; row++) {
                encrypted_text += matrix[row][col];
            }
        }
        return encrypted_text;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the text to encrypt:");
        String text = sc.nextLine();

        System.out.println("Enter the key to encrypt:");
        String key = sc.nextLine();
        sc.close();

        System.out.println("The encrypted text is:" + encrypt(text, key));
    }
}