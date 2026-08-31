#include <bits/stdc++.h>
using namespace std;
int tmp[5000000 + 5], a[5000000 + 5], p[5000000 + 5], n, r, c, ans[5000000 + 5],
    k[5000000 + 5], cnt = 0, w[5000000 + 5][2];
char s[2 * 5000000 + 5];
void multy(int *a, int *b) {
  for (int i = 0; i <= n + 1; i++) k[i] = b[a[i]];
  for (int i = 0; i <= n + 1; i++) a[i] = k[i];
}
int main() {
  scanf("%d%d%d", &n, &r, &c);
  getchar();
  gets(s);
  cnt = 1;
  int l = strlen(s);
  for (int i = 0; i <= l; i++)
    if (i == l || s[i] == ' ') w[cnt][1] = i, w[++cnt][0] = i + 1;
  for (int i = 1, j = 0; i <= n; i++) {
    while (j <= n && w[j][1] - w[i][0] <= c) j++;
    if (j <= i)
      p[i] = j = i;
    else
      p[i] = j;
  }
  p[n + 1] = n + 1;
  for (int i = 0; i <= n + 1; i++) ans[i] = i, tmp[i] = p[i];
  while (r) {
    if (r & 1) multy(ans, tmp);
    multy(tmp, tmp), r >>= 1;
  }
  int mx = 0;
  for (int i = 1; i <= n; i++)
    if (ans[i] - i > ans[mx] - mx) mx = i;
  int now = mx;
  while (now < ans[mx]) {
    for (int i = w[now][0]; i < w[p[now] - 1][1]; i++) putchar(s[i]);
    puts("");
    now = p[now];
  }
  return 0;
}
