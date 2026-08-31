#include <bits/stdc++.h>
using namespace std;
int sum[1000005];
int main() {
  int n, d, i, ans = 0, deposit = 0, curr;
  scanf("%d%d", &n, &d);
  int ar[n + 5], maxd[n + 5];
  for (i = 1; i <= n; i++) {
    scanf("%d", &ar[i]);
    sum[i] = sum[i - 1] + ar[i];
  }
  maxd[n] = sum[n];
  for (i = n - 1; i >= 1; i--) {
    maxd[i] = max(maxd[i + 1], sum[i]);
  }
  for (i = 1; i <= n; i++) {
    curr = deposit + sum[i];
    if (curr > d) {
      ans = -1;
      break;
    }
    if (ar[i] == 0 && curr < 0) {
      if (d + sum[i] - maxd[i] < 0) {
        ans = -1;
        break;
      }
      ans++;
      deposit += d - (maxd[i] + deposit);
    }
  }
  printf("%d\n", ans);
}
