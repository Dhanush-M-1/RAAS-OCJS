#include <bits/stdc++.h>
using namespace std;
const int MAX = 1e5 + 5;
vector<int> adj[MAX], tree[MAX], point_to[MAX];
bool visited[MAX];
int out_degree[MAX], father[MAX];
int n, m;
set<pair<int, int> > edges;
void dfs(int source) {
  visited[source] = true;
  for (auto &each : adj[source]) {
    if (!visited[each]) {
      tree[source].push_back(each);
      edges.erase(pair<int, int>(min(each, source), max(each, source)));
      father[each] = source;
      dfs(each);
    }
  }
}
void fix(int source) {
  for (auto &each : tree[source]) {
    fix(each);
  }
  if (out_degree[source] & 1) {
    point_to[source].push_back(father[source]);
    out_degree[source]++;
  } else if (father[source] != -1) {
    out_degree[father[source]]++;
    point_to[father[source]].push_back(source);
  }
}
int main() {
  scanf("%d %d", &n, &m);
  if (m & 1) {
    puts("No solution");
    return 0;
  }
  for (int i = int(0); i < int(m); i++) {
    int u, v;
    scanf("%d %d", &u, &v);
    edges.emplace(min(u, v), max(u, v));
    adj[u].push_back(v);
    adj[v].push_back(u);
  }
  father[1] = -1;
  dfs(1);
  for (auto &each : edges) {
    point_to[each.first].push_back(each.second);
    out_degree[each.first]++;
  }
  fix(1);
  for (int i = int(1); i < int(n + 1); i++) {
    for (int j = 0; j < (int)point_to[i].size(); j += 2) {
      printf("%d %d %d\n", point_to[i][j], i, point_to[i][j + 1]);
    }
  }
  return 0;
}
