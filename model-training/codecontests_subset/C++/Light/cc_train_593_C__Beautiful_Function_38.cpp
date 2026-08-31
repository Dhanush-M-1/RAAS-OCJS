#include <bits/stdc++.h>
using namespace std;
const int N = 55;
int x[N], y[N];
int main() {
  int n, z;
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) scanf("%d%d%d", &x[i], &y[i], &z);
  for (int i = 1; i <= n - 1; ++i) printf("(");
  for (int i = 1; i <= n; ++i) {
    printf("(%d*((1-abs((t-%d)))+abs((abs((t-%d))-1))))", x[i] / 2, i, i);
    if (i > 1) printf(")");
    if (i < n) printf("+");
  }
  puts("");
  for (int i = 1; i <= n - 1; ++i) printf("(");
  for (int i = 1; i <= n; ++i) {
    printf("(%d*((1-abs((t-%d)))+abs((abs((t-%d))-1))))", y[i] / 2, i, i);
    if (i > 1) printf(")");
    if (i < n) printf("+");
  }
  return 0;
}
