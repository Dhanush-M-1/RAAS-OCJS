#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, x[51], y[51], r[51];
  while (cin >> n) {
    for (i = 0; i < n; i++) scanf("%d%d%d", &x[i], &y[i], &r[i]);
    for (i = 1; i < n; i++) printf("(");
    for (i = 0; i < n; i++) {
      printf("(%d*((1-abs((t-%d)))+abs((abs((t-%d))-1))))", x[i] / 2, i, i);
      if (i) printf(")");
      if (i != n - 1) printf("+");
    }
    printf("\n");
    for (i = 1; i < n; i++) printf("(");
    for (i = 0; i < n; i++) {
      printf("(%d*((1-abs((t-%d)))+abs((abs((t-%d))-1))))", y[i] / 2, i, i);
      if (i) printf(")");
      if (i != n - 1) printf("+");
    }
    printf("\n");
  }
}
