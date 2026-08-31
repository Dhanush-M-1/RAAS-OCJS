#include <bits/stdc++.h>
using namespace std;
const int N = 3e6 + 5;
const int M = 805;
const double PI = acos(-1.0);
int n, m, nn, mm, r, c, id[M][M], ans[M][M];
char s1[M][M], s2[M][M];
struct Complex {
  double real, imag;
  Complex() {}
  Complex(double real_, double imag_) : real(real_), imag(imag_) {}
  friend inline Complex operator+(const Complex &lhs, const Complex &rhs) {
    return Complex(lhs.real + rhs.real, lhs.imag + rhs.imag);
  }
  friend inline Complex operator-(const Complex &lhs, const Complex &rhs) {
    return Complex(lhs.real - rhs.real, lhs.imag - rhs.imag);
  }
  friend inline Complex operator*(const Complex &lhs, const Complex &rhs) {
    return Complex(lhs.real * rhs.real - lhs.imag * rhs.imag,
                   lhs.real * rhs.imag + lhs.imag * rhs.real);
  }
};
void FFT(Complex *a, int n, int rev) {
  for (int i = 0, j = 0; i < n; ++i) {
    if (i > j) swap(a[i], a[j]);
    for (int k = n >> 1; (j ^= k) < k; k >>= 1)
      ;
  }
  for (int i = 2; i <= n; i <<= 1) {
    int m = i >> 1;
    Complex g(cos(PI / m), rev * sin(PI / m));
    for (int j = 0; j < n; j += i) {
      Complex w(1.0, 0.0);
      for (int k = 0; k != m; k++) {
        Complex z = a[j + m + k] * w;
        a[j + m + k] = a[j + k] - z;
        a[j + k] = a[j + k] + z;
        w = w * g;
      }
    }
  }
  if (rev == -1) {
    for (int i = 0; i < n; i++) a[i].real /= n;
  }
}
int tot, len, T[N], P[N], T2[N], P2[N], TT[N], PP[N];
Complex A[N], B[N];
inline void cal(int *a, int *b, int c) {
  for (int i = 0; i < tot; i++) {
    if (i > tot - i) break;
    swap(b[i], b[tot - i]);
  }
  for (int i = 0; i < len; i++)
    A[i] = Complex(a[i], 0), B[i] = Complex(b[i], 0);
  FFT(A, len, 1);
  FFT(B, len, 1);
  for (int i = 0; i < len; i++) A[i] = A[i] * B[i];
  FFT(A, len, -1);
  for (int i = 0; i < nn; i++)
    for (int j = 0; j < mm; j++)
      ans[i][j] += c * (int)(A[id[i][j] + tot].real + 0.5);
}
void solve() {
  tot = n * m;
  len = 1;
  while (len < 2 * tot) len <<= 1;
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
        printf("1");
      else
        printf("0");
    printf("\n");
  }
}
