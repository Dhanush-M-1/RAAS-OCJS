#include <bits/stdc++.h>
using namespace std;
vector<vector<pair<int, int>>> adj(100005);
map<int, int> vis;
int vis2[100005], p[100005];
void DFS(int s, int edge) {
  vis2[s] = 1;
  deque<int> dq;
  for (auto i = adj[s].begin(); i != adj[s].end(); i++) {
    if (!vis2[i->first]) {
      p[i->first] = s;
      DFS(i->first, i->second);
      if (vis[i->second]) {
        vis[i->second] = 0;
        dq.push_back(i->first);
      }
    } else if (vis[i->second] && p[s] != i->first) {
      vis[i->second] = 0;
      dq.push_back(i->first);
    }
  }
  if (dq.size() % 2) {
    vis[edge] = 0;
    dq.push_back(p[s]);
  }
  while (!dq.empty()) {
    printf("%d %d %d\n", dq.front(), s, dq.back());
    dq.pop_front();
    dq.pop_back();
  }
}
int main() {
  int n, m;
  scanf("%d %d", &n, &m);
  if (m % 2) {
    printf("No solution");
    return 0;
  }
  for (int i = 1; i <= m; i++) {
    int x, y;
    scanf("%d %d", &x, &y);
    adj[x].push_back(make_pair(y, i));
    adj[y].push_back(make_pair(x, i));
    vis[i] = 1;
  }
  DFS(1, 100006);
  return 0;
}
