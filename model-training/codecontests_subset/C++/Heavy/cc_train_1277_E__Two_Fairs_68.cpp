#include <bits/stdc++.h>
using namespace std;
long long dis[200009];
bool mark[200009], vis[200009];
long long nodes, edges;
void dijkstra(int s, int av, vector<long long> ed[]) {
  long long i, j, sz, u, v;
  for (i = 1; i <= nodes; i++) {
    dis[i] = 1e18;
    vis[i] = false;
  }
  dis[s] = 0LL;
  priority_queue<long long, vector<long long>, greater<long long> > pq;
  pq.push(s);
  while (!pq.empty()) {
    u = pq.top();
    pq.pop();
    if (vis[u]) continue;
    vis[u] = true;
    sz = ed[u].size();
    for (i = 0; i < sz; i++) {
      v = ed[u][i];
      if (v == av) continue;
      if (dis[v] > dis[u] + ed[u][i]) {
        dis[v] = dis[u] + ed[u][i];
        pq.push(v);
      }
    }
  }
  return;
}
int main() {
  long long t, i, j, k, l, node1, node2, ans, a, b;
  cin >> t;
  while (t--) {
    cin >> nodes >> edges >> a >> b;
    vector<long long> ed[nodes + 10];
    for (i = 1; i <= nodes; i++) mark[i] = false;
    for (i = 1; i <= edges; i++) {
      cin >> node1 >> node2;
      ed[node1].push_back(node2);
      ed[node2].push_back(node1);
    }
    dijkstra(a, 0, ed);
    if (dis[b] == 1e18) {
      cout << 0 << endl;
      continue;
    }
    dijkstra(a, b, ed);
    long long xa = 0, xb = 0;
    for (i = 1; i <= nodes; i++) {
      if (i == a) continue;
      if (dis[i] < 1e18) {
        xa++;
        mark[i] = true;
      }
    }
    dijkstra(b, a, ed);
    for (i = 1; i <= nodes; i++) {
      if (i == b) continue;
      if (dis[i] < 1e18) {
        if (mark[i])
          xa--;
        else
          xb++;
      }
    }
    cout << xa * xb << endl;
  }
}
