#include <bits/stdc++.h>
using namespace std;
int n, m, i, size[12000], b[12000], a[12000], num, fa[12000], j;
int get(int x) { return fa[x] == x ? x : (fa[x] = get(fa[x])); }
int main() {
  scanf("%d%d", &n, &m);
  for (i = 1; i <= n; ++i) fa[i] = i;
  for (i = 1; i <= n; ++i) {
    scanf("%d", &a[i]);
    if (a[i]) fa[i] = a[i];
  }
  for (i = 1; i <= n; ++i) size[get(i)]++;
  b[0] = 1;
  for (i = 1; i <= n; ++i)
    if (get(i) == i && get(m) != get(i))
      for (j = n - size[i]; j >= 0; --j) b[j + size[i]] |= b[j];
  for (i = m; i; i = a[i]) num++;
  for (i = 0; i <= n; ++i)
    if (b[i]) printf("%d\n", i + num);
}
