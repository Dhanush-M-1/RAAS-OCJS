#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e6 + 7;
bool vis[maxn];
int n, m, k, last[maxn];
int main() {
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 1; i <= m; i++) {
    int x;
    scanf("%d", &x);
    vis[x] = 1;
  }
  if (vis[0]) {
    printf("-1\n");
    return 0;
  }
  int la = 0;
  for (int i = 1; i <= n; i++) {
    if (!vis[i]) la = i;
    last[i] = la;
  }
  long long ans = -1;
  for (int i = 1; i <= k; i++) {
    int x;
    scanf("%d", &x);
    long long sum = 0;
    for (int j = 0; j < n;) {
      sum += x;
      int id;
      if (j + i > n)
        id = n;
      else
        id = last[i + j];
      if (id <= j) {
        sum = -1;
        break;
      }
      j = id;
    }
    if (sum != -1) {
      if (ans == -1)
        ans = sum;
      else
        ans = min(ans, sum);
    }
  }
  printf("%lld\n", ans);
  return 0;
}
