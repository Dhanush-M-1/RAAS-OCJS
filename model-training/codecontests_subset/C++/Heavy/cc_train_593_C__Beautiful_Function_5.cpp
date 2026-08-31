#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x[105], y[105];
  scanf("%d", &n);
  for (int i = 1, z; i <= n; i++) scanf("%d%d%d", &x[i], &y[i], &z);
  for (int i = 1; i <= n - 1; i++) printf("(");
  for (int i = 1; i <= n; i++) {
    printf("(%d*((1-abs((t-%d)))+abs((abs((t-%d))-1))))", x[i] / 2, i - 1,
           i - 1);
    if (i != 1) printf(")");
    if (i != n) printf("+");
  }
  printf("\n");
  for (int i = 1; i <= n - 1; i++) printf("(");
  for (int i = 1; i <= n; i++) {
    printf("(%d*((1-abs((t-%d)))+abs((abs((t-%d))-1))))", y[i] / 2, i - 1,
           i - 1);
    if (i != 1) printf(")");
    if (i != n) printf("+");
  }
  return 0;
}
