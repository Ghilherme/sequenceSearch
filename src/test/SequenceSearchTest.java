import com.company.MatrixSizeModel;
import com.company.SequenceSearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class SequenceSearchTest {

    @Test
    void sortMatrix3x3() {
        // given
        int[][] test = {{5, 8, 7,}, {6, 9, 1}, {4, 3, 2}};
        MatrixSizeModel matrixConfig = new MatrixSizeModel();
        matrixConfig.setRowLen(3);
        matrixConfig.setColLen(3);
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        // when
        int[] sortedValues = SequenceSearch.sortMatrix(test, matrixConfig);

        // then
        Assertions.assertArrayEquals(expected, SequenceSearch.longestSearchSequence(sortedValues));
    }

    @Test
    void sortMatrix4x4() {
        //given
        int[][] test = {{5, 8, 7, 12}, {6, 9, 1, 13}, {4, 3, 11, 14}};
        MatrixSizeModel matrixConfig = new MatrixSizeModel();
        matrixConfig.setRowLen(3);
        matrixConfig.setColLen(4);
        int[] expected = {3, 4, 5, 6, 7, 8, 9};

        //when
        int[] sortedValues = SequenceSearch.sortMatrix(test, matrixConfig);

        //then
        Assertions.assertArrayEquals(expected, SequenceSearch.longestSearchSequence(sortedValues));
    }

    @Test
    void sortMatrix5x5() {
        //given
        int[][] test = {
                {2, 3, 18, 5, 6},
                {4, 4, 72, 3, 2},
                {11, 20, 21, 23, 22},
                {25, 24, 30, 4, 35},
                {26, 27, 7, 9, 10}
        };
        MatrixSizeModel matrixConfig = new MatrixSizeModel();
        matrixConfig.setRowLen(5);
        matrixConfig.setColLen(5);
        int[] expected = {20, 21, 22, 23, 24, 25, 26, 27};

        //when
        int[] sortedValues = SequenceSearch.sortMatrix(test, matrixConfig);

        //then
        Assertions.assertArrayEquals(expected, SequenceSearch.longestSearchSequence(sortedValues));
    }
}