#include <bits/stdc++.h>
using namespace std;
struct node {
  int l, r, f, w;
} q[5555];
int n, m, ans1[5555], ans2[5555];
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= m; i++)
    scanf("%d%d%d%d", &q[i].f, &q[i].l, &q[i].r, &q[i].w);
  for (int i = 1; i <= n; i++) ans1[i] = 1000000000;
  for (int i = m; i >= 1; i--) {
    if (q[i].f == 1) {
      for (int j = q[i].l; j <= q[i].r; j++) {
        if (ans1[j] != 1000000000) ans1[j] -= q[i].w;
      }
    } else {
      for (int j = q[i].l; j <= q[i].r; j++) {
        if (ans1[j] > q[i].w) ans1[j] = q[i].w;
      }
    }
  }
  for (int i = 1; i <= n; i++) ans2[i] = ans1[i];
  int flag = 1;
  for (int i = 1; i <= m; i++) {
    if (q[i].f == 1) {
      for (int j = q[i].l; j <= q[i].r; j++) {
        ans1[j] += q[i].w;
      }
    } else {
      int maxn = -1000000000;
      for (int j = q[i].l; j <= q[i].r; j++) {
        if (ans1[j] > maxn) maxn = ans1[j];
      }
      if (maxn != q[i].w) {
        flag = 0;
        break;
      }
    }
  }
  if (!flag)
    printf("NO\n");
  else {
    printf("YES\n");
    printf("%d", ans2[1]);
    for (int j = 2; j <= n; j++) printf(" %d", ans2[j]);
    printf("\n");
  }
  return 0;
}
