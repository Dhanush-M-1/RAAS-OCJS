#include <bits/stdc++.h>
using namespace std;
int getint() {
  unsigned int c;
  int x = 0;
  while (((c = getchar()) - '0') >= 10) {
    if (c == '-') return -getint();
    if (!~c) exit(0);
  }
  do {
    x = (x << 3) + (x << 1) + (c - '0');
  } while (((c = getchar()) - '0') < 10);
  return x;
}
int getc_str(char str[]) {
  unsigned int c, n = 0;
  for (; (c = getchar()) <= ' ';)
    if (!~c) exit(0);
  do {
    str[n++] = c;
  } while ((c = getchar()) > ' ');
  str[n] = '\0';
  return n;
}
int wd, ht;
int dx[] = {-1, 0, 1, 0};
int dy[] = {0, 1, 0, -1};
inline bool inc(int x, int y) {
  return 0 <= x and x < ht and 0 <= y and y < wd;
}
inline bool nget(int &nx, int &ny, int x, int y, int d) {
  nx = x + dx[d], ny = y + dy[d];
  return inc(nx, ny);
}
int n, m;
char fld[55][55];
int vis[55][55];
int next_pos[3333][4][2];
int next_dps[3333][4][2];
int next_cps[3333][4][2];
int minx[3333], maxx[3333], miny[3333], maxy[3333];
int color_table[3333];
void dfs(int x, int y, char color, int k) {
  if (fld[x][y] != color) return;
  color_table[k] = color;
  vis[x][y] = k;
  minx[k] = min(minx[k], x);
  maxx[k] = max(maxx[k], x);
  miny[k] = min(miny[k], y);
  maxy[k] = max(maxy[k], y);
  int nx, ny, d;
  for (d = 0; d < 4; d++)
    if (nget(nx, ny, x, y, d) and fld[nx][ny] == color and vis[nx][ny] == -1) {
      dfs(nx, ny, color, k);
    }
}
int main() {
  int i, j, tcc, tc = 1;
  for (tcc = 0; tcc < tc; tcc++) {
    ht = getint(), n = getint();
    for (i = 0; i < ht; i++) wd = getc_str(fld[i]);
    memset(vis, ~0, sizeof(vis));
    m = 0;
    for (i = 0; i < ht; i++)
      for (j = 0; j < wd; j++)
        if (vis[i][j] == ~0) {
          int color = fld[i][j];
          if (color == '0') continue;
          minx[m] = miny[m] = 1 << 28;
          maxx[m] = maxy[m] = ~0;
          dfs(i, j, color, m);
          m++;
        }
    for (i = 0; i < ht; i++)
      for (j = 0; j < wd; j++) {
        if (fld[i][j] == '0') continue;
        int k = vis[i][j];
        int nx, ny;
        nx = minx[k] - 1, ny = maxy[k];
        if (inc(nx, ny) and fld[nx][ny] != '0') {
          next_pos[k][0][0] = vis[nx][ny];
          next_dps[k][0][0] = 0;
          next_cps[k][0][0] = 0;
        } else {
          next_pos[k][0][0] = k;
          next_dps[k][0][0] = 1;
          next_cps[k][0][0] = 1;
        }
        nx = minx[k] - 1, ny = miny[k];
        if (inc(nx, ny) and fld[nx][ny] != '0') {
          next_pos[k][0][1] = vis[nx][ny];
          next_dps[k][0][1] = 0;
          next_cps[k][0][1] = 1;
        } else {
          next_pos[k][0][1] = k;
          next_dps[k][0][1] = 0;
          next_cps[k][0][1] = 0;
        }
        nx = maxx[k], ny = maxy[k] + 1;
        if (inc(nx, ny) and fld[nx][ny] != '0') {
          next_pos[k][1][0] = vis[nx][ny];
          next_dps[k][1][0] = 1;
          next_cps[k][1][0] = 0;
        } else {
          next_pos[k][1][0] = k;
          next_dps[k][1][0] = 2;
          next_cps[k][1][0] = 1;
        }
        nx = minx[k], ny = maxy[k] + 1;
        if (inc(nx, ny) and fld[nx][ny] != '0') {
          next_pos[k][1][1] = vis[nx][ny];
          next_dps[k][1][1] = 1;
          next_cps[k][1][1] = 1;
        } else {
          next_pos[k][1][1] = k;
          next_dps[k][1][1] = 1;
          next_cps[k][1][1] = 0;
        }
        nx = maxx[k] + 1, ny = miny[k];
        if (inc(nx, ny) and fld[nx][ny] != '0') {
          next_pos[k][2][0] = vis[nx][ny];
          next_dps[k][2][0] = 2;
          next_cps[k][2][0] = 0;
        } else {
          next_pos[k][2][0] = k;
          next_dps[k][2][0] = 3;
          next_cps[k][2][0] = 1;
        }
        nx = maxx[k] + 1, ny = maxy[k];
        if (inc(nx, ny) and fld[nx][ny] != '0') {
          next_pos[k][2][1] = vis[nx][ny];
          next_dps[k][2][1] = 2;
          next_cps[k][2][1] = 1;
        } else {
          next_pos[k][2][1] = k;
          next_dps[k][2][1] = 2;
          next_cps[k][2][1] = 0;
        }
        nx = minx[k], ny = miny[k] - 1;
        if (inc(nx, ny) and fld[nx][ny] != '0') {
          next_pos[k][3][0] = vis[nx][ny];
          next_dps[k][3][0] = 3;
          next_cps[k][3][0] = 0;
        } else {
          next_pos[k][3][0] = k;
          next_dps[k][3][0] = 0;
          next_cps[k][3][0] = 1;
        }
        nx = maxx[k], ny = miny[k] - 1;
        if (inc(nx, ny) and fld[nx][ny] != '0') {
          next_pos[k][3][1] = vis[nx][ny];
          next_dps[k][3][1] = 3;
          next_cps[k][3][1] = 1;
        } else {
          next_pos[k][3][1] = k;
          next_dps[k][3][1] = 3;
          next_cps[k][3][1] = 0;
        }
      }
    int pos = 0, dp = 1, cp = 1;
    for (i = 0; i < n; i++) {
      int npos = next_pos[pos][dp][cp];
      int ndp = next_dps[pos][dp][cp];
      int ncp = next_cps[pos][dp][cp];
      pos = npos, dp = ndp, cp = ncp;
    }
    putchar(color_table[pos]);
    puts("");
  }
  return 0;
}
