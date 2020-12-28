
public class MinCoinChange {
    public int minCoinRecursion(int amount, int[] coins, int coinTotal) {
        // change has been made, no more coin needed
        if (amount == 0)
            return 0;

        for (int i=coinTotal-1; i>=0; i--) {
            if (amount < coins[i])
                continue;
            else {
                return Math.min(minCoinRecursion(amount-coins[i], coins, coinTotal)+1,
                                minCoinRecursion(amount, coins, coinTotal-1));
            }
        }
        // you get here when amount !=0 and amount is less than the minimum
        // value of any coin denomination in coins[], so return INT_MAX to 
        // indicate no solution
        return Integer.MAX_VALUE;
    }

    public int minCoinDynamic(int amount, int[] coins) {
        // this will store the optimal solution
        // for all the values -- from 0 to given amount.
        int[] coinReq = new int[amount+1];

        coinReq[0] = 0; // 0 coins are required to make the change for 0
        // now solve for all the amounts
        for (int amt = 1; amt <= amount; amt++) {
            coinReq[amt] = Integer.MAX_VALUE;
            // Now try taking every coin one at a time and pick the minimum
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= amt) { // check if coin value is less than amount
                    // select the coin and add 1 to solution of (amount-coin value)
                    if (coinReq[amt - coins[j]] == Integer.MAX_VALUE)
                        coinReq[amt] = Integer.MAX_VALUE;
                    else
                        coinReq[amt] = Math.min(coinReq[amt - coins[j]] + 1, coinReq[amt]) ;
                }
            }
        }
        //return the optimal solution for amount
        return coinReq[amount];
    }

    public static void main(String[] args) {
        MinCoinChange m = new MinCoinChange();
        System.out.println("(Dynamic Programming) Minimum Coins required to make change for 20 are: "
                + m.minCoinDynamic(20, new int[] {1, 2, 3}));
        System.out.println("(Recursion) Minimum Coins required to make change for 20 are: "
                + m.minCoinRecursion(20, new int[] {1, 2, 3}, 3));
    }
}