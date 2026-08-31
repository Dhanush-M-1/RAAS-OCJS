#include <bits/stdc++.h>
using namespace std;
long long int pw(long long int a, long long int b, long long int mod) {
  if (!b) return 1;
  if (b & 1) return a * pw(a * a % mod, b / 2, mod) % mod;
  return pw(a * a % mod, b / 2, mod) % mod;
}
const long long int MAXN = 2e5 + 10;
const long long int INF = 8e18;
const long long int MOD = 1e9 + 7;
int n, m, mark[MAXN], last[MAXN];
vector<int> adj[MAXN];
vector<pair<int, pair<int, int>>> ans;
void DFS(int u, int p = -1) {
  mark[u] = 1;
  vector<int> now;
  for (int v : adj[u]) {
    if (mark[v] == 2 || v == p) continue;
    if (mark[v] == 1) {
      now.push_back(v);
      continue;
    }
    DFS(v, u);
    if (last[v])
      ans.push_back({last[v], {v, u}});
    else
      now.push_back(v);
  }
  for (int i = 0; i + 1 < now.size(); i += 2) {
    ans.push_back({now[i], {u, now[i + 1]}});
  }
  if (now.size() % 2 == 1) last[u] = now[now.size() - 1];
  mark[u] = 2;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  cin >> n >> m;
  if (m % 2 == 1) return cout << "No solution" << '\n', 0;
  ;
  for (int i = 0; i < m; i++) {
    int u, v;
    cin >> u >> v;
    adj[u].push_back(v);
    adj[v].push_back(u);
  }
  for (int i = 1; i <= n; i++)
    if (mark[i] == 0) {
      DFS(i);
    }
  if (ans.size() != m / 2) return cout << "No solution" << '\n', 0;
  ;
  for (auto p : ans) {
    cout << p.first << ' ' << p.second.first << ' ' << p.second.second << '\n';
  }
  return 0;
}
