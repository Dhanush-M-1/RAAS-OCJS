#include <bits/stdc++.h>
const double Pi = acos(-1.0);
using namespace std;
int a[1005], g[1005], c[1005], dp[1005];
int main(void) {
  int n, x;
  scanf("%d%d", &n, &x);
  for (int i = 1; i <= n; i++) scanf("%d", &a[i]);
  for (int i = 1; i <= n; i++)
    for (g[i] = i; a[g[i]]; g[i] = a[g[i]])
      ;
  for (int i = 1; i <= n; i++) c[g[i]]++;
  c[g[x]] = 0;
  int ans = 0;
  for (int i = x; i; i = a[i]) ++ans;
  dp[0] = 1;
  for (int i = 1; i <= n; i++)
    if (c[i])
      for (int j = n - c[i]; j >= 0; j--) dp[j + c[i]] |= dp[j];
  for (int i = 0; i <= n; i++)
    if (dp[i]) printf("%d\n", i + ans);
  return 0;
}
