#include <bits/stdc++.h>
using namespace std;
const int N = 3e6 + 5;
const int M = 805;
int n, m, nn, mm, r, c, id[M][M], ans[M][M];
char s1[M][M], s2[M][M];
const int Mod = 998244353;
const int g = 3;
int Pow(long long a, int x) {
  long long res = 1;
  while (x) {
    if (x & 1) (res *= a) %= Mod;
    (a *= a) %= Mod;
    x >>= 1;
  }
  return (int)res;
}
void FFT(int *a, int n, int rev) {
  for (int i = 0, j = 0; i < n; ++i) {
    if (i > j) swap(a[i], a[j]);
    for (int k = n >> 1; (j ^= k) < k; k >>= 1)
      ;
  }
  for (int i = 2; i <= n; i <<= 1) {
    int m = i >> 1;
    int w = Pow(g, (Mod - 1) / i);
    if (rev == -1) w = Pow(w, Mod - 2);
    for (int j = 0; j < n; j += i) {
      long long Wx = 1;
      for (int k = 0; k != m; k++) {
        long long z = a[j + m + k] * Wx % Mod;
        a[j + m + k] = a[j + k] - z + Mod;
        if (a[j + m + k] > Mod) a[j + m + k] -= Mod;
        a[j + k] = a[j + k] + z;
        if (a[j + k] > Mod) a[j + k] -= Mod;
        Wx = Wx * w % Mod;
      }
    }
  }
}
int tot, len, inv, T[N], P[N], T2[N], P2[N], TT[N], PP[N];
inline void cal(int *a, int *b, int c) {
  for (int i = 0; i < tot; i++) {
    if (i > tot - i) break;
    swap(b[i], b[tot - i]);
  }
  FFT(a, len, 1);
  FFT(b, len, 1);
  for (int i = 0; i < len; i++) a[i] = (long long)a[i] * b[i] % Mod;
  FFT(a, len, -1);
  for (int i = 0; i < nn; i++)
    for (int j = 0; j < mm; j++)
      ans[i][j] += c * (long long)a[id[i][j] + tot] * inv % Mod;
}
void solve() {
  tot = n * m;
  len = 1;
  while (len < 2 * tot) len <<= 1;
  inv = Pow(len, Mod - 2);
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      T[id[i][j]] = s1[i][j] - 'a' + 1;
      P[id[i][j]] = s2[i][j] - 'a' + 1;
    }
  }
  for (int i = 0; i < tot; i++) {
    T2[i] = T[i] * T[i];
    P2[i] = P[i] * P[i];
    TT[i] = (T[i] != 0);
    PP[i] = (P[i] != 0);
  }
  cal(T2, PP, 1);
  cal(T, P, -2);
  cal(TT, P2, 1);
}
int main() {
  scanf("%d%d", &nn, &mm);
  for (int i = 0; i < nn; i++) scanf("%s", s1[i]);
  scanf("%d%d", &r, &c);
  for (int i = 0; i < r; i++) scanf("%s", s2[i]);
  n = nn;
  m = mm;
  for (int i = 0; i < n; i++)
    for (int j = m; j < m + c; j++) s1[i][j] = s1[i][j % m];
  m += c - 1;
  for (int i = 0; i < m; i++)
    for (int j = n; j < n + r; j++) s1[j][i] = s1[j % n][i];
  n += r - 1;
  for (int i = 0; i < n; i++)
    for (int j = 0; j < m; j++) id[i][j] = i * m + j;
  for (int i = 0; i < n; i++)
    for (int j = 0; j < m; j++)
      if (i >= r || j >= c || s2[i][j] == '?') s2[i][j] = 'a' - 1;
  solve();
  for (int i = 0; i < nn; i++) {
    for (int j = 0; j < mm; j++)
      if (ans[i][j] == 0)
        putchar('1');
      else
        putchar('0');
    printf("\n");
  }
}
