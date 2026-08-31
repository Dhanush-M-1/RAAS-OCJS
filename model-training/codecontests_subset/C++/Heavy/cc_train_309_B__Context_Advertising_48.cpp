#include <bits/stdc++.h>
const int maxn = 6000010;
using namespace std;
int n, r, c, bel[maxn], st[maxn], ed[maxn], fa[maxn / 5][21];
char s[maxn];
int main() {
  scanf("%d%d%d\n", &n, &r, &c);
  gets(s + 1);
  int len = strlen(s + 1) + 1;
  s[len] = ' ';
  for (int i = 1, now = 1; i <= len; ++i) {
    bel[i] = now;
    if (s[i] == ' ') ++now;
  }
  for (int i = len; i; --i) st[bel[i]] = i;
  for (int i = 1; i <= len; ++i) ed[bel[i]] = i;
  for (int i = 1; i <= n; ++i)
    if (st[i] + c - 1 <= len) {
      if (ed[bel[st[i] + c - 1]] <= st[i] + c)
        fa[i][0] = bel[st[i] + c - 1] + 1;
      else
        fa[i][0] = bel[st[i] + c - 1];
    } else
      fa[i][0] = n + 1;
  for (int j = 0; (1 << j) <= r; ++j) fa[n + 1][j] = n + 1;
  for (int j = 1; (1 << j) <= r; ++j)
    for (int i = 1; i <= n; ++i) fa[i][j] = fa[fa[i][j - 1]][j - 1];
  int ans = 0, _ans = 0;
  for (int i = 1; i <= n; ++i) {
    int tmp = r, x = i;
    for (int j = 20; j >= 0; --j)
      if ((tmp >> j) & 1) x = fa[x][j];
    if (x - i > ans) ans = x - i, _ans = i;
  }
  for (int i = _ans; i <= _ans + ans - 1;) {
    for (int j = st[i]; j < ed[fa[i][0] - 1]; ++j) printf("%c", s[j]);
    i = fa[i][0], printf("\n");
  }
  return 0;
}
