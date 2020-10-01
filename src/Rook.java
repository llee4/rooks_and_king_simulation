//Theo Baker and Christopher Nash
//20200312 APCSA
//create a rook piece and override the generateMoves method so that it can't do diagonals


import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {
	Rook(){
		super();
	}
	public List<List<Integer>> generateMoves(ArrayList<Piece> otherObjects, int row, int column) {
		List<List<Integer>> rookMoves = super.generateMoves(otherObjects, row, column);
		for (int i = 0; i < rookMoves.size(); i ++) {
			if (rookMoves.get(i).get(0) != row && rookMoves.get(i).get(1) != column) {
				rookMoves.remove(i);
			}
		}
		return rookMoves;
		
	}
}
