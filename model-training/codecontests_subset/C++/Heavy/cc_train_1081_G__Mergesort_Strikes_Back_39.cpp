#include <bits/stdc++.h>
using namespace std;
template <class T>
inline void read(T &x) {
  x = 0;
  char c = getchar();
  int f = 1;
  while (!isdigit(c)) {
    if (c == '-') f = -1;
    c = getchar();
  }
  while (isdigit(c)) {
    x = x * 10 + c - '0';
    c = getchar();
  }
  x *= f;
}
template <class T>
inline void umin(T &x, T y) {
  x = x < y ? x : y;
}
template <class T>
inline void umax(T &x, T y) {
  x = x > y ? x : y;
}
inline unsigned int R() {
  static unsigned int seed = 416;
  return seed ^= seed >> 5, seed ^= seed << 17, seed ^= seed >> 13;
}
const int N = 233333;
int n, k, mo, s[N], len;
long long res;
void solve(int l, int r, int h) {
  if (l > r) return;
  if (h <= 1 || l == r) {
    s[++len] = r - l + 1;
    return;
  }
  int mid = (l + r) >> 1;
  solve(l, mid, h - 1);
  solve(mid + 1, r, h - 1);
}
inline int power(int a, int n) {
  int res = 1;
  while (n) {
    if (n & 1) res = 1LL * res * a % mo;
    a = 1LL * a * a % mo;
    n >>= 1;
  }
  return res;
}
long long solve(int n, int m) {
  long long res = 1LL * n * m % mo * power(2, mo - 2) % mo;
  for (register int c = (1); c <= (n + m); c++) {
    int l = max(1, c - m), r = min(n, c - 1);
    if (r - l + 1 >= 1) res = (res - 1LL * (r - l + 1) * power(c, mo - 2)) % mo;
  }
  return res;
}
int main() {
  read(n);
  read(k);
  read(mo);
  solve(1, n, k);
  sort(s + 1, s + len + 1);
  for (register int i = (1); i <= (len); i++)
    res += 1LL * s[i] * (s[i] - 1) % mo * power(4, mo - 2) % mo;
  static pair<int, int> a[N];
  int tot = 0;
  for (register int i = (1); i <= (len); i++)
    if (a[tot].first == s[i])
      a[tot].second++;
    else
      a[++tot] = pair<int, int>(s[i], 1);
  assert(tot <= 2);
  for (register int i = (1); i <= (tot); i++)
    res += 1LL * a[i].second * (a[i].second - 1) / 2 % mo *
           solve(a[i].first, a[i].first) % mo;
  if (tot == 2)
    res += 1LL * a[1].second * a[2].second % mo *
           solve(a[1].first, a[2].first) % mo;
  printf("%lld", (res % mo + mo) % mo);
  return 0;
}
