import java.util.Scanner;
import java.math.*;

public class rsa {
    
    // GCD function
    public static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    // Check Prime funciton
    public static boolean isPrime(int n) {
        if(n <= 1) {
            return false;
        }

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        // Plain text
        System.out.println("Enter the message to be encrypted:");
        int message = scan.nextInt();

        System.out.println("Enter prime number p:");
        int p = scan.nextInt();

        System.out.println("Enter prime number q:");
        int q = scan.nextInt();

        // Check Prime
        if(!isPrime(p) && !isPrime(q)) {
            System.out.println("p and q are supposed to be prime numbers!!");
        }

        // n value
        int n = p * q;

        // totient value
        int nz = (p - 1)*(q - 1);

        // Encryption Exponent e value
        System.out.println("Enter the exponent value e:");
        int exp = scan.nextInt();

        scan.close();

        int e;
        for(e = exp ; e < nz; e++) {
            if(gcd(e, nz) == 1) {
                break;
            }
        }
        System.out.println("Value of e:" + e);

        // Decryption Exponent d value
        int d = 0;
        for(int i = 0; i <= 9; i++) {
            int x = 1 + (i * nz);
            if(x % e == 0) {
                d = x / e;
                break;
            }
        }
        System.out.println("Value of d:" + d);


        // Encryption
        double encrypted = (Math.pow(message, e) % n);
        System.out.println("Encrypted Message:" + encrypted);

        BigInteger N = BigInteger.valueOf(n);
        BigInteger ENCRYPTED = BigDecimal.valueOf(encrypted).toBigInteger();

        // Decryption
        BigInteger decrypted = ENCRYPTED.pow(d).mod(N);
        System.out.println("Decrypted Message:" + decrypted);
    }
}
