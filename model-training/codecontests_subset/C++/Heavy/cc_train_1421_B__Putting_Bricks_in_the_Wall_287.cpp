#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 40;
vector<int> used(N, 0);
void solve() {
  int n;
  cin >> n;
  char a[n + 2][n + 2];
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      cin >> a[i][j];
    }
  }
  int b1;
  b1 = (a[n - 1][n] == '1') + (a[n][n - 1] == '1');
  int bb1;
  bb1 = (a[n - 2][n] == '0') + (a[n - 1][n - 1] == '0') + (a[n][n - 2] == '0');
  if (5 - (b1 + bb1) <= 2) {
    cout << 5 - ((b1 + bb1)) << '\n';
    if (a[n - 1][n] == '0') {
      cout << n - 1 << " " << n << '\n';
    }
    if (a[n][n - 1] == '0') {
      cout << n << " " << n - 1 << '\n';
    }
    if (a[n - 2][n] == '1') {
      cout << n - 2 << " " << n << '\n';
    }
    if (a[n - 1][n - 1] == '1') {
      cout << n - 1 << " " << n - 1 << '\n';
    }
    if (a[n][n - 2] == '1') {
      cout << n << " " << n - 2 << '\n';
    }
  } else {
    cout << (b1 + bb1) << '\n';
    if (a[n - 1][n] == '1') {
      cout << n - 1 << " " << n << '\n';
    }
    if (a[n][n - 1] == '1') {
      cout << n << " " << n - 1 << '\n';
    }
    if (a[n - 2][n] == '0') {
      cout << n - 2 << " " << n << '\n';
    }
    if (a[n - 1][n - 1] == '0') {
      cout << n - 1 << " " << n - 1 << '\n';
    }
    if (a[n][n - 2] == '0') {
      cout << n << " " << n - 2 << '\n';
    }
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int T;
  cin >> T;
  while (T--) {
    solve();
  }
}
