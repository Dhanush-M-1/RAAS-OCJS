#include <bits/stdc++.h>
using namespace std;
int main() {
  bool flag[101];
  memset(flag, false, sizeof flag);
  int n, m, x, y;
  cin >> n >> m;
  for (int i = 0; i < n; ++i) {
    cin >> x;
    for (int i = 0; i < x; ++i) {
      cin >> y;
      flag[y] = true;
    }
  }
  int c = 0;
  for (int i = 1; i <= m; ++i) {
    if (flag[i]) c++;
  }
  if (c == m) {
    cout << "YES" << endl;
  } else {
    cout << "NO" << endl;
  }
  return 0;
}
