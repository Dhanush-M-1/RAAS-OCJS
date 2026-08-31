#include <bits/stdc++.h>
using namespace std;
struct pnt {
  int x, y;
} ul[100][100], ur[100][100], dl[100][100], dr[100][100];
int n, m;
char a[100][100];
char s[][6] = {"up", "right", "down", "left"};
void init() {
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < m; ++j) {
      if (j && a[i][j] == a[i][j - 1]) {
        ul[i][j] = ul[i][j - 1];
      } else if (i && a[i - 1][j] == a[i][j]) {
        ul[i][j] = ul[i - 1][j];
      } else {
        ul[i][j].x = i;
        ul[i][j].y = j;
      }
    }
    for (int j = m - 1; j >= 0; --j) {
      if (j + 1 < m && a[i][j] == a[i][j + 1]) {
        ur[i][j] = ur[i][j + 1];
      } else if (i && a[i - 1][j] == a[i][j]) {
        ur[i][j] = ur[i - 1][j];
      } else {
        ur[i][j].x = i;
        ur[i][j].y = j;
      }
    }
  }
  for (int i = n - 1; i >= 0; --i) {
    for (int j = 0; j < m; ++j) {
      if (j && a[i][j] == a[i][j - 1]) {
        dl[i][j] = dl[i][j - 1];
      } else if (i + 1 < n && a[i + 1][j] == a[i][j]) {
        dl[i][j] = dl[i + 1][j];
      } else {
        dl[i][j].x = i;
        dl[i][j].y = j;
      }
    }
    for (int j = m - 1; j >= 0; --j) {
      if (j + 1 < m && a[i][j] == a[i][j + 1]) {
        dr[i][j] = dr[i][j + 1];
      } else if (i + 1 < n && a[i + 1][j] == a[i][j]) {
        dr[i][j] = dr[i + 1][j];
      } else {
        dr[i][j].x = i;
        dr[i][j].y = j;
      }
    }
  }
}
int main() {
  int k;
  scanf("%d%d\n", &n, &k);
  for (int i = 0; i < n; ++i) gets(a[i]);
  m = strlen(a[0]);
  init();
  int cp = 0, dp = 1, x = 0, y = 0, tx, ty, cc = a[0][0];
  while (k--) {
    if (dp == 1) {
      if (cp == 0) {
        tx = ur[x][y].x;
        ty = ur[x][y].y + 1;
      } else {
        tx = dr[x][y].x;
        ty = dr[x][y].y + 1;
      }
    } else if (dp == 2) {
      if (cp == 1) {
        tx = dr[x][y].x + 1;
        ty = dr[x][y].y;
      } else {
        tx = dl[x][y].x + 1;
        ty = dl[x][y].y;
      }
    } else if (dp == 3) {
      if (cp == 2) {
        tx = dl[x][y].x;
        ty = dl[x][y].y - 1;
      } else {
        tx = ul[x][y].x;
        ty = ul[x][y].y - 1;
      }
    } else {
      if (cp == 3) {
        tx = ul[x][y].x - 1;
        ty = ul[x][y].y;
      } else {
        tx = ur[x][y].x - 1;
        ty = ur[x][y].y;
      }
    }
    if (tx < 0 || ty < 0 || tx >= n || ty >= m || a[tx][ty] == '0') {
      if (dp == 1) {
        if (cp == 0)
          cp = 2;
        else
          dp = 2, cp = 1;
      } else if (dp == 2) {
        if (cp == 1)
          cp = 3;
        else
          dp = 3, cp = 2;
      } else if (dp == 3) {
        if (cp == 2)
          cp = 0;
        else
          dp = 0, cp = 3;
      } else {
        if (cp == 3)
          cp = 1;
        else
          dp = 1, cp = 0;
      }
    } else
      cc = a[tx][ty] - '0', x = tx, y = ty;
  }
  cout << a[x][y] << endl;
  return 0;
}
