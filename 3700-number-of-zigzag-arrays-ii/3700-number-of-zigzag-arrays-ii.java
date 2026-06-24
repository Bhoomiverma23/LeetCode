class Solution {
    static final long MOD = 1_000_000_007L;
    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        int sz = 2 * m;
        if (n == 1) return m;
        long[] vec = new long[sz];
        for (int v = 0; v < m; v++) {
            vec[v] = v;                 
            vec[m + v] = m - 1 - v;   
        }
        if (n == 2) {
            long ans = 0;
            for (long x : vec) ans = (ans + x) % MOD;
            return (int) ans;
        }
        long[][] T = new long[sz][sz];
        for (int u = 0; u < m; u++) {
            for (int v = u + 1; v < m; v++) {
                T[v][m + u] = 1;
            }
            for (int v = 0; v < u; v++) {
                T[m + v][u] = 1;
            }
        }
        long[][] P = matPow(T, n - 2);
        long[] res = matVecMul(P, vec);
        long ans = 0;
        for (long x : res) {
            ans = (ans + x) % MOD;
        }
        return (int) ans;
    }

    private long[] matVecMul(long[][] A, long[] v) {
        int n = A.length;
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int k = 0; k < n; k++) {
                if (A[i][k] != 0) {
                    sum = (sum + A[i][k] * v[k]) % MOD;
                }
            }
            res[i] = sum;
        }
        return res;
    }

    private long[][] matPow(long[][] base, long exp) {
        int n = base.length;
        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = multiply(res, base);
            }
            base = multiply(base, base);
            exp >>= 1;
        }
        return res;
    }

    private long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;
        long[][] C = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] == 0) continue;
                long aik = A[i][k];
                for (int j = 0; j < n; j++) {
                    if (B[k][j] == 0) continue;
                    C[i][j] = (C[i][j] + aik * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }
}