#include <bits/stdc++.h>
using namespace std;
template <typename T, typename U>
inline void smin(T &a, const U &b) {
  if (a > b) a = b;
}
template <typename T, typename U>
inline void smax(T &a, const U &b) {
  if (a < b) a = b;
}
template <class T>
inline void gn(T &first) {
  char c, sg = 0;
  while (c = getchar(), (c > '9' || c < '0') && c != '-')
    ;
  for ((c == '-' ? sg = 1, c = getchar() : 0), first = 0; c >= '0' && c <= '9';
       c = getchar())
    first = (first << 1) + (first << 3) + c - '0';
  if (sg) first = -first;
}
template <class T1, class T2>
inline void gn(T1 &x1, T2 &x2) {
  gn(x1), gn(x2);
}
template <class T1, class T2, class T3>
inline void gn(T1 &x1, T2 &x2, T3 &x3) {
  gn(x1, x2), gn(x3);
}
template <class T>
inline void print(T first) {
  if (first < 0) {
    putchar('-');
    return print(-first);
  }
  if (first < 10) {
    putchar('0' + first);
    return;
  }
  print(first / 10);
  putchar(first % 10 + '0');
}
template <class T>
inline void println(T first) {
  print(first);
  putchar('\n');
}
template <class T>
inline void printsp(T first) {
  print(first);
  putchar(' ');
}
template <class T1, class T2>
inline void print(T1 x1, T2 x2) {
  printsp(x1), println(x2);
}
template <class T1, class T2, class T3>
inline void print(T1 x1, T2 x2, T3 x3) {
  printsp(x1), printsp(x2), println(x3);
}
int power(int a, int b, int m, int ans = 1) {
  for (; b; b >>= 1, a = (long long)a * a % m)
    if (b & 1) ans = (long long)ans * a % m;
  return ans;
}
int n, a, b;
int X[200010], Y[200010];
int Ba[200010], Bb[200010];
void update_a(int u, int first) {
  int pre = X[u];
  X[u] = min(a, X[u] + first);
  int add = X[u] - pre;
  for (; u; u -= u & -u) Ba[u] += add;
}
void update_b(int u, int first) {
  int pre = Y[u];
  Y[u] = min(b, Y[u] + first);
  int add = Y[u] - pre;
  for (; u <= n; u += u & -u) Bb[u] += add;
}
int calc_a(int u, int ans = 0) {
  for (; u <= n; u += u & -u) ans += Ba[u];
  return ans;
}
int calc_b(int u, int ans = 0) {
  for (; u; u -= u & -u) ans += Bb[u];
  return ans;
}
int main() {
  int k, q;
  gn(n, k);
  gn(a, b, q);
  while (q--) {
    int t, first, second;
    gn(t, first);
    if (t == 1) {
      gn(second);
      update_a(first, second);
      update_b(first, second);
    } else
      println(calc_b(first - 1) + calc_a(first + k));
  }
}
