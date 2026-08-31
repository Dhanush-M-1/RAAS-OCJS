#include <bits/stdc++.h>
int main() {
  int i, n, sum = 0, m, c = 0, c1 = 0;
  scanf("%d", &n);
  for (i = 1; i <= n; i++) {
    scanf("%d", &m);
    if (m == 200)
      c++;
    else
      c1++;
    sum += m;
  }
  if (n < 2 || sum % 200 != 0 || (c % 2 == 1 && c1 == 0)) {
    printf("NO\n");
  } else
    printf("YES\n");
  return 0;
}
