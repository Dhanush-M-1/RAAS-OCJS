#include <bits/stdc++.h>
using namespace std;
int n, m, k, s[1000010], p[1000010], pre[1000010];
bool used[1000010];
int main() {
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 1; i <= m; i++) {
    scanf("%d", &s[i]);
    used[s[i] + 1] = true;
  }
  for (int i = 1; i <= k; i++) {
    scanf("%d", &p[i]);
  }
  for (int i = 1; i <= n; i++) {
    if (used[i]) {
      pre[i] = pre[i - 1];
    } else {
      pre[i] = i;
    }
  }
  long long ans = (long long)1000010 * 1000010 * 1000010;
  for (int i = 1; i <= k; i++) {
    int lst = 0;
    long long now = 0;
    for (int j = 1; j <= n; j += i) {
      if (j > n) break;
      j = pre[j];
      if (j == lst) {
        now = (long long)1000010 * 1000010 * 1000010;
        break;
      }
      now += p[i];
      lst = j;
    }
    ans = min(ans, now);
  }
  printf("%I64d\n", ans == (long long)1000010 * 1000010 * 1000010 ? -1 : ans);
  return 0;
}
