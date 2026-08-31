#include <bits/stdc++.h>
using namespace std;
struct Edge {
  int from, to, capacity, cost;
  Edge(int from, int to, int capacity, int cost)
      : from(from), to(to), capacity(capacity), cost(cost){};
};
vector<vector<int>> adj, cost, capacity;
const int INF = 2e9;
void shortest_paths(int n, int v0, vector<int>& d, vector<int>& p) {
  d.assign(n, INF);
  d[v0] = 0;
  vector<bool> inq(n, false);
  queue<int> q;
  q.push(v0);
  p.assign(n, -1);
  while (!q.empty()) {
    int u = q.front();
    q.pop();
    inq[u] = false;
    for (int v : adj[u]) {
      if (capacity[u][v] > 0 && d[v] > d[u] + cost[u][v]) {
        d[v] = d[u] + cost[u][v];
        p[v] = u;
        if (!inq[v]) {
          inq[v] = true;
          q.push(v);
        }
      }
    }
  }
}
int min_cost_flow(int N, vector<Edge>& edges, int s, int t) {
  adj.assign(N, vector<int>());
  cost.assign(N, vector<int>(N, 0));
  capacity.assign(N, vector<int>(N, 0));
  for (Edge e : edges) {
    adj[e.from].push_back(e.to);
    adj[e.to].push_back(e.from);
    cost[e.from][e.to] = e.cost;
    cost[e.to][e.from] = -e.cost;
    capacity[e.from][e.to] = e.capacity;
  }
  int flow = 0;
  int cost = 0;
  vector<int> d, p;
  while (1) {
    shortest_paths(N, s, d, p);
    if (d[t] == INF) break;
    int f = 2000000000;
    int cur = t;
    while (cur != s) {
      f = min(f, capacity[p[cur]][cur]);
      cur = p[cur];
    }
    flow += f;
    cost += f * d[t];
    cur = t;
    while (cur != s) {
      capacity[p[cur]][cur] -= f;
      capacity[cur][p[cur]] += f;
      cur = p[cur];
    }
  }
  return cost;
}
int ab[76][2];
int main() {
  int T;
  int i, j;
  int n, k;
  int s, t;
  scanf("%d", &T);
  while (T--) {
    vector<Edge> edges;
    vector<int> res;
    scanf("%d %d", &n, &k);
    s = n + n, t = n + n + 1;
    for (i = 0; i < n; i++) {
      scanf("%d %d", &ab[i][0], &ab[i][1]);
    }
    for (i = 0; i < n; i++) {
      edges.emplace_back(s, i, 1, 0);
      edges.emplace_back(i + n, t, 1, 0);
    }
    for (i = 0; i < n; i++) {
      for (j = 0; j < n; j++) {
        if (i >= k - 1 && i < n - 1)
          edges.emplace_back(j, i + n, 1, -(k - 1) * ab[j][1]);
        else if (i == n - 1)
          edges.emplace_back(j, i + n, 1, -(ab[j][0] + (k - 1) * ab[j][1]));
        else
          edges.emplace_back(j, i + n, 1, -(ab[j][0] + i * ab[j][1]));
      }
    }
    min_cost_flow(n + n + 2, edges, s, t);
    for (i = 0; i < n; i++) {
      for (j = 0; j < n; j++) {
        if (!capacity[j][i + n]) {
          if (i >= k - 1 && i < n - 1) {
            res.push_back(j + 1);
            res.push_back(-j - 1);
          } else
            res.push_back(j + 1);
        }
      }
    }
    printf("%d\n", 2 * n - k);
    for (auto o : res) printf("%d ", o);
    printf("\n");
  }
}
