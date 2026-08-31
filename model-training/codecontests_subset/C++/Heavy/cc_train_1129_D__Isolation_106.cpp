#include <bits/stdc++.h>
using namespace std;
int n, k, flag[310], ret[310], a[100100], pos[100100], lst[100100], w[100100],
    f[100100], cnt[310][100100];
int mo(int x, int y) { return x + y < 998244353 ? x + y : x + y - 998244353; }
void add(int l, int r, int x) {
  int s = (l - 1) / 350 + 1, t = r / 350 + 1;
  if (s == t) {
    for (int i = l; i <= r; i++) {
      w[i] += x;
      cnt[s][w[i] - x] = mo(cnt[s][w[i] - x], 998244353 - f[i - 1]),
                    cnt[s][w[i]] = mo(cnt[s][w[i]], f[i - 1]);
      if (x == 1 && w[i] == k - flag[s] + 1)
        ret[s] = mo(ret[s], 998244353 - f[i - 1]);
      else if (x == -1 && w[i] == k - flag[s])
        ret[s] = mo(ret[s], f[i - 1]);
    }
    return;
  }
  for (int i = l; i <= s * 350; i++) {
    w[i] += x;
    cnt[s][w[i] - x] = mo(cnt[s][w[i] - x], 998244353 - f[i - 1]),
                  cnt[s][w[i]] = mo(cnt[s][w[i]], f[i - 1]);
    if (x == 1 && w[i] - 1 == k - flag[s])
      ret[s] = mo(ret[s], 998244353 - f[i - 1]);
    else if (x == -1 && w[i] == k - flag[s])
      ret[s] = mo(ret[s], f[i - 1]);
  }
  for (int i = s + 1; i < t; i++) {
    flag[i] += x;
    if (x == 1)
      ret[i] = mo(ret[i], 998244353 - cnt[i][k - flag[i] + 1]);
    else
      ret[i] = mo(ret[i], cnt[i][k - flag[i]]);
  }
  for (int i = (t - 1) * 350 + 1; i <= r; i++) {
    w[i] += x;
    cnt[t][w[i] - x] = mo(cnt[t][w[i] - x], 998244353 - f[i - 1]),
                  cnt[t][w[i]] = mo(cnt[t][w[i]], f[i - 1]);
    if (x == 1 && w[i] - 1 == k - flag[t])
      ret[t] = mo(ret[t], 998244353 - f[i - 1]);
    else if (x == -1 && w[i] == k - flag[t])
      ret[t] = mo(ret[t], f[i - 1]);
  }
}
int main() {
  scanf("%d%d", &n, &k);
  for (int i = 1; i <= n; i++) scanf("%d", &a[i]);
  for (int i = 1; i <= n; i++) lst[i] = pos[a[i]], pos[a[i]] = i;
  f[0] = 1;
  for (int i = 1; i <= n; i++) {
    add(lst[i] + 1, i - 1, 1);
    if (lst[i]) add(lst[lst[i]] + 1, lst[i], -1);
    for (int j = 1; j <= (i - 1) / 350 + 1; j++) f[i] = mo(f[i], ret[j]);
    if (k >= 1)
      f[i] = mo(f[i], f[i - 1]),
      ret[(i - 1) / 350 + 1] = mo(ret[(i - 1) / 350 + 1], f[i - 1]);
    w[i] = 1;
    cnt[(i - 1) / 350 + 1][1] = mo(cnt[(i - 1) / 350 + 1][1], f[i - 1]);
  }
  printf("%d\n", f[n]);
}
