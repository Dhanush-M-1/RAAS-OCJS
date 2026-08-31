#include <bits/stdc++.h>
using namespace std;
#pragma GCC target("avx2")
#pragma GCC optimization("O3")
#pragma GCC optimization("unroll-loops")
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  ;
  int t = 1;
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
    int cnt = 0;
    int c = 0;
    vector<pair<int, int>> v;
    int ans = 0;
    if (a[0][1] == '1') {
      cnt++;
    }
    if (a[1][0] == '1') {
      cnt++;
    }
    if (a[n - 1][n - 2] == '1') {
      c++;
    }
    if (a[n - 2][n - 1] == '1') {
      c++;
    }
    if (cnt == 2) {
      if (a[n - 2][n - 1] == '1') {
        v.push_back({n - 1, n});
        ans++;
      }
      if (a[n - 1][n - 2] == '1') {
        v.push_back({n, n - 1});
        ans++;
      }
    } else if (c == 2) {
      if (a[1][0] == '1') {
        v.push_back({2, 1});
        ans++;
      }
      if (a[0][1] == '1') {
        v.push_back({1, 2});
        ans++;
      }
    } else if (cnt == 0) {
      if (a[n - 2][n - 1] == '0') {
        v.push_back({n - 1, n});
        ans++;
      }
      if (a[n - 1][n - 2] == '0') {
        v.push_back({n, n - 1});
        ans++;
      }
    } else if (c == 0) {
      if (a[1][0] == '0') {
        v.push_back({2, 1});
        ans++;
      }
      if (a[0][1] == '0') {
        v.push_back({1, 2});
        ans++;
      }
    } else if (cnt == 1 && c == 1) {
      if (a[1][0] == '1') {
        v.push_back({2, 1});
        ans++;
      }
      if (a[0][1] == '1') {
        v.push_back({1, 2});
        ans++;
      }
      if (a[n - 2][n - 1] == '0') {
        v.push_back({n - 1, n});
        ans++;
      }
      if (a[n - 1][n - 2] == '0') {
        v.push_back({n, n - 1});
        ans++;
      }
    }
    cout << ans << "\n";
    for (auto u : v) {
      cout << u.first << " " << u.second << "\n";
    }
  }
}
