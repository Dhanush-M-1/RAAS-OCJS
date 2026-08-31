#include <bits/stdc++.h>
int map[55][55];
int to[55][55][4][2];
int rx[] = {0, -1, 0, 1};
int ry[] = {1, 0, -1, 0};
struct node {
  int x, y, dp, cp;
};
int main() {
  memset(map, 0, sizeof(map));
  int n, m, step, i, j;
  char str[55];
  node now;
  now.x = 1, now.y = 1;
  now.dp = 0, now.cp = 1;
  scanf("%d %d", &n, &step);
  scanf("%s", str + 1);
  m = strlen(str + 1);
  for (i = 1; i <= m; i++) map[1][i] = str[i] - '0';
  for (i = 2; i <= n; i++) {
    for (j = 1; j <= m; j++) scanf("%1d", &map[i][j]);
  }
  for (i = 1; i <= n; i++)
    for (j = 1; j <= m; j++) {
      if (map[i][j] == 0) continue;
      for (int dir = 0; dir < 4; dir++) {
        int x = i;
        int y = j;
        while (1) {
          x += rx[dir];
          y += ry[dir];
          if (map[x][y] != map[i][j]) {
            x -= rx[dir];
            y -= ry[dir];
            break;
          }
        }
        to[i][j][dir][0] = x;
        to[i][j][dir][1] = y;
      }
    }
  for (i = 0; i < step; i++) {
    int x = to[now.x][now.y][now.dp][0];
    int y = to[now.x][now.y][now.dp][1];
    now.x = x, now.y = y;
    now.x = to[x][y][(now.dp + now.cp + 4) % 4][0];
    now.y = to[x][y][(now.dp + now.cp + 4) % 4][1];
    x = now.x + rx[now.dp];
    y = now.y + ry[now.dp];
    if (map[x][y]) {
      now.x = x, now.y = y;
    } else {
      if (now.cp == 1) {
        now.cp = -1;
      } else {
        now.cp = 1;
        now.dp = (now.dp - 1 + 4) % 4;
      }
    }
  }
  printf("%d\n", map[now.x][now.y]);
  return 0;
}
