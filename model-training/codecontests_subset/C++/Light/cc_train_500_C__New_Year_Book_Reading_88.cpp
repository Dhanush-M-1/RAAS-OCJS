#include <bits/stdc++.h>
using namespace std;
int main() {
  int w[505];
  bool first[505];
  int up[505];
  int down[505];
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    cin >> w[i];
    first[i] = true;
    up[i] = -1;
    down[i] = -1;
  }
  int b;
  int ans = 0;
  int totCarry = 0;
  int top = -1;
  for (int i = 0; i < m; i++) {
    cin >> b;
    if (first[b]) {
      ans += totCarry;
      totCarry += w[b];
      first[b] = false;
    } else {
      int j = up[b];
      while (j != -1) {
        ans += w[j];
        j = up[j];
      }
      if (up[b] != -1) {
        if (down[b] != -1) up[down[b]] = up[b];
        down[up[b]] = down[b];
      }
    }
    if (top != -1 && top != b) {
      up[top] = b;
      down[b] = top;
    }
    top = b;
    up[top] = -1;
  }
  cout << ans << endl;
  return 0;
}
