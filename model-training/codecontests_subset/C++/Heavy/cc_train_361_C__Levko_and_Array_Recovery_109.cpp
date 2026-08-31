#include <bits/stdc++.h>
using namespace std;
int num[5005], out[5005], n, m;
struct node {
  int t, l, r, d;
} dd[5005];
int main() {
  scanf("%d%d", &n, &m);
  int flag = 0;
  for (int i = 1; i <= m; i++)
    scanf("%d%d%d%d", &dd[i].t, &dd[i].l, &dd[i].r, &dd[i].d);
  for (int i = 0; i <= n; i++) num[i] = out[i] = 1000000000;
  for (int i = m; i >= 1; i--) {
    if (dd[i].t == 1) {
      for (int j = dd[i].l; j <= dd[i].r; j++) {
        num[j] -= dd[i].d;
        out[j] = num[j];
      }
    } else if (dd[i].t == 2) {
      for (int j = dd[i].l; j <= dd[i].r; j++)
        num[j] = min(num[j], dd[i].d), out[j] = num[j];
    }
  }
  for (int i = 1; i <= m; i++) {
    if (dd[i].t == 1) {
      for (int j = dd[i].l; j <= dd[i].r; j++) num[j] += dd[i].d;
    } else if (dd[i].t == 2) {
      int tmp = 0;
      for (int j = dd[i].l; j <= dd[i].r; j++) {
        if (num[j] > dd[i].d) flag = 1;
        if (num[j] == dd[i].d) tmp = 1;
      }
      if (!tmp) flag = 1;
    }
  }
  if (flag)
    printf("NO\n");
  else {
    printf("YES\n");
    for (int i = 1; i <= n; i++) {
      if (out[i] > 1000000000)
        printf("1000000000 ");
      else
        printf("%d ", out[i]);
    }
    puts("");
  }
  return 0;
}
