#include <bits/stdc++.h>
using namespace std;
int n, x[105000], h[105000];
int ans;
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) scanf("%d%d", &x[i], &h[i]);
  x[0] = -INT_MAX;
  x[n + 1] = INT_MAX;
  for (int i = 1; i <= n; ++i) {
    if (x[i] - h[i] > x[i - 1])
      ++ans;
    else if (x[i] + h[i] < x[i + 1]) {
      ++ans;
      x[i] += h[i];
    }
  }
  printf("%d\n", ans);
  return 0;
}
