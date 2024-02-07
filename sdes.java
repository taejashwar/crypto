import java.util.Scanner;

public class sdes {
    public int K1, K2;
    public static final int P10[] = { 3, 5, 2, 7, 4, 10, 1, 9, 8, 6 };
    public static final int P10max = 10;
    public static final int P8[] = { 6, 3, 7, 4, 8, 5, 10, 9 };
    public static final int P8max = 10;

    public static int permute(int x, int p[], int pmax) {
        int y = 0;
        for (int i = 0; i < p.length; i++) {
            y = y << 1;
            y = y | (x >> (pmax - p[i])) & 1;
        }
        return y;
    }

    public sdes(int K) {
        K = permute(K, P10, P10max);
        int t1 = (K >> 5) & 0x1F;
        int t2 = K & 0x1F;
        t1 = ((t1 & 0xF) << 1) | ((t1 & 0x10) >> 4);
        t2 = ((t2 & 0xF) << 1) | ((t2 & 0x10) >> 4);
        K1 = permute((t1 << 5) | t2, P8, P8max);
        t1 = ((t1 & 0x7) << 2) | ((t1 & 0x18) >> 3);
        t2 = ((t2 & 0x7) << 2) | ((t2 & 0x18) >> 3);
        K2 = permute((t1 << 5) | t2, P8, P8max);
    }

    public static String toBinaryString(int num) {
        return String.format("%8s", Integer.toBinaryString(num)).replace(' ', '0');
    }

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the 10 Bit Key :");
        int K = Integer.parseInt(sc.next());
        sdes A = new sdes(K);
        System.out.print("\nKey K1: " + toBinaryString(A.K1));
        System.out.print("\nKey K2: " + toBinaryString(A.K2));
        sc.close();
    }
}
