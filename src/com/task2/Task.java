package com.task2;

import java.util.*;

public class Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        task9_6(scanner.nextLine());
    }

    /**
     * Для удобства чтения каждый метод как решение задания,
     * по этому есть повтор кода
     */
    static void task1(String str) {
        String[] arrSplit = str.split(" ");
        int min = Integer.MAX_VALUE, max = 0;
        int indexMin = 0, indexMax = 0;
        for (int i = 0; i < arrSplit.length; i++) {
            if (min > arrSplit[i].length()) {
                min = arrSplit[i].length();
                indexMin = i;
            }
            if (max < arrSplit[i].length()) {
                max = arrSplit[i].length();
                indexMax = i;
            }
        }
        System.out.println("min -> " + arrSplit[indexMin] + "=" + min);
        System.out.println("max -> " + arrSplit[indexMax] + "=" + max);
    }

    //I used simple sorting -> bubble sort it works O(n^2)
    static void task2(String str) {
        String[] arr = str.split(" ");
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].length() > arr[j + 1].length()) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].length() < arr[j + 1].length()) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    static void task3(String str) {
        String[] arr = str.split(" ");
        int average = 0;
        for (String s : arr) {
            average += s.length();
        }
        average /= arr.length;
        System.out.println("average=" + average);
        System.out.println("less average");
        for (String s : arr) {
            if (s.length() < average) {
                System.out.print(s + "=" + s.length() + " ");
            }
        }
        System.out.println("more average");
        for (String s : arr) {
            if (s.length() > average) {
                System.out.print(s + "=" + s.length() + " ");
            }
        }
    }

    static void task4(String str) {
        String[] arr = str.split(" ");
        String keyMin = "";
        double minEqual = Double.MAX_VALUE;
        for (String s : arr) {
            String[] arrNum = s.split("");
            double equal = 0;
            for (String num : arrNum) {
                equal += Double.parseDouble(num);
            }
            equal /= arrNum.length;
            if (minEqual > equal) {
                minEqual = equal;
                keyMin = s;
            }
        }
        System.out.println(keyMin);
    }

    static void task5(String str) {
        String[] arr = str.split(" ");
        List<String> listEven = new ArrayList<>();
        List<String> listEqualEven = new ArrayList<>();
        for (String s : arr) {
            if (Integer.parseInt(s) % 2 == 0) {
                listEven.add(s);
                int even = 0, notEven = 0;
                for (String num : s.split("")) {
                    if (Integer.parseInt(num) % 2 == 0) {
                        even++;
                    } else {
                        notEven++;
                    }
                }
                if (even == notEven) {
                    listEqualEven.add(s);
                }
            }
        }
        System.out.println(listEven.size() + " " + listEven);
        System.out.println(listEqualEven.size() + " " + listEqualEven);
    }

    static void task6(String str) {
        String[] arr = str.split(" ");
        for (String val : arr) {
            String[] arrNum = val.split("");
            boolean isIncreasing = true;
            for (int i = 0, num = 0; i < arrNum.length; i++) {
                if (Integer.parseInt(arrNum[i]) > num) {
                    num = Integer.parseInt(arrNum[i]);
                } else {
                    isIncreasing = false;
                    break;
                }
            }
            if (isIncreasing) {
                System.out.println(val);
                break;
            }
        }
    }

    static void task7(String str) {
        String[] arr = str.split(" ");
        Map<String, Integer> variousNum = new LinkedHashMap<>();
        boolean isPresent = false;
        for (String s : arr) {
            String[] nums = s.split("");
            for (int i = 0; i < nums.length; i++) {
                if (!variousNum.containsKey(nums[i])) {
                    variousNum.put(nums[i], 1);
                } else {
                    variousNum.clear();
                    break;
                }
                if (i == nums.length - 1) {
                    System.out.println(s);
                    isPresent = true;
                }
            }
            if (isPresent) {
                break;
            }
        }
    }

    static void task8(String str) {
        int n = Integer.parseInt(str);
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d\t", count++);
            }
            System.out.println();
        }
    }

    static void task9(String str) {
        int size = Integer.parseInt(str);
        int[][] matrix = new int[size][size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = -size + random.nextInt(size - (-size) + 1);
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%d\t", matrix[i][j]);
            }
            System.out.println();
        }
    }

    static void task9_1(String str) {
        int size = Integer.parseInt(str);
        int[][] matrix = new int[size][size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = -size + random.nextInt(size - (-size) + 1);
            }
        }
        System.out.println("before sort");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%d\t", matrix[i][j]);
            }
            System.out.println();
        }
        //sort line
        for (int i = 0; i < size; i++) {
            Arrays.sort(matrix[i]);
        }
        System.out.println("after line sort");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%d\t", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("after column sort");
        //sort column, i used triple nesting "for", it works O(n^3)
        for (int k = 0; k < size; k++) {
            //inserted bubble sort
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size - i - 1; j++) {
                    if (matrix[j][k] > matrix[j + 1][k]) {
                        int temp = matrix[j][k];
                        matrix[j][k] = matrix[j + 1][k];
                        matrix[j + 1][k] = temp;
                    }
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%d\t", matrix[i][j]);
            }
            System.out.println();
        }
    }

    static void task9_2(String str) {
        String[] values = str.split(" ");
        int size = Integer.parseInt(values[0]);
        int shift = Integer.parseInt(values[1]);
        int[][] matrix = new int[size][size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = -size + random.nextInt(size - (-size) + 1);
            }
        }
        System.out.println("before shift");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%d\t", matrix[i][j]);
            }
            System.out.println();
        }
        /**
         * shift execution right
         */
        int shiftR = shift;
        int[] arrTemp = new int[size];

        for (int i = 0; i < size; i++) {
            arrTemp = Arrays.copyOf(matrix[i], size);
            for (int j = 0; j < size; j++) {
                matrix[i][(j + shiftR) % size] = arrTemp[j];
            }
        }
        System.out.println("after shift right");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%d\t", matrix[i][j]);
            }
            System.out.println();
        }
        /**
         * shift execution left
         */
        int shiftL = -shift;
        for (int i = 0; i < size; i++) {
            arrTemp = Arrays.copyOf(matrix[i], size);
            for (int j = 0; j < size; j++) {
                int sideL = (shiftL + j) % size;
                while (sideL < 0) {
                    sideL += 3;
                }
                matrix[i][sideL] = arrTemp[j];
            }
        }
        System.out.println("after shift left");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%d\t", matrix[i][j]);
            }
            System.out.println();
        }
        /**
         * shift execution up
         */
        int shiftU = -shift;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arrTemp[j] = matrix[j][i];
            }
            for (int j = 0; j < size; j++) {
                int sideU = (shiftU + j) % size;
                while (sideU < 0) {
                    sideU += 3;
                }
                matrix[sideU][i] = arrTemp[j];
            }
        }
        System.out.println("after shift up");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%d\t", matrix[i][j]);
            }
            System.out.println();
        }
        /**
         * shift execution down
         */
        int shiftD = shift;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arrTemp[j] = matrix[j][i];
            }
            for (int j = 0; j < size; j++) {
                matrix[(j + shiftD) % size][i] = arrTemp[j];
            }
        }
        System.out.println("after shift down");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%d\t", matrix[i][j]);
            }
            System.out.println();
        }
    }

    /*
     example
     enter size matrix -> 4
     enter matrix ->
     1 2 3 2
     1 2 8 9
     8 7 6 0
     8 5 2 1
     */
    static void task9_3(String str) {
        int size = Integer.parseInt(str);
        int[][] matrix = new int[size][size];
        System.out.println("enter matrix NxN");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int maxCount = 0;
        int startLine = 0, startPoint = 0, finPoint = 0;
        /**
         * increase
         */
        for (int i = 0, j; i < size; i++) {
            int count = 0;
            int startL = 0, startP = 0, finP = 0;
            for (j = 0; j < size - 1; j++) {
                if (matrix[i][j] < matrix[i][j + 1]) {
                    if (count == 0) {
                        startL = i;
                        startP = j;
                    }
                    count++;
                    finP = j + 1;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                startLine = startL;
                startPoint = startP;
                finPoint = finP;
            } else if (maxCount == size - 1) {
                break;
            }
        }
        System.out.println("increase:");
        for (int i = startPoint; i <= finPoint; i++) {
            System.out.print(matrix[startLine][i] + " ");
        }
        /**
         * decrease
         */
        maxCount = 0;
        startLine = 0;
        startPoint = 0;
        finPoint = 0;
        for (int i = 0, j; i < size; i++) {
            int count = 0;
            int startL = 0, startP = 0, finP = 0;
            for (j = 0; j < size - 1; j++) {
                if (matrix[i][j] > matrix[i][j + 1]) {
                    if (count == 0) {
                        startL = i;
                        startP = j;
                    }
                    count++;
                    finP = j + 1;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                startLine = startL;
                startPoint = startP;
                finPoint = finP;
            } else if (maxCount == size - 1) {
                break;
            }
        }
        System.out.println("\ndecrease:");
        for (int i = startPoint; i <= finPoint; i++) {
            System.out.print(matrix[startLine][i] + " ");
        }
    }

    /*
        size = 5
        matrix =
        1 -1 0 -2 2
        -2 1 -2 -4 2
        2 -2 -1 -1 -1
        0 -1 1 -2 2
        1 2 3 4 5
     */
    static void task9_4(String str) {
        int size = Integer.parseInt(str);
        int[][] matrix = new int[size][size];
        System.out.println("enter matrix NxN");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < size; i++) {
            int firstP = -1, secondP = -1;
            int sum = 0;
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] > 0 && firstP == -1) {
                    firstP = j;
                } else if (matrix[i][j] > 0 && secondP == -1) {
                    secondP = j;
                    break;
                }
            }
            if (firstP != -1 && secondP != -1) {
                for (int j = firstP + 1; j < secondP; j++) {
                    sum += matrix[i][j];
                }
                System.out.println("line=" + i + " sum=" + sum);
            } else {
                System.out.println("line=" + i + " not have a two positive num");
            }
        }
    }

    /*
     example
     enter size matrix -> 3
     enter matrix ->
     1 2 3
     1 2 3
     1 2 3
     */
    static void task9_5(String str) {
        int size = Integer.parseInt(str);
        int[][] matrix = new int[size][size];
        System.out.println("enter matrix NxN");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int[][] matrixTmp = new int[size][size];
        /**
         rotate the matrix 90
         */
        for (int i = 0; i < size; i++) {
            for (int j = size - 1, k = 0; j >= 0; j--, k++) {
                matrixTmp[k][i] = matrix[i][j];
            }
        }
        /**
         rotate the matrix 180
         */
        matrixTmp = Arrays.copyOf(matrix, size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size / 2; j++) {
                int tmp = matrixTmp[i][j];
                matrixTmp[i][j] = matrixTmp[i][size - j - 1];
                matrixTmp[i][size - j - 1] = tmp;
            }
        }
        /**
         rotate the matrix 270
         */
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrixTmp[i][j] = matrix[size - j - 1][i];
            }
        }
        for (int i = 0; i < size; i++) {
            System.out.println(Arrays.toString(matrixTmp[i]));
        }
    }

    /*
      example
      enter matrix size -> 3
      enter matrix ->
      3 4 5
      7 8 9
      8 8 8
     */
    static void task9_6(String str) {
        int size = Integer.parseInt(str);
        int[][] matrix = new int[size][size];
        System.out.println("enter matrix NxN");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < size; i++) {
            int average = 0;
            for (int j = 0; j < size; j++) {
                average += matrix[i][j];
            }
            average /= size;
            for (int j = 0; j < size; j++) {
                matrix[i][j] -= average;
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%d\t", matrix[i][j]);
            }
            System.out.println();
        }

    }

    /*
     example
     enter matrix size -> 5
     enter matrix ->
     1 0 5 0 0
     0 0 5 0 0
     2 0 5 0 0
     0 0 0 0 0
     0 0 0 0 0
     */
    static void task9_7(String str) {
        int size = Integer.parseInt(str);
        int[][] matrix = new int[size][size];
        System.out.println("enter matrix NxN");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        //two lists for empty cells
        List<Integer> nonL = new ArrayList<>();
        List<Integer> nonC = new ArrayList<>();
        int sizeLine = size, sizeColumn = size;
        //zero line check
        for (int i = 0; i < size; i++) {
            int sumL = 0;
            for (int j = 0; j < size; j++) {
                sumL += Math.abs(matrix[i][j]);
            }
            if (sumL == 0) {
                sizeLine--;
                nonL.add(i);
            }
        }
        //zero column check
        for (int j = 0; j < size; j++) {
            int sumC = 0;
            for (int i = 0; i < size; i++) {
                sumC += Math.abs(matrix[i][j]);
            }
            if (sumC == 0) {
                sizeColumn--;
                nonC.add(j);
            }
        }
        //new compressed matrix
        int[][] newMatrix = new int[sizeLine][sizeColumn];
        //filling
        for (int i = 0, c = 0, l = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                boolean line = true;
                boolean colunm = true;
                //zero line check
                for (Integer index : nonL) {
                    if (i == index) {
                        line = false;
                        break;
                    }
                }
                //zero column check
                for (Integer index : nonC) {
                    if (j == index) {
                        colunm = false;
                        break;
                    }
                }
                if (line && colunm && l != sizeLine) {
                    if (c >= sizeColumn) {
                        l++;
                        c = 0;
                    }
                    newMatrix[l][c] = matrix[i][j];
                    c++;
                }
            }
        }
        //output compressed matrix
        for (int i = 0; i < sizeLine; i++) {
            for (int j = 0; j < sizeColumn; j++) {
                System.out.printf("%d\t", newMatrix[i][j]);
            }
            System.out.println();
        }
    }

    /*
     example
     enter matrix size -> 5
     enter matrix ->
     5 1 0 0 1
     6 8 0 1 0
     0 0 0 0 1
     0 0 5 5 0
     8 8 0 8 8
     */
    static void task9_8(String str) {
        int size = Integer.parseInt(str);
        int[][] matrix = new int[size][size];
        System.out.println("enter matrix NxN");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size - 1; j++) {
                    if (matrix[k][j] == 0) {
                        int temp = matrix[k][j];
                        matrix[k][j] = matrix[k][j + 1];
                        matrix[k][j + 1] = temp;
                    }
                }
            }
        }
        System.out.println("after sort");
        for (int i = 0; i < size; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
