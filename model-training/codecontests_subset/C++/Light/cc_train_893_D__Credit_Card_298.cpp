#include <bits/stdc++.h>
using std::max;
using std::min;
struct limit {
  long long max, min;
};
limit lim[100010];
int n, d;
int main() {
  scanf("%d%d", &n, &d);
  long long sum = 0, low = 0;
  for (int i = 1, x; i <= n; ++i) {
    scanf("%d", &x);
    sum += x;
    if (sum > d) {
      puts("-1");
      return 0;
    }
    if (x == 0) {
      low = max(low, -sum);
    }
    lim[i].max = d - sum;
    lim[i].min = low;
  }
  for (int i = n - 1; i >= 1; --i) {
    lim[i].max = min(lim[i].max, lim[i + 1].max);
  }
  for (int i = 1; i <= n; ++i) {
    if (lim[i].max < lim[i].min) {
      puts("-1");
      return 0;
    }
  }
  long long high = 0;
  int ans = 0;
  for (int i = 1; i <= n; ++i) {
    if (lim[i].min > high) {
      ++ans;
      high = lim[i].max;
    }
  }
  printf("%d\n", ans);
  return 0;
}
