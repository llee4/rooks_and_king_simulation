//Theo Baker and Christopher Nash
//20200312 APCSA
//run a simulation 250,000 times to see how many times 4 randomly placed rooks will checkmate a king

import java.io.*;
import java.util.*;
public class Simulation {
	public static void main(String[] args) throws IOException{

		String fileName = "/Users/theobaker/simulation_results.csv";
		FileWriter myWriter = new FileWriter(new File(fileName));
		int checkmateCounter = 0;
		int stalemateCounter = 0;
		
		for (int i = 0; i < 250000; i++){
			int[][] board = new int[8][8];
			ArrayList<Piece> piecesOnBoard = new ArrayList<Piece>();
			King king = new King();
			board[king.row][king.column] = 3;
			piecesOnBoard.add(king);
			Rook rook1 = new Rook();
			// keeps re-randomizing until it isn't a problem
			while (board[rook1.row][rook1.column] != 0) {
				rook1.reRandomize();
			}
			board[rook1.row][rook1.column] = 1;
			piecesOnBoard.add(rook1);
			Rook rook2 = new Rook();
			while (board[rook2.row][rook2.column] != 0) {
				rook2.reRandomize();
			}
			board[rook2.row][rook2.column] = 1;
			piecesOnBoard.add(rook2);
			Rook rook3 = new Rook();
			while(board[rook3.row][rook3.column] != 0) {
				rook3.reRandomize();
			}
			board[rook3.row][rook3.column] = 1;
			piecesOnBoard.add(rook3);
			Rook rook4 = new Rook();
			while(board[rook4.row][rook4.column] != 0) {
				rook4.reRandomize();
			}
			board[rook4.row][rook4.column] = 1;
			piecesOnBoard.add(rook4);
			//creates all the possible moves by sending to respective overriden methods
			List<List<Integer>> kingMoves = king.generateMoves(king.giveOtherObjectArrayList(piecesOnBoard, king), king.row, king.column);
			List<List<Integer>> rook1Moves = rook1.generateMoves(rook1.giveOtherObjectArrayList(piecesOnBoard, rook1), rook1.row, rook1.column);
			List<List<Integer>> rook2Moves = rook2.generateMoves(rook2.giveOtherObjectArrayList(piecesOnBoard, rook2), rook2.row, rook2.column);
			List<List<Integer>> rook3Moves = rook3.generateMoves(rook3.giveOtherObjectArrayList(piecesOnBoard, rook3), rook3.row, rook3.column);
			List<List<Integer>> rook4Moves = rook4.generateMoves(rook4.giveOtherObjectArrayList(piecesOnBoard, rook4), rook4.row, rook4.column);

			// conditions for a checkmate: king cannot move without placing itself into check
			// one of the rooks has to be in position to kill the king (i.e. in attacking position)
			// we are disregarding stalemates
			if (kingMoves.isEmpty() && rookHitKing(king, rook1Moves, rook2Moves, rook3Moves, rook4Moves) == true) {
				myWriter.write("\ncheckmate\n");
				checkmateCounter++;
				for(int r = 0; r < board.length; r++) {
					for(int c = 0; c < board[0].length; c++) {
						myWriter.write(board[r][c] + "     ");
					}
					myWriter.write("\n");
				}
			}
			else if (kingMoves.isEmpty() && rookHitKing(king, rook1Moves, rook2Moves, rook3Moves, rook4Moves) == false){
				myWriter.write("\nstalemate\n");
				stalemateCounter++;
				for(int r = 0; r < board.length; r++) {
					for(int c = 0; c < board[0].length; c++) {
						myWriter.write(board[r][c] + "     ");
					}
					myWriter.write("\n");
				}
			}
			else {
				myWriter.write("\nno checkmate or stalemate\n");
				for(int r = 0; r < board.length; r++) {
					for(int c = 0; c < board[0].length; c++) {
						myWriter.write(board[r][c] + "     ");
					}
					myWriter.write("\n");
				}
			}
			if (i%10000 == 0)
				System.out.print(".");
		}
		System.out.println("\nThere were a total of " + checkmateCounter + " checkmates and " + stalemateCounter
				+ " stalemates out of 250,000 runs");
		myWriter.write("\nThere were a total of " + checkmateCounter + " checkmates and " + stalemateCounter
				+ " stalemates out of 250,000 runs");
		myWriter.close();
	}
	
	//checks to see if a rook is in attacking position
	public static boolean rookHitKing(King king, List<List<Integer>> rook1Moves, List<List<Integer>> rook2Moves, List<List<Integer>> rook3Moves, List<List<Integer>> rook4Moves) {
		List<List<List<Integer>>> allRookMoves = new ArrayList<List<List<Integer>>>();
		allRookMoves.add(rook1Moves);
		allRookMoves.add(rook2Moves); 
		allRookMoves.add(rook3Moves);
		allRookMoves.add(rook4Moves);
		for (int i = 0; i < allRookMoves.size(); i++) {
			for (int m = 0; m < allRookMoves.get(i).size(); m++)
				if (allRookMoves.get(i).get(m).get(0) == king.row && allRookMoves.get(i).get(m).get(1) == king.column) {
					return true;
				}
		}

		return false;
	}
}

