#include <bits/stdc++.h>
using namespace std;
int i, j, k, n, m, K, an1, an2;
map<double, int> Map1, Map2;
long long mi, sum;
inline int get(int x) {
  int s = 0;
  for (; x; x /= 10) s = s * 10 + x % 10;
  return s;
}
int main() {
  scanf("%d%d%d", &n, &m, &K);
  for (i = 1; i <= n; i++) Map1[1. * get(i) / i]++;
  mi = (long long)1e15;
  j = n;
  for (i = 1; i <= m; i++) {
    sum += Map1[1. * i / get(i)];
    Map2[1. * i / get(i)]++;
    for (; j > 1;) {
      int A = Map2[1. * get(j) / j];
      if (sum - A >= K) {
        sum -= A;
        Map1[1. * get(j) / j]--;
        j--;
      } else
        break;
    }
    if (sum >= K && 1ll * i * j < mi) mi = 1ll * i * j, an1 = j, an2 = i;
  }
  if (mi == 1e15)
    printf("-1\n");
  else
    printf("%d %d\n", an1, an2);
  return 0;
}
