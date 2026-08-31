#include <bits/stdc++.h>
#pragma GCC optimize(2)
#pragma comment(linker, "/STACK:102400000,102400000")
using namespace std;
const int INF = ~0U >> 1;
const long long LINF = 0x3f3f3f3f3f3f3f3fLL;
const int dx[] = {-1, 0, 1, 0, 1, -1, -1, 1};
const int dy[] = {0, 1, 0, -1, -1, 1, -1, 1};
const int maxn = 1e5 + 10;
const int maxx = 1e3 + 10;
const double EPS = 1e-8;
const double eps = 1e-8;
const int mod = 1e9 + 7;
template <class T>
inline T min(T a, T b, T c) {
  return min(min(a, b), c);
}
template <class T>
inline T max(T a, T b, T c) {
  return max(max(a, b), c);
}
template <class T>
inline T min(T a, T b, T c, T d) {
  return min(min(a, b), min(c, d));
}
template <class T>
inline T max(T a, T b, T c, T d) {
  return max(max(a, b), max(c, d));
}
template <class T>
inline bool scan_d(T &ret) {
  char c;
  int sgn;
  if (c = getchar(), c == EOF) {
    return 0;
  }
  while (c != '-' && (c < '0' || c > '9')) {
    c = getchar();
  }
  sgn = (c == '-') ? -1 : 1;
  ret = (c == '-') ? 0 : (c - '0');
  while (c = getchar(), c >= '0' && c <= '9') {
    ret = ret * 10 + (c - '0');
  }
  ret *= sgn;
  return 1;
}
inline bool scan_lf(double &num) {
  char in;
  double Dec = 0.1;
  bool IsN = false, IsD = false;
  in = getchar();
  if (in == EOF) return false;
  while (in != '-' && in != '.' && (in < '0' || in > '9')) in = getchar();
  if (in == '-') {
    IsN = true;
    num = 0;
  } else if (in == '.') {
    IsD = true;
    num = 0;
  } else
    num = in - '0';
  if (!IsD) {
    while (in = getchar(), in >= '0' && in <= '9') {
      num *= 10;
      num += in - '0';
    }
  }
  if (in != '.') {
    if (IsN) num = -num;
    return true;
  } else {
    while (in = getchar(), in >= '0' && in <= '9') {
      num += Dec * (in - '0');
      Dec *= 0.1;
    }
  }
  if (IsN) num = -num;
  return true;
}
void Out(long long a) {
  if (a < 0) {
    putchar('-');
    a = -a;
  }
  if (a >= 10) Out(a / 10);
  putchar(a % 10 + '0');
}
void print(long long a) { Out(a), puts(""); }
int n, d;
int a[maxn];
void solve() {
  scanf("%d%d", &n, &d);
  for (int i = 1; i <= n; i++) scanf("%d", &a[i]);
  int top = 0, bon = 0;
  int ans = 0;
  for (int i = 1; i <= n; i++) {
    if (a[i] == 0) {
      if (top < 0) {
        ans++;
        top = d;
      }
      bon = max(bon, 0);
    } else {
      top += a[i];
      bon += a[i];
      if (bon > d) {
        puts("-1");
        return;
      }
      top = min(d, top);
    }
  }
  print(ans);
}
int main() {
  int t = 1;
  for (int cas = 1; cas <= t; cas++) {
    solve();
  }
}
