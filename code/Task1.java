public class Task1 {

    static boolean PRINT = false;
    static long steps = 0;

    static void work(int n) {
        if (PRINT) {
            System.out.println(n);
        }
        steps++;
    }

    // Function 1: T(n) = T(n - 1) + 1
    static void fun1(int n) {
        if (n > 0) {
            work(n);
            fun1(n - 1);
        }
    }

    // Function 2: T(n) = T(n - 1) + n
    static void fun2(int n) {
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                work(n);
            }
            fun2(n - 1);
        }
    }

    // Function 3: T(n) = T(n - 1) + log n
    static void fun3(int n) {
        if (n > 0) {
            for (int i = 1; i < n; i = i * 2) {
                work(n);
            }
            fun3(n - 1);
        }
    }

    // Function 4: T(n) = 2T(n - 1) + 1
    static void fun4(int n) {
        if (n > 0) {
            work(n);
            fun4(n - 1);
            fun4(n - 1);
        }
    }

    static double log2(double x) {
        return Math.log(x) / Math.log(2);
    }

    public static void main(String[] args) {
        PRINT = true;
        System.out.println("Demo: fun1(3) prints:");
        fun1(3);
        System.out.println("Demo: fun4(3) prints:");
        fun4(3);
        PRINT = false;

        int[] sizes = {5, 10, 20};

        System.out.println();
        System.out.println("Function 1: T(n) = T(n-1) + 1   expected: n");
        for (int n : sizes) {
            steps = 0;
            fun1(n);
            System.out.println("  n = " + n + "  steps = " + steps + "  formula n = " + n);
        }

        System.out.println("Function 2: T(n) = T(n-1) + n   expected: n(n+1)/2");
        for (int n : sizes) {
            steps = 0;
            fun2(n);
            long formula = (long) n * (n + 1) / 2;
            System.out.println("  n = " + n + "  steps = " + steps + "  formula n(n+1)/2 = " + formula);
        }

        System.out.println("Function 3: T(n) = T(n-1) + log n   expected: about log(n!) <= n*log2(n)");
        for (int n : sizes) {
            steps = 0;
            fun3(n);
            double logFactorial = 0;
            for (int k = 1; k <= n; k++) {
                logFactorial += log2(k);
            }
            System.out.printf("  n = %d  steps = %d  log2(n!) = %.1f  n*log2(n) = %.1f%n",
                    n, steps, logFactorial, n * log2(n));
        }

        System.out.println("Function 4: T(n) = 2T(n-1) + 1   expected: 2^n - 1 prints");
        for (int n : sizes) {
            steps = 0;
            fun4(n);
            long formula = (1L << n) - 1;
            System.out.println("  n = " + n + "  steps = " + steps + "  formula 2^n - 1 = " + formula);
        }
    }
}
