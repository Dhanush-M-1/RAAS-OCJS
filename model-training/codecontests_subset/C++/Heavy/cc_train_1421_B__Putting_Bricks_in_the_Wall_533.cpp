#include <bits/stdc++.h>
using namespace std;
template <typename T1, typename T2>
istream& operator>>(istream& in, pair<T1, T2>& a) {
  in >> a.first >> a.second;
  return in;
}
template <typename T1, typename T2>
ostream& operator<<(ostream& out, pair<T1, T2> a) {
  out << a.first << " " << a.second;
  return out;
}
template <typename T, typename T1>
T amax(T& a, T1 b) {
  if (b > a) a = b;
  return a;
}
template <typename T, typename T1>
T amin(T& a, T1 b) {
  if (b < a) a = b;
  return a;
}
const long long INF = 1e18;
const int32_t M = 1e9 + 7;
const int32_t MM = 998244353;
const long long N = 0;
void solve() {
  long long n;
  cin >> n;
  string s[n];
  for (long long i = 0; i < n; i++) {
    cin >> s[i];
  }
  long long a = s[0][1], b = s[1][0];
  long long c = s[n - 1][n - 2], d = s[n - 2][n - 1];
  vector<pair<long long, long long> > pr;
  if (a == b) {
    if (c == a) pr.push_back({n, n - 1});
    if (d == a) pr.push_back({n - 1, n});
  } else if (c == d) {
    if (a == c) pr.push_back({1, 2});
    if (b == c) pr.push_back({2, 1});
  } else {
    pr.push_back({2, 1});
    if (c == a) pr.push_back({n, n - 1});
    if (d == a) pr.push_back({n - 1, n});
  }
  cout << (long long)((pr).size()) << "\n";
  for (auto x : pr) {
    cout << x << "\n";
  }
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long t = 1;
  cin >> t;
  while (t--) solve();
  return 0;
}
