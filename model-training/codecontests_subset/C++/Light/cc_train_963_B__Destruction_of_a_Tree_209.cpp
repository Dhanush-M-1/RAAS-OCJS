#include <bits/stdc++.h>
using namespace std;
const int N = 200002;
int n;
struct edge {
  int to, nxt;
} tree[N << 1];
int head[N], cnt = 0;
void addEdge(int u, int v) {
  edge node = {v, head[u]};
  tree[head[u] = ++cnt] = node;
}
int num[N], deg[N];
vector<int> graph[N];
void dfs(int u, int v) {
  num[u] = 0;
  for (int i = head[u]; i; i = tree[i].nxt)
    if (tree[i].to != v) {
      dfs(tree[i].to, u), num[u] ^= (num[tree[i].to] ^ 1);
      if (num[tree[i].to])
        graph[tree[i].to].push_back(u);
      else
        graph[u].push_back(tree[i].to);
    }
}
queue<int> q;
vector<int> seq;
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    int pi;
    scanf("%d", &pi);
    if (!pi) continue;
    addEdge(pi, i), addEdge(i, pi);
  }
  if (n % 2 == 0)
    printf("NO\n");
  else {
    printf("YES\n");
    dfs(1, 0);
    for (int i = 1; i <= n; i++) deg[i] = 0;
    for (int i = 1; i <= n; i++)
      for (int j = 0; j < graph[i].size(); j++) deg[graph[i][j]]++;
    for (int i = 1; i <= n; i++)
      if (!deg[i]) q.push(i);
    while (!q.empty()) {
      int u = q.front();
      q.pop(), seq.push_back(u);
      for (int i = 0; i < graph[u].size(); i++) {
        deg[graph[u][i]]--;
        if (!deg[graph[u][i]]) q.push(graph[u][i]);
      }
    }
    for (int i = 1; i <= n; i++) printf("%d\n", seq[i - 1]);
  }
  return 0;
}
