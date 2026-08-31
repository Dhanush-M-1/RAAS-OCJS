#include <bits/stdc++.h>
template <class T>
using MinHeap = std::priority_queue<T, std::vector<T>, std::greater<T>>;
const int MAX_N = 2e5 + 7;
struct bg_edge {
  int a, b;
} edges[MAX_N];
struct bg_state {
  int node;
  long unsigned int deg;
  bool operator>(const bg_state& o) const { return deg > o.deg; }
};
static inline void setio(void);
int n, m;
long unsigned int k;
std::set<int> gr[MAX_N];
int ans[MAX_N], in[MAX_N];
int main(void) {
  setio();
  memset(in, 1, sizeof(in));
  std::cin >> n >> m >> k;
  for (int i = 0, a, b; i < m; ++i) {
    std::cin >> a >> b;
    --a;
    --b;
    gr[a].insert(b);
    gr[b].insert(a);
    edges[i] = {a, b};
  }
  MinHeap<bg_state> pq;
  for (int i = 0; i < n; ++i) pq.push(bg_state{i, gr[i].size()});
  std::function<int(void)> doit = [&](void) {
    int rem = 0;
    while (pq.size() && pq.top().deg < k) {
      bg_state now = pq.top();
      pq.pop();
      if (now.deg != gr[now.node].size() || !in[now.node]) continue;
      ++rem;
      in[now.node] = false;
      for (const auto& nei : gr[now.node]) {
        gr[nei].erase(now.node);
        pq.push(bg_state{nei, gr[nei].size()});
      }
    }
    return rem;
  };
  ans[m] = n;
  for (int i = m; i > 0; --i) {
    if (i < m) {
      gr[edges[i].a].erase(edges[i].b);
      gr[edges[i].b].erase(edges[i].a);
      pq.push(bg_state{edges[i].a, gr[edges[i].a].size()});
      pq.push(bg_state{edges[i].b, gr[edges[i].b].size()});
    }
    ans[i - 1] = ans[i] - doit();
  }
  for (int i = 0; i < m; ++i) std::cout << ans[i] << "\n";
  return 0;
}
static inline void setio(void) {
  std::ios::sync_with_stdio(false);
  std::cin.tie(nullptr);
  std::cout.precision(10);
  std::cout << std::fixed;
}
