#include <bits/stdc++.h>
using namespace std;
template <class T>
using pqg = priority_queue<T, vector<T>, greater<T>>;
template <class T>
T poll(pqg<T> &x) {
  T y = x.top();
  x.pop();
  return y;
}
template <int SZ>
struct mcmf {
  struct Edge {
    int to, rev;
    long long flow, cap;
    long long cost;
  };
  vector<Edge> adj[SZ];
  void addEdge(int u, int v, long long cap, long long cost) {
    assert(cap >= 0);
    Edge a{v, (int)adj[v].size(), 0, cap, cost},
        b{u, (int)adj[u].size(), 0, 0, -cost};
    adj[u].push_back(a), adj[v].push_back(b);
  }
  int N, second, t;
  long long INF = 1e18;
  pair<int, int> pre[SZ];
  pair<long long, long long> cost[SZ];
  long long totCost, curCost;
  long long totFlow;
  void reweight() {
    for (int i = 0; i < N; i++)
      for (auto &p : adj[i]) p.cost += cost[i].first - cost[p.to].first;
  }
  bool spfa() {
    for (int i = 0; i < N; i++) cost[i] = make_pair(INF, 0);
    cost[second] = make_pair(0, INF);
    pqg<pair<long long, int>> todo;
    todo.push({0, second});
    while ((int)todo.size()) {
      auto x = poll(todo);
      if (x.first > cost[x.second].first) continue;
      for (auto &a : adj[x.second])
        if (x.first + a.cost < cost[a.to].first && a.flow < a.cap) {
          pre[a.to] = {x.second, a.rev};
          cost[a.to] = {x.first + a.cost,
                        min(a.cap - a.flow, cost[x.second].second)};
          todo.push({cost[a.to].first, a.to});
        }
    }
    curCost += cost[t].first;
    return cost[t].second;
  }
  void backtrack() {
    long long df = cost[t].second;
    totFlow += df, totCost += curCost * df;
    for (int x = t; x != second; x = pre[x].first) {
      adj[x][pre[x].second].flow -= df;
      adj[pre[x].first][adj[x][pre[x].second].rev].flow += df;
    }
  }
  pair<long long, long long> calc(int _N, int _s, int _t) {
    N = _N;
    second = _s, t = _t;
    totFlow = totCost = curCost = 0;
    while (spfa()) {
      reweight();
      backtrack();
    }
    return {totFlow, totCost};
  }
};
void solve() {
  int n, k;
  cin >> n >> k;
  vector<pair<long long, long long>> minion;
  for (int i = 0; i < n; i++) {
    long long a, b;
    cin >> a >> b;
    minion.push_back(make_pair(a, b));
  }
  mcmf<160> G;
  int second = n + k + 1;
  int t = n + k + 2;
  for (int i = 0; i < n; i++) G.addEdge(second, i, 1, 0);
  for (int i = n; i < n + k; i++) G.addEdge(i, t, 1, 0);
  G.addEdge(n + k, t, n - k, 0);
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < k; j++) {
      G.addEdge(i, j + n, 1, -(minion[i].first + j * minion[i].second));
    }
  }
  for (int i = 0; i < n; i++)
    G.addEdge(i, n + k, 1, -(k - 1) * minion[i].second);
  pair<long long, long long> sol = G.calc(t + 1, second, t);
  assert(sol.first == n);
  vector<int> ans;
  for (int i = n; i < n + k - 1; i++) {
    for (auto &e : G.adj[i]) {
      if (e.flow == -1) {
        ans.push_back(e.to + 1);
      }
    }
  }
  for (auto &e : G.adj[n + k]) {
    if (e.flow == -1) {
      ans.push_back(e.to + 1);
      ans.push_back(-(e.to + 1));
    }
  }
  for (auto &e : G.adj[n + k - 1]) {
    if (e.flow == -1) {
      ans.push_back(e.to + 1);
    }
  }
  cout << ans.size() << endl;
  for (int i = 0; i < ans.size(); i++) cout << ans[i] << ' ';
  cout << endl;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
  int t;
  cin >> t;
  for (int i = 0; i < t; i++) solve();
}
