#include <bits/stdc++.h>
using namespace std;
namespace Sweet {
template <typename T>
inline void read(T &x) {
  char ch;
  int f = 1;
  while (ch = getchar(), ch > '9' || ch < '0') (ch == '-') && (f = -1);
  x = (ch ^ 48);
  while (ch = getchar(), ch >= '0' && ch <= '9') x = x * 10 + (ch ^ 48);
  x *= f;
}
template <typename T>
inline void write(T x) {
  static int stk[100], top = 0;
  if (x == 0) return (void)putchar('0');
  if (x < 0) x = -x, putchar('-');
  while (x) stk[++top] = x % 10, x /= 10;
  while (top) putchar(stk[top--] + '0');
}
const int N = 4e2 + 10;
struct E {
  int a, b;
  friend bool operator<(const E &a, const E &b) {
    return a.b == b.b ? a.a > b.a : a.b > b.b;
  }
} e[N];
inline void max(int &x, const int &y) { (x < y) && (x = y); }
int n, q, sigmaA, sigmaB, pre[N], f[N * N][N];
inline void main() {
  read(n);
  for (int i = 1; i <= n; ++i) read(e[i].a), sigmaA += e[i].a;
  for (int i = 1; i <= n; ++i) read(e[i].b), sigmaB += e[i].b;
  sort(e + 1, e + n + 1);
  for (int i = 1; i <= n; ++i) pre[i] = pre[i - 1] + e[i].b;
  memset(f, 0xcf, sizeof(f));
  f[0][0] = 0;
  int x = lower_bound(pre + 1, pre + n + 1, sigmaA) - pre;
  write(x), putchar(' ');
  for (int i = 1; i <= n; ++i) {
    for (int j = sigmaB; j >= e[i].b; --j) {
      for (int k = 1; k <= x; ++k) {
        max(f[j][k], f[j - e[i].b][k - 1] + e[i].a);
      }
    }
  }
  int ans = 0;
  for (int i = sigmaA; i <= sigmaB; ++i) max(ans, f[i][x]);
  write(sigmaA - ans);
}
}  // namespace Sweet
int main() {
  Sweet::main();
  return 0;
}
