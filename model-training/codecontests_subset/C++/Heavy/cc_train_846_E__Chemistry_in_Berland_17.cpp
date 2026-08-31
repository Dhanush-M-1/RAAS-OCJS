#include <bits/stdc++.h>
using namespace std;
const int N = 1e5, inf = 2e9;
int n;
long long a[N], b[N], val[N];
vector<pair<int, int>> g[N];
void dfs(int x, int k) {
  for (auto u : g[x]) {
    int to = u.first, nk = u.second;
    dfs(to, nk);
    if ((__int128)a[x] + val[to] <= (__int128)-1e18) {
      puts("NO");
      exit(0);
    }
    a[x] += val[to];
  }
  if (!x) return;
  if (b[x] > a[x]) {
    __int128 want = (__int128)(a[x] - b[x]) * k;
    if (want <= (__int128)-1e18) {
      puts("NO");
      exit(0);
    }
    val[x] = want;
  } else {
    val[x] = a[x] - b[x];
  }
}
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; ++i) {
    scanf("%lld", a + i);
  }
  for (int i = 0; i < n; ++i) {
    scanf("%lld", b + i);
  }
  for (int i = 0; i < n - 1; ++i) {
    int x, k;
    scanf("%d%d", &x, &k);
    x--;
    g[x].push_back({i + 1, k});
  }
  dfs(0, 0);
  if (a[0] >= b[0])
    puts("YES");
  else
    puts("NO");
}
