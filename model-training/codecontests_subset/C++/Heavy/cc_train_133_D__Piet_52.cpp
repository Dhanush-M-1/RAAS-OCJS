#include <bits/stdc++.h>
using namespace std;
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1};
char dc[4] = {'<', 'V', '>', '^'};
int main() {
  int n, step;
  char img[64][64];
  int vis[64][64][4][2];
  while (scanf("%d%d", &n, &step) != EOF) {
    for (int i = 0; i < n; ++i) scanf("%s", img[i]);
    int m = strlen(img[0]);
    memset(vis, -1, sizeof(vis));
    int x = 0, y = 0, dp = 2, cp = 0;
    int base, cyc;
    int i;
    for (i = 0; i < step; ++i) {
      if (vis[y][x][dp][cp] != -1) {
        base = vis[y][x][dp][cp];
        cyc = i - base;
        break;
      }
      while (x - 1 >= 0 && img[y][x - 1] == img[y][x]) --x;
      int minx = x;
      while (y - 1 >= 0 && img[y - 1][x] == img[y][x]) --y;
      int miny = y;
      while (x + 1 < m && img[y][x + 1] == img[y][x]) ++x;
      int maxx = x;
      while (y + 1 < n && img[y + 1][x] == img[y][x]) ++y;
      int maxy = y;
      int edges[4] = {minx, maxy, maxx, miny};
      int cpd = (cp ? (dp == 0 ? 3 : dp - 1) : (dp == 3 ? 0 : dp + 1));
      for (x = minx; x <= maxx; ++x)
        for (y = miny; y <= maxy; ++y) vis[y][x][dp][cp] = i;
      if (dx[dp] == 0) {
        x = edges[cpd];
        y = edges[dp];
      } else {
        y = edges[cpd];
        x = edges[dp];
      }
      int nx = x + dx[dp];
      int ny = y + dy[dp];
      if (nx >= 0 && nx < m && ny >= 0 && ny < n && img[ny][nx] != '0') {
        x = nx, y = ny;
      } else {
        if (cp == 0)
          cp = 1;
        else {
          cp = 0;
          dp = (dp == 0 ? 3 : dp - 1);
        }
      }
    }
    if (i == step) {
      printf("%c\n", img[y][x]);
    } else {
      step = base + (step - base) % cyc;
      for (int i = 0; i < n; ++i)
        for (int j = 0; j < m; ++j)
          for (int d = 0; d < 4; ++d)
            for (int lr = 0; lr < 2; ++lr)
              if (vis[i][j][d][lr] == step) {
                printf("%c\n", img[i][j]);
                goto outer;
              }
    outer:
      step = 0;
    }
  }
  return 0;
}
