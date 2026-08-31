#include <bits/stdc++.h>
using namespace std;
int myXOR(long long int x, long long int y) { return (x | y) & (~x | ~y); }
int main() {
  int tt = 1;
  cin >> tt;
  while (tt--) {
    long long int n, i, j;
    cin >> n;
    char a[n][n];
    for (i = 0; i < n; i++) {
      for (j = 0; j < n; j++) cin >> a[i][j];
    }
    long long int ans = 0;
    if (a[0][1] == a[1][0] && a[n - 1][n - 2] == a[n - 2][n - 1]) {
      if (a[0][1] == a[n - 1][n - 2]) {
        cout << 2 << "\n";
        cout << 1 << " " << 2 << "\n";
        cout << 2 << " " << 1 << "\n";
      } else
        cout << 0 << "\n";
    } else {
      vector<pair<long long int, long long int> > v;
      long long int f = 0;
      char ch;
      if (a[0][1] == a[1][0]) {
        f = 1;
        ch = a[0][1];
      }
      if (a[n - 1][n - 2] == a[n - 2][n - 1]) {
        f = 2;
        ch = a[n - 1][n - 2];
      }
      if (f == 0) {
        if (a[0][1] != '1') {
          ans++;
          v.push_back({1, 2});
        } else if (a[1][0] != '1') {
          ans++;
          v.push_back({2, 1});
        }
        if (a[n - 1][n - 2] != '0') {
          ans++;
          v.push_back({n, n - 1});
        } else if (a[n - 2][n - 1] != '0') {
          ans++;
          v.push_back({n - 1, n});
        }
        cout << ans << "\n";
        for (i = 0; i < ans; i++) {
          cout << v[i].first << " " << v[i].second << "\n";
        }
      }
      if (f == 1) {
        if (a[n - 2][n - 1] == ch) {
          ans++;
          v.push_back({n - 1, n});
        } else if (a[n - 1][n - 2] == ch) {
          ans++;
          v.push_back({n, n - 1});
        }
        cout << ans << "\n";
        for (i = 0; i < ans; i++) {
          cout << v[i].first << " " << v[i].second << "\n";
        }
      }
      if (f == 2) {
        if (a[0][1] == ch) {
          ans++;
          v.push_back({1, 2});
        } else if (a[1][0] == ch) {
          ans++;
          v.push_back({2, 1});
        }
        cout << ans << "\n";
        for (i = 0; i < ans; i++) {
          cout << v[i].first << " " << v[i].second << "\n";
        }
      }
    }
    cout << "\n";
  }
}
