#include <bits/stdc++.h>
using namespace std;
int n, m, k, x[200009], y[200009];
set<int> alive;
vector<int> kaaj;
set<int> graph[200009];
int degree[200009], ans[200009];
void doit(int z) {
  if (alive.find(z) == alive.end()) return;
  alive.erase(z);
  if (graph[z].empty()) return;
  auto it = graph[z].begin();
  while (it != graph[z].end()) {
    int v = *it;
    degree[v]--;
    graph[v].erase(z);
    if (degree[v] < k && alive.find(v) != alive.end()) {
      kaaj.push_back(v);
    }
    it++;
  }
  graph[z].clear();
}
int main() {
  scanf("%d %d %d", &n, &m, &k);
  for (int i = 1; i <= m; i++) {
    scanf("%d %d", &x[i], &y[i]);
    graph[x[i]].insert(y[i]);
    graph[y[i]].insert(x[i]);
    degree[x[i]]++;
    degree[y[i]]++;
  }
  for (int i = 1; i <= n; i++) alive.insert(i);
  for (int i = 1; i <= n; i++) {
    if (degree[i] < k) {
      kaaj.push_back(i);
    }
  }
  while (!kaaj.empty()) {
    int z = kaaj.back();
    kaaj.pop_back();
    doit(z);
  }
  for (int i = m; i >= 1; i--) {
    ans[i] = alive.size();
    if (alive.find(x[i]) == alive.end() || alive.find(y[i]) == alive.end())
      continue;
    degree[x[i]]--;
    degree[y[i]]--;
    graph[x[i]].erase(y[i]);
    graph[y[i]].erase(x[i]);
    if (degree[x[i]] < k && alive.find(x[i]) != alive.end()) {
      kaaj.push_back(x[i]);
    }
    while (!kaaj.empty()) {
      int z = kaaj.back();
      kaaj.pop_back();
      doit(z);
    }
    if (degree[y[i]] < k && alive.find(y[i]) != alive.end()) {
      kaaj.push_back(y[i]);
    }
    while (!kaaj.empty()) {
      int z = kaaj.back();
      kaaj.pop_back();
      doit(z);
    }
  }
  for (int i = 1; i <= m; i++) printf("%d\n", ans[i]);
  return 0;
}
