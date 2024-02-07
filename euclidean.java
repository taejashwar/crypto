import java.util.Scanner;

public class euclidean {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.println("Enter first number:");
        int n1 = input.nextInt();
        System.out.println("Enter second number:");
        int n2 = input.nextInt();

        if(n2 > n1) {
            int temp = n1;
            n1 = n2;
            n2 = temp;
        }

        int rem;

        do {
            
            rem = n1 % n2;
            n1 = n2;
            if(rem == 0) {
                int gcd = n2;
                System.out.println("GCD:"+ gcd);
            }
            n2 = rem;
            
        } while (rem != 0);

        input.close();
    }
}