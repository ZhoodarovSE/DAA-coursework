public class Task2 {

    static boolean PRINT = false;
    static long steps = 0;

    static void work(int n) {
        if (PRINT) {
            System.out.println(n);
        }
        steps++;
    }

    // Function 1: T(n) = T(n/2) + 1
    static void fun1(int n) {
        if (n > 1) {
            work(n);
            fun1(n / 2);
        }
    }

    // Function 2: T(n) = T(n/2) + n
    static void fun2(int n) {
        if (n > 1) {
            for (int i = 0; i < n; i++) {
                work(n);
            }
            fun2(n / 2);
        }
    }

    // Function 3: T(n) = 2T(n/2) + n
    static void fun3(int n) {
        if (n > 1) {
            for (int i = 0; i < n; i++) {
                work(n);
            }
            fun3(n / 2);
            fun3(n / 2);
        }
    }

    static int log2(int n) {
        int k = 0;
        while (n > 1) {
            n = n / 2;
            k++;
        }
        return k;
    }

    public static void main(String[] args) {
        PRINT = true;
        System.out.println("Demo: fun1(16) prints:");
        fun1(16);
        PRINT = false;

        int[] sizes = {16, 1024, 65536};

        System.out.println();
        System.out.println("Function 1: T(n) = T(n/2) + 1   expected: log2(n)");
        for (int n : sizes) {
            steps = 0;
            fun1(n);
            System.out.println("  n = " + n + "  steps = " + steps + "  formula log2(n) = " + log2(n));
        }

        System.out.println("Function 2: T(n) = T(n/2) + n   expected: n + n/2 + ... + 2 = 2n - 2");
        for (int n : sizes) {
            steps = 0;
            fun2(n);
            System.out.println("  n = " + n + "  steps = " + steps + "  formula 2n - 2 = " + (2L * n - 2));
        }

        System.out.println("Function 3: T(n) = 2T(n/2) + n   expected: n * log2(n)");
        for (int n : sizes) {
            steps = 0;
            fun3(n);
            System.out.println("  n = " + n + "  steps = " + steps + "  formula n*log2(n) = " + ((long) n * log2(n)));
        }
    }
}
