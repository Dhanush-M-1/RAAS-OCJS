#include <bits/stdc++.h>
using namespace std;
int g[100010];
int f;
int main() {
  int n, i, j, ok = 0, x, y;
  scanf("%d", &n);
  for (i = 1; i < n; i++) {
    scanf("%d%d", &x, &y);
    g[x]++;
    g[y]++;
  }
  for (i = 1; i <= n; i++) {
    if (g[i] == 1) f++;
    if (g[i] == 2) ok = 1;
  }
  f = (f * (f - 1)) / 2;
  if (ok)
    printf("NO");
  else
    printf("YES");
}
