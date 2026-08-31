#include <bits/stdc++.h>
using namespace std;
template <typename T, typename U>
inline void smin(T &a, U b) {
  if (a > b) a = b;
}
template <typename T, typename U>
inline void smax(T &a, U b) {
  if (a < b) a = b;
}
template <class T>
inline void gn(T &x) {
  char c, sg = 0;
  while (c = getchar(), (c > '9' || c < '0') && c != '-')
    ;
  for ((c == '-' ? sg = 1, c = getchar() : 0), x = 0; c >= '0' && c <= '9';
       c = getchar())
    x = (x << 1) + (x << 3) + c - '0';
  if (sg) x = -x;
}
template <class T1, class T2>
inline void gn(T1 &x1, T2 &x2) {
  gn(x1), gn(x2);
}
template <class T1, class T2, class T3>
inline void gn(T1 &x1, T2 &x2, T3 &x3) {
  gn(x1), gn(x2), gn(x3);
}
template <class T1, class T2, class T3, class T4>
inline void gn(T1 &x1, T2 &x2, T3 &x3, T4 &x4) {
  gn(x1), gn(x2), gn(x3), gn(x4);
}
template <class T>
inline void print(T x) {
  if (x < 0) {
    putchar('-');
    return print(-x);
  }
  if (x < 10) {
    putchar('0' + x);
    return;
  }
  print(x / 10);
  putchar(x % 10 + '0');
}
template <class T>
inline void printsp(T x) {
  print(x);
  putchar(' ');
}
template <class T>
inline void println(T x) {
  print(x);
  putchar('\n');
}
template <class T1, class T2>
inline void print(T1 x1, T2 x2) {
  printsp(x1), println(x2);
}
template <class T1, class T2, class T3>
inline void print(T1 x1, T2 x2, T3 x3) {
  printsp(x1), printsp(x2), println(x3);
}
template <class T1, class T2, class T3, class T4>
inline void print(T1 x1, T2 x2, T3 x3, T4 x4) {
  printsp(x1), printsp(x2), printsp(x3), println(x4);
}
int power(int a, int b, int ans = 1) {
  for (; b; b >>= 1, a = 1LL * a * a % 1000000007)
    if (b & 1) ans = 1LL * ans * a % 1000000007;
  return ans;
}
int Ba[222222], Bb[222222];
int x[222222], y[222222];
int a, b, n;
void update_a(int u, int ad) {
  int cur = x[u];
  x[u] = min(a, x[u] + ad);
  int up = x[u] - cur;
  for (; u; u -= u & -u) Ba[u] += up;
}
void update_b(int u, int ad) {
  int cur = y[u];
  y[u] = min(b, y[u] + ad);
  int add = y[u] - cur;
  for (; u <= n + 10; u += u & -u) Bb[u] += add;
}
int calc_a(int u) {
  int ans = 0;
  for (; u <= n + 10; u += u & -u) ans += Ba[u];
  return ans;
}
int calc_b(int u) {
  int ans = 0;
  for (; u; u -= u & -u) ans += Bb[u];
  return ans;
}
int main() {
  int q, k;
  int op, x, y;
  gn(n, k);
  gn(a, b, q);
  while (q--) {
    gn(op, x);
    if (op == 1) {
      gn(y);
      update_a(x, y), update_b(x, y);
    } else
      println(calc_b(x - 1) + calc_a(x + k));
  }
}
