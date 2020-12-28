public class LongestCommonSubstring {
	public StringBuilder lcsString = new StringBuilder();

    public int dp(char [] A, char [] B) {
        int [][]LCS = new int [A.length+1][B.length+1];
		int maxLen = 0;
		int lastStartIndex = -1;
		// if A is null then LCS of A, B =0
		for(int i=0;i<=B.length;i++){
			LCS[0][i]=0;
		}
		
		// if B is null then LCS of A, B =0
		for(int i=0;i<=A.length;i++){ 
			LCS[i][0]=0;
		}
		
		//fill the rest of the matrix
		for(int i=1; i<=A.length; i++){
			for(int j=1; j<=B.length; j++) {
				if(A[i-1] == B[j-1]) {
                    LCS[i][j] =  LCS[i-1][j-1] +1;
					if (LCS[i][j] > maxLen) {
						maxLen = LCS[i][j];
						// current char index is i-1
						int currStartIndex = (i-1) - LCS[i][j] + 1;
						if (lastStartIndex != currStartIndex) {
							lastStartIndex = currStartIndex;
							lcsString.setLength(0);
							lcsString.append(A, currStartIndex, (i-1) - currStartIndex + 1);
						} else {
							lcsString.append(A[i-1]);
						}
					}
				} else {
					LCS[i][j] = 0;					
				}
			}
		}	
		
		return maxLen;
    }
    
    public static void main(String[] args) {
		String A = "varena";
		String B = "varenaesportsarena";
		LongestCommonSubstring m = new LongestCommonSubstring();
		System.out.println("LCS length : " + m.dp(A.toCharArray(), B.toCharArray()) 
					+ ", and the LCS is: " + m.lcsString);
	}
}