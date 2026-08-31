#include <bits/stdc++.h>
using namespace std;
int main() {
  int b, n, m, x, y, c, z;
  int a[105];
  while (cin >> n >> m) {
    c = 0;
    for (int i = 1; i <= m; i++) a[i] = 0;
    for (b = 1; b <= n; b++) {
      cin >> x;
      for (int i = 1; i <= x; i++) {
        cin >> y;
        a[y] = 1;
      }
    }
    for (b = 1; b <= m; b++) {
      if (a[b] == 0) {
        c = 1;
        break;
      }
    }
    if (c == 0)
      cout << "YES" << endl;
    else
      cout << "NO" << endl;
  }
}
