import java.util.Scanner;

public class extended {

    public static int[] multiplicativeInverse(int a, int m) {
        int[] result = new int[21];

        int A = a, B = m, Q, R, T1 = 0, T2 = 1, T;
        int step = 0;
        
        if(B > A) {
            int temp = A;
            A = B;
            B = temp;
        }

        while (true) {
            
            Q = A / B;
            R = A % B;
            T = T1 - Q * T2;
            result[step] = Q;
            result[step + 1] = A;
            result[step + 2] = B;
            result[step + 3] = R;
            result[step + 4] = T1;
            result[step + 5] = T2;
            result[step + 6] = T;

            if(R == 0) {
                break;
            }

            A = B;
            B = R;
            T1 = T2;
            T2 = T;

            step += 7;
        }

        return result;
    }

    public static void displayTable(int[] result, int a, int m) {
        int steps = result.length / 7;
        for(int i = 0; i < steps; i++) {
            int step = i*7;
            System.out.println(
                result[step] + "\t" +
                result[step + 1] + "\t" +
                result[step + 2] + "\t" +
                result[step + 3] + "\t" +
                result[step + 4] + "\t" +
                result[step + 5] + "\t" +
                result[step + 6]
            );
        }

        int multiplicativeInverse = (result[result.length - 2] % m + m) % m;
        System.out.println("--------------------------------------------------------------");
        System.out.println("MULTIPLICATIVE INVERSE: " + multiplicativeInverse); 
        System.out.println(result[result.length - 2] % m); 
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter value of a:");
        int a = scan.nextInt();
        System.out.println("Enter value of m:");
        int m = scan.nextInt();

        scan.close();

        int[] result = multiplicativeInverse(a, m);

        System.out.println("EXTENDED EUCLIDEAN ALGORITHM TO FIND MULTIPLICATIVE INVERSE");
        System.out.println("--------------------------------------------------------------");
        System.out.println("Q\tA\tB\tR\tT1\tT2\tT");

        displayTable(result, a, m);
    }
}