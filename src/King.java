//Theo Baker
//20200312 APCSA
//create a king piece and override the generateMoves method so that it 
//cannot move to a row or column with a rook or move more than one space

import java.util.ArrayList;
import java.util.List;

public class King extends Piece{
	King(){
		super();
	}
	public List<List<Integer>> generateMoves(ArrayList<Piece> otherObjects, int row, int column) {
		List<List<Integer>> kingMoves = super.generateMoves(otherObjects, row, column);
		// removes a movement if not applicable because more than one move
		for (int i = 0; i < kingMoves.size(); i++) {
				if (kingMoves.get(i).get(0) > (row + 1)) {
					kingMoves.remove(i);
					i--;
				}
				else if (kingMoves.get(i).get(0) < (row - 1)) {
					kingMoves.remove(i);
					i--;
				}
				else if (kingMoves.get(i).get(1) > (column + 1)) {
					kingMoves.remove(i);
					i--;
				}
				else if (kingMoves.get(i).get(1) < (column - 1)) {
					kingMoves.remove(i);
					i--;
				}
		}
		// if king moves to row or column of another rook then delete that move
		for (int i = 0; i < kingMoves.size(); i++) {
			for(int x = 0; x < otherObjects.size(); x++) {
				if(kingMoves.get(i).get(0) == otherObjects.get(x).row) {
					kingMoves.remove(i);
				}
				else if (kingMoves.get(i).get(1) == otherObjects.get(x).column) {
					kingMoves.remove(i);
				}
				if(i >= kingMoves.size()) {
					x = otherObjects.size();
				}
			}
			
		}
		return kingMoves;
	}
}
