#include <bits/stdc++.h>
using namespace std;
const int N = 20100;
int b[N], c[N], x, y, z, n;
int main() {
  int i, j, l;
  while (scanf("%d%d%d%d", &n, &x, &y, &z) != EOF) {
    if (x + y * 2 + z * 4 < n) {
      printf("0\n");
      break;
    }
    n *= 2;
    for (i = 0; i <= x; i++) b[i] = 1;
    for (; i < N; i++) b[i] = 0;
    for (i = 0; i < N; i++) c[i] = 0;
    for (i = 0; i < N; i++)
      for (j = 0; j + i < N && j <= y * 2; j += 2) c[i + j] += b[i];
    for (i = 0; i < N; i++) b[i] = c[i];
    for (i = 0; i < N; i++) c[i] = 0;
    for (i = 0; i < N; i++)
      for (j = 0; j + i < N && j <= z * 4; j += 4) c[i + j] += b[i];
    printf("%d\n", c[n]);
  }
  return 0;
}
