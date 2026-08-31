#include <bits/stdc++.h>
const int N = 200005;
int n, m, sg[N];
bool r[N];
long long a[N], sum[N];
std::vector<int> g[N];
bool vis[N];
int dfs(int x) {
  if (~sg[x]) return sg[x];
  for (int p : g[x]) dfs(p);
  for (int p : g[x]) vis[dfs(p)] = 1;
  for (int i = 0;; ++i)
    if (!vis[i]) {
      sg[x] = i;
      break;
    }
  for (int p : g[x]) vis[dfs(p)] = 0;
  return sg[x];
}
void print(int col) {
  std::cout << "WIN\n";
  int pos = 0;
  for (int i = 1; i <= n; ++i)
    if (sg[i] == col && (sum[col] ^ a[i]) < a[i]) pos = i;
  a[pos] ^= sum[col], sum[col] = 0;
  for (int p : g[pos]) a[p] ^= sum[sg[p]], sum[sg[p]] = 0;
  for (int i = 1; i <= n; ++i) std::cout << a[i] << ' ';
  std::cout << '\n', std::exit(0);
}
int main() {
  std::ios::sync_with_stdio(0), std::cin.tie(0);
  std::cin >> n >> m;
  for (int i = 1; i <= n; ++i) std::cin >> a[i], sg[i] = -1;
  for (int i = 0, x, y; i < m; ++i) std::cin >> x >> y, g[x].emplace_back(y);
  for (int i = 1; i <= n; ++i) sum[dfs(i)] ^= a[i];
  for (int i = n - 1; ~i; --i)
    if (sum[i]) print(i);
  std::cout << "LOSE\n";
  return 0;
}
