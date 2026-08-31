#include <bits/stdc++.h>
using namespace std;
int main() {
  int x, n, m, i, j, c, flag[1000];
  for (i = 0; i < 1000; i++) flag[i] = 0;
  cin >> n >> m;
  for (i = 0; i < n; i++) {
    cin >> c;
    for (j = 0; j < c; j++) {
      cin >> x;
      flag[x] = 1;
    }
  }
  for (i = 0; i < m; i++)
    if (flag[i + 1] == 0) {
      cout << "NO" << endl;
      return 0;
    }
  cout << "YES" << endl;
  return 0;
}
