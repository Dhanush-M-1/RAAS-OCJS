#include <bits/stdc++.h>
using namespace std;
int n, k, m, i, x, y, x2, y2, z, c, d, p;
int D[51][51][5][3];
char A[51][51];
int dx[] = {-1, 0, 1, 0};
int dy[] = {0, 1, 0, -1};
int main() {
  scanf("%d%d", &n, &k);
  for (i = 0; i < n; i++) scanf("%s", A[i]);
  m = strlen(A[0]);
  x = y = 0;
  d = 1;
  c = 0;
  memset(D, -1, sizeof D);
  while (1) {
    for (p = 0; p <= 1; p++)
      while (1) {
        x2 = x + dx[(d + p * (2 * c - 1) + 4) % 4];
        y2 = y + dy[(d + p * (2 * c - 1) + 4) % 4];
        if ((x2 >= 0 && x2 < n) && (y2 >= 0 && y2 < m) &&
            A[x2][y2] == A[x][y]) {
          x = x2;
          y = y2;
        } else
          break;
      }
    if (D[x][y][d][c] != -1) {
      k -= z;
      k %= z - D[x][y][d][c];
      z = 0;
      memset(D, -1, sizeof D);
    }
    D[x][y][d][c] = z;
    if (z == k) {
      printf("%c\n", A[x][y]);
      return 0;
    }
    x2 = x + dx[d];
    y2 = y + dy[d];
    if ((x2 >= 0 && x2 < n) && (y2 >= 0 && y2 < m) && A[x2][y2] != '0') {
      x = x2;
      y = y2;
    } else {
      if (c) d = (d + 1) % 4;
      c = 1 - c;
    }
    z++;
  }
  return 0;
}
