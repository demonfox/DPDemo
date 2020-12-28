public class RodCutting {
    public int recursion(int[] price, int cutIndex) {
        if (cutIndex >= price.length)
            return 0;
        int maxPrice = -1;
        for (int i=cutIndex+1; i<=price.length; i++) {
            maxPrice = Math.max(maxPrice, price[i-cutIndex-1] + recursion(price, i));
        }
        return maxPrice;
    }

    public int dp(int[] price, int length) {
		int[] solution = new int[length + 1];
		solution[0] = 0;

		for (int i = 1; i <= length; i++) {
			int max = -1;
			for (int j = 0; j < i; j++) {
				max = Math.max(max, price[j] + solution[i - j - 1]);
				solution[i] = max;
			}
		}
		return solution[length];
	}

    public static void main(String[] args) {
        int[] price = { 2, 3, 7, 8, 9 };
        int len = 5;
        RodCutting m = new RodCutting();
        System.out.println("Max profit for length using recursion is " + len + ":"
            + m.recursion(price, 0));
        System.out.println("Max profit for length using DP is " + len + ":"
            + m.dp(price, 5));
        price = new int[]{ 1, 5, 8, 9 };
        len = 4;
        System.out.println("Max profit for length using recursion is " + len + ":"
            + m.recursion(price, 0));
        System.out.println("Max profit for length using DP is " + len + ":"
            + m.dp(price, 4));
    }
}