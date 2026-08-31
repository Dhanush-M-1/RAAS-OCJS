#include <bits/stdc++.h>
int a[100][100], n, z[2];
void k(int x, int y) {
  z[0] = a[x][y] % n;
  z[1] = (a[x][y] / n) % n;
  if (z[1] == 0 && y != 1) printf(" ");
  if (z[1] > 0) printf("%d", z[1]);
  printf("%d", z[0]);
}
int main() {
  int x, mod;
  scanf("%d", &n);
  for (int i = 1; i < n; ++i) {
    for (int j = 1; j < n; ++j) a[i][j] = i * j;
  }
  for (int i = 1; i < n; ++i) {
    for (int j = 1; j < n; ++j) {
      k(i, j);
      printf(" ");
    }
    if (i < n - 1) printf("\n");
  }
  return 0;
}
