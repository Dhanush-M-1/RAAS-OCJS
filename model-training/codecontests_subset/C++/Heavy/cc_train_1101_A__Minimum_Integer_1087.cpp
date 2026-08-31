#include <bits/stdc++.h>
using namespace std;
void debug_out() { cerr << '\n'; }
template <typename T, typename... R>
void debug_out(const T &f, const R &...r) {
  cerr << f << " ";
  debug_out(r...);
}
inline long long read() {
  long long x = 0;
  int f = 0;
  char ch = getchar();
  while (ch < '0' || ch > '9') f |= (ch == '-'), ch = getchar();
  while (ch >= '0' && ch <= '9')
    x = (x << 3) + (x << 1) + ch - '0', ch = getchar();
  return x = f ? -x : x;
}
inline void write(long long x) {
  if (x == 0) {
    putchar('0');
    return;
  }
  if (x < 0) {
    putchar('-');
    x = -x;
  }
  static char s[23];
  int l = 0;
  while (x != 0) s[l++] = x % 10 + 48, x /= 10;
  while (l) putchar(s[--l]);
}
int lowbit(int x) { return x & (-x); }
template <class T>
T big(const T &a1, const T &a2) {
  return a1 > a2 ? a1 : a2;
}
template <typename T, typename... R>
T big(const T &f, const R &...r) {
  return big(f, big(r...));
}
template <class T>
T sml(const T &a1, const T &a2) {
  return a1 < a2 ? a1 : a2;
}
template <typename T, typename... R>
T sml(const T &f, const R &...r) {
  return sml(f, sml(r...));
}
template <class T, class U>
inline void checkMin(T &x, U y) {
  if (y < x) x = y;
}
template <class T, class U>
inline void checkMax(T &x, U y) {
  if (y > x) x = y;
}
const int M = 212345;
const int inf = 0x3f3f3f3f;
const long long INF = 0x3f3f3f3f3f3f3f3f;
const int mod = 1000000007;
void init() {
  int _ = read();
  while (_--) {
    long long l = read();
    long long r = read();
    long long x = read();
    long long now;
    if (x > r) {
      now = x;
    } else if (x < l) {
      now = x;
    } else {
      now = (r + x) / x * x;
    }
    write(now);
    puts("");
  }
}
void solve() {}
int main() {
  init();
  solve();
  return 0;
}
