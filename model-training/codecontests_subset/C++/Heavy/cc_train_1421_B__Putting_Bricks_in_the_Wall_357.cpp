#include <bits/stdc++.h>
using namespace std;
long long maxi = LLONG_MAX;
long long mini = LLONG_MIN;
void fast() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
}
int main() {
  fast();
  long long t;
  cin >> t;
  while (t--) {
    long long n;
    cin >> n;
    char a[n][n];
    for (long long i = 0; i < n; i++) {
      for (long long j = 0; j < n; j++) {
        cin >> a[i][j];
      }
    }
    vector<pair<long long, long long> > ans;
    if (a[0][1] + a[1][0] == '0' + '0') {
      if (a[n - 1][n - 2] == '0') ans.push_back({n, n - 1});
      if (a[n - 2][n - 1] == '0') ans.push_back({n - 1, n});
    } else if (a[0][1] + a[1][0] == '1' + '1') {
      if (a[n - 1][n - 2] == '1') ans.push_back({n, n - 1});
      if (a[n - 2][n - 1] == '1') ans.push_back({n - 1, n});
    } else if (a[n - 1][n - 2] + a[n - 2][n - 1] == '1' + '1') {
      if (a[0][1] == '1') ans.push_back({1, 2});
      if (a[1][0] == '1') ans.push_back({2, 1});
    } else if (a[n - 1][n - 2] + a[n - 2][n - 1] == '0' + '0') {
      if (a[0][1] == '0') ans.push_back({1, 2});
      if (a[1][0] == '0') ans.push_back({2, 1});
    } else if ((a[0][1] + a[1][0] == '1' + '0') &&
               (a[n - 1][n - 2] + a[n - 2][n - 1] == '1' + '0')) {
      if (a[n - 1][n - 2] == '0') ans.push_back({n, n - 1});
      if (a[n - 2][n - 1] == '0') ans.push_back({n - 1, n});
      if (a[0][1] == '1') ans.push_back({1, 2});
      if (a[1][0] == '1') ans.push_back({2, 1});
    }
    cout << ans.size() << endl;
    for (auto p : ans) {
      cout << p.first << ' ' << p.second << "\n";
      ;
    }
  }
  return 0;
}
