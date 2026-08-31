#include <bits/stdc++.h>
using namespace std;
void solve(int x[55], int n) {
  for (int i = 1; i < n; ++i) printf("(");
  for (int i = 1; i <= n; ++i) {
    int k = x[i] / 2;
    printf("(%d*((1-abs((t-%d)))+abs((abs((t-%d))-1))))", k, i, i);
    if (i != 1) printf(")");
    if (i != n) printf("+");
  }
  printf("\n");
}
int main() {
  int n, i, x[55], y[55], r[55];
  cin >> n;
  for (i = 1; i <= n; i++) scanf("%d%d%d", &x[i], &y[i], &r[i]);
  solve(x, n);
  solve(y, n);
  return 0;
}
