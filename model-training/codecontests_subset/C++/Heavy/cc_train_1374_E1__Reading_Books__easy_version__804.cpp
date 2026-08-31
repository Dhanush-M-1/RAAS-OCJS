#include <bits/stdc++.h>
using namespace std;
const long long int mod = 1e9 + 7;
const long long int inf = 2e9 + 5;
double PI = 3.14159265358979323846;
void solve() {
  long long int n, k;
  cin >> n >> k;
  vector<long long int> books[2][2];
  for (int i = 0; i < n; i++) {
    long long int t, a, b;
    cin >> t >> a >> b;
    books[a][b].push_back(t);
  }
  for (int i = 0; i < 2; i++) {
    for (int j = 0; j < 2; j++) {
      sort((books[i][j]).begin(), (books[i][j]).end());
    }
  }
  vector<vector<long long int> > pre(4);
  pre[0].push_back(0);
  pre[1].push_back(0);
  pre[2].push_back(0);
  pre[3].push_back(0);
  for (auto x : books[0][1]) {
    pre[1].push_back(pre[1].back() + x);
  }
  for (auto x : books[1][0]) {
    pre[2].push_back(pre[2].back() + x);
  }
  for (auto x : books[1][1]) {
    pre[3].push_back(pre[3].back() + x);
  }
  long long int ans = inf;
  for (long long int i = 0; i <= min(k, (long long int)pre[3].size() - 1);
       i++) {
    long long int remain = k - i;
    if ((int)pre[1].size() > remain and (int) pre[2].size() > remain) {
      long long int cur = pre[3][i] + pre[1][remain] + pre[2][remain];
      ans = min(ans, cur);
    }
  }
  if (ans == inf) {
    cout << -1 << "\n";
  } else {
    cout << ans << "\n";
  }
}
int32_t main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  solve();
  return 0;
}
