#include <bits/stdc++.h>
using namespace std;
int px[60][60][8], py[60][60][8], pz[60][60][8];
int m, n, p;
char g[60][60];
int dir[4][2] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
inline bool valid(int x, int y) { return (0 <= x && x < m && 0 <= y && y < n); }
int main() {
  cin >> m >> p;
  for (int i = 0; i < m; ++i) cin >> g[i];
  n = strlen(g[0]);
  int i, j, k, d1, d2, x, y, x1, y1;
  for (i = 0; i < m; ++i)
    for (j = 0; j < n; ++j)
      for (k = 0; k < 8; ++k) {
        d1 = k / 2, d2 = ((k & 1) ? d1 + 1 : d1 + 3) & 3;
        x1 = i, y1 = j;
        while (1) {
          x = x1 + dir[d1][0], y = y1 + dir[d1][1];
          if (!valid(x, y) || g[x][y] == '0' || g[x][y] != g[i][j]) break;
          x1 = x, y1 = y;
        }
        while (1) {
          x = x1 + dir[d2][0], y = y1 + dir[d2][1];
          if (!valid(x, y) || g[x][y] == '0' || g[x][y] != g[i][j]) break;
          x1 = x, y1 = y;
        }
        x = x1 + dir[d1][0], y = y1 + dir[d1][1];
        if (!valid(x, y) || g[x][y] == '0') {
          px[i][j][k] = x1, py[i][j][k] = y1;
          if (k & 1)
            pz[i][j][k] = ((k / 2 + 1) & 3) * 2;
          else
            pz[i][j][k] = k ^ 1;
        } else
          px[i][j][k] = x, py[i][j][k] = y, pz[i][j][k] = k;
      }
  int wx = 0, wy = 0, wz = 0, wx1, wy1, wz1;
  while (p--) {
    wx1 = px[wx][wy][wz];
    wy1 = py[wx][wy][wz];
    wz1 = pz[wx][wy][wz];
    wx = wx1, wy = wy1, wz = wz1;
  }
  cout << g[wx][wy] << endl;
  return 0;
}
