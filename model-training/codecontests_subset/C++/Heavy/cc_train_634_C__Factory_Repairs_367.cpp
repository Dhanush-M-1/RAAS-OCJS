#include <bits/stdc++.h>
using namespace std;
long long power(long long x, long long y);
bool isPrime(long long n);
long long modInv(long long a, long long b);
long long gcdExtended(long long a, long long b, long long *x, long long *y);
long long mpower(long long a, long long b, long long p);
bool sorted(vector<long long> v, long long n, long long strict);
const long long inf = (long long)1e17;
const long long N = (long long)3e6 + 5;
long long n, k, q, a, b;
pair<long long, long long> tree[N];
void update(long long ss, long long se, long long idx, long long val,
            long long i) {
  if (ss == se) {
    tree[i].first += val;
    tree[i].second += val;
    tree[i].first = min(a, tree[i].first);
    tree[i].second = min(b, tree[i].second);
    return;
  }
  long long mid = (ss + se) >> 1;
  if (idx <= mid)
    update(ss, mid, idx, val, 2 * i);
  else
    update(mid + 1, se, idx, val, 2 * i + 1);
  tree[i].first = tree[2 * i].first + tree[2 * i + 1].first;
  tree[i].second = tree[2 * i].second + tree[2 * i + 1].second;
}
pair<long long, long long> query(long long ss, long long se, long long l,
                                 long long r, long long i) {
  if (l > r) return make_pair(0, 0);
  if (l > se || r < ss) return make_pair(0, 0);
  if (l <= ss && r >= se) return tree[i];
  long long mid = (ss + se) >> 1;
  pair<long long, long long> left = query(ss, mid, l, r, 2 * i);
  pair<long long, long long> right = query(mid + 1, se, l, r, 2 * i + 1);
  pair<long long, long long> ret;
  ret.first = left.first + right.first;
  ret.second = right.second + left.second;
  return ret;
}
void solve() {
  cin >> n >> k >> a >> b >> q;
  for (long long i = 0; i < q; i++) {
    long long t;
    cin >> t;
    if (t == 1) {
      long long x, y;
      cin >> x >> y;
      update(1, n, x, y, 1);
    } else {
      long long d;
      cin >> d;
      pair<long long, long long> beg = query(1, n, 1, d - 1, 1);
      pair<long long, long long> end = query(1, n, d + k, n, 1);
      cout << beg.second + end.first << "\n";
    }
  }
}
int32_t main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  clock_t start, end;
  start = clock();
  solve();
  end = clock();
  double time_taken = double(end - start) / (double)CLOCKS_PER_SEC;
  return 0;
}
long long modInv(long long a, long long m) {
  long long x, y;
  long long g = gcdExtended(a, m, &x, &y);
  long long res = (x % m + m) % m;
  return res;
}
long long gcdExtended(long long a, long long b, long long *x, long long *y) {
  if (a == 0) {
    *x = 0, *y = 1;
    return b;
  }
  long long x1, y1;
  long long gcd = gcdExtended(b % a, a, &x1, &y1);
  *x = y1 - (b / a) * x1;
  *y = x1;
  return gcd;
}
long long mpower(long long x, long long y, long long p) {
  long long res = 1;
  x = x % p;
  while (y > 0) {
    if (y & 1) res = (res * x) % p;
    y = y >> 1;
    x = (x * x) % p;
  }
  return res;
}
long long power(long long x, long long y) {
  long long res = 1;
  while (y > 0) {
    if (y & 1) res = res * x;
    y = y >> 1;
    x = x * x;
  }
  return res;
}
bool isPrime(long long n) {
  if (n <= 1) return false;
  if (n <= 3) return true;
  if (n % 2 == 0 || n % 3 == 0) return false;
  long long p = sqrt(n);
  for (long long i = 5; i <= p; i = i + 6)
    if (n % i == 0 || n % (i + 2) == 0) return false;
  return true;
}
bool sorted(vector<long long> v, long long n, long long strict) {
  if (n <= 1) return 1;
  for (long long i = 1; i < n; i++) {
    if (strict) {
      if (v[i] <= v[i - 1]) return 0;
    } else {
      if (v[i] < v[i - 1]) return 0;
    }
  }
  return 1;
}
