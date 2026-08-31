#include <bits/stdc++.h>
int n, d;
const int N = 1e5 + 1;
int val[N];
int mx[N];
int main() {
  scanf("%d%d", &n, &d);
  for (int i = 0; i < n; i++) scanf("%d", val + i);
  mx[n - 1] = val[n - 1];
  for (int i = n - 2; i >= 0; i--) mx[i] = std::max(val[i], val[i] + mx[i + 1]);
  int balance = 0;
  int ans = 0;
  for (int i = 0; i < n; i++) {
    if (val[i] != 0) {
      balance += val[i];
      if (balance > d) {
        printf("-1\n");
        return 0;
      }
    } else {
      if (balance < 0) {
        ans++;
        int m = std::min(d, d - mx[i]) - balance;
        if (m > 0) balance += m;
        if (balance < 0) {
          printf("-1\n");
          return 0;
        }
      }
    }
  }
  printf("%d\n", ans);
}
