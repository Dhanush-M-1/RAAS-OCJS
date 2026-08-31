#include <bits/stdc++.h>
using namespace std;
const long long MOD = 1e9 + 7;
const long long INF = 1e18;
const long long MAX = 100100;
void pre() {}
void solve() {
  long long n;
  cin >> n;
  vector<string> v(n);
  for (long long i = 0; i < n; ++i) cin >> v[i];
  vector<pair<long long, long long> > rm;
  long long up = 0, dn = 0;
  if (v[0][1] == '1') up++;
  if (v[1][0] == '1') up++;
  if (v[n - 1][n - 2] == '1') dn++;
  if (v[n - 2][n - 1] == '1') dn++;
  if (up == 0) {
    if (v[n - 1][n - 2] != '1') rm.push_back({n - 1, n - 2});
    if (v[n - 2][n - 1] != '1') rm.push_back({n - 2, n - 1});
  } else if (dn == 0) {
    if (v[1][0] != '1') rm.push_back({1, 0});
    if (v[0][1] != '1') rm.push_back({0, 1});
  } else if (up + dn == 4) {
    rm.push_back({1, 0});
    rm.push_back({0, 1});
  } else if (up + dn == 0) {
    rm.push_back({1, 0});
    rm.push_back({0, 1});
  } else if (up == 1 && dn == 1) {
    if (v[n - 1][n - 2] != '1') rm.push_back({n - 1, n - 2});
    if (v[n - 2][n - 1] != '1') rm.push_back({n - 2, n - 1});
    if (v[1][0] != '0') rm.push_back({1, 0});
    if (v[0][1] != '0') rm.push_back({0, 1});
  } else if (up == 2) {
    if (v[n - 1][n - 2] != '0') rm.push_back({n - 1, n - 2});
    if (v[n - 2][n - 1] != '0') rm.push_back({n - 2, n - 1});
  } else if (dn == 2) {
    if (v[1][0] != '0') rm.push_back({1, 0});
    if (v[0][1] != '0') rm.push_back({0, 1});
  }
  cout << ((long long)(rm).size()) << "\n";
  for (auto p : rm) cout << p.first + 1 << " " << p.second + 1 << "\n";
}
signed main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  pre();
  long long t = 1;
  cin >> t;
  for (long long CASE = 1; CASE <= t; ++CASE) {
    solve();
  }
  {};
  return 0;
}
