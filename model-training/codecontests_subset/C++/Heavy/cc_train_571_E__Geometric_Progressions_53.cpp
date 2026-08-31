#include <bits/stdc++.h>
using namespace std;
template <typename T>
inline bool chkmin(T &a, const T &b) {
  return a > b ? a = b, 1 : 0;
}
template <typename T>
inline bool chkmax(T &a, const T &b) {
  return a < b ? a = b, 1 : 0;
}
const int oo = 0x3f3f3f3f;
const int Mod = 1e9 + 7;
template <typename T>
T &Read(T &first) {
  static char c;
  while (!isdigit(c = getchar()))
    ;
  first = c - '0';
  while (isdigit(c = getchar())) (first *= 10) += c - '0';
  return first;
}
inline long long mul(long long b, long long e, const long long &m) {
  long long t = 0;
  for (; e; e >>= 1, (b <<= 1) %= m)
    if (e & 1) (t += b) %= m;
  return t;
}
const int max0 = 3500, max1 = 1000000000;
const int maxn = 100;
int pr[max0 + 5];
int pn = 0;
inline void prepare() {
  for (int i = 2; i * i <= max1; ++i) {
    bool flag = 1;
    for (int j = 2; j * j <= i; ++j)
      if (!(i % j)) {
        flag = 0;
        break;
      }
    if (flag) pr[pn++] = i;
  }
}
int A[maxn + 5], B[maxn + 5];
int aa[max0 + 5], bb[max0 + 5];
template <typename T>
T ex_gcd(T a, T b, T &first, T &second) {
  if (!b) {
    first = 1, second = 0;
    return a;
  }
  T d = ex_gcd(b, a % b, second, first);
  second -= a / b * first;
  return d;
}
struct data {
  int a, b, c;
  data() {}
  data(const int &_a, const int &_b, const int &_c) : a(_a), b(_b), c(_c) {}
};
data a[maxn + 5];
int an = 0;
inline int get(int first, const int &second) {
  int ret = 0;
  while (!(first % pr[second])) first /= pr[second], ++ret;
  return ret;
}
template <typename T>
inline T ceil(T a, T b) {
  if (b < 0) a = -a, b = -b;
  if (a < 0) return a / b;
  return (a + b - 1) / b;
}
template <typename T>
inline T floor(T a, T b) {
  return -ceil(-a, -b);
}
int main() {
  prepare();
  int n;
  scanf("%d", &n);
  for (int i = (0), _end_ = (n); i < _end_; ++i) scanf("%d%d", B + i, A + i);
  for (int i = (0), _end_ = (pn); i < _end_; ++i)
    aa[i] = get(A[n - 1], i), bb[i] = get(B[n - 1], i);
  long long ans = -1;
  for (int i = (0), _end_ = (n - 1); i < _end_; ++i) {
    bool flag = 0;
    data pre;
    for (int j = (0), _end_ = (pn); j < _end_; ++j) {
      int a0 = aa[j], b0 = bb[j];
      int a1 = get(A[i], j), b1 = get(B[i], j);
      if (a0 || a1 || b0 != b1) {
        if (b0 != b1 && !a0 && !a1) printf("-1\n"), exit(0);
        if (a0 || a1) {
          if (!flag)
            pre = data(a0, -a1, b0 - b1);
          else {
            int newa = a0, newb = -a1, newc = b0 - b1;
            int D = -(pre.a * newb - pre.b * newa);
            int X = pre.c * newb - pre.b * newc;
            int Y = pre.a * newc - pre.c * newa;
            if (!D) {
              if (X || Y) printf("-1\n"), exit(0);
            } else {
              if (X % D || Y % D)
                printf("-1\n"), exit(0);
              else {
                if (X / D < 0 || Y / D < 0) printf("-1\n"), exit(0);
                if (ans != -1 && X / D != ans) printf("-1\n"), exit(0);
                ans = X / D;
              }
            }
          }
          flag = 1;
        }
      }
    }
    if (flag) a[an++] = pre;
  }
  for (int i = (0), _end_ = (an); i < _end_; ++i)
    if (!a[i].b) {
      if (a[i].c % a[i].a) printf("-1\n"), exit(0);
      if (a[i].c * a[i].a > 0) printf("-1\n"), exit(0);
      if (ans != -1 && (-a[i].c) / a[i].a != ans) printf("-1\n"), exit(0);
      ans = (-a[i].c) / a[i].a;
    }
  if (ans != -1) {
    for (int i = (0), _end_ = (an); i < _end_; ++i) {
      a[i].c += a[i].a * ans;
      if (a[i].b) {
        if (a[i].c % a[i].b) printf("-1\n"), exit(0);
        if (a[i].c * a[i].b > 0) printf("-1\n"), exit(0);
      } else if (a[i].c)
        printf("-1\n"), exit(0);
    }
  } else {
    static int val[maxn + 5];
    static int Mod[maxn + 5];
    int m = 0;
    long long Min = 0, Max = LLONG_MAX;
    for (int i = (0), _end_ = (an); i < _end_; ++i)
      if (!a[i].a) {
        if (a[i].c % a[i].b) printf("-1\n"), exit(0);
        if (a[i].c * a[i].b > 0) printf("-1\n"), exit(0);
      } else {
        static int first, second;
        int d = ex_gcd(a[i].a, a[i].b, first, second);
        if (a[i].c % d) printf("-1\n"), exit(0);
        first *= (-a[i].c) / d;
        Mod[m] = abs(a[i].b / d);
        val[m] = first % Mod[m];
        ++m;
        if (a[i].b < 0)
          Min = max(Min, (long long)ceil(-a[i].c, a[i].a));
        else
          Max = min(Max, (long long)floor(-a[i].c, a[i].a));
      }
    if (Min > Max) printf("-1\n"), exit(0);
    long long a = 0, b = 1;
    for (int i = (0), _end_ = (m); i < _end_; ++i) {
      static long long first, second;
      long long d = ex_gcd(b, (long long)Mod[i], first, second);
      long long res = a % d;
      if ((val[i] - res) % d) printf("-1\n"), exit(0);
      b /= d, Mod[i] /= d;
      (a -= res) /= d;
      (val[i] -= res) /= d;
      long long newb = b * Mod[i];
      (a += b) %= b;
      (val[i] += Mod[i]) %= Mod[i];
      a = (mul(mul(first, b, newb), val[i], newb) +
           mul(mul(second, Mod[i], newb), a, newb)) %
          newb;
      b = newb * d;
      ((a *= d) += res) %= b;
    }
    (a += b) %= b;
    ans = ceil(Min - a, b) * b + a;
    if (ans > Max) printf("-1\n"), exit(0);
  }
  long long t = 1;
  long long b = A[n - 1];
  assert(ans >= 0);
  for (; ans; ans >>= 1, (b *= b) %= Mod)
    if (ans & 1) (t *= b) %= Mod;
  (t *= B[n - 1]) %= Mod;
  printf("%I64d\n", t);
  return 0;
}
