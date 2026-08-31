#include <bits/stdc++.h>
using namespace std;
const long long N = 200005;
long long n;
pair<long long, long long> x[N];
long long ans;
struct seg {
  long long vals[2 * N];
  long long q(long long l, long long r) {
    long long ret = 0;
    for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
      if (l & 1) ret += vals[l++];
      if (r & 1) ret += vals[--r];
    }
    return ret;
  }
  void inc(long long i, long long v) {
    i += n;
    vals[i] += v;
    while (i > 1) {
      vals[i >> 1] = vals[i] + vals[i ^ 1];
      i >>= 1;
    }
  }
  void print() {
    for (long long i = 1; i < 2 * n; ++i) {
      cerr << vals[i] << ' ';
    }
    cerr << endl;
  }
} sm, ct;
bool compSecond(pair<long long, long long>& a, pair<long long, long long>& b) {
  if (a.second != b.second) return a.second < b.second;
  return a.first < b.first;
}
void doMapping() {
  sort(x, x + n, compSecond);
  for (long long i = 0; i < n; ++i) {
    x[i].second = i;
  }
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n;
  for (long long i = 0; i < n; ++i) {
    cin >> x[i].first;
  }
  for (long long i = 0; i < n; ++i) {
    cin >> x[i].second;
  }
  doMapping();
  sort(x, x + n);
  for (long long i = 0; i < n; ++i) {
    long long pt = x[i].first;
    long long cur = x[i].second;
    long long cur_sum = sm.q(0, cur), cur_ct = ct.q(0, cur);
    ans += pt * cur_ct - cur_sum;
    sm.inc(cur, pt);
    ct.inc(cur, 1);
  }
  cout << ans << '\n';
  return 0;
}
