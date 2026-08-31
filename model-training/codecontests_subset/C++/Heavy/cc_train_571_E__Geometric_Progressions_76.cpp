#include <bits/stdc++.h>
using namespace std;
void read(map<int, pair<long long, long long> > &mp) {
  int x, y;
  scanf("%d%d", &x, &y);
  for (int i = 2; i * i <= x; i++)
    if (x % i == 0) {
      int cnt = 0;
      for (; x % i == 0; x /= i, cnt++)
        ;
      mp[i].first += cnt;
    }
  if (x > 1) mp[x].first++;
  for (int i = 2; i * i <= y; i++)
    if (y % i == 0) {
      int cnt = 0;
      for (; y % i == 0; y /= i, cnt++)
        ;
      mp[i].second += cnt;
    }
  if (y > 1) mp[y].second++;
}
long long gcd(long long x, long long y) {
  if (x < 0) x = -x;
  if (y < 0) y = -y;
  for (; y;) {
    long long r = x % y;
    x = y;
    y = r;
  }
  return x;
}
long long mul(long long a, long long b, long long c) {
  long long s = 0;
  for (; b; b >>= 1) {
    if (b & 1) (s += a) >= c ? s -= c : 233;
    (a += a) >= c ? a -= c : 233;
  }
  return s;
}
long long power(long long a, long long b, long long c) {
  long long s = 1;
  for (; b; b /= 2, a = mul(a, a, c))
    if (b & 1) s = mul(s, a, c);
  return s;
}
long long phi(long long x) {
  long long ans = x;
  for (long long i = 2; i * i <= x; i++)
    if (x % i == 0) {
      for (; x % i == 0; x /= i)
        ;
      ans -= ans / i;
    }
  if (x != 1) ans -= ans / x;
  return ans;
}
long long solve(long long a, long long b, long long c) {
  if (a == 0) return 0;
  if (b == 0) return c / a;
  long long ta = mul(power(a, phi(-b) - 1, -b), (c % (-b) + (-b)) % (-b), -b);
  long long tb = (c - ta * a) / b;
  if (tb < 0) {
    long long d = (-tb + a - 1) / a;
    ta += -b * d;
    tb += a * d;
  }
  return ta;
}
void GG() {
  puts("-1");
  exit(0);
}
map<int, pair<long long, long long> > merge(
    map<int, pair<long long, long long> > a,
    map<int, pair<long long, long long> > b) {
  long long l = 0, la = 0, lb = 0, lc = 0;
  long long p = 0, px = 0, py = 0;
  map<int, pair<long long, long long> >::iterator it;
  for (it = b.begin(); it != b.end(); it++) a[it->first];
  for (it = a.begin(); it != a.end(); it++) {
    pair<long long, long long> &pa = it->second, &pb = b[it->first];
    long long A = pa.second, B = -pb.second, C = pb.first - pa.first,
              G = gcd(A, B);
    if (A == 0 && B == 0) {
      if (C) GG();
      continue;
    }
    if (C % G) GG();
    A /= G;
    B /= G;
    C /= G;
    if (A < 0 || (A == 0 && B < 0)) A = -A, B = -B, C = -C;
    if (p) {
      if (px * A + py * B != C) GG();
    } else if (l) {
      if (la == A && lb == B) {
        if (lc != C) GG();
      } else {
        long long X0 = A * lb - B * la, X1 = C * lb - B * lc;
        long long Y0 = B * la - A * lb, Y1 = C * la - A * lc;
        if (X1 % X0 || Y1 % Y0) GG();
        l = 0;
        p = 1;
        px = X1 / X0;
        py = Y1 / Y0;
        if (px < 0 || py < 0) GG();
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
    for (it = a.begin(); it != a.end(); it++)
      ans[it->first] = pair<long long, long long>(
          it->second.first + it->second.second * solve(la, lb, lc),
          it->second.second * (-lb));
    return ans;
  } else if (p) {
    map<int, pair<long long, long long> > ans;
    for (it = a.begin(); it != a.end(); it++)
      ans[it->first] = pair<long long, long long>(
          px * it->second.second + it->second.first, 0);
    return ans;
  } else
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
  map<int, pair<long long, long long> >::iterator it;
  for (it = a[n].begin(); it != a[n].end(); it++)
    ans =
        1ll * ans * power(it->first, it->second.first, 1000000007) % 1000000007;
  printf("%lld\n", ans);
}
