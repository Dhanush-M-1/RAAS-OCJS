#include <bits/stdc++.h>
using namespace std;
const int up = 1e6 + 6;
int n, m, k, pos;
int cost[up], p[up], last[up];
int main() {
  scanf("%d", &n);
  scanf("%d", &m);
  scanf("%d", &k);
  for (int i = 1; i <= m; i++) {
    scanf("%d", &pos);
    p[pos] = 1;
  }
  if (p[0]) {
    printf("%d\n", -1);
    return 0;
  }
  for (int i = 0; i <= n; i++) {
    if (!p[i])
      last[i] = i;
    else
      last[i] = last[i - 1];
  }
  for (int i = 1; i <= k; i++) {
    scanf("%d", &cost[i]);
  }
  long long res = 1ll * up * up;
  for (int i = 1; i <= k; i++) {
    int cnt = 1;
    for (int j = i; j < n; j += i) {
      if (j - last[j] >= i) {
        cnt = n + 10;
        break;
      } else {
        j = last[j];
        cnt++;
      }
    }
    if (cnt <= n) {
      res = min(res, 1ll * cnt * cost[i]);
    }
  }
  if (res == 1ll * up * up) {
    res = -1ll;
  }
  printf("%I64d\n", res);
  return 0;
}
