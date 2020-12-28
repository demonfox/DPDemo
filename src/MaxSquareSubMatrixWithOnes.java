class MaxSquareSubMatrixWithOnes {
    public int compute(int[][] array, int rows, int cols) {
        int[][] auxMatrix = new int[rows][cols];
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (i==0 || j==0) {
                    // this is the first row or first column, just copy the value
                    auxMatrix[i][j] = array[i][j];
                } else {
                    if (array[i][j] == 0) {
                        auxMatrix[i][j] = 0;
                    } else {
                        auxMatrix[i][j] = 1 + Math.min(auxMatrix[i - 1][j - 1], Math.min(auxMatrix[i - 1][j], auxMatrix[i][j - 1]));
                    }
                }
            }
        }

        int maxSize = 0;
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                maxSize = (auxMatrix[i][j] > maxSize) ? auxMatrix[i][j] : maxSize;
            }
        }

        return maxSize;
    }

    public static void main(String[] args) {
		int[][] array = { { 0, 1, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1, 0 },
				{ 0, 1, 1, 1, 1, 0 }, { 0, 0, 1, 1, 1, 0 },
				{ 1, 1, 1, 1, 1, 1 } };
        MaxSquareSubMatrixWithOnes m = new MaxSquareSubMatrixWithOnes();
		System.out.println("Max size sub-matrix with all 1's is: " + m.compute(array, 5, 6));
	}
}