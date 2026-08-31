#include <bits/stdc++.h>
using namespace std;
struct point {
  int x, y;
  point(int xv = 0, int yv = 0) {
    x = xv;
    y = yv;
  }
} edge[55][55][4];
char s[55];
int gr[55][55];
int dir[4][2] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
int lr[4][4] = {{0, 2, 0, 1}, {1, 0, 2, 0}, {0, 1, 0, 2}, {2, 0, 1, 0}};
int co[4][4] = {{4, 1, 4, 0}, {1, 4, 2, 4}, {4, 2, 4, 3}, {0, 4, 3, 4}};
int main() {
  int n, k, i, j, cp, dp, gx, gy, m, K;
  point d[4];
  point bp(1, 1);
  scanf("%d%d", &n, &K);
  memset(gr, 0, sizeof(gr));
  for (i = 1; i <= n; i++) {
    scanf("%s", s);
    m = strlen(s);
    for (j = 1; j <= m; j++) gr[i][j] = s[j - 1] - '0';
  }
  for (i = 1; i <= n; i++) {
    for (j = 1; j <= m; j++) {
      for (k = 0; k < 4; k++) {
        d[k].x = i;
        d[k].y = j;
        while (gr[d[k].x + dir[k][0]][d[k].y + dir[k][1]] == gr[d[k].x][d[k].y])
          d[k].x += dir[k][0], d[k].y += dir[k][1];
      }
      edge[i][j][0].x = edge[i][j][1].x = d[0].x;
      edge[i][j][1].y = edge[i][j][2].y = d[1].y;
      edge[i][j][2].x = edge[i][j][3].x = d[2].x;
      edge[i][j][3].y = edge[i][j][0].y = d[3].y;
    }
  }
  cp = 0;
  dp = 1;
  while (K--) {
    gx = edge[bp.x][bp.y][co[dp][cp]].x;
    gy = edge[bp.x][bp.y][co[dp][cp]].y;
    gx = gx + dir[dp][0];
    gy = gy + dir[dp][1];
    if (gr[gx][gy] == 0) {
      if (lr[dp][cp] == 1) {
        cp = (dp + 1) % 4;
      } else {
        dp = (dp + 1) % 4;
        cp = (dp - 1 + 4) % 4;
      }
    } else {
      bp.x = gx;
      bp.y = gy;
    }
  }
  printf("%d\n", gr[bp.x][bp.y]);
  return 0;
}
