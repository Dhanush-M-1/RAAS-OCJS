#include <bits/stdc++.h>
using namespace std;
const int MAXN = 2e5;
set<int> g[MAXN];
int n, m, k;
int result = 0;
bool removed[MAXN];
int c[MAXN];
int edges[MAXN][2];
queue<int> q;
void remove_item(int m) {
  result--;
  q.push(m);
  removed[m] = true;
}
void clear_queue() {
  while (!q.empty()) {
    auto to = q.front();
    q.pop();
    for (auto u : g[to]) {
      c[u]--;
      if (c[u] < k && !removed[u]) remove_item(u);
    }
  }
}
void remove_edge(int a, int b) {
  g[a].erase(b);
  g[b].erase(a);
}
int main() {
  scanf("%d %d %d", &n, &m, &k);
  for (int i = 0; i < m; i++) {
    int a, b;
    scanf("%d %d", &a, &b);
    a--;
    b--;
    edges[i][0] = a;
    edges[i][1] = b;
    g[a].insert(b);
    g[b].insert(a);
    c[a]++;
    c[b]++;
  }
  for (int i = 0; i < n; i++) {
    if (c[i] < k) remove_item(i);
  }
  clear_queue();
  vector<int> result_reversed;
  result_reversed.push_back(n + result);
  for (int i = m - 1; i > 0; i--) {
    int a = edges[i][0];
    int b = edges[i][1];
    if (removed[a] || removed[b]) {
      result_reversed.push_back(n + result);
      continue;
    }
    c[a]--;
    c[b]--;
    g[a].erase(b);
    g[b].erase(a);
    if (c[a] < k) remove_item(a);
    if (c[b] < k && !removed[b]) remove_item(b);
    clear_queue();
    result_reversed.push_back(n + result);
  }
  for (int i = m - 1; i >= 0; i--) {
    printf("%d\n", result_reversed[i]);
  }
  return 0;
}
