#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n;
  scanf("%d", &n);
  char ch[n + 1][n + 1], a, b, c, d, x;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; ++j) cin >> ch[i][j];
  }
  a = ch[0][1];
  b = ch[1][0];
  c = ch[n - 1][n - 2];
  d = ch[n - 2][n - 1];
  if (a == b && c != d) {
    cout << 1 << "\n";
    if (a == c) {
      cout << n << " " << n - 1 << "\n";
    } else {
      cout << n - 1 << " " << n << "\n";
    }
  } else if (a == b and c == d) {
    if (a == c) {
      cout << 2 << "\n";
      cout << 1 << " " << 2 << "\n";
      cout << 2 << " " << 1 << "\n";
    } else
      cout << 0 << "\n";
  } else if (c == d and a != b) {
    cout << 1 << "\n";
    if (a == c) {
      cout << 1 << " " << 2 << "\n";
    } else {
      cout << 2 << " " << 1 << "\n";
    }
  } else if (a != b and c != d) {
    cout << "2\n";
    if (a == c) {
      cout << "1 2"
           << "\n";
      cout << n - 1 << " " << n << "\n";
    } else {
      cout << "1 2"
           << "\n";
      cout << n << " " << n - 1 << "\n";
    }
  }
}
int main() {
  int t;
  scanf("%d", &t);
  while (t--) solve();
  return 0;
}
