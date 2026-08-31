#include <bits/stdc++.h>
using namespace std;
long long a[100010], b[100010], k[100010], c[100010];
int n, x[100010];
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%I64d", &b[i]);
  for (int i = 1; i <= n; i++) scanf("%I64d", &a[i]), c[i] = b[i] - a[i];
  for (int i = 2; i <= n; i++) scanf("%d%I64d", &x[i], &k[i]);
  for (int i = n; i; i--) {
    if (c[i] < 0) {
      if (i == 1 || 100000000000000000 / k[i] <= -c[i] ||
          c[x[i]] + k[i] * c[i] <= -100000000000000000) {
        printf("NO\n");
        return 0;
      }
      c[x[i]] += k[i] * c[i];
      c[i] = 0;
    } else if (c[i] > 0) {
      c[x[i]] += c[i];
      c[i] = 0;
    }
  }
  printf("YES\n");
  return 0;
}
