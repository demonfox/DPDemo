public class MinNumberSquareSum {
    public int recursion(int N, int upperBound) {
        // reached the conlusion
        if (N <= 0)
            return 0;
        for (int i=upperBound; i>=1; i--) {
            if (i*i > N)
                continue;
            else {
                return Math.min(recursion(N-i*i, upperBound)+1, recursion(N, upperBound-1));
            }
        }

        // you get here when N != 0 and we did not figure out a correct resolution for
        // splitting N into square sum of a list of numbers, so return INT_MAX to 
        // indicate no solution
        return Integer.MAX_VALUE;
    }

    public int dp(int N, int upperBound) {
        int[] solutions = new int[N+1];
        // for N=0, there is no solution
        solutions[0] = 0;
        for (int i=1; i<N+1; i++) {
            solutions[i] = Integer.MAX_VALUE;
            for (int j=1; j<upperBound; j++) {
                if (j * j <= i) {
                    if (solutions[i - j*j] == Integer.MAX_VALUE)
                        solutions[i] = Integer.MAX_VALUE;
                    else
                        solutions[i] = Math.min(solutions[i-j*j] + 1, solutions[i]);
                } else 
                    break;
            }
        }
        return solutions[N];
    }

    public static void main(String[] args) {
		int N = 12;
		MinNumberSquareSum m = new MinNumberSquareSum();
        System.out.println("(Recursive) Minimum Numbers Required Whose Square Sum is Equal To a "
            + N + ": " + m.recursion(N, (int)Math.sqrt(N)));
        System.out.println("(DP) Minimum Numbers Required Whose Square Sum is Equal To a "
            + N + ": " + m.dp(N, (int)Math.sqrt(N)));
    }
}