#include <bits/stdc++.h>
using namespace std;
const int maxn = 5333;
const int INF = 5e7 + 233;
struct node {
  int op, l, r, m;
  void input() { scanf("%d%d%d%d", &op, &l, &r, &m); }
} p[maxn];
int ans[maxn], ans1[maxn];
int main(void) {
  int n, m;
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= m; i++) p[i].input();
  for (int i = 1; i <= n; i++) ans1[i] = INF;
  for (int i = m; i >= 1; i--) {
    if (p[i].op == 1) {
      for (int j = p[i].l; j <= p[i].r; j++) ans1[j] -= p[i].m;
    } else {
      for (int j = p[i].l; j <= p[i].r; j++) ans1[j] = min(ans1[j], p[i].m);
    }
  }
  for (int i = 1; i <= n; i++) ans[i] = ans1[i];
  int flag = 0;
  for (int i = 1; i <= m; i++) {
    if (p[i].op == 1) {
      for (int j = p[i].l; j <= p[i].r; j++) ans1[j] += p[i].m;
    } else {
      int ma = -INF * 2;
      for (int j = p[i].l; j <= p[i].r; j++) ma = max(ans1[j], ma);
      if (ma != p[i].m) {
        flag = 1;
        break;
      }
    }
  }
  if (flag)
    puts("NO");
  else {
    puts("YES");
    for (int i = 1; i <= n; i++) {
      if (i == n)
        printf("%d\n", ans[i]);
      else
        printf("%d ", ans[i]);
    }
  }
  return 0;
}
