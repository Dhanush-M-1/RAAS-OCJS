#include <bits/stdc++.h>
using namespace std;
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  long long T = 1;
  cin >> T;
  while (T--) {
    long long n;
    cin >> n;
    char a[n][n];
    for (long long i = 0; i < n; i++)
      for (long long j = 0; j < n; j++) cin >> a[i][j];
    vector<pair<long long, long long> > v;
    if (a[1][0] == '0' && a[0][1] == '0') {
      if (a[n - 1][n - 2] != '1') v.push_back({n - 1, n - 2});
      if (a[n - 2][n - 1] != '1') v.push_back({n - 2, n - 1});
    } else if (a[1][0] == '0' && a[0][1] == '1') {
      if (a[n - 1][n - 2] == '0' && a[n - 2][n - 1] == '0') {
        v.push_back({1, 0});
      } else if (a[n - 1][n - 2] == '1' && a[n - 2][n - 1] == '0') {
        v.push_back({n - 1, n - 2});
        v.push_back({1, 0});
      } else if (a[n - 1][n - 2] == '0' && a[n - 2][n - 1] == '1') {
        v.push_back({n - 2, n - 1});
        v.push_back({1, 0});
      } else {
        v.push_back({0, 1});
      }
    } else if (a[1][0] == '1' && a[0][1] == '1') {
      if (a[n - 1][n - 2] != '0') v.push_back({n - 1, n - 2});
      if (a[n - 2][n - 1] != '0') v.push_back({n - 2, n - 1});
    } else if (a[1][0] == '1' && a[0][1] == '0') {
      if (a[n - 1][n - 2] == '0' && a[n - 2][n - 1] == '0') {
        v.push_back({0, 1});
      } else if (a[n - 1][n - 2] == '1' && a[n - 2][n - 1] == '0') {
        v.push_back({n - 1, n - 2});
        v.push_back({0, 1});
      } else if (a[n - 1][n - 2] == '0' && a[n - 2][n - 1] == '1') {
        v.push_back({n - 2, n - 1});
        v.push_back({0, 1});
      } else {
        v.push_back({1, 0});
      }
    }
    cout << v.size() << "\n";
    for (auto it = (v).begin(); it != (v).end(); it++)
      cout << it->first + 1 << " " << it->second + 1 << "\n";
  }
  return 0;
}
