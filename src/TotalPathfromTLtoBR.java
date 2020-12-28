class TotalPathfromTLtoBR {
    int rowCount;
	int colCount;
    int[][] auxArray;
    public int recursionTime = 0;
    public int dpTime = 0;

	public TotalPathfromTLtoBR(int array[][]) {
		this.auxArray = array;
		rowCount = array.length;
		colCount = array[0].length;
    }
    
    public int countRecursion(int currentRow, int currentCol) {
        if (currentRow == rowCount - 1) {
            recursionTime++;
            return 1;
        }
        if (currentCol == colCount - 1) {
            recursionTime++;
            return 1;
        }
        return countRecursion(currentRow + 1, currentCol) + countRecursion(currentRow, currentCol + 1)
                + countRecursion(currentRow + 1, currentCol + 1);
    }

    public int countDP() {
        for (int i=0; i<rowCount; i++) {
            for (int j=0; j<colCount; j++) {
                if (i==0 || j==0) {
                    auxArray[i][j] = 1;
                } else {
                    auxArray[i][j] = auxArray[i-1][j] + auxArray[i][j-1] + auxArray[i-1][j-1];
                }
                dpTime++;
            }
        }
        return auxArray[rowCount-1][colCount-1];
    }

    public static void main(String[] args) {
        int[][] array = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, {10, 11, 12} };
		TotalPathfromTLtoBR t = new TotalPathfromTLtoBR(array);
        System.out.println("No of Paths By Recursion: " + t.countRecursion(0, 0) + ". Time cost: " + t.recursionTime);
        System.out.println("No of Paths By Dynamic Programming: " + t.countDP() + ". Time cost: " + t.dpTime);
    }
}