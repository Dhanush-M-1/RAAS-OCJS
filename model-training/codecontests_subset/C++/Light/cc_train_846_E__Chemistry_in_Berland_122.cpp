#include <bits/stdc++.h>
const long double PI = acos(-1);
const long double eps = 0.0000000001;
const long long INF = 1e17;
long long n, v[100005], fa[100005], k[100005];
std::vector<long long> son[100005];
long long dfs(long long now) {
  long long res = v[now];
  for (auto i : son[now]) {
    res += dfs(i);
    if (1.0l * res * k[now] < -INF) std::cout << "NO" << std::endl, exit(0);
  }
  return res < 0 ? res * k[now] : res;
}
signed main() {
  std::ios::sync_with_stdio(false);
  std::cin >> n;
  for (long long i = 1; i <= n; ++i) std::cin >> v[i];
  for (long long i = 1; i <= n; ++i) {
    static long long tmp;
    std::cin >> tmp;
    v[i] -= tmp;
  }
  for (long long i = 2; i <= n; ++i) {
    std::cin >> fa[i] >> k[i];
    son[fa[i]].push_back(i);
  }
  k[1] = 1;
  std::cout << (dfs(1) >= 0 ? "YES" : "NO") << std::endl;
  return 0;
}
