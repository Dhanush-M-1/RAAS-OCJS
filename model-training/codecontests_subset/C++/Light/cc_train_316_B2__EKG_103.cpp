#include <bits/stdc++.h>
using namespace std;
int a[1010], g[1010], d[1010];
bool f[1010];
int main() {
  int n, k;
  scanf("%d%d", &n, &k);
  for (int i = 1; i <= n; i++) scanf("%d", &a[i]);
  for (int i = 1; i <= n; i++) {
    for (g[i] = i; a[g[i]]; g[i] = a[g[i]])
      ;
  }
  for (int i = 1; i <= n; i++) d[g[i]]++;
  d[g[k]] = 0;
  int add = 0;
  for (int i = k; i; i = a[i]) add++;
  f[0] = true;
  for (int i = 1; i <= n; i++) {
    if (!d[i]) continue;
    for (int j = n; j >= d[i]; j--) {
      f[j] |= f[j - d[i]];
    }
  }
  for (int i = 0; i <= n; i++)
    if (f[i]) printf("%d\n", i + add);
  return 0;
}
