#include <bits/stdc++.h>
using namespace std;
int a, b, c;
int n, i, j, k, ans;
int main() {
  scanf("%d%d%d%d", &n, &a, &b, &c);
  n *= 10;
  ans = 0;
  for (i = 0; i <= c; i++)
    for (j = 0; j <= b; j++)
      if ((n - 10 * j - 20 * i) % 5 == 0 && (n - 10 * j - 20 * i >= 0) &&
          (n - 10 * j - 20 * i) / 5 <= a)
        ans++;
  printf("%d\n", ans);
  return 0;
}
