public class MaxProductCutting {
    public int recursive(int N) {
        if (N == 0 || N == 1)
            return 0;
        
        if (N == 2)
            return 1;

        int maxProduct = 0;
        for (int i=1; i<N; i++) {
            maxProduct = Math.max(maxProduct, Math.max(i * (N-i), i * recursive(N-i)));
        }

        return maxProduct;
    }

    public int dp(int N) {
        // pre: minimum N is 2
        int[] solutions = new int[N+1];
        solutions[0] = 0;
        solutions[1] = 0;
        solutions[2] = 1;

        for (int i=3; i<N+1; i++) {
            for (int j=1; j<i; j++) {
                solutions[i] = Math.max(solutions[i], Math.max(j * (i-j), j * solutions[i-j]));
            }
        }

        return solutions[N];
    }

    public static void main(String[] args) {
        MaxProductCutting m = new MaxProductCutting();
        for (int i=2; i<=10; i++) {
            System.out.println("(Recursive) Maximum Product for length: " + i + " is: "+ m.recursive(i));
            System.out.println("(DP) Maximum Product for legnth: " + i + " is: " + m.dp(i));
        }
    }
}