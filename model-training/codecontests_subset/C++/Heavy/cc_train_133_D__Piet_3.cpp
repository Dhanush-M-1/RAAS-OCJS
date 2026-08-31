#include <bits/stdc++.h>
char field[55][55];
int n, steps, m;
int next[55][55][4][2][4];
int main() {
  int i, j, k, dir, r;
  scanf("%d %d", &n, &steps);
  for (i = 0; i < n; i++) scanf("%s", field[i]);
  m = strlen(field[0]);
  for (i = 0; i < n; i++)
    for (j = 0; j < m; j++)
      for (k = 0; k < 4; k++)
        for (dir = 0; dir < 2; dir++)
          for (r = 0; r < 4; r++) next[i][j][k][dir][r] = -1;
  for (i = 0; i < n; i++)
    for (j = 0; j < m; j++) {
      if (field[i][j] != '0') {
        int left, right, top, bottom;
        left = right = j;
        top = bottom = i;
        while (left > 0 && field[i][left - 1] == field[i][j]) left--;
        while (right < m - 1 && field[i][right + 1] == field[i][j]) right++;
        while (top > 0 && field[top - 1][j] == field[i][j]) top--;
        while (bottom < n - 1 && field[bottom + 1][j] == field[i][j]) bottom++;
        for (k = 0; k < 4; k++) {
          for (dir = 0; dir < 2; dir++) {
            int nx, ny;
            if (k == 0) {
              nx = top - 1;
              ny = (1 - dir ? left : right);
            } else if (k == 1) {
              ny = right + 1;
              nx = (1 - dir ? top : bottom);
            } else if (k == 2) {
              nx = bottom + 1;
              ny = (1 - dir ? right : left);
            } else {
              ny = left - 1;
              nx = (1 - dir ? bottom : top);
            }
            if (nx < 0 || ny < 0 || nx >= n || ny >= m ||
                field[nx][ny] == '0') {
              next[i][j][k][dir][0] = i;
              next[i][j][k][dir][1] = j;
              next[i][j][k][dir][2] = (k + dir) % 4;
              next[i][j][k][dir][3] = 1 - dir;
              continue;
            }
            next[i][j][k][dir][0] = nx;
            next[i][j][k][dir][1] = ny;
            next[i][j][k][dir][2] = k;
            next[i][j][k][dir][3] = dir;
          }
        }
      }
    }
  int cx = 0, cy = 0, ck = 1, cdir = 0;
  for (i = 0; i < steps; i++) {
    int tx, ty, tk, tdir;
    tx = cx;
    ty = cy;
    tk = ck;
    tdir = cdir;
    cx = next[tx][ty][tk][tdir][0];
    cy = next[tx][ty][tk][tdir][1];
    ck = next[tx][ty][tk][tdir][2];
    cdir = next[tx][ty][tk][tdir][3];
  }
  printf("%c\n", field[cx][cy]);
  return 0;
}
