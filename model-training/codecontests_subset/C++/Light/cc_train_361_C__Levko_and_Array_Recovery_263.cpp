#include <bits/stdc++.h>
using namespace std;
const int MaxN = 1e5;
struct NOOD {
  int flag;
  int l;
  int r;
  int v;
} num[MaxN + 5];
int ans[MaxN + 5], p[MaxN + 5];
bool ok[MaxN + 5], flag;
int Max;
int n, m;
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= m; i++) {
    scanf("%d%d%d%d", &num[i].flag, &num[i].l, &num[i].r, &num[i].v);
  }
  for (int i = 1; i <= n; i++) ans[i] = -100000000;
  for (int i = m; i >= 1; i--) {
    if (num[i].flag == 1) {
      for (int j = num[i].l; j <= num[i].r; j++) ans[j] -= num[i].v;
    } else {
      for (int j = num[i].l; j <= num[i].r; j++) {
        if (ok[j] && ans[j] < num[i].v) continue;
        ans[j] = num[i].v;
        ok[j] = 1;
      }
    }
  }
  for (int i = 1; i <= n; i++) p[i] = ans[i];
  for (int i = 1; i <= m; i++) {
    if (num[i].flag == 1) {
      for (int j = num[i].l; j <= num[i].r; j++) p[j] += num[i].v;
    } else {
      Max = -100000000;
      for (int j = num[i].l; j <= num[i].r; j++) Max = max(Max, p[j]);
      if (Max != num[i].v) flag = 1;
    }
  }
  if (flag)
    printf("NO\n");
  else {
    printf("YES\n");
    for (int i = 1; i <= n; i++) printf("%d ", ans[i]);
    printf("\n");
  }
}
