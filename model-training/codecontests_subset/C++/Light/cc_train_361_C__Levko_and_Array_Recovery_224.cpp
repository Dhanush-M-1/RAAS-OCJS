#include <bits/stdc++.h>
using namespace std;
struct Node {
  int t, l, r, x;
} p[5010];
int n, m;
int mx[5010], b[5010];
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= m; i++)
    scanf("%d%d%d%d", &p[i].t, &p[i].l, &p[i].r, &p[i].x);
  memset(b, 0, sizeof(b));
  for (int i = 1; i <= n; i++) mx[i] = 1000000000;
  for (int i = 1; i <= m; i++)
    if (p[i].t == 1)
      for (int j = p[i].l; j <= p[i].r; j++) b[j] += p[i].x;
    else {
      for (int j = p[i].l; j <= p[i].r; j++) mx[j] = min(mx[j], p[i].x - b[j]);
    }
  bool flag = true;
  for (int i = 1; i <= n; i++)
    if (abs(mx[i]) > 1000000000) flag = false;
  memset(b, 0, sizeof(b));
  for (int i = 1; i <= m && flag; i++)
    if (p[i].t == 1)
      for (int j = p[i].l; j <= p[i].r; j++) b[j] += p[i].x;
    else {
      flag = false;
      for (int j = p[i].l; j <= p[i].r; j++)
        if (mx[j] + b[j] == p[i].x) flag = true;
    }
  if (flag) {
    puts("YES");
    for (int i = 1; i <= n; i++) {
      printf("%d", mx[i]);
      if (i < n)
        printf(" ");
      else
        puts("");
    }
  } else
    puts("NO");
  return 0;
}
