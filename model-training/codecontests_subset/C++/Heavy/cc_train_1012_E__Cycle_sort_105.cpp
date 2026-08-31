#include <bits/stdc++.h>
using namespace std;
vector<int> new_val;
inline int Val(int first) {
  return lower_bound(new_val.begin(), new_val.end(), first) - new_val.begin();
}
void Move(vector<int> &ind, vector<int> &a) {
  int last = a[ind.back()];
  for (int i : ind) {
    swap(a[i], last);
  }
}
int n, s;
void Dfs(vector<vector<int> > &graph, int node, vector<bool> &visited) {
  visited[node] = true;
  for (int neighbor : graph[node]) {
    if (!visited[neighbor]) Dfs(graph, neighbor, visited);
  }
}
vector<int> Solve(int i, vector<vector<int> > &graph,
                  map<pair<int, int>, vector<int> > &v) {
  list<int> path = {i};
  for (auto it = path.begin(); it != path.end(); it++) {
    auto it2 = it;
    it2++;
    for (int node = *it; !graph[node].empty();) {
      int next = graph[node].back();
      graph[node].pop_back();
      node = next;
      path.insert(it2, node);
    }
  }
  vector<int> ans;
  for (auto it = path.begin(); it != path.end(); it++) {
    auto next = it;
    next++;
    if (next == path.end()) break;
    ans.push_back(v[{*it, *next}].back());
    v[{*it, *next}].pop_back();
  }
  return ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cin >> n >> s;
  vector<int> a(n + 1);
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    new_val.push_back(a[i]);
  }
  sort(new_val.begin(), new_val.end());
  vector<int> sorted = new_val;
  new_val.erase(unique(new_val.begin(), new_val.end()), new_val.end());
  for (int i = 0; i < n; i++) {
    sorted[i] = Val(sorted[i]);
  }
  for (int i = 1; i <= n; i++) {
    a[i] = Val(a[i]);
  }
  vector<vector<int> > graph(n + 1);
  int count = 0;
  map<pair<int, int>, vector<int> > v;
  vector<int> ind(n + 1);
  for (int i = 1; i <= n; i++) {
    if (sorted[i - 1] != a[i]) {
      count++;
      graph[sorted[i - 1]].push_back(a[i]);
      ind[a[i]] = i;
    }
  }
  if (count > s) {
    cout << -1;
    return 0;
  }
  vector<int> components;
  vector<bool> visited(n + 1);
  for (int i = 0; i <= n; i++) {
    if (graph[i].empty()) continue;
    if (!visited[i]) {
      Dfs(graph, i, visited);
      components.push_back(ind[i]);
    }
  }
  vector<vector<int> > moves = {};
  if (components.size() > 1 && s > count + 1) {
    moves.push_back({});
    for (int i = 0; i < min(s - count, int(components.size())); i++) {
      moves.back().push_back(components[i]);
    }
    Move(moves.back(), a);
  }
  for (int i = 0; i <= n; i++) {
    graph[i].clear();
    visited[i] = false;
  }
  for (int i = 1; i <= n; i++) {
    if (sorted[i - 1] != a[i]) {
      v[{sorted[i - 1], a[i]}].push_back(i);
      count++;
      graph[sorted[i - 1]].push_back(a[i]);
    }
  }
  for (int i = 0; i <= n; i++) {
    if (graph[i].empty()) continue;
    if (!visited[i]) {
      Dfs(graph, i, visited);
      moves.push_back(Solve(i, graph, v));
    }
  }
  cout << moves.size() << '\n';
  for (vector<int> &move : moves) {
    cout << move.size() << '\n';
    for (int i : move) {
      cout << i << ' ';
    }
    cout << '\n';
  }
}
