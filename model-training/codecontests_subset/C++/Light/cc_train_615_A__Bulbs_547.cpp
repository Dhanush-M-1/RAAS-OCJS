#include <bits/stdc++.h>
using namespace std;
int main() {
  int hit[111] = {0};
  int m, n, x, y;
  scanf("%d %d", &n, &m);
  for (int i = 0; i < n; i++) {
    scanf("%d", &x);
    for (int j = 0; j < x; j++) {
      scanf("%d", &y);
      hit[y] = 1;
    }
  }
  for (int i = 1; i <= m; i++) {
    if (hit[i] == 0) {
      cout << "NO" << endl;
      return 0;
    }
  }
  cout << "YES" << endl;
  return 0;
}
