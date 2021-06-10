
public class Lab9 {
	public static void addTo10(int [][] array) {
		int answer = 0;
		for (rows = 0; rows < array.length; rows++);
		{
			for(columns = 0; columns < array[0].length; columns++)
			{
				answer = array[rows][columns];
			}
			for(columns = 0; columns < array[0].length; columns++)
			{
				if(array[rows][columns]==0)
				{
					array[rows][columns]=10-answer ;
				}
			}
		answer = 0;
		}

	public static void setHints(int [][] array) {

	}

	public static boolean isInBounds(int i, int j, int[][] board){
		return (i >= 0 && i < board.length) && (j >= 0 && j < board[i].length);
	}

	public static boolean isBomb(int value){
		return value == -1;
	}


	public static void main(String[] args){ 

		int [][] matrix = {
			{-1, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, -1, 0, -1}, 
			{0, 0, 0, -1, 0, 0}, 
			{0, 0, 0, 0, 0, 0}
		};

		int [][] matrix2 = {
			{6, 3, 2, 0, 4}, 
			{34, 53, 0, 23, 1}, 
			{0, 23, 54, 11, 7}
		};

		int [][] matrix3 = {
			{ 0, -1, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0 }, 
			{ -1, 0, 0, 0, 0, 0 }, 
			{ -1, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0 } 
		};

		addTo10(matrix2);
		setHints(matrix);
		setHints(matrix3);
	} 

}




