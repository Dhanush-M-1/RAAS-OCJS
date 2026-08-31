#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, x, y, a[101] = {0};
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    cin >> x;
    for (int j = 1; j <= x; j++) {
      cin >> y;
      a[y] = 1;
    }
  }
  for (int i = 1; i <= m; i++) {
    if (a[i] == 0) {
      cout << "NO";
      return 0;
    }
  }
  cout << "YES";
  return 0;
}
