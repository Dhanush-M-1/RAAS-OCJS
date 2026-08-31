#include <bits/stdc++.h>
using namespace std;
using int64 = long long int;
struct Edge {
  int from;
  int to;
  int to_index;
};
class Graph {
 public:
  explicit Graph(const int n) : edges_(n) {}
  void AddEdge(Edge e) { edges_[e.from].push_back(e); }
  vector<vector<int>> FindCycles() {
    current_edge_.assign(edges_.size(), 0);
    vector<vector<int>> result;
    for (size_t i = 0; i < edges_.size(); ++i) {
      Dfs(i);
      if (!cycle_.empty()) {
        result.push_back(move(cycle_));
        cycle_.clear();
      }
    }
    return result;
  }

 private:
  void Dfs(const int node) {
    while (current_edge_[node] < edges_[node].size()) {
      const Edge& e = edges_[node][current_edge_[node]++];
      Dfs(e.to);
      cycle_.push_back(e.to_index);
    }
  }
  vector<vector<Edge>> edges_;
  vector<size_t> current_edge_;
  vector<int> cycle_;
};
void solve() {
  int n, s;
  scanf("%d %d", &n, &s);
  vector<pair<int, int>> a(n);
  for (int i = 0; i < n; ++i) {
    scanf("%d", &a[i].first);
    a[i].second = i;
  }
  sort(a.begin(), a.end());
  vector<int> group(n);
  int current_group = -1;
  for (int i = 0; i < n; ++i) {
    if (i == 0 || a[i].first != a[i - 1].first) {
      ++current_group;
    }
    group[i] = current_group;
  }
  Graph graph(current_group + 1);
  for (int i = 0; i < n; ++i) {
    const int gi = group[i];
    const int gj = group[a[i].second];
    if (gi != gj) {
      graph.AddEdge({gi, gj, a[i].second});
    }
  }
  vector<vector<int>> cycles = graph.FindCycles();
  int cycles_size = 0;
  for (const vector<int>& cycle : cycles) {
    cycles_size += cycle.size();
  }
  if (s < cycles_size) {
    cout << -1 << "\n";
    return;
  }
  if (s >= cycles_size + 2 && cycles.size() >= 2) {
    const int num_cycles = cycles.size();
    const int cycles_to_merge = min(s - cycles_size, num_cycles);
    vector<int> merged_cycle;
    for (int i = num_cycles - cycles_to_merge; i < num_cycles; ++i) {
      merged_cycle.insert(merged_cycle.end(), cycles[i].begin(),
                          cycles[i].end());
    }
    vector<int> additional_cycle;
    for (int i = num_cycles - 1; i >= num_cycles - cycles_to_merge; --i) {
      additional_cycle.push_back(cycles[i][0]);
    }
    cycles.resize(cycles.size() - cycles_to_merge);
    cycles.push_back(move(merged_cycle));
    cycles.push_back(move(additional_cycle));
  }
  cout << cycles.size() << "\n";
  for (const auto& cycle : cycles) {
    cout << cycle.size() << "\n";
    for (const int node : cycle) {
      cout << (node + 1) << " ";
    }
    cout << "\n";
  }
}
int main() {
  solve();
  return 0;
}
