#include <bits/stdc++.h>
const int mxn = 1e6 + 6;
int n, r, c, t = 1, fr[mxn], nxt[mxn], ans[mxn];
char s[6 * mxn];
inline void dfs(int x) {
  if (!x) return;
  dfs(x >> 1);
  for (int i = 1; i <= n; ++i) {
    ans[i] = ans[ans[i]];
    if (x & 1) ans[i] = nxt[ans[i]];
  }
}
int main() {
  scanf("%d%d%d", &n, &r, &c);
  for (int i = 1; i <= n; ++i)
    scanf("%s", s + fr[i]), fr[i + 1] = fr[i] + strlen(s + fr[i]),
                                   s[fr[i + 1]++] = ' ';
  for (int i = n + 1, j = n + 1; i; nxt[ans[i] = i] = j, --i)
    for (; fr[j] - fr[i] > c + 1; --j)
      ;
  dfs(r);
  for (int i = 2; i <= n; ++i)
    if (ans[i] - i > ans[t] - t) t = i;
  for (int i = 1; i <= r; ++i, t = nxt[t], putchar('\n'))
    for (int j = fr[t]; j + 1 < fr[nxt[t]]; j++) putchar(s[j]);
}
