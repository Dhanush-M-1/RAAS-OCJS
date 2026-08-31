#include <bits/stdc++.h>
using namespace std;
const int N = 1000000 + 100;
const int LEN = 5000000 + 100;
int n, r, c, ans, pos, cnt, a[N], p[N], L[N], fa[N][20];
char str[LEN + N * 2], *st[N];
inline void solve(int now) {
  int t = now;
  for (int i = 19, k = r - 1; ~i && k; --i)
    if ((1 << i) <= k && ~fa[t][i]) t = fa[t][i], k -= 1 << i;
  t = now - L[t] + 1;
  if (t > ans) ans = t, pos = now;
}
int main(int argc, char **argv) {
  scanf("%d%d%d", &n, &r, &c);
  ++c;
  for (int i = 1; i <= n; ++i) {
    st[i] = str + a[i - 1] + i;
    scanf("%s", st[i]);
    a[i] = strlen(st[i]) + 1 + a[i - 1];
  }
  for (int i = 1, j = 1; i <= n; ++i) {
    while (a[i] - a[j - 1] > c) ++j;
    L[i] = j;
  }
  for (int i = 1; i <= n; ++i) {
    if (L[i] > i) continue;
    if (L[i] == 1 || L[L[i] - 1] > L[i] - 1)
      fa[i][0] = -1;
    else
      fa[i][0] = L[i] - 1;
    for (int j = 0; j < 19; ++j)
      fa[i][j + 1] = ~fa[i][j] ? fa[fa[i][j]][j] : -1;
    solve(i);
  }
  if (ans) {
    for (p[cnt = 1] = pos; cnt < r && L[p[cnt]] > 1 && L[p[cnt]] <= p[cnt];
         ++cnt)
      p[cnt + 1] = L[p[cnt]] - 1;
    for (int i = cnt; i; --i)
      for (int j = L[p[i]]; j <= p[i]; ++j)
        printf("%s%c", st[j], " \n"[j == p[i]]);
  }
  return 0;
}
