#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
long long mul(long long a, long long b, long long mod) {
  long long res = 0;
  for (; b; b >>= 1, a = (a + a) % mod)
    if (b & 1) res = (res + a) % mod;
  return res;
}
long long pow(long long b, long long e, long long mod) {
  long long res = 1;
  for (; e; e >>= 1, b = mul(b, b, mod))
    if (e & 1) res = mul(res, b, mod);
  return res;
}
long long gcd(long long a, long long b) {
  if (a < 0) a = -a;
  if (b < 0) b = -b;
  for (; b;) {
    long long res = a % b;
    a = b;
    b = res;
  }
  return a;
}
long long phi(long long x) {
  long long ans = x;
  for (long long i = 2; i * i <= x; i++) {
    if (x % i == 0) {
      for (; x % i == 0; x /= i)
        ;
      ans -= ans / i;
    }
  }
  if (x != 1) ans -= ans / x;
  return ans;
}
void reject() {
  printf("-1\n");
  exit(0);
}
void read(map<int, pair<long long, long long> > &mp) {
  int x, y;
  scanf("%d %d", &x, &y);
  for (int i = 2; i * i <= x; i++) {
    if (x % i == 0) {
      int cnt = 0;
      for (; x % i == 0; x /= i, cnt++)
        ;
      mp[i].first += cnt;
    }
  }
  if (x > 1) mp[x].first++;
  for (int i = 2; i * i <= y; i++) {
    if (y % i == 0) {
      int cnt = 0;
      for (; y % i == 0; y /= i, cnt++)
        ;
      mp[i].second += cnt;
    }
  }
  if (y > 1) mp[y].second++;
  return;
}
long long solve(long long a, long long b, long long c) {
  if (a == 0) return 0;
  if (b == 0) return c / a;
  long long ta = mul(pow(a, phi(-b) - 1, -b), (c % (-b) + (-b)) % (-b), -b);
  long long tb = (c - ta * a) / b;
  if (tb < 0) {
    long long d = (-tb + a - 1) / a;
    ta += -b * d;
    tb += a * d;
  }
  return ta;
}
map<int, pair<long long, long long> > merge(
    map<int, pair<long long, long long> > a,
    map<int, pair<long long, long long> > b) {
  long long la = 0, lb = 0, lc = 0, px = 0, py = 0, l = 0, p = 0;
  for (auto it = b.begin(); it != b.end(); it++) a[it->first];
  for (auto it = a.begin(); it != a.end(); it++) {
    pair<long long, long long> &pa = it->second;
    pair<long long, long long> &pb = b[it->first];
    long long A = pa.second, B = -pb.second, C = pb.first - pa.first,
              GCD = gcd(A, B);
    if (A == 0 && B == 0) {
      if (C) reject();
      continue;
    }
    if (C % GCD) reject();
    A /= GCD;
    B /= GCD;
    C /= GCD;
    if (A < 0 || (A == 0 && B < 0)) {
      A = -A;
      B = -B;
      C = -C;
    }
    if (p) {
      if (px * A + py * B != C) reject();
    } else if (l) {
      if (la == A && lb == B) {
        if (lc != C) reject();
      } else {
        long long x0 = A * lb - B * la, x1 = C * lb - B * lc;
        long long y0 = B * la - A * lb, y1 = C * la - A * lc;
        if (x1 % x0 || y1 % y0) reject();
        l = 0;
        p = 1;
        px = x1 / x0;
        py = y1 / y0;
        if (px < 0 || py < 0) reject();
      }
    } else {
      l = 1;
      la = A;
      lb = B;
      lc = C;
    }
  }
  if (l) {
    map<int, pair<long long, long long> > ans;
    for (auto it = a.begin(); it != a.end(); it++) {
      ans[it->first] = {
          it->second.first + it->second.second * solve(la, lb, lc),
          it->second.second * (-lb)};
    }
    return ans;
  } else if (p) {
    map<int, pair<long long, long long> > ans;
    for (auto it = a.begin(); it != a.end(); it++) {
      ans[it->first] = {px * it->second.second + it->second.first, 0};
    }
    return ans;
  }
  return a;
}
map<int, pair<long long, long long> > a[105];
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    read(a[i]);
    if (i != 1) a[i] = merge(a[i], a[i - 1]);
  }
  long long ans = 1;
  for (auto it = a[n].begin(); it != a[n].end(); it++)
    ans = ans * 1ll * pow(it->first, it->second.first, mod) % mod;
  printf("%lld\n", ans);
  return 0;
}
