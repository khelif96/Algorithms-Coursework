import java.util.Random;

/**
 * Created by mohamed on 7/3/17.
 */
public class Strassen {
    private static int[][] multi(int[][] A, int[][] B) {
        int aRows = A.length;
        int aColumns = A[0].length;
        int bRows = B.length;
        int bColumns = B[0].length;

        int[][] C = new int[aRows][bColumns];

        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bColumns; j++) {
                for (int k = 0; k < aColumns; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;

    }

    public static void main(String[] args) {
        Random rand = new Random();
        int n = 10;
        for(;n<=100;n+=10) {
            long averageTimeMulti = 0, averageTimeStrassen = 0;
            int[][] A = new int[n][n];
            int[][] B = new int[n][n];
            int[][] C;
            for (int t = 0; t < 1; t++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        A[i][j] = rand.nextInt(10) + 1;
                        B[i][j] = rand.nextInt(10) + 1;
                    }

                }
                long timeStart = System.currentTimeMillis();
                C = multi(A, B);
                long timeEnd = System.currentTimeMillis();

                averageTimeMulti += (timeEnd - timeStart);
                timeStart = System.currentTimeMillis();
                C = strassen(A, B);
                timeEnd = System.currentTimeMillis();

                averageTimeStrassen += (timeEnd - timeStart);

            }
            System.out.println("N = " + n);
            System.out.println("Multiplication Run time " + (averageTimeMulti / 1));
            System.out.println("Strassen Multiplication Run time " + (averageTimeStrassen / 1));
        }


//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(C[i][j] + " ");
//            }
//            System.out.println();
//
//        }


//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(C[i][j] + " ");
//            }
//            System.out.println();
//
//        }
    }

//
    // Matrix addition (n*n)
    private static int[][] add(int[][] a, int[][] b) {
        int n = a.length;
        int[][] c = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return c;
    }

    // Matrix subtraction (n*n)
    private static int[][] sub(int[][] a, int[][] b) {
        int n = a.length;
        int[][] c = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = a[i][j] - b[i][j];
            }
        }
        return c;
    }

    // Matrix multiplication (2*2)
    private static int[][] mul(int[][] a, int[][] b) {
        int n = 2;
        int[][] c = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    private static int[][] strassenMatrixMul(int[][] a, int[][] b) {
        int n = a.length / 2;
        int[][] c = new int[2 * n][2 * n];

        int[][] a11 = new int[n][n];
        int[][] a12 = new int[n][n];
        int[][] a21 = new int[n][n];
        int[][] a22 = new int[n][n];
        int[][] b11 = new int[n][n];
        int[][] b12 = new int[n][n];
        int[][] b21 = new int[n][n];
        int[][] b22 = new int[n][n];

        if (a.length == 2) {
            c = mul(a, b); // base case
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a11[i][j] = a[i][j];
                    a12[i][j] = a[i][j + n];
                    a21[i][j] = a[i + n][j];
                    a22[i][j] = a[i + n][j + n];
                    b11[i][j] = b[i][j];
                    b12[i][j] = b[i][j + n];
                    b21[i][j] = b[i + n][j];
                    b22[i][j] = b[i + n][j + n];
                }
            }

            int[][] p1 = sub(strassenMatrixMul(a11, b12), strassenMatrixMul(a11, b22));
            int[][] p2 = add(strassenMatrixMul(a11, b22), strassenMatrixMul(a12, b22));
            int[][] p3 = add(strassenMatrixMul(a21, b11), strassenMatrixMul(a22, b11));
            int[][] p4 = sub(strassenMatrixMul(a22, b21), strassenMatrixMul(a22, b11));
            int[][] p5 = strassenMatrixMul(add(a11, a22), add(b11, b22));
            int[][] p6 = strassenMatrixMul(sub(a12, a22), add(b21, b22));
            int[][] p7 = strassenMatrixMul(sub(a11, a21), add(b11, b12));

            int[][] c11 = sub(add(add(p5, p4), p6), p2);
            int[][] c12 = add(p1, p2);
            int[][] c21 = add(p3, p4);
            int[][] c22 = sub(sub(add(p1, p5), p3), p7);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    c[i][j] = c11[i][j];
                    c[i][j + n] = c12[i][j];
                    c[i + n][j] = c21[i][j];
                    c[i + n][j + n] = c22[i][j];
                }
            }
        }
        return c;
    }

    public static int[][] strassen(int[][] a, int[][] b) {
        int k;
        int n = a.length;
        for (k = 0; n > 0; k++) {
            n >>= 1;
        }
        n = a.length;
        int nPower = (int) Math.pow(2, k);
        if (n == nPower / 2) { // n = 2^k
            return strassenMatrixMul(a, b);
        } else {
// Solve the problem when n != 2^k
            int[][] ap = new int[nPower][nPower];
            int[][] bp = new int[nPower][nPower];
            int[][] cp;
            int[][] c = new int[n][n]; // return value
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    ap[i][j] = a[i][j];
                    bp[i][j] = b[i][j];
                }
            }
// Add 0
            for (int i = 0; i < nPower; i++) {
                for (int j = 0; j < nPower; j++) {
                    ap[i][j] += 0;
                    bp[i][j] += 0;
                }
            }
            cp = strassenMatrixMul(ap, bp);
// Get rid of 0
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    c[i][j] = cp[i][j];
                }
            }
            return c;
        }
    }
}

