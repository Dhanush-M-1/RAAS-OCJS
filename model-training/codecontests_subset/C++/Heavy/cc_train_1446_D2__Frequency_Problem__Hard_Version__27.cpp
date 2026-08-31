#include <bits/stdc++.h>
using namespace std;
void read(int &x) {
  char ch = getchar();
  x = 0;
  while (!isdigit(ch)) ch = getchar();
  while (isdigit(ch)) x = x * 10 + ch - 48, ch = getchar();
}
const int N = 2e5 + 5;
int n, m, val, res, a[N], cnt[N], w[N * 2], c[N], cc[N], t[N], tp;
void modify(int x, int o) { --cc[c[x]], c[x] += o, ++cc[c[x]]; }
signed main() {
  read(n);
  m = sqrt(n);
  for (int i = 1; i <= n; ++i) read(a[i]), ++cnt[a[i]];
  int mx = 0, num = 0;
  for (int i = 1; i <= n; ++i)
    if (cnt[i] == mx)
      ++num;
    else if (cnt[i] > mx)
      mx = cnt[i], num = 1;
  if (num > 1) return printf("%d\n", n), 0;
  for (int i = 1; i <= n; ++i)
    if (cnt[i] == mx)
      val = i;
    else if (cnt[i] > m)
      t[++tp] = i;
  for (int p = 1; p <= tp; ++p) {
    int i = t[p], s = n, la = n;
    memset(w, 0x3f, sizeof(w));
    for (int j = 1; j <= n; ++j) {
      if (a[j] == i) --s;
      if (a[j] == val) ++s;
      res = max(res, j - w[s] + 1);
      w[la] = min(w[la], j);
      la = s;
    }
  }
  for (int i = 1; i <= m; ++i) {
    memset(c, 0, sizeof(c));
    memset(cc, 0, sizeof(cc));
    int l = 1, r = 0;
    while (r < n) {
      ++r, modify(a[r], 1);
      while (c[a[r]] > i) modify(a[l], -1), ++l;
      if (cc[i] >= 2) res = max(res, r - l + 1);
    }
  }
  return printf("%d\n", res), 0;
}
