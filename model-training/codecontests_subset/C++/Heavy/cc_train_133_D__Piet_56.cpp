#include <bits/stdc++.h>
using namespace std;
int n, m, d[100][100][4], dir[4][2] = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
int mat[100][100] = {0}, len;
char st[1001];
int main() {
  scanf("%d%d", &m, &n);
  gets(st);
  for (int i = 0; i < m; i++) {
    gets(st);
    len = strlen(st);
    for (int j = 0; j < len; j++) {
      mat[i + 1][j + 1] = st[j] - '0';
    }
  }
  for (int i = (1); i < (m + 1); i++)
    for (int j = (1); j < (len + 1); j++)
      for (int k = (0); k < (4); k++) {
        int l = 0, x = i, y = j;
        while (mat[i][j] == mat[x][y]) x += dir[k][0], y += dir[k][1], l++;
        d[i][j][k] = l;
      }
  pair<int, int> bp = pair<int, int>(1, 1);
  int dp = 0, cp = 1;
  for (int i = (0); i < (n); i++) {
    int x = bp.first, y = bp.second, l = d[x][y][dp];
    l--;
    x += l * dir[dp][0];
    y += l * dir[dp][1];
    int l2 = d[x][y][cp];
    l2--;
    x += l2 * dir[cp][0];
    y += l2 * dir[cp][1];
    if (mat[x + dir[dp][0]][y + dir[dp][1]] == 0) {
      if (cp == (dp + 1) % 4)
        cp = ((dp - 1) % 4 + 4) % 4;
      else {
        int tmp = dp;
        dp = cp;
        cp = tmp;
      }
    } else {
      x += dir[dp][0];
      y += dir[dp][1];
    }
    bp.first = x;
    bp.second = y;
  }
  printf("%d\n", mat[bp.first][bp.second]);
  return 0;
}
