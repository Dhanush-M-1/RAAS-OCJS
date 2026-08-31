#include <bits/stdc++.h>
const int N = 100005;
int n;
long long fa[N], k[N];
double a[N];
int main() {
  scanf("%d", &n);
  long long x;
  for (int i = 1; i <= n; ++i) scanf("%lf", &a[i]);
  for (int i = 1; i <= n; ++i) scanf("%lld", &x), a[i] -= x;
  for (int i = 2; i <= n; ++i) scanf("%lld%lld", &fa[i], &k[i]);
  for (int i = n; i >= 2; --i)
    if (a[i] < 0)
      a[fa[i]] += a[i] * k[i];
    else
      a[fa[i]] += a[i];
  puts(a[1] < 0 ? "NO" : "YES");
  return 0;
}
