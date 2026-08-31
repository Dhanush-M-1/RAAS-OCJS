#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:1024000000,1024000000")
using namespace std;
struct node {
  int t, l, r, m;
} op[5005];
int a[5005], b[5005], n, m;
bool solve() {
  int p, i, k;
  for (i = 1; i <= n; i++) a[i] = 1000000000;
  memset(b, 0, sizeof(b));
  for (p = 1; p <= m; p++)
    if (op[p].t == 1)
      for (i = op[p].l; i <= op[p].r; i++) b[i] += op[p].m;
    else
      for (i = op[p].l; i <= op[p].r; i++) a[i] = min(a[i], op[p].m - b[i]);
  memset(b, 0, sizeof(b));
  for (p = 1; p <= m; p++)
    if (op[p].t == 1)
      for (i = op[p].l; i <= op[p].r; i++) b[i] += op[p].m;
    else {
      k = -1000000007;
      for (i = op[p].l; i <= op[p].r; i++) k = max(k, a[i] + b[i]);
      if (k != op[p].m) return false;
    }
  return true;
}
int main() {
  int i;
  scanf("%d%d", &n, &m);
  for (i = 1; i <= m; i++)
    scanf("%d%d%d%d", &op[i].t, &op[i].l, &op[i].r, &op[i].m);
  if (!solve())
    puts("NO");
  else {
    puts("YES");
    for (i = 1; i <= n; i++) printf("%d ", a[i]);
    puts("");
  }
  return 0;
}
