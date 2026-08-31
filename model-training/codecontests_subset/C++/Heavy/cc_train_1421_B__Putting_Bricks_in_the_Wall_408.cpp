#include <bits/stdc++.h>
using namespace std;
const int MOD = 1000000007;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    char fi[n][n];
    for (int i = 0; i < (n); ++i) {
      for (int j = 0; j < (n); ++j) {
        cin >> fi[i][j];
      }
    }
    int a = fi[0][1] - '0';
    int b = fi[1][0] - '0';
    int c = fi[n - 2][n - 1] - '0';
    int d = fi[n - 1][n - 2] - '0';
    if (a == 0 && b == 0 && c == 0 && d == 0) {
      cout << 2 << endl;
      cout << 1 << " " << 2 << endl;
      cout << 2 << " " << 1 << endl;
    } else if (a == 0 && b == 0 && c == 0 && d == 1) {
      cout << 1 << endl;
      cout << n - 1 << " " << n << endl;
    } else if (a == 0 && b == 0 && c == 1 && d == 0) {
      cout << 1 << endl;
      cout << n << " " << n - 1 << endl;
    } else if (a == 0 && b == 0 && c == 1 && d == 1) {
      cout << 0 << endl;
    } else if (a == 0 && b == 1 && c == 0 && d == 0) {
      cout << 1 << endl;
      cout << 1 << " " << 2 << endl;
    } else if (a == 0 && b == 1 && c == 0 && d == 1) {
      cout << 2 << endl;
      cout << 1 << " " << 2 << endl;
      cout << n << " " << n - 1 << endl;
    } else if (a == 0 && b == 1 && c == 1 && d == 0) {
      cout << 2 << endl;
      cout << 1 << " " << 2 << endl;
      cout << n - 1 << " " << n << endl;
    } else if (a == 0 && b == 1 && c == 1 && d == 1) {
      cout << 1 << endl;
      cout << 2 << " " << 1 << endl;
    } else if (a == 1 && b == 0 && c == 0 && d == 0) {
      cout << 1 << endl;
      cout << 2 << " " << 1 << endl;
    } else if (a == 1 && b == 0 && c == 0 && d == 1) {
      cout << 2 << endl;
      cout << 2 << " " << 1 << endl;
      cout << n << " " << n - 1 << endl;
    } else if (a == 1 && b == 0 && c == 1 && d == 0) {
      cout << 2 << endl;
      cout << 2 << " " << 1 << endl;
      cout << n - 1 << " " << n << endl;
    } else if (a == 1 && b == 0 && c == 1 && d == 1) {
      cout << 1 << endl;
      cout << 1 << " " << 2 << endl;
    } else if (a == 1 && b == 1 && c == 0 && d == 0) {
      cout << 0 << endl;
    } else if (a == 1 && b == 1 && c == 0 && d == 1) {
      cout << 1 << endl;
      cout << n << " " << n - 1 << endl;
    } else if (a == 1 && b == 1 && c == 1 && d == 0) {
      cout << 1 << endl;
      cout << n - 1 << " " << n << endl;
    } else if (a == 1 && b == 1 && c == 1 && d == 1) {
      cout << 2 << endl;
      cout << n - 1 << " " << n << endl;
      cout << n << " " << n - 1 << endl;
    }
  }
}
