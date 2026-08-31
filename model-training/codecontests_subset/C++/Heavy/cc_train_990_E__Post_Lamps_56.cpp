#include <bits/stdc++.h>
using namespace std;
int n, m, k;
int s[1000005];
long long a[1000005];
int head[1000005];
int main() {
  memset(s, 0, sizeof(s));
  memset(a, 0, sizeof(a));
  scanf("%d%d%d", &n, &m, &k);
  int tmp;
  for (int i = 1; i <= m; i++) {
    scanf("%d", &tmp);
    s[tmp] = 1;
  }
  for (int i = 1; i <= k; i++) scanf("%lld", &a[i]);
  if (s[0] == 1) {
    printf("-1\n");
    return 0;
  }
  for (int i = 0; i < n; i++) {
    if (s[i])
      head[i] = head[i - 1];
    else
      head[i] = i;
  }
  long long ans = 0x7fffffffffffffff;
  for (int i = 1; i <= k; i++) {
    int now = 0;
    long long tmp = 1;
    while (1) {
      if (now + i > n - 1) {
        long long ans1 = tmp * a[i];
        ans = min(ans, ans1);
        break;
      }
      if (now == head[now + i]) {
        break;
      }
      now = head[now + i];
      tmp++;
    }
  }
  if (ans == 0x7fffffffffffffff)
    printf("-1\n");
  else
    printf("%lld\n", ans);
  return 0;
}
