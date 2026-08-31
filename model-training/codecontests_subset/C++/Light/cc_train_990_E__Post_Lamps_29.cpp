#include <bits/stdc++.h>
const int MAXN = 1e6 + 10;
int n;
int m;
int k;
int a[MAXN];
int cnt[MAXN];
bool blk[MAXN];
int main() {
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 0; i < m; i++) {
    int tmp;
    scanf("%d", &tmp);
    blk[tmp] = true;
  }
  for (int i = 1; i <= k; i++) scanf("%d", a + i);
  if (blk[0]) {
    puts("-1");
    return 0;
  }
  int maxl = 0;
  for (int i = 0; i < n; i++) {
    if (blk[i]) {
      cnt[i] = cnt[i - 1] + blk[i];
      maxl = std::max(maxl, cnt[i]);
    }
  }
  long long ans = LLONG_MAX;
  for (int i = maxl + 1; i <= k; i++) {
    int now = 0;
    long long sum = 0;
    while (now < n) {
      if (blk[now])
        now -= cnt[now];
      else {
        sum += a[i];
        now += i;
      }
    }
    ans = std::min(ans, sum);
  }
  if (ans == LLONG_MAX)
    puts("-1");
  else
    printf("%I64d\n", ans);
  return 0;
}
