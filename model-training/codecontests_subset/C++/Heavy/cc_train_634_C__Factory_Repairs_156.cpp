#include <bits/stdc++.h>
using namespace std;
const long long MAXN = 2e5 + 7;
long long n, k, a, b, q;
long long arr[MAXN];
void read() { cin >> n >> k >> a >> b >> q; }
long long acnt[MAXN << 2], asum[MAXN << 2], bcnt[MAXN << 2], bsum[MAXN << 2];
long long getacnt(long long v, long long tl, long long tr, long long l,
                  long long r) {
  if (tr < l || r < tl) return 0;
  if (l <= tl && tr <= r) return acnt[v];
  long long tm = (tl + tr) >> 1;
  return getacnt(v * 2 + 1, tl, tm, l, r) +
         getacnt(v * 2 + 2, tm + 1, tr, l, r);
}
long long getbcnt(long long v, long long tl, long long tr, long long l,
                  long long r) {
  if (tr < l || r < tl) return 0;
  if (l <= tl && tr <= r) return bcnt[v];
  long long tm = (tl + tr) >> 1;
  return getbcnt(v * 2 + 1, tl, tm, l, r) +
         getbcnt(v * 2 + 2, tm + 1, tr, l, r);
}
long long getasum(long long v, long long tl, long long tr, long long l,
                  long long r) {
  if (tr < l || r < tl) return 0;
  if (l <= tl && tr <= r) return asum[v];
  long long tm = (tl + tr) >> 1;
  return getasum(v * 2 + 1, tl, tm, l, r) +
         getasum(v * 2 + 2, tm + 1, tr, l, r);
}
long long getbsum(long long v, long long tl, long long tr, long long l,
                  long long r) {
  if (tr < l || r < tl) return 0;
  if (l <= tl && tr <= r) return bsum[v];
  long long tm = (tl + tr) >> 1;
  return getbsum(v * 2 + 1, tl, tm, l, r) +
         getbsum(v * 2 + 2, tm + 1, tr, l, r);
}
void updacnt(long long v, long long tl, long long tr, long long p,
             long long x) {
  if (tl == tr) {
    acnt[v] = (arr[p] + x >= a);
    return;
  }
  long long tm = (tl + tr) >> 1;
  if (p <= tm)
    updacnt(v * 2 + 1, tl, tm, p, x);
  else
    updacnt(v * 2 + 2, tm + 1, tr, p, x);
  acnt[v] = acnt[v * 2 + 1] + acnt[v * 2 + 2];
}
void updbcnt(long long v, long long tl, long long tr, long long p,
             long long x) {
  if (tl == tr) {
    bcnt[v] = (arr[p] + x >= b);
    return;
  }
  long long tm = (tl + tr) >> 1;
  if (p <= tm)
    updbcnt(v * 2 + 1, tl, tm, p, x);
  else
    updbcnt(v * 2 + 2, tm + 1, tr, p, x);
  bcnt[v] = bcnt[v * 2 + 1] + bcnt[v * 2 + 2];
}
void updasum(long long v, long long tl, long long tr, long long p,
             long long x) {
  if (tl == tr) {
    asum[v] = (arr[p] + x) * (arr[p] + x < a);
    return;
  }
  long long tm = (tl + tr) >> 1;
  if (p <= tm)
    updasum(v * 2 + 1, tl, tm, p, x);
  else
    updasum(v * 2 + 2, tm + 1, tr, p, x);
  asum[v] = asum[v * 2 + 1] + asum[v * 2 + 2];
}
void updbsum(long long v, long long tl, long long tr, long long p,
             long long x) {
  if (tl == tr) {
    bsum[v] = (arr[p] + x) * (arr[p] + x < b);
    return;
  }
  long long tm = (tl + tr) >> 1;
  if (p <= tm)
    updbsum(v * 2 + 1, tl, tm, p, x);
  else
    updbsum(v * 2 + 2, tm + 1, tr, p, x);
  bsum[v] = bsum[v * 2 + 1] + bsum[v * 2 + 2];
}
void print() {
  for (long long i = 0; i < q; ++i) {
    long long t;
    cin >> t;
    if (t == 1) {
      long long p, x;
      cin >> p >> x;
      --p;
      updacnt(0, 0, MAXN, p, x);
      updbcnt(0, 0, MAXN, p, x);
      updasum(0, 0, MAXN, p, x);
      updbsum(0, 0, MAXN, p, x);
      arr[p] += x;
    } else {
      long long p;
      cin >> p;
      --p;
      long long sum1 =
          getbcnt(0, 0, MAXN, 0, p - 1) * b + getbsum(0, 0, MAXN, 0, p - 1);
      long long sum2 = getacnt(0, 0, MAXN, p + k, MAXN) * a +
                       getasum(0, 0, MAXN, p + k, MAXN);
      cout << sum1 + sum2 << '\n';
    }
  }
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  read();
  print();
  return 0;
}
