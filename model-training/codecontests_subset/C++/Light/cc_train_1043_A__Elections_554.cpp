#include <bits/stdc++.h>
int main() {
  std::ios::sync_with_stdio(false);
  int n;
  scanf("%d", &n);
  int sum = 0, mxa = 0;
  for (int i = 1; i <= n; i++) {
    int a;
    scanf("%d", &a);
    sum += a;
    mxa = std::max(mxa, a);
  }
  int opt_k = ceil(2.0 * sum / n);
  if (opt_k == 2.0 * sum / n) opt_k++;
  if (opt_k < mxa) opt_k = mxa;
  printf("%d\n", opt_k);
  return 0;
}
