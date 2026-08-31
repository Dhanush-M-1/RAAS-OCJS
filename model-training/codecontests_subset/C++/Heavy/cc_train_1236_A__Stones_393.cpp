#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e6 + 10, modd = 1e9 + 7, SIZE = 100000, inf = 0x3f3f3f3f,
          INF = 0x7fffffff, hmod1 = 0x48E2DCE7, hmod2 = 0x60000005;
const int dir[4][2] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
const double eps = 1e-8;
template <class T>
inline void sc(T &x) {
  char c;
  x = 0;
  while ((c = getchar()) < '0')
    ;
  while (c >= '0' && c <= '9') x = x * 10 + (c - 48), c = getchar();
}
inline long long min(long long a, long long b) { return a < b ? a : b; }
inline long long max(long long a, long long b) { return a > b ? a : b; }
inline long long gcd(long long a, long long b) {
  return b == 0 ? a : gcd(b, a % b);
}
inline long long exgcd(long long a, long long b, long long &x, long long &y) {
  long long d;
  (b == 0 ? (x = 1, y = 0, d = a)
          : (d = exgcd(b, a % b, y, x), y -= a / b * x));
  return d;
}
inline long long qpow(long long a, long long n) {
  long long sum = 1;
  while (n) {
    if (n & 1) sum = sum * a % modd;
    a = a * a % modd;
    n >>= 1;
  }
  return sum;
}
inline long long qmul(long long a, long long n) {
  long long sum = 0;
  while (n) {
    if (n & 1) sum = (sum + a) % modd;
    a = (a + a) % modd;
    n >>= 1;
  }
  return sum;
}
inline long long inv(long long a) { return qpow(a, modd - 2); }
inline long long madd(long long a, long long b) {
  return (a % modd + b % modd) % modd;
}
inline long long mmul(long long a, long long b) { return a % modd * b % modd; }
inline void uadd(long long &a, long long b) { a = madd(a, b); }
inline void umul(long long &a, long long b) { a = mmul(a, b); }
inline void umin(long long &a, long long b) { a = min(a, b); }
inline void umax(long long &a, long long b) { a = max(a, b); }
long long a, b, c, ans;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int kase;
  cin >> kase;
  while (kase--) {
    ans = 0;
    cin >> a >> b >> c;
    ans += min(b, c / 2);
    b -= min(b, c / 2), c -= 2 * min(b, c / 2);
    ans += min(a, b / 2);
    cout << 3 * ans << endl;
  }
}
