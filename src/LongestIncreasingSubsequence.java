
public class LongestIncreasingSubsequence {

	public void findLIS(int[] array) {
		int[] LIS = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			int max = -1;
			for (int j = 0; j < i; j++) {
				// check if previous elements > current element
				if (array[j] < array[i]) {
					// update the max from the previous entries
					if (max == -1 || max < LIS[j] + 1) {
						max = 1 + LIS[j];
					}
				}
			}
			if (max == -1) {
				// means none of the previous element is smaller than arrA[i]
				max = 1;
			}
			LIS[i] = max;
		}

		printLIS(array, LIS);
	}

	public void printLIS(int[] array, int[] LIS) {
		// find the max in the LIS[]
		int result = -1;
		int index = -1;
		for (int i = 0; i < LIS.length; i++) {
			if (result < LIS[i]) {
				result = LIS[i];
				index = i;
			}
		}
		// print the result: moving backwards from the end
		StringBuilder path = new StringBuilder();
		path.insert(0, array[index]);
		int res = result - 1;
		for (int i = index - 1; i >= 0; i--) {
			if (LIS[i] == res) {
				path.insert(0, array[i] + " ");
				res--;
			}
		}
		System.out.println("Longest Increasing subsequence: " + result);
		System.out.println("Actual Elements: " + path.toString());
	}

	public static void main(String[] args) {
		int[] A = { 1, 12, 7, 0, 23, 11, 52, 31, 61, 69, 70, 2 };
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		lis.findLIS(A);
	}
}