class MinCostPath {
    public int findPath(int[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        int[][] solution = new int[rows][cols];
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (i == 0 && j==0) {
                    solution[i][j] = array[i][j];
                } else if (i==0 && j!=0) {
                    solution[i][j] = solution[i][j-1] + array[i][j];
                } else if (i!=0 && j==0) {
                    solution[i][j] = solution[i-1][j] + array[i][j];
                } else {
                    solution[i][j] = Math.min(solution[i-1][j], solution[i][j-1]) + array[i][j];
                }
            }
        }
        return solution[rows-1][cols-1];
    }

    public static void main(String[] args) {
        int[][] array = { { 1, 7, 9, 2, 11 }, { 8, 6, 3, 2, 12 }, { 1, 6, 7, 8, 13 }, { 2, 9, 8, 2, 10 } };
        MinCostPath m = new MinCostPath();
        System.out.println("Minimum Cost Path " + m.findPath(array));
    }
}