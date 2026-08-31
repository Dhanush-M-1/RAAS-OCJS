#include <bits/stdc++.h>
using namespace std;
bool block[1000002] = {false};
long long int count1[1000002] = {0};
int main() {
  long long int n, m, k;
  scanf("%lld %lld %lld", &n, &m, &k);
  long long int x;
  for (int i = 0; i < m; ++i) {
    scanf("%lld", &x);
    block[x] = true;
  }
  long long int cost[n + 2];
  for (int i = 1; i <= k; ++i) {
    scanf("%lld", &cost[i]);
  }
  long long int mx = -1;
  for (int i = 0; i < n; i++) {
    if (block[i]) {
      count1[i] = 1;
      if (i) count1[i] += count1[i - 1];
    }
    mx = max(mx, count1[i]);
  }
  if (block[0]) {
    printf("-1");
    return 0;
  } else {
    long long int ans = 100000000000000;
    for (int i = mx + 1; i <= k; i++) {
      long long int ans1 = 100000000000000;
      int j = 0;
      while (j < n) {
        if (block[j]) {
          j -= count1[j];
        } else {
          if (ans1 == 100000000000000) ans1 = 0;
          j += i;
          ans1 += cost[i];
        }
      }
      ans = min(ans1, ans);
    }
    if (ans == 100000000000000)
      printf("-1");
    else
      printf("%lld", ans);
  }
  return 0;
}
