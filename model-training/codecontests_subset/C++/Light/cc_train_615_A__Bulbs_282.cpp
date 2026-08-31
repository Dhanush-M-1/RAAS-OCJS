#include <bits/stdc++.h>
using namespace std;
bool all_on(bool vis[105], int n, int m) {
  int i;
  for (i = 1; i <= m; i++) {
    if (!vis[i]) return 0;
  }
  return 1;
}
int main() {
  int n, m, x, y;
  bool vis[105];
  cin >> n >> m;
  int i, j;
  for (i = 1; i <= m; i++) {
    vis[i] = 0;
  }
  for (i = 1; i <= n; i++) {
    cin >> x;
    for (j = 0; j < x; j++) {
      cin >> y;
      vis[y] = true;
    }
  }
  if (all_on(vis, n, m))
    cout << "YES";
  else
    cout << "NO";
  return 0;
}
