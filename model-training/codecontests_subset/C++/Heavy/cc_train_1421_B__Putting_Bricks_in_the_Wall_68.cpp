#include <bits/stdc++.h>
using namespace std;
mt19937 rnd(1337);
ostream& operator<<(ostream& a, const pair<long long, long long> b) {
  cout << "{" << b.first << ", " << b.second << "}";
  return a;
}
ostream& operator<<(ostream& a, const vector<long long int>& b) {
  for (auto& k : b) cout << k << " ";
  return a;
}
ostream& operator<<(ostream& a, const vector<pair<long long, long long> >& b) {
  for (auto& k : b) cout << k << " ";
  return a;
}
const long long int INF = (long long int)1e9;
const long long int MOD = 1000 * 1000 * 1000 + 7, MOD2 = 274876858367;
const long long int maxn = (long long int)3e5 + 10, L = 22;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long int T = 1;
  cin >> T;
  while (T--) {
    long long int n;
    cin >> n;
    vector<string> a(n);
    for (long long int i = 0; i < n; ++i) cin >> a[i];
    vector<pair<long long, long long> > ans, res;
    if (a[0][1] != '0') ans.push_back({0, 1});
    if (a[1][0] != '0') ans.push_back({1, 0});
    if (a[2][0] != '1') ans.push_back({2, 0});
    if (a[1][1] != '1') ans.push_back({1, 1});
    if (a[0][2] != '1') ans.push_back({0, 2});
    if (a[0][1] != '1') res.push_back({0, 1});
    if (a[1][0] != '1') res.push_back({1, 0});
    if (a[2][0] != '0') res.push_back({2, 0});
    if (a[1][1] != '0') res.push_back({1, 1});
    if (a[0][2] != '0') res.push_back({0, 2});
    if (ans.size() > res.size()) swap(ans, res);
    cout << ans.size() << '\n';
    for (pair<long long, long long>& x : ans)
      cout << x.first + 1 << " " << x.second + 1 << '\n';
  }
  return 0;
}
