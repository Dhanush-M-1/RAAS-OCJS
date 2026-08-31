#include <bits/stdc++.h>
using namespace std;
int n, i, j, k, a, b, c, ans;
int main() {
  scanf("%d%d%d%d", &n, &a, &b, &c);
  a = a / 2;
  for (i = 0; i <= a; i++)
    for (j = 0; j <= b; j++)
      if (i + j <= n && i + j + 2 * c >= n && (n - i - j) % 2 == 0) ans++;
  printf("%d\n", ans);
  return 0;
}
