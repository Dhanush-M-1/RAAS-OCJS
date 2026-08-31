#include <bits/stdc++.h>
using namespace std;
long long num_a[200010], num_b[200010], sum_a[200010], sum_b[200010];
long long n, k, a, b, q, ans;
long long lowbit(long long x) { return (-x) & x; }
int main() {
  long long i, j, s, t, u;
  scanf("%I64d%I64d%I64d%I64d%I64d", &n, &k, &a, &b, &q);
  for (i = 1; i <= q; i++) {
    scanf("%I64d", &u);
    if (u == 1) {
      scanf("%I64d%I64d", &s, &t);
      for (j = s; j <= n; j += lowbit(j)) {
        sum_a[j] -= num_a[s];
        sum_b[j] -= num_b[s];
      }
      num_a[s] = min(a, num_a[s] + t);
      num_b[s] = min(b, num_b[s] + t);
      for (j = s; j <= n; j += lowbit(j)) {
        sum_a[j] += num_a[s];
        sum_b[j] += num_b[s];
      }
    } else {
      scanf("%I64d", &s);
      ans = 0;
      for (j = s - 1; j; j -= lowbit(j)) {
        ans += sum_b[j];
      }
      for (j = n; j; j -= lowbit(j)) {
        ans += sum_a[j];
      }
      for (j = s + k - 1; j; j -= lowbit(j)) {
        ans -= sum_a[j];
      }
      printf("%I64d\n", ans);
    }
  }
  return 0;
}
