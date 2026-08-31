#include <bits/stdc++.h>
using namespace std;
long long t, n, m, u, v, q, k, p;
const int N = 1e6 + 1e5 + 500;
const long long mod = 1e9 + 7;
const long long INF = 1LL << 57;
long long arr[N];
vector<int> adj[N], ancestors[N];
bool anc[N], vis[N], isValid, isInteresting[N];
int degree[N];
bool cmp(int a, int b) { return degree[a] < degree[b]; }
void dfs(int node) {
  vis[node] = true;
  anc[node] = true;
  for (int u : adj[node]) {
    if (vis[u]) {
      if (anc[u])
        continue;
      else
        isValid = false;
    } else {
      dfs(u);
    }
  }
  anc[node] = false;
}
void dfs(int node, int deg) {
  vis[node] = true;
  anc[node] = true;
  degree[node] = deg;
  for (int u : adj[node]) {
    if (vis[u]) {
      ancestors[node].push_back(u);
    } else {
      dfs(u, deg + 1);
      for (int v : ancestors[u]) {
        if (v != node) ancestors[node].push_back(v);
      }
    }
  }
  sort(ancestors[node].begin(), ancestors[node].end(), cmp);
  while (ancestors[node].size() > 2) ancestors[node].pop_back();
}
inline int getInt(int a = INT_MIN, int b = INT_MAX) {
  static mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
  return uniform_int_distribution<int>(a, b)(rng);
}
void solve(int node) {
  vis[node] = true;
  if (ancestors[node].size() == 0)
    ;
  else if (ancestors[node].size() >= 2)
    isInteresting[node] = false;
  else {
    isInteresting[node] = isInteresting[ancestors[node][0]];
  }
  for (int u : adj[node]) {
    if (vis[u])
      continue;
    else
      solve(u);
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> t;
  while (t--) {
    cin >> n >> m;
    for (int i = 1; i <= n; ++i) {
      adj[i].clear();
      ancestors[i].clear();
      degree[i] = 0;
      isInteresting[i] = false;
    }
    for (int i = 1; i <= m; ++i) {
      cin >> u >> v;
      adj[u].push_back(v);
    }
    bool hasInteresting = false;
    int interestingNode = 0;
    for (int i = 1; i <= 100; ++i) {
      int node = getInt(1, n);
      for (int j = 1; j <= n; ++j) vis[j] = false;
      isValid = true;
      dfs(node);
      for (int j = 1; j <= n; ++j)
        if (vis[j] == false) isValid = false;
      if (isValid) {
        hasInteresting = true;
        interestingNode = node;
        break;
      }
    }
    if (!hasInteresting) {
      cout << -1 << '\n';
      continue;
    }
    isInteresting[interestingNode] = true;
    for (int j = 1; j <= n; ++j) vis[j] = false;
    dfs(interestingNode, 0);
    for (int j = 1; j <= n; ++j) vis[j] = false;
    solve(interestingNode);
    vector<int> interesting;
    for (int i = 1; i <= n; ++i)
      if (isInteresting[i]) interesting.push_back(i);
    if (interesting.size() >= ceil(0.2 * n)) {
      sort(interesting.begin(), interesting.end());
      for (int u : interesting) cout << u << " ";
      cout << '\n';
    } else
      cout << -1 << '\n';
  }
}
