public class LongestCommonSubsequence {
    public StringBuilder lcsString = new StringBuilder();

    public int recursion(String A, String B) {
        if (A.length() == 0 || B.length() == 0) {
            return 0;
        }
        int lenA = A.length();
        int lenB = B.length();
        // check if last characters are same
        if (A.charAt(lenA - 1) == B.charAt(lenB - 1)) {
            // Add 1 to the result and remove the last character from both
            // the strings and make recursive call to the modified strings.
            return 1 + recursion(A.substring(0, lenA - 1), B.substring(0, lenB - 1));
        } else {
            // Remove the last character of String 1 and make a recursive
            // call and remove the last character from String 2 and make a
            // recursive and then return the max from returns of both recursive
            // calls
            return Math.max(
                recursion(A.substring(0, lenA - 1), B.substring(0, lenB)),
                recursion(A.substring(0, lenA), B.substring(0, lenB - 1)));
        }
    }

    public int dp(char[] A, char[] B) {
        int[][] LCS = new int[A.length + 1][B.length + 1];

        // if A is null then LCS of A, B =0
        for (int i = 0; i<=B.length; i++) {
            LCS[0][i] = 0;
        }

        // if B is null then LCS of A, B =0
        for (int i=0; i<=A.length; i++) {
            LCS[i][0] = 0;
        }

        for (int i=1; i<=A.length; i++) {
            for (int j=1; j<=B.length; j++) {
                if (A[i-1] == B[j-1]) {
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                } else {
                    LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
                }
            }
        }

        recon(lcsString, LCS, A, B, A.length, B.length);

        return LCS[A.length][B.length];
    }

    private void recon(StringBuilder a, int[][] LCS, char[]A, char[]B, int i, int j) {
        if (i == 0 || j == 0)
            return;
        if (A[i-1] == B[j-1]) {
            a.insert(0, A[i-1]);
            recon(a, LCS, A, B, i-1, j-1);
            //a.append(A[i-1]);
        }
        else if (LCS[i-1][j] > LCS[i][j-1]) {
            recon(a, LCS, A, B, i-1, j);
        } else {
            recon(a, LCS, A, B, i, j-1);
        }
    }

    public static void main(String[] args) {
        String A = "ACBDEA";
        String B = "ABCDA";
        LongestCommonSubsequence m = new LongestCommonSubsequence();
        System.out.println("LCS length: " + m.recursion(A, B));
        System.out.println("LCS length: " + m.dp(A.toCharArray(), B.toCharArray()) + ", and the LCS is: " + m.lcsString);
    }
}