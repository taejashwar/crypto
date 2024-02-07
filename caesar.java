import java.util.Scanner;

public class caesar {
    public static String encrypt(String plaintext, int key) {
        StringBuilder ciphertext = new StringBuilder();

        for(char i: plaintext.toCharArray()) {
            if(Character.isLetter(i)) {
                char base = Character.isUpperCase(i) ? 'A' : 'a';
                ciphertext.append((char) ((i - base + key) % 26 + base));
            } else {
                ciphertext.append(i);
            }
        }

        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, int key) {
        return encrypt(ciphertext, 26 - key);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter plain text:");
        String plaintext = scan.nextLine();

        System.out.println("Enter key value:");
        int key = scan.nextInt();

        String encryptedText = encrypt(plaintext, key);
        String decryptedText = decrypt(encryptedText, key);

        System.out.println("Encrypted Text: " + encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);

        scan.close();
    }
}