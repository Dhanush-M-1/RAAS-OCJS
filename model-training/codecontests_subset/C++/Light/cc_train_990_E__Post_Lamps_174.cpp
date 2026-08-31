#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 123;
bool vis[N];
int pre[N];
void load() {}
void process() {
  int n, m, k;
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 1; i <= m; ++i) {
    int pos;
    scanf("%d", &pos);
    vis[pos] = 1;
  }
  for (int i = 0, j = -1; i < n; ++i) {
    if (!vis[i]) j = i;
    pre[i] = j;
  }
  long long ans = 1e18;
  for (int i = 1; i <= k; ++i) {
    int cost;
    scanf("%d", &cost);
    int res = 0;
    for (int j = 0; j < n; j += i) {
      if (j - pre[j] >= i || pre[j] == -1) {
        res = 1e9;
        break;
      }
      j = pre[j];
      ++res;
    }
    if (res != 1e9) ans = min(ans, 1LL * res * cost);
  }
  if (ans != 1e18)
    printf("%lld", ans);
  else
    printf("-1");
  return;
}
int main() {
  load();
  process();
  return 0;
}
