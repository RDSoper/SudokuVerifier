package com.company;

import java.util.Arrays;
import java.util.HashSet;

/**
 * As part of my studies i was tasked with creating a tool to verify if a sudoku answer was correct. This is my solution based on what i was taught.
 *
 * @author (Russell Soper)
 * @version (V01 01012022)
 */
public class SudokuVerifier{

    // instance variables - replace the example below with your own
    private int[][] grid;

    /**
     * Constructor for objects of class SudokuVerifier
     */
    public SudokuVerifier(int[][] value){
        // initialise instance variables
        grid = value;

    }

    /**
     * Constructor for objects of class SudokuVerifier
     */
    public SudokuVerifier(boolean test){
        // initialise instance variables
        if (test){
            populateGrid1();
        }else{
            populateGrid2();
        }
        for(int row =0; row< grid[0].length; row++){
            System.out.println(Arrays.toString(grid[row]));
        }

    }

    /**
     * Checks one row, specified by aRow, for the numbers one to nine.
     * @param aRow The row to be checked.
     * @return true or false.
     */
    private boolean checkARow(int aRow){
        int[][] gridToCheck = grid;
        HashSet<Integer> values = new HashSet<>();
        for (int col = 0; col < grid[0].length; col++){
            values.add(gridToCheck[aRow][col]);
        }

        return values.size()==(grid[0].length);
    }

    /**
     * Checks one column, specified by aCol, for the numbers one to nine.
     * @param aCol The column to be checked.
     * @return true or false.
     */
    private boolean checkAColumn(int aCol){
        int[][] gridToCheck = grid;
        HashSet<Integer> values = new HashSet<>();
        for (int row = 0; row < grid[0].length; row++){
            values.add(gridToCheck[row][aCol]);
        }
        return values.size() == grid[0].length;
    }

    /**
     * Checks one block, a 3 by 3 grid, for the numbers one to nine.
     * @param aRow The starting row of the top left value in the grid to be checked.
     * @param aCol The starting column of the top left value in the grid to be checked.
     * @return true or false.
     */
    private boolean checkABlock(int aRow, int aCol){
        int[][] gridToCheck = grid;
        HashSet<Integer> values = new HashSet<>();
        for (int row = aRow; row < aRow + 3; row++){
            for (int col = aCol; col < aCol + 3; col++){
                values.add(gridToCheck[row][col]);
            }
        }
        if (values.size() == grid[0].length){
            return true;
        }
        return false;
    }

    /**
     * Checks all columns, for the numbers one to nine.
     *
     * @return true or false.
     */
    private boolean checkAllColumns(){
        int num = 0;
        for (int col = 0; col < grid.length; col++){
            if (checkAColumn(col)){
                num++;
            }
        }
        if (num == grid[0].length){
            return true;
        }
        return false;
    }

    /**
     * Checks all rows, for the numbers one to nine.
     *
     * @return true or false.
     */
    private boolean checkAllRows(){
        int num = 0;
        for (int row = 0; row < grid.length; row++) {
            if (checkARow(row)){
                num++;
            }
        }
        if (num == grid[0].length){
            return true;
        }
        return false;
    }

    /**
     * Checks all blocks, for the numbers one to nine.
     *
     * @return true or false.
     */
    private boolean checkAllBlocks(){
        int num = 0;
        for (int row = 0; row < grid[0].length; row = row + 3) {
            for (int col = 0; col < grid.length; col = col + 3) {
                if (checkABlock(row, col)){
                    num++;
                }
            }
        }
        if (num == grid[0].length){
            return true;
        }
        return false;
    }

    /**
     * Checks the entire sudoku grid, if everything is correct, congratulates the player.
     * @return A string congratulating or commiserating the player, depending on if the sudoku is correct.
     */
    public void verifySolution(){
        if ((checkAllRows()) && (checkAllColumns()) && (checkAllBlocks())){
            System.out.println("Congrats! This is Correct.");
        }else{
            System.out.println("Try again.");
        }
    }

    /**
     * Populates grid with a correct solution (Given to me as part of my open university studies.)
     */
    private void populateGrid1(){
        int[][] tempArray =
                        {{2, 4, 1, 6, 9, 5, 3, 8, 7},
                        {7, 3, 5, 4, 2, 8, 1, 6, 9},
                        {8, 6, 9, 7, 3, 1, 4, 2, 5},
                        {4, 1, 3, 8, 7, 9, 2, 5, 6},
                        {6, 9, 2, 5, 1, 3, 7, 4, 8},
                        {5, 8, 7, 2, 4, 6, 9, 3, 1},
                        {1, 7, 8, 3, 6, 4, 5, 9, 2},
                        {9, 5, 4, 1, 8, 2, 6, 7, 3},
                        {3, 2, 6, 9, 5, 7, 8, 1, 4}};
        grid = tempArray;
    }

    /**
     * Populates grid with an incorrect solution (Given to me as part of my open university studies.)
     */
    private void populateGrid2(){
        int[][] tempArray =
                        {{2, 4, 1, 6, 9, 5, 3, 8, 1},
                        {7, 3, 5, 4, 2, 8, 1, 6, 9},
                        {8, 6, 9, 7, 3, 1, 4, 2, 5},
                        {4, 1, 3, 8, 7, 9, 2, 5, 6},
                        {6, 9, 2, 5, 2, 3, 7, 4, 8},
                        {5, 8, 7, 2, 4, 6, 9, 3, 1},
                        {1, 7, 8, 3, 6, 4, 5, 9, 2},
                        {8, 5, 4, 1, 8, 2, 6, 7, 3},
                        {3, 2, 6, 9, 5, 7, 8, 1, 4}};
        grid = tempArray;
    }
}

