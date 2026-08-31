#include <bits/stdc++.h>
using namespace std;
void solve() {
  long long int n;
  cin >> n;
  char m[n][n];
  for (long long int i = (0); i < (n); i++) {
    for (long long int j = (0); j < (n); j++) cin >> m[i][j];
  }
  if (m[0][1] == '0' and m[1][0] == '0') {
    if (m[n - 2][n - 1] == '0' and m[n - 1][n - 2] == '0') {
      cout << '2' << '\n';
      cout << n - 1 << " " << n << '\n';
      cout << n << " " << n - 1 << '\n';
    } else if (m[n - 2][n - 1] == '1' and m[n - 1][n - 2] == '1') {
      cout << "0" << '\n';
    } else if (m[n - 2][n - 1] == '1' and m[n - 1][n - 2] == '0') {
      cout << "1" << '\n';
      cout << n << " " << n - 1 << '\n';
    } else {
      cout << "1" << '\n';
      cout << n - 1 << " " << n << '\n';
    }
  }
  if (m[0][1] == '1' and m[1][0] == '1') {
    if (m[n - 2][n - 1] == '1' and m[n - 1][n - 2] == '1') {
      cout << '2' << '\n';
      cout << n - 1 << " " << n << '\n';
      cout << n << " " << n - 1 << '\n';
    } else if (m[n - 2][n - 1] == '0' and m[n - 1][n - 2] == '0') {
      cout << "0" << '\n';
    } else if (m[n - 2][n - 1] == '1' and m[n - 1][n - 2] == '0') {
      cout << "1" << '\n';
      cout << n - 1 << " " << n << '\n';
    } else {
      cout << "1" << '\n';
      cout << n << " " << n - 1 << '\n';
    }
  }
  if (m[0][1] == '1' and m[1][0] == '0') {
    if (m[n - 2][n - 1] == '1' and m[n - 1][n - 2] == '1') {
      cout << "1" << '\n';
      cout << 1 << " " << 2 << '\n';
    } else if (m[n - 2][n - 1] == '0' and m[n - 1][n - 2] == '0') {
      cout << 1 << '\n';
      cout << 2 << " " << 1 << '\n';
    } else if (m[n - 2][n - 1] == '1' and m[n - 1][n - 2] == '0') {
      cout << "2" << '\n';
      cout << 1 << " " << 2 << '\n';
      cout << n << " " << n - 1 << '\n';
    } else {
      cout << "2" << '\n';
      cout << 1 << " " << 2 << '\n';
      cout << n - 1 << " " << n << '\n';
    }
  }
  if (m[0][1] == '0' and m[1][0] == '1') {
    if (m[n - 2][n - 1] == '1' and m[n - 1][n - 2] == '1') {
      cout << "1" << '\n';
      cout << 2 << " " << 1 << '\n';
    } else if (m[n - 2][n - 1] == '0' and m[n - 1][n - 2] == '0') {
      cout << 1 << '\n';
      cout << 1 << " " << 2 << '\n';
    } else if (m[n - 2][n - 1] == '1' and m[n - 1][n - 2] == '0') {
      cout << "2" << '\n';
      cout << 2 << " " << 1 << '\n';
      cout << n << " " << n - 1 << '\n';
    } else {
      cout << "2" << '\n';
      cout << 2 << " " << 1 << '\n';
      cout << n - 1 << " " << n << '\n';
    }
  }
}
clock_t startTime;
double getCurrentTime() {
  return (double)(clock() - startTime) / CLOCKS_PER_SEC;
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long int T;
  cin >> T;
  while (T--) {
    solve();
  }
  return 0;
}
