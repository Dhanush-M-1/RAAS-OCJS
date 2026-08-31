#include <bits/stdc++.h>
#pragma GCC optimize "trapv"
using namespace std;
const int N = 1e5 + 5;
const unsigned int M = 1000000007;
long long a[N], b[N];
char invert(char x) {
  if (x == '0')
    return '1';
  else
    return '0';
}
void solve() {
  int n;
  cin >> n;
  char a[n][n];
  vector<pair<int, int>> ans;
  for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++) cin >> a[i][j];
  if (a[0][1] == a[1][0]) {
    if (a[n - 1][n - 2] == a[0][1]) {
      a[n - 1][n - 2] = invert(a[n - 1][n - 2]);
      ans.push_back(make_pair(n, n - 1));
    }
    if (a[n - 2][n - 1] == a[0][1]) {
      a[n - 2][n - 1] = invert(a[n - 2][n - 1]);
      ans.push_back(make_pair(n - 1, n));
    }
  } else {
    if (a[n - 1][n - 2] == a[n - 2][n - 1]) {
      if (a[0][1] == a[n - 1][n - 2])
        ans.push_back(make_pair(1, 2));
      else
        ans.push_back(make_pair(2, 1));
    } else {
      if (a[0][1] != a[n - 1][n - 2]) {
        ans.push_back(make_pair(1, 2));
        ans.push_back(make_pair(n, n - 1));
      } else {
        ans.push_back(make_pair(1, 2));
        ans.push_back(make_pair(n - 1, n));
      }
    }
  }
  cout << ans.size() << "\n";
  for (int i = 0; i < ans.size(); i++) {
    cout << ans[i].first << ' ' << ans[i].second << "\n";
  }
}
int32_t main() {
  ;
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  int t;
  cin >> t;
  while (t--) {
    solve();
  }
  return 0;
}
