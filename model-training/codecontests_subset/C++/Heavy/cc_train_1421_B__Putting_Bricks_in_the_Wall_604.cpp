#include <bits/stdc++.h>
using namespace std;
int vis[301][300];
char str[300][300];
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n, x, y, k = 1, sum = 0;
    bool sign = false;
    memset(vis, 0, sizeof(vis));
    scanf("%d", &n);
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        cin >> str[i][j];
      }
    }
    if (str[1][2] != '0') {
      sum++;
      vis[1][2] = 1;
    }
    if (str[2][1] != '0') {
      sum++;
      vis[2][1] = 1;
    }
    if (str[n - 1][n] != '1') {
      sum++;
      vis[n - 1][n] = 1;
    }
    if (str[n][n - 1] != '1') {
      sum++;
      vis[n][n - 1] = 1;
    }
    if (sum > 2) {
      memset(vis, 0, sizeof(vis));
      sum = 0;
      if (str[1][2] != '1') {
        sum++;
        vis[1][2] = 1;
      }
      if (str[2][1] != '1') {
        sum++;
        vis[2][1] = 1;
      }
      if (str[n - 1][n] != '0') {
        sum++;
        vis[n - 1][n] = 1;
      }
      if (str[n][n - 1] != '0') {
        sum++;
        vis[n][n - 1] = 1;
      }
    }
    printf("%d\n", sum);
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (vis[i][j]) {
          printf("%d %d\n", i, j);
        }
      }
    }
  }
}
