#include <bits/stdc++.h>
const int N = 100010;
const long long MOD = 1e9 + 7;
using namespace std;
int n, x[N], y[N];
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d%d%*d", &x[i], &y[i]);
  for (int i = 1; i <= n - 1; i++) printf("(");
  for (int i = 1; i <= n; i++) {
    printf("(%d*((1-abs((t-%d)))+abs((abs((t-%d))-1))))", x[i] / 2, i, i);
    if (i > 1) printf(")");
    if (i < n) printf("+");
  }
  printf("\n");
  for (int i = 1; i <= n - 1; i++) printf("(");
  for (int i = 1; i <= n; i++) {
    printf("(%d*((1-abs((t-%d)))+abs((abs((t-%d))-1))))", y[i] / 2, i, i);
    if (i > 1) printf(")");
    if (i < n) printf("+");
  }
  printf("\n");
  return 0;
}
