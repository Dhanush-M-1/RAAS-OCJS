#include <bits/stdc++.h>
int n, x[2][105];
void solve(int id) {
  for (int i = 1; i < n; i++) printf("(");
  for (int i = 1; i <= n; i++) {
    if (i != 1) printf("+");
    printf("(%d*(abs((abs((t-%d))-1))-(abs((t-%d))-1)))", x[id][i] / 2, i, i);
    if (i != 1) printf(")");
  }
  puts("");
}
int main() {
  int m, i, k, j, z;
  scanf("%d", &n);
  for (i = 1; i <= n; i++) scanf("%d%d%d", &x[0][i], &x[1][i], &z);
  solve(0);
  solve(1);
  return 0;
}
