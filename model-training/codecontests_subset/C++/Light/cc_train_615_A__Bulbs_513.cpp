#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, x, y, a[500];
  for (int k = 0; k < 500; ++k) a[k] = 0;
  cin >> n >> m;
  for (int i = 1; i <= n; ++i) {
    cin >> x;
    for (int j = 1; j <= x; ++j) {
      cin >> y;
      a[y] = 1;
    }
  }
  for (int i = 1; i <= m; ++i) {
    if (a[i] == 0) {
      cout << "NO" << endl;
      return 0;
    }
  }
  cout << "YES" << endl;
  return 0;
}
