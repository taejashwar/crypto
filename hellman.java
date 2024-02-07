import java.util.Scanner;

public class hellman {

    public static boolean isPrime(long p) {
        if(p <= 1) {
            return false;
        } 

        for(long i = 2; i <= Math.sqrt(p); i++) {
            if(p % i == 0) {
                return false;
            }
        }

        return true;
    }
    
    public static long power(long a, long b, long p) {
        if(b == 1) {
            return a;
        } else {
            return (((long) Math.pow(a, b)) % p);
        }
    }

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a prime number P:");
        long P = scan.nextInt();

        if(isPrime(P)) {
            System.out.println("Enter its primitive root G:");
            long G = scan.nextInt();

            System.out.println("Enter private key of A:");
            long A = scan.nextInt();

            System.out.println("Enter private key of B:");
            long B = scan.nextInt();

            long X = power(G, A, P);
            long Y = power(G, B, P);

            long kA = power(Y, A, P);
            long kB = power(X, B, P);

            System.out.println("Shared key of A: " + kA);
            System.out.println("Shared key of B: " + kB);
            
        } else {
            System.out.println("P should be a prime number");
        }

        scan.close();
    }
}
