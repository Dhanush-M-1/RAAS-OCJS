#include <bits/stdc++.h>
using namespace std;
int n, a, b, c, i, j, an;
int main() {
  scanf("%d%d%d%d", &n, &a, &b, &c);
  an = 0;
  for (i = 0; i <= c; ++i)
    for (j = 0; j <= b; ++j)
      if (i + i + j <= n && (n - i - i - j) * 2 <= a) ++an;
  printf("%d\n", an);
  return 0;
}
