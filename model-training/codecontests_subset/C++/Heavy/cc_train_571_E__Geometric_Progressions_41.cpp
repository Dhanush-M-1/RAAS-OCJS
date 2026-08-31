#include <bits/stdc++.h>
using namespace std;
const int N = 210;
const int mod = 1e9 + 7;
inline int Pow(int x, int y) {
  int res = 1;
  for (; y; y >>= 1, x = (long long)x * x % mod)
    if (y & 1) res = (long long)res * x % mod;
  return res;
}
inline void FUCK() { puts("-1"), exit(0); }
map<long long, pair<long long, long long> > wkr[N];
inline void test(int a, int b) {
  long long cur = -1;
  for (auto t : wkr[b])
    if (!wkr[a].count(t.first)) FUCK();
  for (auto t : wkr[a])
    if (wkr[b].count(t.first)) {
      auto A = t.second, B = wkr[b][t.first];
      if (A.second != B.second) {
        if (!B.first) FUCK();
        if (A.second < B.second || (A.second - B.second) % B.first) FUCK();
      }
      long long hh = B.first ? (A.second - B.second) / B.first : -1;
      if (cur == -1) cur = hh;
      if (cur != hh) FUCK();
    } else
      FUCK();
}
int n, tot;
long long A, B, C;
long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
long long G[2][2];
inline long long Det() { return G[0][0] * G[1][1] - G[0][1] * G[1][0]; }
inline bool push(long long tA, long long tB, long long tC) {
  long long g = gcd(tA, tB);
  assert(g);
  if (tC % g) FUCK();
  tA /= g, tB /= g, tC /= g;
  if (!A) return A = tA, B = tB, C = tC, false;
  if (A == tA && B == tB) {
    if (C != tC) FUCK();
    return false;
  }
  G[0][0] = A, G[0][1] = B, G[1][0] = tA, G[1][1] = tB;
  long long base = Det();
  assert(base);
  G[0][0] = C, G[0][1] = B, G[1][0] = tC, G[1][1] = tB;
  long long t1 = Det();
  if (t1 % base) FUCK();
  G[0][0] = A, G[0][1] = C, G[1][0] = tA, G[1][1] = tC;
  long long t2 = Det();
  if (t2 % base) FUCK();
  long long x = t1 / base, y = t2 / base;
  if (x < 0 || y < 0) FUCK();
  A = x, B = y;
  return true;
}
long long x, y;
long long exgcd(long long a, long long b) {
  if (!b) return x = 1, y = 0, a;
  long long d = exgcd(b, a % b), t = x;
  x = y, y = t - a / b * y;
  return d;
}
inline void merge(int a, int b) {
  A = B = C = 0, tot++;
  bool flag = false;
  for (auto t : wkr[a])
    if (wkr[b].count(t.first)) {
      auto A = t.second, B = wkr[b][t.first];
      if (push(A.first, -B.first, B.second - A.second)) {
        flag = true;
        break;
      }
    } else
      FUCK();
  for (auto t : wkr[b])
    if (!wkr[a].count(t.first)) FUCK();
  if (flag) {
    int ans = 1;
    for (auto t : wkr[a]) {
      long long tmp = t.second.first * A + t.second.second;
      wkr[tot][t.first] = pair<long long, long long>(0, tmp);
      ans = (long long)ans * Pow(t.first, tmp % (mod - 1)) % mod;
    }
    for (int i = 1; i <= n; i++) test(tot, i);
    printf("%d\n", ans), exit(0);
  }
  if (!A) FUCK();
  if (B < 0) A = -A, B = -B, C = -C;
  long long g = exgcd(A, B);
  x *= C / g, x = (x % B + B) % B;
  for (auto t : wkr[a])
    wkr[tot][t.first] = pair<long long, long long>(
        B * t.second.first, t.second.second + t.second.first * x);
}
int fuck[N], zjk[N];
inline void test(int x) {
  for (int i = 1; i <= n; i++) {
    if (x % fuck[i]) return;
    int tmp = x / fuck[i];
    while (tmp > 1) {
      if (tmp % zjk[i]) return;
      tmp /= zjk[i];
    }
    if (tmp == 0) return;
  }
  printf("%d\n", x), exit(0);
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    int a, b;
    scanf("%d%d", &a, &b), fuck[i] = a, zjk[i] = b;
    for (int j = 2; (j * j <= a) || (j * j <= b); j++)
      if (a % j == 0 || b % j == 0) {
        int ct = 0, ct1 = 0;
        while (a % j == 0) ct++, a /= j;
        while (b % j == 0) ct1++, b /= j;
        wkr[i][j] = pair<long long, long long>(ct1, ct);
      }
    if (a != 1 || b != 1) {
      if (a == b)
        wkr[i][a] = pair<long long, long long>(1, 1);
      else {
        if (a != 1) wkr[i][a] = pair<long long, long long>(0, 1);
        if (b != 1) wkr[i][b] = pair<long long, long long>(1, 0);
      }
    }
  }
  test(1);
  for (int i = 1; i <= n; i++) test(fuck[i]);
  tot = n, merge(1, 2);
  for (int i = 3; i <= n; i++) merge(tot, i);
  for (int i = 1; i <= n; i++) test(tot, i);
  int ans = 1;
  for (auto t : wkr[tot])
    ans = (long long)ans * Pow(t.first, t.second.second % (mod - 1)) % mod;
  printf("%d\n", ans);
}
