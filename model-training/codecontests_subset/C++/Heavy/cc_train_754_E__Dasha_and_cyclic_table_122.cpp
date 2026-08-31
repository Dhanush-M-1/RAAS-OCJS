#include <bits/stdc++.h>
using namespace std;
const int NUM = 410;
int n, m, r, c;
char table[NUM][NUM], pattern[NUM][NUM];
long long qpow(long long x, long long k, long long mod) {
  long long res = 1;
  for (; k; k >>= 1) {
    if (k & 1) res = res * x % mod;
    x = x * x % mod;
  }
  return res;
}
class NTT {
 public:
  const int wroot = 3;
  const long long mod = 998244353;
  int N;
  int wi[1024];
  NTT() {
    N = 1024;
    wi[0] = 1;
    wi[1] = qpow(wroot, (mod - 1) / N, mod);
    for (int i = 2; i < N; ++i) wi[i] = 1ll * wi[i - 1] * wi[1] % mod;
  }
  void ntt_1D(int *A, int n, int op) {
    for (int i = 1, j = n >> 1, k; i < n - 2; ++i) {
      if (i < j) swap(A[i], A[j]);
      for (k = n >> 1; j >= k; k >>= 1) j -= k;
      if (j < k) j += k;
    }
    for (int h = 2; h <= n; h <<= 1) {
      int unit = op == -1 ? N - N / h : N / h;
      int hf = h >> 1;
      for (int i = 0; i < n; i += h) {
        for (int j = i, w = 0; j < i + hf; ++j) {
          int u = A[j], t = 1ll * wi[w] * A[j + hf] % mod;
          if ((A[j] = u + t) >= mod) A[j] -= mod;
          if ((A[j + hf] = u - t) < 0) A[j + hf] += mod;
          if ((w += unit) >= N) w -= N;
        }
      }
    }
    if (op == 1) return;
    int inv = qpow(n, mod - 2, mod);
    for (int i = 0; i < n; ++i) A[i] = 1ll * A[i] * inv % mod;
  }
  void ntt_2D(int A[1024][1024], int n, int op) {
    for (int i = 0; i < n; ++i) {
      ntt_1D(A[i], n, op);
    }
    for (int i = 0; i < n; ++i) {
      for (int j = i; j < n; ++j) {
        swap(A[i][j], A[j][i]);
      }
    }
    for (int i = 0; i < n; ++i) {
      ntt_1D(A[i], n, op);
    }
    for (int i = 0; i < n; ++i) {
      for (int j = i; j < n; ++j) {
        swap(A[i][j], A[j][i]);
      }
    }
  }
} ntt;
int A[1024][1024], B[1024][1024], res[1024][1024], sum;
inline int two(int x) { return x * x; }
inline int three(int x) { return x * x * x; }
int N;
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 0; i < n; ++i) {
    scanf("%s", table[i]);
    for (int j = 0; j < m; ++j) table[i][j] = table[i][j] - 'a' + 1;
  }
  scanf("%d%d", &r, &c);
  for (int i = 0; i < r; ++i) {
    scanf("%s", pattern[i]);
    for (int j = 0; j < c; ++j) {
      if (pattern[i][j] == '?')
        pattern[i][j] = 0;
      else
        pattern[i][j] = pattern[i][j] - 'a' + 1;
      sum += two(pattern[i][j]);
    }
  }
  for (N = 1; N < max(n + r, m + c); N <<= 1)
    ;
  for (int i = 0; i < N; ++i) {
    for (int j = 0; j < N; ++j) {
      A[i][j] = table[i % n][j % m];
    }
  }
  for (int i = 0; i < r; ++i) {
    for (int j = 0; j < c; ++j) {
      B[r - 1 - i][c - 1 - j] = pattern[i][j];
    }
  }
  ntt.ntt_2D(A, N, 1);
  ntt.ntt_2D(B, N, 1);
  for (int i = 0; i < N; ++i) {
    for (int j = 0; j < N; ++j) {
      res[i][j] = 1ll * A[i][j] * B[i][j] % ntt.mod;
    }
  }
  ntt.ntt_2D(res, N, -1);
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < m; ++j) {
      printf("%d", res[r - 1 + i][c - 1 + j] == sum);
    }
    puts("");
  }
  return 0;
}
