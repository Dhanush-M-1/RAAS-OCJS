#include <bits/stdc++.h>
using namespace std;
long long f[4][20001];
int n;
int a[3], b[3];
int main() {
  scanf("%d%d%d%d", &n, &a[0], &a[1], &a[2]);
  n *= 2;
  b[0] = 1;
  b[1] = 2;
  b[2] = 4;
  f[0][0] = 1;
  for (int i = 0; i <= 2; i++)
    for (int j = 0; j <= n; j++)
      if (f[i][j] > 0) {
        int u = j;
        for (int k = 0; k <= a[i]; k++) {
          f[i + 1][u] += f[i][j];
          u += b[i];
          if (u > n) {
            break;
          }
        }
      }
  cout << f[3][n] << endl;
  return 0;
}
