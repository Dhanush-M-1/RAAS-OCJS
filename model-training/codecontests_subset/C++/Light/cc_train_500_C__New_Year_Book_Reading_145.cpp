#include <bits/stdc++.h>
const long long inf = 1000000000;
const long long inf64 = inf * inf;
const long long base = inf / 10ll;
const double pi = acos(-1.0);
using namespace std;
int Abs(int x) { return (x >= 0 ? x : -x); }
bool solve() {
  int n, m;
  cin >> n >> m;
  vector<int> w(n), b(m);
  set<int> s;
  for (int i(0); i < n; i++) cin >> w[i];
  for (int i(0); i < m; i++) cin >> b[i];
  vector<long long> dp(m);
  for (int i(1); i < m; i++) {
    long long tmp = 0;
    s.clear();
    for (int j(i - 1); j >= 0; j--) {
      if (b[j] == b[i]) break;
      s.insert(b[j]);
    }
    for (set<int>::iterator j = s.begin(); j != s.end(); j++) tmp += w[*j - 1];
    dp[i] = dp[i - 1] + tmp;
  }
  cout << dp[m - 1] << '\n';
  return true;
}
int main() {
  solve();
  return 0;
}
