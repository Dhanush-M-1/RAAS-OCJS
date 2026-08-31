#include <bits/stdc++.h>
using namespace std;
template <class T>
inline void rd(T &x) {
  x = 0;
  char c = getchar();
  int f = 1;
  while (!isdigit(c)) {
    if (c == '-') f = -1;
    c = getchar();
  }
  while (isdigit(c)) x = x * 10 - '0' + c, c = getchar();
  x *= f;
}
inline long long Abs(long long x) { return x > 0 ? x : -x; }
long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
struct item {
  int p;
  long long k;
  item(int p = 0, long long k = 0) : p(p), k(k) {}
};
struct Num {
  item p[810];
  int num;
  void init(int x) {
    for (int i = 2; i * (long long)i <= x; ++i)
      if (x % i == 0) {
        int c = 0;
        while (x % i == 0) x /= i, c++;
        p[num++] = item(i, c);
      }
    if (x > 1) p[num++] = item(x, 1);
  }
  item query(int x) {
    for (int i = 0; i < num; ++i)
      if (p[i].p == x) return p[i];
    return item(x, 0);
  }
} A[110], B[110];
int n;
void FAIL() {
  puts("-1");
  exit(0);
}
item A1[3210], B1[3210], A2[3210], B2[3210];
int pri[3210], num;
long long exgcd(long long a, long long b, long long &x, long long &y) {
  if (!b) {
    x = 1, y = 0;
    return a;
  }
  long long g = exgcd(b, a % b, y, x);
  y -= a / b * x;
  return g;
}
void Inter(long long A, long long B, long long C, long long a, long long b,
           long long c, long long &x1, long long &x2) {
  while (a) {
    long long t = A / a;
    A -= t * a, B -= t * b, C -= t * c;
    swap(A, a), swap(B, b), swap(C, c);
  }
  if (c % b) FAIL();
  x2 = -c / b;
  if ((C + B * x2) % A) FAIL();
  x1 = (-C - B * x2) / A;
}
void UN(Num &a1, Num &b1, Num &a2, Num &b2) {
  num = 0;
  for (int i = 0; i < a1.num; ++i) pri[num++] = a1.p[i].p;
  for (int i = 0; i < a2.num; ++i) pri[num++] = a2.p[i].p;
  for (int i = 0; i < b1.num; ++i) pri[num++] = b1.p[i].p;
  for (int i = 0; i < b2.num; ++i) pri[num++] = b2.p[i].p;
  sort(pri, pri + num);
  num = unique(pri, pri + num) - pri;
  for (int i = 0; i < num; ++i) A1[i] = a1.query(pri[i]);
  for (int i = 0; i < num; ++i) A2[i] = a2.query(pri[i]);
  for (int i = 0; i < num; ++i) B1[i] = b1.query(pri[i]);
  for (int i = 0; i < num; ++i) B2[i] = b2.query(pri[i]);
  long long A = 0, B = 0, C = 0;
  int flg1 = 0;
  long long x1, x2;
  for (int i = 0; i < num; ++i) {
    long long a = B1[i].k, b = -B2[i].k, c = A1[i].k - A2[i].k;
    if (a == 0 && b == 0) {
      if (c) FAIL();
      continue;
    }
    long long g = gcd(a, gcd(-b, Abs(c)));
    a /= g, b /= g, c /= g;
    if (!b) {
      if (c % a) FAIL();
      if (-c / a < 0) FAIL();
    }
    if (!A && !B) {
      A = a, B = b, C = c;
      continue;
    }
    if (!B) {
      if (b) {
        Inter(A, B, C, a, b, c, x1, x2), flg1 = 1;
        break;
      }
      if (C / A != c / a) FAIL();
      continue;
    }
    if (A * b == a * B) {
      if (c * A == C * a) continue;
      FAIL();
    }
    Inter(A, B, C, a, b, c, x1, x2), flg1 = 1;
    break;
  }
  if (flg1) {
    for (int i = 0; i < num; ++i) {
      long long a = B1[i].k, b = -B2[i].k, c = A1[i].k - A2[i].k;
      if (a * x1 + b * x2 + c) FAIL();
    }
    for (int i = 0; i < num; ++i) {
      A1[i].k = A1[i].k + B1[i].k * x1;
      B1[i].k = 0;
    }
    for (int i = 0; i < num; ++i) a1.p[i] = A1[i], b1.p[i] = B1[i];
    a1.num = b1.num = num;
    return;
  }
  long long g = exgcd(A, B, x1, x2);
  if (C % g) FAIL();
  x1 *= -C / g, x2 *= -C / g;
  long long tx = Abs(-B / g), ty = Abs(A / g);
  if (C > 0 || !ty) {
    x1 = (x1 % tx + tx) % tx;
    if (B)
      x2 = -(A * x1 + C) / B;
    else
      x2 = 0;
  } else {
    x2 = (x2 % ty + ty) % ty;
    if (A)
      x1 = (-B * x2 - C) / A;
    else
      x1 = 0;
  }
  for (int i = 0; i < num; ++i) {
    A1[i].k = A1[i].k + B1[i].k * x1;
    B1[i].k = tx * B1[i].k;
  }
  for (int i = 0; i < num; ++i) a1.p[i] = A1[i], b1.p[i] = B1[i];
  a1.num = b1.num = num;
}
const int mod = 1e9 + 7;
int Pow(int x, long long y) {
  int res = 1;
  for (y %= (mod - 1); y; x = x * (long long)x % mod, y >>= 1)
    if (y & 1) res = res * (long long)x % mod;
  return res;
}
int main() {
  rd(n);
  for (int i = 1, a, b; i <= n; ++i) rd(a), rd(b), A[i].init(a), B[i].init(b);
  for (int i = 2; i <= n; ++i) UN(A[1], B[1], A[i], B[i]);
  long long ans = 1;
  for (int i = 0; i < A[1].num; ++i)
    ans = ans * (long long)Pow(A[1].p[i].p, A[1].p[i].k) % mod;
  printf("%lld", ans);
  return 0;
}
