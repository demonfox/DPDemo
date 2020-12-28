public class ClimbStairs {		

	public int countPossibleWaysTopDown(int totalSteps, int[] ways) {
		if (totalSteps < 1) {
			return 0;
		}
		if (ways[totalSteps] > 0) {
			return ways[totalSteps];
		}
		// Here "+1" means the last step there is one way of getting to the goal 
		// (either by taking 1 step or 2 steps or 3 steps) given you have already
		// taken possibleWays[n-1] + possibleWays[n-2] + possibleWays[n-3] steps
        ways[totalSteps] = 1 + countPossibleWaysTopDown(totalSteps - 1, ways) 
                + countPossibleWaysTopDown(totalSteps - 2, ways)
				+ countPossibleWaysTopDown(totalSteps - 3, ways);
		return ways[totalSteps];
	}

    public int countPossibleWaysBottomUp(int totalSteps) {
        int[] ways = new int[totalSteps+1];
        ways[0] = 0;
        ways[1] = 1;
        ways[2] = 2;
        for (int i=3; i<=totalSteps; i++) {
            ways[i] = 1 + ways[i-1] + ways[i-2] + ways[i-3];
        }
        return ways[totalSteps];
    }

	public static void main(String[] args) {
		int totalSteps = 20;
		ClimbStairs s = new ClimbStairs();
		int[] ways = new int[totalSteps + 1];
        System.out.println(s.countPossibleWaysTopDown(totalSteps, ways));
        System.out.println(s.countPossibleWaysBottomUp(totalSteps));
	}

}