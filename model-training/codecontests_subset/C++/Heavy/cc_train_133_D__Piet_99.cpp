#include <bits/stdc++.h>
using namespace std;
void file_open() {
  freopen("input.txt", "r", stdin);
  freopen("output.txt", "w", stdout);
}
const int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1},
          dk[4][2] = {3, 1, 0, 2, 1, 3, 2, 0};
const int MAX = 60;
typedef int kieu[MAX][MAX];
struct point {
  int x, y;
};
point tinh(kieu a, int i, int j, int dir) {
  int t = a[i][j];
  int u = i, v = j;
  while (a[u][v] == t) {
    u += di[dir];
    v += dj[dir];
  }
  u -= di[dir];
  v -= dj[dir];
  point tmp = {u, v};
  return tmp;
}
int main() {
  int m, n, u, v, p;
  kieu a = {};
  point d[MAX][MAX][4] = {};
  char buff[100] = {};
  int tr[MAX][MAX][8] = {};
  point track[MAX * MAX * 8 + 1] = {};
  scanf("%d%d\n", &m, &n);
  u = v = 0;
  for (int i = 1; i <= m; ++i) {
    gets(buff);
    p = strlen(buff);
    for (int j = 1; j <= p; ++j) {
      a[i][j] = buff[j - 1] - '0';
    }
  }
  for (int i = 1; i <= m; ++i)
    for (int j = 1; j <= p; ++j)
      for (int k = 0; k < 4; ++k)
        if (a[i][j]) d[i][j][k] = tinh(a, i, j, k);
  int bp, dp, cp, cost;
  point tmp;
  u = v = 1;
  bp = a[u][v];
  dp = 1;
  cp = 0;
  tr[u][v][dp * 2 + cp] = cost = 1;
  track[1].x = 1;
  track[1].y = 1;
  while (n) {
    int r1, r2, c1, c2, k;
    k = dk[dp][cp];
    r1 = d[u][v][dp].x;
    c1 = d[u][v][dp].y;
    r2 = d[r1][c1][k].x;
    c2 = d[r1][c1][k].y;
    r1 = r2 + di[dp];
    c1 = c2 + dj[dp];
    if (a[r1][c1] == 0) {
      r1 -= di[dp];
      c1 -= dj[dp];
      dp = (dp + cp) % 4;
      cp = (cp + 1) % 2;
    }
    u = r1;
    v = c1;
    bp = a[u][v];
    --n;
    ++cost;
    if (tr[u][v][dp * 2 + cp]) {
      cost = cost - tr[u][v][dp * 2 + cp];
      n = n % cost;
      tmp = track[tr[u][v][dp * 2 + cp] + n];
      bp = a[tmp.x][tmp.y];
      break;
    } else {
      tr[u][v][dp * 2 + cp] = cost;
      tmp.x = u;
      tmp.y = v;
      track[cost] = tmp;
    }
  }
  printf("%d", bp);
  return 0;
}
