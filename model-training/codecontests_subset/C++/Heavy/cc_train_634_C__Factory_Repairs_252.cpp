#include <bits/stdc++.h>
using namespace std;
inline int read() {
  int x = 0, f = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while ('0' <= ch && ch <= '9') x = x * 10 + ch - '0', ch = getchar();
  return x * f;
}
int n, K, A, B, m, a[200009], b[200009], k[200009];
inline int Que(int *s, int x) {
  int now = 0;
  while (x) now += s[x], x -= (x & -x);
  return now;
}
inline void Add(int *s, int x, int v) {
  while (x <= n) s[x] += v, x += (x & -x);
}
int main() {
  n = read(), K = read(), A = read(), B = read(), m = read();
  for (int i = 1; i <= m; i++) {
    int op = read();
    if (op == 1) {
      int x = read();
      Add(a, x, -min(A, k[x]));
      Add(b, x, -min(B, k[x]));
      k[x] += read();
      Add(a, x, min(A, k[x]));
      Add(b, x, min(B, k[x]));
    } else {
      int d = read();
      printf("%d\n", Que(b, d - 1) + Que(a, n) - Que(a, d + K - 1));
    }
  }
  return 0;
}
