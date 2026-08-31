#include <bits/stdc++.h>
using namespace std;
const int qq = 5005;
const int MAXN = 1e9;
struct Node {
  int t, l, r, x;
} node[qq];
int a[qq], b[qq], n, m;
bool solve() {
  for (int i = 1; i <= n; ++i) a[i] = 1e9;
  memset(b, 0, sizeof(b));
  for (int i = 1; i <= m; ++i)
    if (node[i].t == 1)
      for (int j = node[i].l; j <= node[i].r; ++j) b[j] += node[i].x;
    else
      for (int j = node[i].l; j <= node[i].r; ++j)
        a[j] = min(a[j], node[i].x - b[j]);
  memset(b, 0, sizeof(b));
  int k;
  for (int i = 1; i <= m; ++i)
    if (node[i].t == 1)
      for (int j = node[i].l; j <= node[i].r; ++j) b[j] += node[i].x;
    else {
      k = -MAXN;
      for (int j = node[i].l; j <= node[i].r; ++j) k = max(k, a[j] + b[j]);
      if (k != node[i].x) return false;
    }
  return true;
}
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= m; ++i)
    scanf("%d%d%d%d", &node[i].t, &node[i].l, &node[i].r, &node[i].x);
  if (!solve())
    puts("NO");
  else {
    puts("YES");
    for (int i = 1; i <= n; ++i) printf("%d ", a[i]);
    puts("");
  }
  return 0;
}
