#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    char a[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        cin >> a[i][j];
      }
    }
    vector<pair<long long int, long long int>> ans;
    if (a[n - 1][n - 2] == a[n - 2][n - 1]) {
      if (a[n - 1][n - 2] == '0') {
        if (a[0][1] == '0') {
          ans.push_back({1, 2});
        }
        if (a[1][0] == '0') {
          ans.push_back({2, 1});
        }
      } else {
        if (a[0][1] == '1') {
          ans.push_back({1, 2});
        }
        if (a[1][0] == '1') {
          ans.push_back({2, 1});
        }
      }
    } else {
      if (a[1][0] == '0' && a[0][1] == '0') {
        if (a[n - 1][n - 2] == '0') {
          ans.push_back({n, n - 1});
        }
        if (a[n - 2][n - 1] == '0') {
          ans.push_back({n - 1, n});
        }
      } else if (a[1][0] == '1' && a[0][1] == '1') {
        if (a[n - 1][n - 2] == '1') {
          ans.push_back({n, n - 1});
        }
        if (a[n - 2][n - 1] == '1') {
          ans.push_back({n - 1, n});
        }
      } else if (a[n - 1][n - 2] == '1') {
        ans.push_back({n, n - 1});
        if (a[0][1] == '0') {
          ans.push_back({1, 2});
        }
        if (a[1][0] == '0') {
          ans.push_back({2, 1});
        }
      } else {
        ans.push_back({n, n - 1});
        if (a[0][1] == '1') {
          ans.push_back({1, 2});
        }
        if (a[1][0] == '1') {
          ans.push_back({2, 1});
        }
      }
    }
    cout << ((int)(ans).size()) << "\n";
    for (auto it : ans) {
      cout << it.first << " " << it.second << "\n";
    }
  }
}
