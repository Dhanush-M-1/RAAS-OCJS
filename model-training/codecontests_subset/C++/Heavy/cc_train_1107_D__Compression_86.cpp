#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout << fixed << setprecision(15);
  int n;
  cin >> n;
  int m = n / 4;
  vector<vector<int> > a(n, vector<int>(m));
  vector<vector<int> > c(n, vector<int>(m));
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      char c;
      cin >> c;
      a[i][j] = isdigit(c) ? c - '0' : c - 'A' + 10;
    }
  }
  for (int i = 0; i + 4 <= n; i++) {
    vector<vector<int> > b(4, vector<int>(n));
    for (int j = i; j < i + 4; j++) {
      for (int k = 0; k < m; k++) {
        int tmp = a[j][k];
        for (int t = 3; t >= 0; t--) {
          b[j - i][k * 4 + t] = tmp % 2;
          tmp /= 2;
        }
      }
    }
    for (int k = 0; k < n; k++) {
      int tmp = 0;
      for (int j = 0; j < 4; j++) {
        tmp = tmp * 2 + b[j][k];
      }
      c[k][i / 4] = tmp;
    }
  }
  auto compression = [&](int x) {
    for (int i = 0; i + x <= n; i += x) {
      vector<int> b = a[i];
      for (int j = i; j < i + x; j++) {
        for (int k = 0; k < m; k++) {
          b[k] &= a[j][k];
        }
      }
      for (int j = i; j < i + x; j++) {
        for (int k = 0; k < m; k++) {
          if (b[k] != a[j][k]) return false;
        }
      }
    }
    for (int i = 0; i + x <= n; i += x) {
      vector<int> b = c[i];
      for (int j = i; j < i + x; j++) {
        for (int k = 0; k < m; k++) {
          b[k] &= c[j][k];
        }
      }
      for (int j = i; j < i + x; j++) {
        for (int k = 0; k < m; k++) {
          if (b[k] != c[j][k]) return false;
        }
      }
    }
    return true;
  };
  int ans = 1;
  for (int x = 1; x * x <= n; x++) {
    if (n % x) continue;
    if (compression(x)) {
      ans = max(ans, x);
    }
    if (x * x != n && compression(n / x)) {
      ans = max(ans, n / x);
    }
  }
  cout << ans << '\n';
  return 0;
}
