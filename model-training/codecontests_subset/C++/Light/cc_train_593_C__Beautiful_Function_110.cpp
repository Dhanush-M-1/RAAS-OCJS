#include <bits/stdc++.h>
const int MAXN = 60;
int n, r;
int x[MAXN], y[MAXN];
void solve(int *x) {
  int t;
  for (int i = 1; i <= n; ++i) putchar('(');
  for (int i = 1; i <= n; ++i) {
    int t = x[i] + 1 >> 1;
    if (i > 1) putchar('(');
    printf("%d*((1-abs((t-%d)))+abs((abs((t-%d))-1))))", t, i - 1, i - 1);
    if (i > 1) putchar(')');
    if (i != n) putchar('+');
  }
  puts("");
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) scanf("%d%d%d", &x[i], &y[i], &r);
  solve(x), solve(y);
  return 0;
}
