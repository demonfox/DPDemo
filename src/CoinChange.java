public class CoinChange {

    public int recursion(int[] coins, int amount, int index) {
        if (amount < 0)
            return 0;
        if (amount == 0)
            return 1;
        // still some change to make but we ran out of coin choices
        if (index < 0 && amount > 0)
            return 0;

        return recursion(coins, amount, index-1) + recursion(coins, amount-coins[index], index);
    }

    public int dp(int[] coins, int amount) {
        int[][] solution = new int[coins.length+1][amount+1];
        for (int j=1; j<amount+1; j++)
            solution[0][j] = 0;
        for (int i=0; i<coins.length+1; i++)
            solution[i][0] = 1;

        for (int i=1; i<coins.length+1; i++) {
            for (int j=1; j<amount+1; j++) {
                if (coins[i-1] > j) {
                    solution[i][j] = solution[i-1][j];
                } else {
                    solution[i][j] = solution[i][j-coins[i-1]] + solution[i-1][j];
                }
            }
        }
        return solution[coins.length][amount];
    }

    public static void main(String[] args) {
		int amount = 5;
        int[] coins = { 1, 2, 3 };
        CoinChange m = new CoinChange();
        System.out.println("By Dynamic Programming " + m.dp(coins, amount));
        System.out.println("By Dynamic Programming " + m.recursion(coins, amount, coins.length-1));
	}
}