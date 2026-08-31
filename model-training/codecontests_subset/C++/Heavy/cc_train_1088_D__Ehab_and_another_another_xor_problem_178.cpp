#include <bits/stdc++.h>
const double PI = acos(-1);
const double EPS = 1e-6;
const long long MOD = 998244353;
const long long N = 30 + 10;
template <typename T>
inline T Abs(T x) {
  return x < 0 ? x * -1 : x;
}
template <typename T>
inline T Max(T x, T y, T z) {
  return std::max(std::max(x, y), z);
}
template <typename T>
inline T Min(T x, T y, T z) {
  return std::min(std::min(x, y), z);
}
template <typename T>
inline void Ckmax(T &x, T y) {
  x = std::max(x, y);
}
template <typename T>
inline void Ckmin(T &x, T y) {
  x = std::min(x, y);
}
template <typename T>
inline T Sqr(T x) {
  return x * x;
}
template <typename T>
inline T Pow(T x, T y) {
  T r = 1;
  while (y > 0) {
    if (y % 2 > 0) (r *= x) %= MOD;
    (x *= x) %= MOD;
    y /= 2;
  }
  return r % MOD;
}
template <typename T>
T Pow(T x, T y, T z) {
  T r = 1;
  while (y > 0) {
    if (y % 2 > 0) (r *= x) %= z;
    (x *= x) %= z;
    y /= 2;
  }
  return r % z;
}
template <typename T>
inline T gcd(T x, T y) {
  return y > 0 ? gcd(y, x % y) : x;
}
template <typename T>
inline T lcm(T x, T y) {
  return x / gcd(x, y) * y;
}
inline void cinspu(void) {
  std::ios::sync_with_stdio(0);
  std::cin.tie(0);
}
inline long long fac(long long x) {
  long long r = 1;
  for (; x > 1; --x) (r *= x) %= MOD;
  return r;
}
int a[N], b[N], ans[N], tim;
int print(char z, int x, int y) {
  ++tim;
  printf("%c %d %d\n", z, x, y);
  fflush(stdout);
  if (z == '?') {
    int r;
    scanf("%d", &r);
    return r;
  }
  return -2;
}
int main() {
  const char q = '?';
  for (int i = 29, x = 0, y = 0; i >= 0; --i) {
    int n = (1 << i), r;
    if (ans[i])
      r = ans[i] - 3;
    else
      r = print(q, x, y);
    if (r > 0) {
      int p = print(q, x + n, y + n);
      if (p > 0) {
        int t = print(q, x + n, y);
        if (t > 0) {
          a[i] = b[i] = 0;
          ans[i - 1] = 3 + r;
        } else {
          a[i] = b[i] = 1;
          ans[i - 1] = 3 + p;
          x += n;
          y += n;
        }
      } else {
        a[i] = 1;
        b[i] = 0;
        x += n;
      }
    } else if (r < 0) {
      int p = print(q, x + n, y + n);
      if (p < 0) {
        int t = print(q, x + n, y);
        if (t > 0) {
          a[i] = b[i] = 0;
          ans[i - 1] = 3 + r;
        } else {
          a[i] = b[i] = 1;
          ans[i - 1] = 3 + p;
          x += n;
          y += n;
        }
      } else {
        a[i] = 0;
        b[i] = 1;
        y += n;
      }
    } else {
      r = print(q, x + n, y);
      if (r > 0) {
        a[i] = b[i] = 0;
      } else {
        a[i] = b[i] = 1;
        x += n;
        y += n;
      }
    }
  }
  int x = 0;
  for (int i = 0; i < 30; ++i) x += a[i] * (1 << i);
  int y = 0;
  for (int i = 0; i < 30; ++i) y += b[i] * (1 << i);
  print('!', x, y);
  return 0;
}
