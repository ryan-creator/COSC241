package week12;

public class TableauApp {

	public static boolean isTableau(int[][] t){
		if(rowLengthsDecrease(t) && isSetOf1toN(t)){
            if(columnValuesIncrease(t)  && rowValuesIncrease(t)){
                return true;
            }
        }
        return false;
    }

	public static boolean rowLengthsDecrease(int[][] t){
		int rowCount = 0;
		int lastRowCount = 0;
		for(int i = 0; i < t.length; i++){
			for(int j = 0; j < t[i].length; j++){
				rowCount++;
			}
			if(lastRowCount != 0 && rowCount > lastRowCount){
				return false;
			}
			lastRowCount = rowCount;
			rowCount = 0;
		}
		return true;
	}

	public static boolean rowValuesIncrease(int[][] t){
		for(int i = 0; i < t.length; i++){
			for(int j = 0; j < t[i].length; j++){
				if(j != 0 && t[i][j] < t[i][j-1]){
					return false;
				}
			}
		}
		return true;
	}

	public static boolean columnValuesIncrease(int[][] t){
		for(int i = 0; i < t.length; i++){
			for(int j = 0; j < t[i].length; j++){
				if(i != 0 && t[i][j] < t[i-1][j]){
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isSetOf1toN(int[][] t){
		int num = 1;
		for(int i = 0; i < t.length; i++){
			for(int j = 0; j < t[i].length; j++){
				if(t[i][j] == num){
					i = 0;
					j = 0;
					num++;
				}
				if(num == countCells(t)){
					return true;
				}
			}
		}
		return false;
	}

	public static int countCells(int[][] t){
		int count = 0;
		for(int i = 0; i < t.length; i++){
			for(int j = 0; j < t[i].length; j++){
				count++;
			}
		}
		return count;
	}
}