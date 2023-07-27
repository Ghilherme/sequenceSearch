package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SequenceSearch {

    private SequenceSearch() {
        //
    }

    public static boolean process() {
        try
        {
            System.out.println("Enter matrix size (N x M):");
            //Read and validate inputs
            MatrixSizeModel matrixConfig= validateInput(getInput());

            if(matrixConfig == null) return true;

            //Read and validate the whole matrix
            int[][] matrix = readMatrix(matrixConfig);
            if (Arrays.deepEquals(matrix, new int[][]{}))
                return true;

            //sort
            int[] sortedMatrixValues = sortMatrix(matrix,matrixConfig);

            //find longest SS
            int[] longestSS = longestSS(sortedMatrixValues);

            //print result
            printOutput(longestSS);

            return true;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static int[] sortMatrix(int[][] matrix, MatrixSizeModel matrixConfig) {
        int[] allValues = new int[matrixConfig.getRowLen() * matrixConfig.getColLen()];

        // retrieve matrix elements
        int n = 0;
        for (int[] row : matrix)
            for (int col : row)
                allValues[n++] = col;

        //sort all values
        Arrays.sort(allValues);

        return allValues;
    }

    public static int[] longestSS(int[] sortedValues) {
        int startOfLongestSS = 0;
        int endOfLongestSS = 0;
        int lengthOfLongestSS = 0;
        int lengthOfCurrentSS = 0;

        for (int i = 1; i < sortedValues.length; i++) {
            if (sortedValues[i] == sortedValues[i - 1] + 1) {
                ++lengthOfCurrentSS;
            } else {

                if (lengthOfCurrentSS > lengthOfLongestSS) {
                    lengthOfLongestSS = lengthOfCurrentSS + 1;
                    endOfLongestSS = i;
                    startOfLongestSS = endOfLongestSS - lengthOfLongestSS + 1;
                } else {
                    lengthOfCurrentSS = 0;
                }
            }
        }

        return Arrays.copyOfRange(sortedValues, startOfLongestSS, endOfLongestSS);
    }


    private static void printOutput(int[] output) {
        StringBuilder st= new StringBuilder();

        for (int x : output)
            st.append(x).append(" ");

        System.out.println(st);
    }

    private static int[][] readMatrix(MatrixSizeModel matrixConfig) {
        try{
            int[][] vars = new int[matrixConfig.getRowLen()][matrixConfig.getColLen()];
            int row;
            for(row=0; row < matrixConfig.getRowLen(); row++){
                String[] checkInput = getInput().split(" ");

                if(checkInput.length != matrixConfig.getColLen()) {
                    System.out.println("Columns numbers differs from specified.");
                    return new int[0][0];
                }

                for (int x=0; x<checkInput.length; x++)
                    vars[row][x] = Integer.parseInt(checkInput[x]);
            }

            return vars;

        } catch(Exception e){
            System.out.println(e.getMessage());
            return new int[0][0];
        }

    }

    private static String getInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        return reader.readLine();
    }

    private static MatrixSizeModel validateInput(String input) {
        try{
            String[] checkInput = input.split(" ");
            MatrixSizeModel matrixConfig = new MatrixSizeModel();

            if(checkInput.length != 2){
                System.out.println("Please enter matrix size split by space.");
                return null;
            }

            matrixConfig.setColLen(Integer.parseInt(checkInput[0]));
            matrixConfig.setRowLen(Integer.parseInt(checkInput[1]));

            return matrixConfig;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
