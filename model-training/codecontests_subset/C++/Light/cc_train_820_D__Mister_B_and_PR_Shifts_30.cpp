#include <bits/stdc++.h>
using namespace std;
int n, p[1000010], cur[1000010 * 2];
int main() {
  long long ans = 0, sum = 0;
  int l = 0, r = 0, temp = 0;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d", &p[i]);
  for (int i = 1; i <= n; i++) {
    sum += abs(p[i] - i);
    if (p[i] >= i) {
      l++;
      cur[p[i] - i]++;
    } else
      r++;
  }
  ans = sum;
  for (int i = 0; i < n - 1; i++) {
    l -= cur[i];
    r += cur[i];
    sum = sum - l + r - abs(p[n - i] - n - 1) + p[n - i] - 1;
    cur[p[n - i] + i]++;
    l++, r--;
    if (sum < ans) {
      ans = sum;
      temp = i + 1;
    }
  }
  printf("%lld %d\n", ans, temp);
  return 0;
}
