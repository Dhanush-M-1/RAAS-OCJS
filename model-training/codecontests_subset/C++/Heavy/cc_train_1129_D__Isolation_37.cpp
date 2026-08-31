#include <bits/stdc++.h>
int bb[1 + 100000], dp[1 + 100000], ss[((100000 + 200 - 1) / 200)],
    dq[((100000 + 200 - 1) / 200)][200 + 1 + 200];
void update(int h) {
  int *qq = dq[h];
  int i, t, c;
  t = 0;
  memset(qq, 0, (200 + 1 + 200) * sizeof *qq);
  for (i = (h + 1) * 200; i > h * 200; i--) {
    t += bb[i];
    qq[200 + t] = (qq[200 + t] + dp[i - 1]) % 998244353;
  }
  for (c = 1; c <= 200 + 200; c++) qq[c] = (qq[c] + qq[c - 1]) % 998244353;
}
int main() {
  static int pp[1 + 100000], ii[1 + 100000];
  int n, m, k, h, i, j;
  scanf("%d%d", &n, &k);
  for (i = 1; i <= n; i++) {
    int a;
    scanf("%d", &a);
    pp[i] = ii[a];
    ii[a] = i;
  }
  dp[0] = 1;
  for (j = 1; j <= n; j++) {
    int p, x, t;
    m = (j - 1) / 200;
    ss[m] += 1 - bb[j];
    bb[j] = 1;
    if ((p = pp[j])) {
      h = (p - 1) / 200;
      ss[h] += -1 - bb[p];
      bb[p] = -1;
      if (p <= m * 200) update(h);
      if ((p = pp[p])) {
        h = (p - 1) / 200;
        ss[h] += 0 - bb[p];
        bb[p] = 0;
        if (p <= m * 200) update(h);
      }
    }
    x = 0;
    t = 0;
    ++t;
    --t;
    for (i = j; i > m * 200; i--) {
      t += bb[i];
      if (t <= k) x = (x + dp[i - 1]) % 998244353;
    }
    for (h = m - 1; h >= 0; h--) {
      if (k - t >= -200)
        x = (x + dq[h][200 + (200 < k - t ? 200 : k - t)]) % 998244353;
      t += ss[h];
    }
    dp[j] = x;
    if (j % 200 == 0) update(m);
  }
  printf("%d\n", dp[n]);
  return 0;
}
