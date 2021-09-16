package com.company;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SequenceSearchTest {

    @Test
    void sortMatrix() {
        int test[][] = {{5, 8, 7,}, {6,9,1}, {4,3,2}};
        MatrixSizeModel matrixConfig = new MatrixSizeModel();
        matrixConfig.setRowLen(3);
        matrixConfig.setColLen(3);
        int expected[] = {1, 2, 3,4,5,6,7,8,9};
        Assertions.assertArrayEquals(expected, SequenceSearch.sortMatrix(test,matrixConfig));
    }
}