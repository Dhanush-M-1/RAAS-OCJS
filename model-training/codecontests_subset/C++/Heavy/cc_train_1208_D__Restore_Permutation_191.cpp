#include <bits/stdc++.h>
using namespace std;
long long dx[] = {1, 0, -1, 0};
long long dy[] = {0, 1, 0, -1};
long long gcd(long long x, long long y) {
  if (y == 0)
    return x;
  else
    return gcd(y, x % y);
}
long long expo(long long n, long long m, long long p) {
  long long r = 1;
  n = n % p;
  while (m > 0) {
    if (m % 2) r = (r * n) % p;
    n = (n * n) % p;
    m = m / 2;
  }
  return r % p;
}
bool isPrime(long long n) {
  if (n <= 1) return false;
  if (n <= 3) return true;
  if (n % 2 == 0 || n % 3 == 0) return false;
  for (long long i = 5; i * i <= n; i = i + 6)
    if (n % i == 0 || n % (i + 2) == 0) return false;
  return true;
}
long long lazy[2000005];
vector<long long> a;
struct node {
  long long val;
  long long ind;
};
node seg[2000005];
void build(long long m, long long s, long long e) {
  node t;
  if (s > e) return;
  if (s == e) {
    t.val = a[s];
    t.ind = s;
    seg[m] = t;
    return;
  }
  long long mid = (s + e) / 2;
  build(2 * m, s, mid);
  build(2 * m + 1, mid + 1, e);
  seg[m].val = min(seg[2 * m].val, seg[2 * m + 1].val);
  if (seg[2 * m].val >= seg[2 * m + 1].val)
    seg[m].ind = seg[2 * m + 1].ind;
  else
    seg[m].ind = seg[2 * m].ind;
}
void update(long long m, long long s, long long e, long long l, long long r,
            long long v) {
  if (lazy[m] != 0) {
    seg[m].val = seg[m].val + lazy[m];
    if (s != e) {
      lazy[2 * m] += lazy[m];
      lazy[2 * m + 1] += lazy[m];
    }
    lazy[m] = 0;
  }
  if (s > e || s > r || e < l || r < l) return;
  if (s >= l && e <= r) {
    seg[m].val += v;
    if (s != e) {
      lazy[2 * m] += v;
      lazy[2 * m + 1] += v;
    }
    return;
  }
  long long mid = (s + e) / 2;
  update(2 * m, s, mid, l, r, v);
  update(2 * m + 1, mid + 1, e, l, r, v);
  seg[m].val = min(seg[2 * m].val, seg[2 * m + 1].val);
  if (seg[2 * m].val >= seg[2 * m + 1].val)
    seg[m].ind = seg[2 * m + 1].ind;
  else
    seg[m].ind = seg[2 * m].ind;
}
node query(long long m, long long s, long long e, long long l, long long r) {
  if (lazy[m] != 0) {
    seg[m].val = seg[m].val + lazy[m];
    if (s != e) {
      lazy[2 * m] += lazy[m];
      lazy[2 * m + 1] += lazy[m];
    }
    lazy[m] = 0;
  }
  node x, y, t;
  x.ind = -1;
  if (s > e || s > r || e < l) return x;
  if (s >= l && e <= r) {
    return seg[m];
  }
  long long mid = (s + e) / 2;
  x = query(2 * m, s, mid, l, r);
  y = query(2 * m + 1, mid + 1, e, l, r);
  t.val = min(x.val, y.val);
  if (x.val >= y.val) {
    t.ind = y.ind;
  } else {
    t.ind = x.ind;
  }
  return t;
}
int32_t main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  long long n;
  cin >> n;
  for (long long i = 0; i < n; i++) {
    long long x;
    cin >> x;
    a.push_back(x);
  }
  build(1, 0, n - 1);
  vector<long long> ans(n);
  for (long long i = 1; i <= n; i++) {
    node t = query(1, 0, n - 1, 0, n - 1);
    ans[t.ind] = i;
    update(1, 0, n - 1, t.ind, t.ind, (1LL << 61));
    update(1, 0, n - 1, t.ind + 1, n - 1, -i);
  }
  for (long long i = 0; i < n; i++) cout << ans[i] << ' ';
}
