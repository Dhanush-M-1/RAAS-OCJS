#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    char arr[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) cin >> arr[i][j];
    }
    vector<pair<int, int>> ans;
    int a, b, c, d;
    a = (int)arr[0][1] - '0';
    b = (int)arr[1][0] - '0';
    c = (int)arr[n - 2][n - 1] - '0';
    d = (int)arr[n - 1][n - 2] - '0';
    int sum = 0;
    sum += (a != 0) + (b != 0) + (c != 1) + (d != 1);
    if (sum <= 2) {
      if (a != 0) ans.push_back({1, 2});
      if (b != 0) ans.push_back({2, 1});
      if (c != 1) ans.push_back({n - 1, n});
      if (d != 1) ans.push_back({n, n - 1});
    } else {
      if (a != 1) ans.push_back({1, 2});
      if (b != 1) ans.push_back({2, 1});
      if (c != 0) ans.push_back({n - 1, n});
      if (d != 0) ans.push_back({n, n - 1});
    }
    cout << ans.size() << "\n";
    for (auto x : ans) cout << x.first << " " << x.second << "\n";
  }
  return 0;
}
