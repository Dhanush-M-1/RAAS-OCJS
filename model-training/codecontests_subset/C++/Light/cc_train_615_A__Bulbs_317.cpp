#include <bits/stdc++.h>
using namespace std;
bool a[105], b[105];
int main() {
  int n, m, x, y;
  cin >> n >> m;
  bool w;
  for (int i = 1; i <= n; i++) {
    cin >> x;
    a[x] = true;
    while (x--) {
      cin >> y;
      b[y] = true;
    }
    for (int k = 1; k <= m; k++) {
      if (b[k] == false) {
        w = false;
        break;
      } else
        w = true;
    }
  }
  if (w)
    cout << "YES";
  else
    cout << "NO";
  return 0;
}
