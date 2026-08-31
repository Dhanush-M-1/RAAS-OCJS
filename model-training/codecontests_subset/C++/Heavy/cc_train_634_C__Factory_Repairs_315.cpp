#include <bits/stdc++.h>
using namespace std;
long long z = 1000000007;
long long gcd(long long a, long long b) {
  if (a == 0) return b;
  if (b == 0) return a;
  return gcd(b, a % b);
}
long long power(long long a, long long b) {
  long long res = 1;
  while (b) {
    if (b & 1) {
      res = (res * a) % z;
      b--;
    } else {
      a = (a * a) % z;
      b = b >> 1;
    }
  }
  return res;
}
vector<long long> seg, seg1;
void arrange(long long i, long long v, long long v1, long long x, long long lx,
             long long rx) {
  if (rx - lx == 1) {
    seg[x] = v;
    seg1[x] = v1;
    return;
  }
  long long mid = (lx + rx) / 2;
  if (i < mid)
    arrange(i, v, v1, 2 * x + 1, lx, mid);
  else
    arrange(i, v, v1, 2 * x + 2, mid, rx);
  seg[x] = seg[2 * x + 1] + seg[2 * x + 2];
  seg1[x] = seg1[2 * x + 1] + seg1[2 * x + 2];
}
long long sum1(long long l, long long r, long long x, long long lx,
               long long rx) {
  if (l >= rx || r <= lx) return 0;
  if (lx >= l && rx <= r) return seg[x];
  long long mid = (lx + rx) / 2;
  long long sl = sum1(l, r, 2 * x + 1, lx, mid),
            sr = sum1(l, r, 2 * x + 2, mid, rx);
  return (sl + sr);
}
long long sum2(long long l, long long r, long long x, long long lx,
               long long rx) {
  if (l >= rx || r <= lx) return 0;
  if (lx >= l && rx <= r) return seg1[x];
  long long mid = (lx + rx) / 2;
  long long sl = sum2(l, r, 2 * x + 1, lx, mid),
            sr = sum2(l, r, 2 * x + 2, mid, rx);
  return (sl + sr);
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long t;
  t = 1;
  while (t--) {
    long long n, k, a, b, q;
    cin >> n >> k >> a >> b >> q;
    long long s = 1;
    while (s < n) s *= 2;
    seg.assign(2 * s, (long long)0);
    seg1.assign(2 * s, (long long)0);
    long long ar[n], ar1[n];
    memset(ar, 0, sizeof(ar));
    memset(ar1, 0, sizeof(ar1));
    set<long long> s1;
    while (q--) {
      long long ty;
      cin >> ty;
      if (ty == 1) {
        long long d, a1;
        cin >> d >> a1;
        d--;
        if (s1.find(d) == s1.end()) {
          ar[d] += a1;
          ar1[d] += a1;
          ar[d] = min(ar[d], a);
          ar1[d] = min(ar1[d], b);
          if (ar[d] <= a) arrange(d, ar[d], ar1[d], 0, 0, s);
          if (ar[d] == a) s1.insert(d);
        }
      } else {
        long long p;
        cin >> p;
        p--;
        long long p1 = 0;
        if (p > 0) p1 = sum2(0, p, 0, 0, s);
        if (p + k < n) p1 += sum1(p + k, n, 0, 0, s);
        cout << p1 << "\n";
      }
    }
  }
}
