#include <bits/stdc++.h>
using namespace std;
int N1, P = 998244353, E = 31, F, I;
void fft(int *A, int PM, int PW) {
  for (int m = N1, h; h = m / 2, m >= 2; PW = (long long)PW * PW % PM, m = h) {
    for (int i = 0, w = 1; i < h; ++i, w = (long long)w * PW % PM)
      for (int j = i; j < N1; j += m) {
        int k = j + h, first = (A[j] - A[k] + PM) % PM;
        A[j] += A[k];
        A[j] %= PM;
        A[k] = (long long)w * first % PM;
      }
  }
  for (int i = 0, j = 1; j < N1 - 1; j++) {
    for (int k = N1 / 2; k > (i ^= k); k /= 2)
      ;
    if (j < i) swap(A[j], A[i]);
  }
}
int power(int a, int b, int c) {
  int ans = 1;
  while (b) {
    if (b & 1) ans = (long long)ans * a % c;
    a = (long long)a * a % c;
    b >>= 1;
  }
  return ans;
}
char grid[410][410], pat[410][410];
int a[1 << 22], b[1 << 22], vst[410][410];
int main() {
  int n, m, r, c;
  scanf("%d%d", &n, &m);
  for (int i = 0; i < n; i++) scanf("%s", grid[i]);
  scanf("%d%d", &r, &c);
  for (int i = 0; i < r; i++) scanf("%s", pat[i]);
  int mm = m + c - 1;
  for (N1 = 1; N1 <= mm * (n + 2 * r); N1 <<= 1)
    ;
  I = power(N1, P - 2, P);
  E = power(E, (P - 1) / N1, P);
  F = power(E, P - 2, P);
  for (int i = 0; i < 26; i++) {
    memset(a, 0, sizeof(int) * N1);
    memset(b, 0, sizeof(int) * N1);
    int cnt = 0;
    for (int j = 0; j < r; j++)
      for (int k = 0; k < c; k++)
        cnt += (b[r * mm - (j * mm + k)] = (pat[j][k] == i + 'a'));
    if (!cnt) {
      for (int j = 0; j < n; j++)
        for (int k = 0; k < m; k++) vst[j][k]++;
      continue;
    }
    for (int j = 0; j < n + r - 1; j++)
      for (int k = 0; k < m + c - 1; k++)
        a[j * mm + k] = (grid[j % n][k % m] == i + 'a');
    fft(a, P, E);
    fft(b, P, E);
    for (int j = 0; j < N1; j++) a[j] = (long long)a[j] * b[j] % P;
    fft(a, P, F);
    for (int j = 0; j < n; j++)
      for (int k = 0; k < m; k++)
        if ((long long)a[j * mm + k + (r * mm)] * I % P == cnt) vst[j][k]++;
    fprintf(stderr, "%c\n", i + 'a');
  }
  for (int i = 0; i < n; i++, puts(""))
    for (int j = 0; j < m; j++) putchar('0' + (vst[i][j] == 26));
  return 0;
}
