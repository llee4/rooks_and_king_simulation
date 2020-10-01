//Theo Baker and Christopher Nash
//20200312 APCSA
//give the basic characteristics for a piece -- random placement
//have a generateMoves method which is applicable to all pieces 
//but then can be reduced by more specific parameters through overriding

import java.util.*;

public class Piece {
	Piece() {
		row = rand.nextInt(8);
		column = rand.nextInt(8);
	}
	public int row;
	public int column;
	Random rand = new Random();
	public void reRandomize() {
		int i = rand.nextInt(8);
		row = i;
		int j = rand.nextInt(8);
		column = j;
	}
	public ArrayList<Piece> giveOtherObjectArrayList(ArrayList<Piece> piecesOnBoard, Piece pieceMakingFor){
		//gets the other objects that serve as obstacles to the movement of the piece 
		ArrayList<Piece> arrayListToReturn = new ArrayList<Piece>();
		for (int i = 0; i < piecesOnBoard.size(); i++) {
			if (pieceMakingFor == piecesOnBoard.get(i) || piecesOnBoard.get(i) instanceof King) {
				
			}
			else{
				arrayListToReturn.add(piecesOnBoard.get(i));
			}
		}
		
		return arrayListToReturn;
		
	}
	
	// row and column of object are given
	public List<List<Integer>> generateMoves(ArrayList<Piece> otherObjectsAsObjects, int row, int column) {
		//keeps adding moves in all directions until runs into an obstacle or runs out of board
		int otherObjects[][] = new int[otherObjectsAsObjects.size()][2];
		for (int i = 0; i < otherObjectsAsObjects.size(); i++) {
			otherObjects[i][0] = otherObjectsAsObjects.get(i).row;
			otherObjects[i][1] = otherObjectsAsObjects.get(i).column;

		}
		List<List<Integer>> possibleMoves = new ArrayList<List<Integer>>();
		for (int i = 1; i <= 8; i++) {
			if(row + i > 7) {
				i = 9;
			}
				for (int r = 0; r < otherObjects.length; r++) {
					
					if (row + i == otherObjects[r][0] && column == otherObjects[r][1]) {
						i = 9;
					}
				}
				if (i<=8) {
					possibleMoves.add(Arrays.asList(row + i, column));
				}
			}
			
		for (int i = 1; i <= 8; i++) {
			if (row - i < 0) {
				i = 9;
			}
				for (int r = 0; r < otherObjects.length; r++) {
					
					if (row - i == otherObjects[r][0] && column == otherObjects[r][1]) {
						i = 9;
					}
				}
				if (i<=8) {
					possibleMoves.add(Arrays.asList(row - i, column));
				}
			
			
		}
		for (int i = 1; i <= 8; i++) {
			if (column + i > 7) {
				i = 9;
			}
				for (int r = 0; r < otherObjects.length; r++) {
					if (row == otherObjects[r][0] && column + i == otherObjects[r][1]) {
						i = 9;
					}
				}
				if (i<=8) {
					possibleMoves.add(Arrays.asList(row, column + i));
				}
		}
		for (int i = 1; i <= 8; i++) {
			if (column - i < 0) {
				i = 9;
			}
				for (int r = 0; r < otherObjects.length; r++) {
					if (row == otherObjects[r][0] && column - i == otherObjects[r][1]) {
						i = 9;
					}
				}
				if (i<=8) {
					possibleMoves.add(Arrays.asList(row, column - i));
				}
		}
		for (int i = 1; i <= 8; i++) {
			if (row + i > 7 || column + i > 7) {
				i = 9;
			}
				for (int r = 0; r < otherObjects.length; r++) {
					
					if (row + i == otherObjects[r][0] && column + i == otherObjects[r][1]) {
						i = 9;
					}
				}
				if (i<=8) {
					possibleMoves.add(Arrays.asList(row + i, column + i));
				}
		}
		for (int i = 1; i <= 8; i++) {
			if (row - i < 0 || column - i < 0) {
				i = 9;
			}
				for (int r = 0; r < otherObjects.length; r++) {
					
					if (row - i == otherObjects[r][0] && column - i == otherObjects[r][1]) {
						i = 9;
					}
				}
				if (i<=8) {
					possibleMoves.add(Arrays.asList(row - i, column - i));
				}
		}
		for (int i = 1; i <= 8; i++) {
			if (row + i > 7 || column - i < 0) {
				i = 9;
			}
				for (int r = 0; r < otherObjects.length; r++) {
					
					if (row + i == otherObjects[r][0] && column - i == otherObjects[r][1]) {
						i = 9;
					}
				}
				if (i<=8) {
					possibleMoves.add(Arrays.asList(row + i, column - i));
				}
		}
		for (int i = 1; i <= 8; i++) {
			if (row - i < 0 || column + i > 7) {
				i = 9;
			}
				for (int r = 0; r < otherObjects.length; r++) {
					
					if (row - i == otherObjects[r][0] && column + i == otherObjects[r][1]) {
						i = 9;
					}
				}
				if (i<=8) {
					possibleMoves.add(Arrays.asList(row - i, column + i));
				}
		}
		return possibleMoves;

	}
}
