#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  scanf("%d", &n);
  int sum = 0, x, maxn = 0;
  for (int i = 1; i <= n; i++) scanf("%d", &x), maxn = max(maxn, x), sum += x;
  for (int k = maxn;; k++) {
    if (k * n - sum > sum) return 0 * printf("%d\n", k);
  }
}
