#include <bits/stdc++.h>
using namespace std;
struct line {
  int t, l, r, d;
} p[5010];
int n, m, ans[5010], che[5010];
bool flag;
int main() {
  cin >> n >> m;
  for (int i = 1; i <= m; i++) {
    scanf("%d%d%d%d", &p[i].t, &p[i].l, &p[i].r, &p[i].d);
  }
  for (int i = 1; i <= n; i++) {
    int k = 0, Min = 1000000000;
    for (int j = 1; j <= m; j++) {
      if (p[j].l <= i && p[j].r >= i) {
        if (p[j].t == 1)
          k += p[j].d;
        else {
          Min = min(p[j].d - k, Min);
        }
      }
    }
    che[i] = ans[i] = Min;
  }
  flag = true;
  for (int i = 1; i <= m; i++) {
    int Max = -1000000000;
    for (int j = p[i].l; j <= p[i].r; j++)
      if (p[i].t == 1)
        che[j] += p[i].d;
      else {
        Max = max(Max, che[j]);
      }
    if (p[i].t == 2 && Max != p[i].d) {
      flag = false;
      break;
    }
  }
  if (flag) {
    printf("YES\n");
    for (int i = 1; i <= n; i++) printf("%d ", ans[i]);
    printf("\n");
  } else
    printf("NO\n");
  return 0;
}
