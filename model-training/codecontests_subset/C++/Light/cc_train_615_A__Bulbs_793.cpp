#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, v[105], x, y, b = 1;
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    cin >> x;
    for (int j = 1; j <= x; j++) {
      cin >> y;
      v[y] = 1;
    }
  }
  for (int i = 1; i <= m; i++) {
    if (v[i] != 1) {
      b = 0;
      break;
    }
  }
  if (b)
    cout << "YES";
  else
    cout << "NO";
}
