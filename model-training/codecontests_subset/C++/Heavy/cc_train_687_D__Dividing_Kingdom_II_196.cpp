#include <bits/stdc++.h>
std::mt19937 engine(42);
struct Edge {
  int from, to, weight, index;
  Edge() {}
  Edge(int from, int to, int weight, int index)
      : from(from), to(to), weight(weight), index(index) {}
};
const int max_size = 1000;
int parent[max_size * 2 + 1];
int rank[max_size * 2 + 1];
Edge edges[max_size * max_size];
int find_set(int v) {
  if (v == parent[v]) {
    return v;
  }
  return parent[v] = find_set(parent[v]);
}
void union_sets(int a, int b) {
  a = find_set(a);
  b = find_set(b);
  if (a == b) {
    return;
  }
  if (rank[a] < rank[b]) {
    std::swap(a, b);
  }
  parent[b] = a;
  if (rank[a] == rank[b]) {
    ++rank[a];
  }
}
int main() {
  std::ios_base::sync_with_stdio(false);
  std::cout.tie(NULL);
  int n, m, q;
  std::cin >> n >> m >> q;
  for (int i = 0; i < m; ++i) {
    int from, to, weight;
    std::cin >> from >> to >> weight;
    from--, to--;
    edges[i] = Edge(from, to, weight, i);
  }
  std::sort(edges, edges + m,
            [](Edge a, Edge b) { return a.weight > b.weight; });
  for (int query_index = 0; query_index < q; ++query_index) {
    int left, right;
    std::cin >> left >> right;
    for (int i = 0; i < 2 * n; ++i) {
      parent[i] = i;
      rank[i] = 0;
    }
    bool flag = false;
    for (int i = 0; i < m; ++i) {
      Edge edge = edges[i];
      if ((edge.index + 1 < left) || (edge.index >= right)) {
        continue;
      }
      int from = edge.from;
      int to = edge.to;
      int anti_from = from + n;
      int anti_to = to + n;
      union_sets(from, anti_to);
      union_sets(to, anti_from);
      if (find_set(anti_to) == find_set(to)) {
        flag = true;
        std::cout << edge.weight << '\n';
        break;
      }
    }
    if (!flag) {
      std::cout << -1 << '\n';
    }
  }
  return 0;
}
