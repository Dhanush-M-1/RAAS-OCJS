#include <bits/stdc++.h>
using namespace std;
const int maxn = 1009;
int w[maxn], b[maxn], a[maxn], flag[maxn], n, m, top, p, ans;
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) scanf("%d", &w[i]);
  for (int i = 1; i <= m; i++) {
    scanf("%d", &b[i]);
    if (!flag[b[i]]) a[++top] = b[i];
    flag[b[i]] = 1;
  }
  for (int i = 1; i <= m; i++) {
    p = 1;
    while (a[p] != b[i]) {
      ans += w[a[p]];
      p++;
    }
    while (p >= 2) {
      swap(a[p], a[p - 1]);
      p--;
    }
  }
  printf("%d\n", ans);
  return 0;
}
