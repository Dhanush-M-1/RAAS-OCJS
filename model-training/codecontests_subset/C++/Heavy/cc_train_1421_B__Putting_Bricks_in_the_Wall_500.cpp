#include <bits/stdc++.h>
using namespace std;
int solve() {
  int n;
  cin >> n;
  vector<vector<char>> gr(n, vector<char>(n));
  vector<vector<int>> g(n, vector<int>(n));
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      cin >> gr[i][j];
    }
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if ((i == 0 && j == 0) || (i == n - 1 && j == n - 1))
        g[i][j] = 2;
      else
        g[i][j] = gr[i][j] - '0';
    }
  }
  if (g[0][1] == 0 && g[1][0] == 1) {
    if (g[n - 1][n - 2] == 1 && g[n - 2][n - 1] == 1) {
      cout << "1" << endl;
      cout << "2 1" << endl;
    } else if (g[n - 1][n - 2] == 1 && g[n - 2][n - 1] == 0) {
      cout << "2" << endl;
      cout << "2 1" << endl;
      cout << n - 1 << " " << n << endl;
    } else if (g[n - 1][n - 2] == 0 && g[n - 2][n - 1] == 1) {
      cout << "2" << endl;
      cout << "2 1" << endl;
      cout << n << " " << n - 1 << endl;
    } else {
      cout << "1" << endl;
      cout << "1 2" << endl;
    }
  } else if (g[0][1] == 1 && g[1][0] == 1) {
    if (g[n - 1][n - 2] == 1 && g[n - 2][n - 1] == 1) {
      cout << "2" << endl;
      cout << n - 1 << " " << n << endl;
      cout << n << " " << n - 1 << endl;
    } else if (g[n - 1][n - 2] == 1 && g[n - 2][n - 1] == 0) {
      cout << "1" << endl;
      cout << n << " " << n - 1 << endl;
    } else if (g[n - 1][n - 2] == 0 && g[n - 2][n - 1] == 1) {
      cout << "1" << endl;
      cout << n - 1 << " " << n << endl;
    } else {
      cout << "0" << endl;
    }
  } else if (g[0][1] == 1 && g[1][0] == 0) {
    if (g[n - 1][n - 2] == 1 && g[n - 2][n - 1] == 1) {
      cout << "1" << endl;
      cout << "1 2" << endl;
    } else if (g[n - 1][n - 2] == 1 && g[n - 2][n - 1] == 0) {
      cout << "2" << endl;
      cout << "2 1" << endl;
      cout << n << " " << n - 1 << endl;
    } else if (g[n - 1][n - 2] == 0 && g[n - 2][n - 1] == 1) {
      cout << "2" << endl;
      cout << "2 1" << endl;
      cout << n - 1 << " " << n << endl;
    } else {
      cout << "1" << endl;
      cout << "2 1" << endl;
    }
  } else {
    if (g[n - 1][n - 2] == 1 && g[n - 2][n - 1] == 1) {
      cout << "0" << endl;
    } else if (g[n - 1][n - 2] == 1 && g[n - 2][n - 1] == 0) {
      cout << "1" << endl;
      cout << n - 1 << " " << n << endl;
    } else if (g[n - 1][n - 2] == 0 && g[n - 2][n - 1] == 1) {
      cout << "1" << endl;
      cout << n << " " << n - 1 << endl;
    } else {
      cout << "2" << endl;
      cout << n - 1 << " " << n << endl;
      cout << n << " " << n - 1 << endl;
    }
  }
  return 0;
}
int main() {
  int t;
  cin >> t;
  while (t--) {
    solve();
  }
  return 0;
}
