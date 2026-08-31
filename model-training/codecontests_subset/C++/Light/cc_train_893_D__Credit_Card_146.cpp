#include <bits/stdc++.h>
int n, a[100005], cnt, ans;
long long d, l[100005], r[100005], sum[100005];
int main() {
  scanf("%d %lld", &n, &d);
  for (int i = 1; i <= n; i++) {
    scanf("%d", a + i);
    sum[i] = sum[i - 1] + a[i];
  }
  long long mx = -1e15;
  for (int i = n; i >= 1; i--) {
    mx = std::max(sum[i], mx);
    if (mx > d) return !printf("-1");
    r[i] = d - mx;
  }
  for (int i = 1; i <= n; i++) {
    if (a[i] == 0) {
      if (sum[i] + r[i] < 0) return !printf("-1");
      if (sum[i] + cnt < 0) {
        ++ans;
        cnt = r[i];
      }
    }
  }
  printf("%d", ans);
}
