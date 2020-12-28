public class LongestPalindromicSubsequence {
    public int recursive(String str, int left, int right) {
        if (str.length() == 0)
            return 0;
        if (str.length() == 1)
            return 1;
        if (left > right)
            return 0;
        else if (left == right)
            return 1;
        if (str.charAt(left)== str.charAt(right)) {
            return 2 + recursive(str, left+1, right-1);
        } else {
            return Math.max(recursive(str, left+1, right), recursive(str, left, right-1));
        }
    }

    // the essence of the difference between DP and recursion is that the recursion
    // algorithm acts by working from outside in, while the DP algorithm acts by
    // working from inside out (thus *bottom-up*)
    public int dp(String A){
		char [] str = A.toCharArray();
		int [][]LPS = new int[str.length][str.length]; 
        // LP[i][j] - length of longest palindrome subsequence from ith index to 
        // jth index all the characters in the string are palindrome by itself 
        // of length 1 so all LPS[i][i] =  1 
		for(int i=0; i<str.length; i++){
			LPS[i][i] = 1;			
        }
        
		for(int sublen=2; sublen<=str.length; sublen++) {
            // i is the start of the current A[i...j] we are examining,
            // while sublen is the length of A[i...j]
			for(int i=0; i<=LPS.length-sublen; i++) {
				int j = i+sublen-1;
				if(str[i]==str[j] && sublen==2) {
					LPS[i][j] = 2;
				}
				else if(str[i]==str[j]) {
					LPS[i][j] = LPS[i+1][j-1]+2;
				}
				else {
					LPS[i][j] = Math.max(LPS[i+1][j], LPS[i][j-1]);
				}
			}
		}
		//printMatrix(LPS);
		return LPS[0][LPS.length-1];
    }
    public void printMatrix(int[][] LPS) {
		for(int i=0; i<LPS.length ;i++) {
			for(int j=0; j<LPS.length; j++) {
				System.out.print("  " + LPS[i][j]);
			}	
			System.out.println("");
		}
    }
    
    public static void main(String[] args) {
        String s = "AABCDEBAZ";
        LongestPalindromicSubsequence m = new LongestPalindromicSubsequence();
        System.out.println("(Recursion) Longest Palindromic Subsequence for " + s + " is: " + m.recursive(s, 0, s.length() - 1));
        System.out.println("(DP) Longest Palindromic Subsequence for " + s + " is: " + m.dp(s));
        s = "ABCA";
        System.out.println("(Recursion) Longest Palindromic Subsequence for " + s + " is: " + m.recursive(s, 0, s.length() - 1));
        System.out.println("(DP) Longest Palindromic Subsequence for " + s + " is: " + m.dp(s));
        s = "ABA";
        System.out.println("(Recursion) Longest Palindromic Subsequence for " + s + " is: " + m.recursive(s, 0, s.length() - 1));
        System.out.println("(DP) Longest Palindromic Subsequence for " + s + " is: " + m.dp(s));
        s = "AA";
        System.out.println("(Recursion) Longest Palindromic Subsequence for " + s + " is: " + m.recursive(s, 0, s.length() - 1));
        System.out.println("(DP) Longest Palindromic Subsequence for " + s + " is: " + m.dp(s));
        s = "ABAABAABA";
        System.out.println("(Recursion) Longest Palindromic Subsequence for " + s + " is: " + m.recursive(s, 0, s.length() - 1));
        System.out.println("(DP) Longest Palindromic Subsequence for " + s + " is: " + m.dp(s));
    }
}