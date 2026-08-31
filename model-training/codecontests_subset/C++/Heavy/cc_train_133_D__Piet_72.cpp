#include <bits/stdc++.h>
using namespace std;
char s[100][100];
int di[4][2] = {0, 1, 1, 0, 0, -1, -1, 0};
int v[100][100];
int fst[4] = {1, 0, 1, 0};
int xi[4][2] = {1, 0, 0, 1, 2, 3, 3, 2};
int m, r;
struct zb {
  int z[2];
} po[100][100][4][2];
void gx(int x, int y, int &a, int &b, int xi) {
  if (xi == 0) {
    if (x > a || (x == a && y > b)) {
      a = x;
      b = y;
    }
  }
  if (xi == 1) {
    if (x > a || (x == a && y < b)) {
      a = x;
      b = y;
    }
  }
  if (xi == 2) {
    if (x < a || (x == a && y > b)) {
      a = x;
      b = y;
    }
  }
  if (xi == 3) {
    if (x < a || (x == a && y < b)) {
      a = x;
      b = y;
    }
  }
}
void dfs(int x, int y, int cx, int cy) {
  v[cx][cy] = 1;
  int i, j;
  for (i = 0; i < 4; i++)
    for (j = 0; j < 2; j++) {
      if (fst[i] == 1)
        gx(cy, cx, po[x][y][i][j].z[1], po[x][y][i][j].z[0], xi[i][j]);
      else
        gx(cx, cy, po[x][y][i][j].z[0], po[x][y][i][j].z[1], xi[i][j]);
    }
  for (i = 0; i < 4; i++) {
    int nx, ny;
    nx = cx + di[i][0];
    ny = cy + di[i][1];
    if (nx >= 0 && nx < m && ny >= 0 && ny < r && v[nx][ny] == 0 &&
        s[nx][ny] == s[x][y])
      dfs(x, y, nx, ny);
  }
}
int main() {
  int n, i, j, k, l, bp, cp, dp, cx, cy;
  while (scanf("%d%d", &m, &n) == 2) {
    for (i = 0; i < m; i++) scanf("%s", s[i]);
    r = strlen(s[0]);
    for (i = 0; i < m; i++)
      for (j = 0; j < r; j++) {
        for (k = 0; k < 4; k++)
          for (l = 0; l < 2; l++) {
            po[i][j][k][l].z[0] = i;
            po[i][j][k][l].z[1] = j;
          }
        memset(v, 0, sizeof(v));
        if (s[i][j] != '0') dfs(i, j, i, j);
      }
    cx = 0;
    cy = 0;
    cp = 0;
    dp = 0;
    while (n--) {
      int nx, ny;
      nx = po[cx][cy][cp][dp].z[0];
      ny = po[cx][cy][cp][dp].z[1];
      cx = nx;
      cy = ny;
      i = cp;
      nx = cx + di[i][0];
      ny = cy + di[i][1];
      if (nx >= 0 && nx < m && ny >= 0 && ny < r && s[nx][ny] != '0') {
        cx = nx;
        cy = ny;
      } else {
        if (dp == 0)
          dp = 1;
        else {
          dp = 0;
          cp = (cp + 1) % 4;
        }
      }
    }
    printf("%c\n", s[cx][cy]);
  }
}
