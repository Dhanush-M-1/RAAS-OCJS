#include <bits/stdc++.h>
using namespace std;
const int N = 200005;
int n;
int sz[N];
int par[N];
int cnt[N];
bool visit[N];
vector<pair<int, int> > G[N];
void dfs(int u) {
  sz[u] = 1;
  for (auto v : G[u])
    if (par[u] != v.first) {
      par[v.first] = u, dfs(v.first), sz[u] += sz[v.first];
    }
}
int main() {
  ios::sync_with_stdio(false);
  cin >> n;
  for (int i = 1; i <= n; ++i) {
    int p;
    cin >> p;
    if (p) G[p].push_back({i, 0}), G[i].push_back({p, 0});
  }
  if (n % 2 == 0) {
    cout << "NO";
    return 0;
  }
  dfs(1);
  for (int i = 1; i <= n; ++i) {
    sort(G[i].begin(), G[i].end());
    for (auto &j : G[i]) {
      if (par[i] == j.first) {
        j.second = (n - sz[i]) & 1;
      } else {
        j.second = sz[j.first] & 1;
      }
      cnt[i] += !j.second;
    }
  }
  queue<int> qu;
  for (int i = 1; i <= n; ++i) {
    if (!cnt[i]) qu.push(i), visit[i] = 1;
  }
  cout << "YES\n";
  while (qu.size()) {
    int u = qu.front();
    qu.pop();
    cout << u << '\n';
    for (auto v : G[u]) {
      auto i =
          lower_bound(G[v.first].begin(), G[v.first].end(), make_pair(u, 0));
      cnt[v.first] -= !(i->second);
      if (!cnt[v.first] && !visit[v.first]) {
        qu.push(v.first), visit[v.first] = 1;
      }
    }
  }
}
