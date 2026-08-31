#include <bits/stdc++.h>
const int INF = 0x3f3f3f3f;
const int MAX_N = 1e6 + 7;
int n, k;
std::vector<int> gr[MAX_N];
std::pair<int, int> drev[MAX_N];
int d[MAX_N];
int pre[2][MAX_N], dep[MAX_N], po = 0;
int dfs(const int& cur, const int& depth) {
  pre[0][cur] = po++;
  dep[cur] = depth;
  for (const auto& nei : gr[cur]) dfs(nei, depth + 1);
  pre[1][cur] = po;
  return 0;
}
int go(const int& cur) {
  if (pre[0][cur] + 1 == pre[1][cur]) {
    drev[cur].first = dep[cur] - k;
    drev[cur].second = 1;
    return 0;
  }
  drev[cur].first = INF;
  for (const auto& nei : gr[cur]) {
    go(nei);
    drev[cur].first = std::min(drev[cur].first, drev[nei].first);
    if (drev[nei].first <= dep[cur]) drev[cur].second += drev[nei].second;
  }
  return 0;
}
int despacito(const int& cur) {
  if (pre[0][cur] + 1 == pre[1][cur]) {
    return d[cur] = 1;
  }
  d[cur] = drev[cur].second;
  for (const auto& nei : gr[cur]) {
    despacito(nei);
    d[cur] = std::max(d[cur],
                      drev[cur].second -
                          (drev[nei].first <= dep[cur] ? drev[nei].second : 0) +
                          d[nei]);
  }
  return d[cur];
}
int main(void) {
  std::ios::sync_with_stdio(0);
  std::cin.tie(0);
  std::cin >> n >> k;
  for (int i = 1, p; i < n; ++i) {
    std::cin >> p;
    gr[p - 1].push_back(i);
  }
  std::cout << (dfs(0, 0) + go(0) + despacito(0)) << "\n";
  return 0;
}
