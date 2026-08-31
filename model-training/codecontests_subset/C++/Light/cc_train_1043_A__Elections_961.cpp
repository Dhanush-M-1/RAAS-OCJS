#include <bits/stdc++.h>
using namespace std;
const int maxn = 110;
int n = 0;
int a[maxn];
int sum = 0, mx = 0;
;
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d", &a[i]);
  for (int i = 1; i <= n; i++) {
    sum += a[i];
    mx = max(mx, a[i]);
  }
  int k = 2 * sum / n;
  if (k < mx) k = mx;
  while (n * k <= 2 * sum) ++k;
  printf("%d\n", k);
  return 0;
}
