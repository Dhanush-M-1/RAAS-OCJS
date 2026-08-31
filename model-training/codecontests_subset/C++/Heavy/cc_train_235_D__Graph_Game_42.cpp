#include <bits/stdc++.h>
using namespace std;
struct node {
  int t, n;
} e[11000];
int fi[11000], di[11000], q[11000];
bool used[11000], in[11000];
int n, tot, len;
double ans;
inline void insert(const int& x, const int& y) {
  e[++tot] = (node){y, fi[x]}, fi[x] = tot;
}
void dfs(int x, int l1, int l2) {
  used[x] = true;
  if (l2 <= 1)
    ans += 1.0 / l1;
  else
    ans += 1.0 / l1 + 1.0 / (l1 - l2 + len - l2 + 2) - 1.0 / (l1 - l2 + len);
  for (int i = fi[x]; i != -1; i = e[i].n)
    if (!used[e[i].t]) dfs(e[i].t, l1 + 1, l2 + in[e[i].t]);
}
int main(void) {
  scanf("%d", &n), fill(fi, fi + n + 1, -1), tot = 1;
  for (int i = 1; i <= n; i++) {
    int x, y;
    scanf("%d%d", &x, &y), x++, y++;
    insert(x, y), insert(y, x), di[x]++, di[y]++;
  }
  int h = 1, t = 0;
  for (int i = 1; i <= n; i++)
    if (di[i] == 1) q[++t] = i;
  while (h <= t) {
    for (int i = fi[q[h]]; i != -1; i = e[i].n)
      if ((--di[e[i].t]) == 1) q[++t] = e[i].t;
    h++;
  }
  len = n - t;
  for (int i = 1; i <= n; i++)
    if (di[i] > 1) in[i] = true;
  for (int i = 1; i <= n; i++)
    fill(used, used + n + 1, false), dfs(i, 1, in[i]);
  printf("%.8lf\n", ans);
  return 0;
}
