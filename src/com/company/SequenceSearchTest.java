package com.company;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SequenceSearchTest {

    @Test
    void sortMatrix() {
        //given
        int[][] test = {{5, 8, 7, 12}, {6, 9, 1, 13}, {4, 3, 11, 14}};
        MatrixSizeModel matrixConfig = new MatrixSizeModel();
        matrixConfig.setRowLen(4);
        matrixConfig.setColLen(4);
        int[] expected = {3, 4, 5, 6, 7, 8, 9};

        //when
        int[] sortedValues = SequenceSearch.sortMatrix(test, matrixConfig);

        //then
        Assertions.assertArrayEquals(expected, SequenceSearch.longestSS(sortedValues));
    }
}