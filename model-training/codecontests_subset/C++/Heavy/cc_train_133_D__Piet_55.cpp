#include <bits/stdc++.h>
using namespace std;
const double eps = 1e-8;
const double pi = acos(-1.0);
const double inf = ~0u >> 2;
char s[55][55];
int a[55][55][4], n, k;
int judge(int x, int y) {
  if (x < 0 || x >= n || y < 0 || y >= k) return 0;
  if (s[x][y] == '0') return 0;
  return 1;
}
int main() {
  int i, j, m, g;
  cin >> n >> m;
  for (i = 0; i < n; i++) cin >> s[i];
  k = strlen(s[1]);
  for (i = 0; i < n; i++) {
    for (j = 0; j < k; j++) {
      for (g = j; g >= 0; g--)
        if (s[i][g] != s[i][j]) break;
      a[i][j][3] = g + 1;
      for (g = i; g >= 0; g--)
        if (s[g][j] != s[i][j]) break;
      a[i][j][0] = g + 1;
      for (g = j; g < k; g++)
        if (s[i][g] != s[i][j]) break;
      a[i][j][1] = g - 1;
      for (g = i; g < n; g++)
        if (s[g][j] != s[i][j]) break;
      a[i][j][2] = g - 1;
    }
  }
  int d1 = 1, d2 = 0, x = 0, y = 0;
  char c = s[0][0];
  int k1 = 1;
  while (k1 <= m) {
    if (d1 == 0 || d1 == 2)
      x = a[x][y][d1];
    else
      y = a[x][y][d1];
    if (d2 == 0 || d2 == 2)
      x = a[x][y][d2];
    else
      y = a[x][y][d2];
    int tx, ty;
    if (d1 == 0) {
      tx = x - 1;
      ty = y;
    } else if (d1 == 1) {
      tx = x;
      ty = y + 1;
    } else if (d1 == 2) {
      tx = x + 1;
      ty = y;
    } else {
      tx = x;
      ty = y - 1;
    }
    if (!judge(tx, ty)) {
      if ((d2 + 1) % 4 == d1)
        d2 = (d1 + 1) % 4;
      else {
        d1 = (d1 + 1) % 4;
        d2 = (d1 - 1 + 4) % 4;
      }
    } else {
      c = s[tx][ty];
      x = tx, y = ty;
    }
    k1++;
  }
  cout << c << endl;
  return 0;
}
