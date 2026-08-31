#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  long long t;
  cin >> t;
  while (t--) {
    long long n;
    cin >> n;
    char a[n + 1][n + 1];
    for (long long i = 1; i <= n; i++) {
      for (long long j = 1; j <= n; j++) {
        cin >> a[i][j];
      }
    }
    vector<pair<long long, long long>> v;
    long long z = 0, c = 0;
    if (a[1][2] == '0') z++;
    if (a[2][1] == '0') z++;
    if (a[n - 1][n] == '0') c++;
    if (a[n][n - 1] == '0') c++;
    if ((z == 2 && c == 0) || (z == 0 && c == 2))
      cout << 0 << "\n";
    else {
      if (z == 0) {
        if (a[n][n - 1] == '1') v.push_back(make_pair(n, n - 1));
        if (a[n - 1][n] == '1') v.push_back(make_pair(n - 1, n));
      } else if (z == 1) {
        if (c == 2) {
          if (a[1][2] == '0') v.push_back(make_pair(1, 2));
          if (a[2][1] == '0') v.push_back(make_pair(2, 1));
        } else {
          if (a[n][n - 1] == '0') v.push_back(make_pair(n, n - 1));
          if (a[n - 1][n] == '0') v.push_back(make_pair(n - 1, n));
          if (a[1][2] == '1') v.push_back(make_pair(1, 2));
          if (a[2][1] == '1') v.push_back(make_pair(2, 1));
        }
      } else if (z == 2) {
        if (a[n][n - 1] == '0') v.push_back(make_pair(n, n - 1));
        if (a[n - 1][n] == '0') v.push_back(make_pair(n - 1, n));
      }
      cout << v.size() << "\n";
      for (long long i = 0; i < v.size(); i++) {
        cout << v[i].first << " " << v[i].second << "\n";
      }
    }
  }
  return 0;
}
