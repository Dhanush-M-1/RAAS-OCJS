#include <bits/stdc++.h>
using namespace std;
long long forbid[2000001], cost[1000001], last_post[2000001];
long long cal_cost(long long lpower, long long n) {
  long long i, j, k, lcost = 0;
  for (i = 0; i < n;) {
    if (last_post[i + lpower] == i) return 10000000000000;
    if (forbid[i])
      i = last_post[i];
    else {
      i = i + lpower;
      lcost += cost[lpower];
    }
  }
  return lcost;
}
int main() {
  long long i, j;
  long long n, m, k;
  long long min_cost = 10000000000000;
  scanf("%lld %lld %lld", &n, &m, &k);
  for (i = 0; i < m; i++) {
    scanf("%lld", &j);
    forbid[j] = 1;
  }
  for (i = 1; i <= k; i++) scanf("%lld", &cost[i]);
  if (forbid[0]) {
    printf("-1");
    return 0;
  }
  for (i = 0, j = -1; i < n; i++) {
    if (forbid[i] == 0) j = i;
    last_post[i] = j;
  }
  for (i = n; i <= (n + k); i++) last_post[i] = -1;
  for (i = 1; i <= k; i++) {
    min_cost = min(min_cost, cal_cost(i, n));
  }
  if (min_cost >= 10000000000000)
    printf("-1");
  else
    printf("%lld", min_cost);
}
