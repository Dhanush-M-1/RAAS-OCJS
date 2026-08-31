#include <bits/stdc++.h>
int n, a[100010], b[100010], ans;
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d%d", &a[i], &b[i]);
  for (int i = 2; i < n; i++)
    if (a[i] - b[i] > a[i - 1])
      ans++;
    else if (a[i] + b[i] < a[i + 1])
      ans++, a[i] += b[i];
  if (n == 1)
    puts("1");
  else
    printf("%d\n", ans + 2);
  return 0;
}
