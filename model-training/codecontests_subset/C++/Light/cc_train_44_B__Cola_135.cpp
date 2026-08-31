#include <bits/stdc++.h>
using namespace std;
int l, r;
int win;
int min1(int a, int b) { return a > b ? b : a; }
int main() {
  int n;
  int a, b, c, i, j, k, m, t;
  while (scanf("%d%d%d%d", &n, &a, &b, &c) != EOF) {
    n = (n << 1);
    int sum = 0, hold;
    for (i = 0; i <= b; i++) {
      for (j = 0; j <= c; j++) {
        if ((i * 2) + (j * 4) <= n) {
          hold = n - 2 * i - 4 * j;
          if (hold >= 0 && hold <= a) {
            sum++;
          }
        }
      }
    }
    printf("%d\n", sum);
  }
}
