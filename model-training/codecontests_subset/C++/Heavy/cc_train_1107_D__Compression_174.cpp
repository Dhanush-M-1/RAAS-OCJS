#include <bits/stdc++.h>
using namespace std;
bool grid[5205][5205];
int rect[5205][5205];
char cek;
int main() {
  int n, i, j, k, x, y, r, c, ans, curr, temp, sum;
  scanf("%d", &n);
  getchar();
  for (i = 1; i <= n; i++) {
    for (j = 0; j < n / 4; j++) {
      scanf("%c", &cek);
      if (cek >= '0' && cek <= '9') {
        curr = cek - '0';
      } else {
        curr = cek - 'A' + 10;
      }
      for (k = 4; k >= 1; k--) {
        if (curr % 2 == 1) {
          grid[i][4 * j + k] = 1;
        }
        curr /= 2;
      }
    }
    getchar();
  }
  memset(rect, 0, sizeof(rect));
  rect[1][1] = grid[1][1];
  for (i = 2; i <= n; i++) {
    rect[1][i] = rect[1][i - 1] + grid[1][i];
    rect[i][1] = rect[i - 1][1] + grid[i][1];
  }
  for (i = 2; i <= n; i++) {
    for (j = 2; j <= n; j++) {
      rect[i][j] =
          rect[i - 1][j] + rect[i][j - 1] - rect[i - 1][j - 1] + grid[i][j];
    }
  }
  for (i = n; i >= 1; i--) {
    if (n % i == 0) {
      int can = 1;
      for (j = 0; j < n; j += i) {
        for (k = 0; k < n; k += i) {
          sum =
              rect[j + i][k + i] - rect[j][k + i] - rect[j + i][k] + rect[j][k];
          if (sum == 0 || sum == i * i) continue;
          can = 0;
          break;
        }
      }
      if (can == 1) {
        ans = i;
        break;
      }
    }
  }
  printf("%d\n", ans);
  return 0;
}
