#include <bits/stdc++.h>
using namespace std;
const int mo = 998244353;
const int FFTN = (1 << 20);
const int N = FFTN + 5;
const int M = 805;
char s[M][M], t[M][M];
int n, m, nn, mm, nnn, mmm;
int W[N], w[N], R[N];
int A[N], B[N], C[N];
int a[N], b[N];
unsigned long long p[N];
int power(int x, int y) {
  int s = 1;
  for (; y; y /= 2, x = 1ll * x * x % mo)
    if (y & 1) s = 1ll * s * x % mo;
  return s;
}
void FFTinit() {
  W[0] = 1;
  W[1] = power(3, (mo - 1) / FFTN);
  for (int i = (int)(2); i <= (int)(N - 1); i++)
    W[i] = 1ll * W[i - 1] * W[1] % mo;
}
int FFTinit(int n) {
  int L = 1;
  for (; L <= n; L <<= 1)
    ;
  for (int i = (int)(0); i <= (int)(L - 1); i++)
    R[i] = (R[i >> 1] >> 1) | ((i & 1) ? (L >> 1) : 0);
  return L;
}
void DFT(int *a, int n) {
  for (int i = (int)(0); i <= (int)(n - 1); i++) p[R[i]] = a[i];
  for (int d = 1; d < n; d <<= 1) {
    int len = FFTN / (d << 1);
    for (int i = 0, j = 0; i < d; i++, j += len) w[i] = W[j];
    for (int i = 0; i < n; i += (d << 1))
      for (int j = 0; j < d; j++) {
        int y = p[i + j + d] * w[j] % mo;
        p[i + j + d] = p[i + j] + mo - y;
        p[i + j] += y;
      }
    if (d == 1 << 10)
      for (int i = (int)(0); i <= (int)(n - 1); i++) p[i] %= mo;
  }
  for (int i = (int)(0); i <= (int)(n - 1); i++) a[i] = p[i] % mo;
}
void IDFT(int *a, int n) {
  for (int i = (int)(0); i <= (int)(n - 1); i++) p[R[i]] = a[i];
  for (int d = 1; d < n; d <<= 1) {
    int len = FFTN / (d << 1);
    for (int i = 0, j = FFTN; i < d; i++, j -= len) w[i] = W[j];
    for (int i = 0; i < n; i += (d << 1))
      for (int j = 0; j < d; j++) {
        int y = p[i + j + d] * w[j] % mo;
        p[i + j + d] = p[i + j] + mo - y;
        p[i + j] += y;
      }
    if (d == 1 << 10)
      for (int i = (int)(0); i <= (int)(n - 1); i++) p[i] %= mo;
  }
  int v = power(n, mo - 2);
  for (int i = (int)(0); i <= (int)(n - 1); i++) a[i] = p[i] * v % mo;
}
int main() {
  FFTinit();
  scanf("%d%d", &n, &m);
  for (int i = (int)(1); i <= (int)(n); i++) scanf("%s", s[i] + 1);
  scanf("%d%d", &nn, &mm);
  for (int i = (int)(1); i <= (int)(nn); i++) scanf("%s", t[i] + 1);
  nnn = nn + n - 1;
  mmm = mm + m - 1;
  for (int i = (int)(1); i <= (int)(nnn); i++)
    for (int j = (int)(1); j <= (int)(mmm); j++)
      s[i][j] = s[(i - 1) % n + 1][(j - 1) % m + 1];
  for (int i = (int)(1); i <= (int)(nnn); i++)
    for (int j = (int)(1); j <= (int)(mmm); j++)
      a[i * mmm - mmm + j] = (s[i][j] - 'a' + 1);
  for (int i = (int)(1); i <= (int)(nn); i++)
    for (int j = (int)(1); j <= (int)(mm); j++)
      b[i * mmm - mmm + j - 1] = (t[i][j] == '?' ? 0 : t[i][j] - 'a' + 1);
  reverse(b, b + nn * mmm + 1);
  int L = FFTinit((nn + nnn) * mmm);
  for (int i = (int)(0); i <= (int)(L - 1); i++) A[i] = B[i] = 0;
  for (int i = (int)(0); i <= (int)(L - 1); i++)
    A[i] = a[i] * a[i], B[i] = b[i];
  DFT(A, L);
  DFT(B, L);
  for (int i = (int)(0); i <= (int)(L - 1); i++)
    C[i] = (C[i] + 1ll * A[i] * B[i]) % mo;
  for (int i = (int)(0); i <= (int)(L - 1); i++) A[i] = B[i] = 0;
  for (int i = (int)(0); i <= (int)(L - 1); i++)
    A[i] = a[i], B[i] = b[i] * b[i];
  DFT(A, L);
  DFT(B, L);
  for (int i = (int)(0); i <= (int)(L - 1); i++)
    C[i] = (C[i] + mo - 2ll * A[i] * B[i] % mo) % mo;
  for (int i = (int)(0); i <= (int)(L - 1); i++) A[i] = B[i] = 0;
  for (int i = (int)(0); i <= (int)(L - 1); i++)
    A[i] = 1, B[i] = b[i] * b[i] * b[i];
  DFT(A, L);
  DFT(B, L);
  for (int i = (int)(0); i <= (int)(L - 1); i++)
    C[i] = (C[i] + 1ll * A[i] * B[i]) % mo;
  IDFT(C, L);
  for (int i = (int)(1); i <= (int)(n); i++) {
    for (int j = (int)(1); j <= (int)(m); j++)
      putchar('0' + (C[nn * mmm + i * mmm - mmm + j] == 0));
    puts("");
  }
}
