#include <bits/stdc++.h>
using namespace std;
int cvt[1000010];
int cost[1000010];
int n, m, k;
int main(void) {
  scanf("%d%d%d", &n, &m, &k);
  int tmp;
  while (m--) {
    scanf("%d", &tmp);
    if (tmp == 0) {
      printf("-1");
      return 0;
    }
    cvt[tmp] = 1;
  }
  for (int i = 1; i <= k; i++) scanf("%d", &cost[i]);
  int lastok = 0;
  int maxlen = 0;
  int tlen = 0;
  for (int i = 1; i <= n; i++) {
    if (cvt[i]) {
      cvt[i] = lastok;
      tlen++;
      maxlen = max(maxlen, tlen);
    } else {
      lastok = i;
      cvt[i] = i;
      tlen = 0;
    }
  }
  if (maxlen + 1 > k) {
    printf("-1");
    return 0;
  }
  long long ans = 1ll * 2147483647 * 2147483647;
  for (int t = max(1, maxlen + 1); t <= k; t++) {
    int tcos = 0;
    int pos = 0;
    while (pos < n) {
      tcos++;
      pos = pos + t >= n ? n : cvt[pos + t];
    }
    ans = min(ans, 1ll * tcos * cost[t]);
  }
  cout << ans;
  return 0;
}
