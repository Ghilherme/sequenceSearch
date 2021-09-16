# sequenceSearch
Java challenge - Sequence search in a matrix


# Objective
The objective of this exercise is to find the longest sequence of values sorted in ascendant order in 
adjacent coordinates of a matrix formed by randomly distributed numbers.
The program should obtain the dimensions and the values of the matrix from the standard input and 
send the detected sequence to standard output in ascending order.
In the evaluation of the exercise, it will be validated the correct behavior of the program, as well as the 
code structure, programming practices, application of OOP principles and the design and efficiency of 
the algorithm.

Specification of requirements 
- The input of the program is obtained from the standard input and starts at first line with the number of 
columns followed by the number of rows separated by a single space, then atsubsequent lines each row 
of the matrix is provided with values separated by a single space;

- The output of the program should be sent to the standard output in a single line with values sorted in 
ascending order;

- Consider that the numbers in the matrix are unique and range from 1 to N x M where N represents the 
number of columns and M represents the number of rows;

- Consider that adjacent coordinated share the same column or row;

- Assume that the input is provided as required and there is only a possible sequence with the maximum 
number of elements;

- There is no need to specify user prompts for input as the program is to be tested automatically;


Example
5 8 7
6 9 1
4 3 2


Input:
3 3
5 8 7
6 9 1
4 3 2

Output
1 2 3 4
