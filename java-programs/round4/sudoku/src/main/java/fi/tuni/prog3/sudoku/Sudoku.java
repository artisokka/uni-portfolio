package fi.tuni.prog3.sudoku;

import static java.lang.Character.isDigit;
import java.util.HashSet;


/**
 *
 * @author janik
 */

public class Sudoku {
    private Character[][] board;
    
    public Sudoku() {
        this.board = new Character[9][9];
    }
    public void set(int i, int j, char c) {
        if(i > 8 || j > 8 || i < 0 || j < 0) {
            System.out.println("Trying to access illegal cell (" + i + ", " + j + ")!");
        }
        else {
            if(isDigit(c) || c == ' ') {
                this.board[i][j] = c;
            }
            else {
                System.out.println("Trying to set illegal character " + c + " to (" + i + ", " + j + ")!");
                this.board[i][j] = ' ';
            }
        }
    }
    public boolean check() {
        boolean isValid = true;
    
        // Row check
        for (int i = 0; i < 9; i++) {
            HashSet<Character> entries = new HashSet<>(9);
            for ( int j = 0; j < 9; j++) {
                
                if (this.board[i][j] != ' ' && entries.add(this.board[i][j]) == false) {
                    isValid = false;
                    char c = this.board[i][j];
                    System.out.println("Row "+ i +" has multiple " + c + "'s!");
                    return isValid;
                }
            }
        }
        // Column check
        for (int i = 0; i < 9; i++) {
            HashSet<Character> entries = new HashSet<>(9);
            for ( int j = 0; j < 9; j++) {
                
                if (this.board[j][i] != ' ' && entries.add(this.board[j][i]) == false) {
                    char c = this.board[j][i];
                    System.out.println("Column "+ i +" has multiple " + c + "'s!");
                    isValid = false;
                    return isValid;
                }
            }
        }
        
        // Block check
        for (int block = 0; block < 9; block++) {
            HashSet<Character> entries = new HashSet<>(9);
            int startRow = (block / 3) * 3;
            int startCol = (block % 3) * 3;
            int x = startRow;
            int y = startCol;
            
            for (int i = startRow; i < startRow + 3; i++) {
                for (int j = startCol; j < startCol + 3; j++) {
                    char c = this.board[i][j];
                    if (c != ' ' && entries.add(c) != true) {
                        System.out.println("Block at (" + x + ", " + y + ") has multiple " + c + "'s!");
                        isValid = false;
                        return isValid;
                    }
                }
            }
        }
        return isValid;
    }
    public void print() {
        System.out.println("#####################################");
        for (int i = 0; i < 9; i++) {
            
            for ( int j = 0; j < 9; j++) {
                if (j == 0) {
                    System.out.print("#");
                }
                System.out.format(" %c ", this.board[i][j]);

                
                if(j == 2 || j == 5 || j == 8) {
                    System.out.print("#");
                    if(j == 8) {
                        System.out.println();
                    }
                }
                else if(j < 8) {
                    System.out.print("|");
                }
            }
            if(i == 2 || i == 5 || i == 8) {
                System.out.println("#####################################");
            }
            else {
                System.out.println("#---+---+---#---+---+---#---+---+---#");
            }
            
        }
    } 
}
