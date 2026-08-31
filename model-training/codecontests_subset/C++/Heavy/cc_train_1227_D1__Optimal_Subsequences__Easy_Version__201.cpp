#include <bits/stdc++.h>
using namespace std;
const long long mod = 1000000007;
const long long inf = LLONG_MAX - 100000;
void IO() {
  ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  cout.setf(ios::fixed);
}
long long pw(long long x, long long y, long long p = inf) {
  long long res = 1;
  x = x % p;
  if (x == 0) return 0;
  while (y > 0) {
    if (y & 1) res = (res * x) % p;
    y = y >> 1;
    x = (x * x) % p;
  }
  return res;
}
long long invmod(long long a, long long m = mod) { return pw(a, m - 2, m); }
long long cl(long long a, long long x) {
  return a % x == 0 ? a / x : a / x + 1;
}
void run_time_terror(long long case_no = 0) {
  long long n, x;
  cin >> n;
  set<pair<long long, long long> > s;
  for (long long i = 0; i < n; ++i) {
    cin >> x;
    s.insert({-x, i});
  }
  long long q;
  cin >> q;
  while (q--) {
    long long sz, k;
    cin >> sz >> k;
    vector<pair<long long, long long> > seq;
    for (auto &it : s) {
      if (seq.size() >= sz) break;
      seq.push_back({it.second, -it.first});
    }
    sort(seq.begin(), seq.end());
    k--;
    cout << seq[k].second << "\n";
  }
}
int32_t main() {
  cout << setprecision(0);
  IO();
  long long tt = 1;
  for (long long case_no = 1; case_no <= tt; case_no++) {
    run_time_terror(case_no);
  }
  return 0;
}
