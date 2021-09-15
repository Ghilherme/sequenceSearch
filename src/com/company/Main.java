package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        //Initializing App
        startSequenceSearch();
    }

    private static void startSequenceSearch() {
        boolean keepRunning;
        do {
            keepRunning = processSequenceSearch();
        }
        while (keepRunning);
    }

    private static boolean processSequenceSearch() {
        try
        {
            System.out.println("Enter matrix size (N x M):");
            //Read and validate inputs
            MatrixSizeModel matrixConfig= validateInput(getInput());

            if(matrixConfig == null) return true;

            //Read and validate the whole matrix
            int[][] matrix = readMatrix(matrixConfig);
            if (matrix == null) return true;

            //sort
            int[] output = sortMatrix(matrix,matrixConfig);

            //print result
            printOutput(output);

            return true;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static int[] sortMatrix(int[][] matrix, MatrixSizeModel matrixConfig) {
        int allValues[] = new int[matrixConfig.getRowLen() * matrixConfig.getColLen()];

        // retrieve matrix elements
        int n = 0;
        for(int row = 0; row< matrix.length; row++)
            for(int col = 0; col< matrix[row].length; col++)
                allValues[n++] = matrix[row][col];

        //sort all values
        Arrays.sort(allValues);

        return allValues;
    }


    private static void printOutput(int[] output) {
        StringBuilder st= new StringBuilder();
        for(int x = 0; x< output.length; x++)
            st.append(output[x] + " ");

        System.out.println(st.toString());
    }

    private static int[][] readMatrix(MatrixSizeModel matrixConfig) {
        try{
            int[][] vars = new int[matrixConfig.getRowLen()][matrixConfig.getColLen()];
            int row,col =0;
            for(row=0; row < matrixConfig.getRowLen(); row++){
                String[] checkInput = getInput().split(" ");

                if(checkInput.length != matrixConfig.getColLen()) {
                    System.out.println("Columns numbers differs from specifieds.");
                    return null;
                }

               for (int x=0; x<checkInput.length; x++)
                   vars[row][x] = Integer.parseInt(checkInput[x]);
            }

            return vars;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
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
                System.out.println("Please enter matrix size splitted by space.");
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
