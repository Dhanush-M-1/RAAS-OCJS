#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 5;
vector<pair<int, int>> G[N];
long long a[N], b[N];
bool gg;
long long dfs(int x) {
  long long res = b[x] - a[x];
  for (auto e : G[x]) {
    int u = e.first, w = e.second;
    long long tmp = dfs(u);
    if (gg) return -1;
    if (tmp < 0) {
      if (1.0 * tmp * w + res < -2e17) {
        gg = 1;
        return -1;
      }
      res += tmp * w;
    } else {
      res += tmp;
    }
  }
  return res;
}
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) scanf("%I64d", &b[i]);
  for (int i = 1; i <= n; ++i) scanf("%I64d", &a[i]);
  for (int i = 2; i <= n; ++i) {
    int p, w;
    scanf("%d%d", &p, &w);
    G[p].push_back({i, w});
  }
  long long ans = dfs(1);
  puts(ans >= 0 ? "YES" : "NO");
}
