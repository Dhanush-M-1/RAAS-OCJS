#include <bits/stdc++.h>
using namespace std;
const int N = 210000;
struct Edge {
  int next, to;
  Edge(int to = 0, int next = -1) : to(to), next(next) {}
};
int head[N], countedge;
Edge edge[N];
void AddEdge(const int& s, const int& t) {
  edge[countedge] = Edge(t, head[s]);
  head[s] = countedge++;
}
void init() {
  memset(head, -1, sizeof(head));
  countedge = 0;
}
bool vis[N];
int dfs(int u) {
  int temp;
  queue<int> que;
  vector<int> unpair;
  for (temp = head[u]; temp != -1; temp = edge[temp].next) {
    int v = edge[temp].to;
    if (vis[temp]) continue;
    vis[temp] = true;
    vis[temp ^ 1] = true;
    que.push(v);
  }
  while (!que.empty()) {
    int v = que.front();
    que.pop();
    int w = dfs(v);
    if (w)
      printf("%d %d %d\n", u, v, w);
    else
      unpair.push_back(v);
  }
  int len = unpair.size();
  while (len >= 2) {
    printf("%d %d %d\n", unpair[len - 1], u, unpair[len - 2]);
    len -= 2;
  }
  if (len) return unpair[0];
  return 0;
}
int main() {
  int n, m;
  scanf("%d%d", &n, &m);
  init();
  for (int i = 0; i < m; i++) {
    int u, v;
    scanf("%d%d", &u, &v);
    AddEdge(u, v);
    AddEdge(v, u);
  }
  if (m & 1) {
    printf("No solution\n");
    return 0;
  } else
    dfs(1);
  return 0;
}
