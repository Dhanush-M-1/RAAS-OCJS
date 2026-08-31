#include <bits/stdc++.h>
using namespace std;
const double eps = 1e-9;
const int siz = 2e5 + 5, siz2 = 1e5 + 5;
int n, parent[siz], degree[siz], still[siz];
vector<int> adj[siz], ans, child[siz], ready;
bool vis[siz], del[siz];
void root(int i) {
  vis[i] = true;
  for (auto v : adj[i]) {
    if (vis[v]) continue;
    child[i].push_back(v);
    parent[v] = i;
    degree[i]++;
    degree[v]++;
    root(v);
  }
  int sz = child[i].size();
  still[i] = sz;
  if (sz == 0) {
    ready.push_back(i);
  }
}
void propagate(int i) {
  del[i] = true;
  ans.push_back(i);
  for (auto v : child[i]) {
    if (!del[v]) {
      propagate(v);
    }
  }
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    int v;
    scanf("%d", &v);
    if (v != 0) {
      adj[v].push_back(i);
      adj[i].push_back(v);
    }
  }
  if (n == 1) {
    printf("YES\n1\n");
    return 0;
  }
  root(1);
  while (!ready.empty()) {
    int cur = ready.back();
    ready.pop_back();
    still[parent[cur]]--;
    if (still[parent[cur]] == 0) {
      ready.push_back(parent[cur]);
    }
    if (degree[cur] % 2 == 0) {
      degree[parent[cur]]--;
      propagate(cur);
    }
  }
  int sz = ans.size();
  if (sz == n) {
    printf("YES\n");
    for (auto v : ans) {
      printf("%d\n", v);
    }
  } else {
    printf("NO\n");
  }
  return 0;
}
