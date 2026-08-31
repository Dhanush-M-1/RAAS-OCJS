#include <bits/stdc++.h>
using namespace std;
char a[52][52];
int vrh[52][52][4];
int u[] = {0, 0, 1, -1};
int v[] = {1, -1, 0, 0};
int main() {
  int m, n, s;
  scanf("%d%d", &m, &n);
  for (int i = 0; i < m; i++) scanf("%s", a[i]);
  s = strlen(a[0]);
  for (int i = 0; i < m; i++)
    for (int j = 0; j < s; j++)
      if (a[i][j] != '0') {
        int l = j, r = j, u = i, d = i;
        while (l >= 0 && a[i][l] == a[i][j]) l--;
        while (r < s && a[i][r] == a[i][j]) r++;
        while (u >= 0 && a[u][j] == a[i][j]) u--;
        while (d < m && a[d][j] == a[i][j]) d++;
        l++;
        r--;
        u++;
        d--;
        vrh[i][j][0] = r;
        vrh[i][j][1] = l;
        vrh[i][j][2] = u;
        vrh[i][j][3] = d;
      }
  int x = 0, y = 0, dp = 0, cp = -1;
  while (n--) {
    int nx, ny;
    if (dp == 0 && cp == -1 || dp == 3 && cp == 1) {
      nx = vrh[x][y][2];
      ny = vrh[x][y][0];
    } else if (dp == 3 && cp == -1 || dp == 1 && cp == 1) {
      nx = vrh[x][y][2];
      ny = vrh[x][y][1];
    } else if (dp == 2 && cp == -1 || dp == 0 && cp == 1) {
      nx = vrh[x][y][3];
      ny = vrh[x][y][0];
    } else if (dp == 1 && cp == -1 || dp == 2 && cp == 1) {
      nx = vrh[x][y][3];
      ny = vrh[x][y][1];
    }
    nx += u[dp];
    ny += v[dp];
    if (nx >= 0 && nx < m && ny >= 0 && ny < s && a[nx][ny] != '0') {
      x = nx;
      y = ny;
      continue;
    }
    if (cp == -1)
      cp = 1;
    else {
      cp = -1;
      if (dp == 0)
        dp = 2;
      else if (dp == 2)
        dp = 1;
      else if (dp == 1)
        dp = 3;
      else if (dp == 3)
        dp = 0;
    }
  }
  cout << a[x][y] << endl;
  return 0;
}
