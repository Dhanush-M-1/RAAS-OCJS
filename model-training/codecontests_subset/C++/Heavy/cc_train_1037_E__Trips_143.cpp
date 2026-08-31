#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 7;
int n, m, k, deg[N], ans[N], s[N], t[N];
map<int, bool> adj[N];
vector<int> g[N];
bool alive[N];
void solve() {
  priority_queue<pair<int, int>, vector<pair<int, int> >,
                 greater<pair<int, int> > >
      q;
  memset(alive, 1, sizeof(alive));
  for (int u = 1; u <= n; u++) q.push(make_pair(deg[u], u));
  while (q.size()) {
    pair<int, int> now = q.top();
    if (now.first >= k) break;
    q.pop();
    if (!alive[now.second]) continue;
    alive[now.second] = 0;
    for (int &v : g[now.second]) {
      deg[v]--;
      if (alive[v]) q.push(make_pair(deg[v], v));
    }
  }
  int res = 0;
  for (int u = 1; u <= n; u++) res += alive[u];
  ans[m] = res;
  for (int i = m; i >= 1; i--) {
    if (alive[s[i]] && alive[t[i]]) {
      deg[s[i]]--;
      deg[t[i]]--;
      adj[s[i]][t[i]] = 0;
      adj[t[i]][s[i]] = 0;
      q.push(make_pair(deg[s[i]], s[i]));
      q.push(make_pair(deg[t[i]], t[i]));
      pair<int, int> now = q.top();
      while (q.size()) {
        pair<int, int> now = q.top();
        if (now.first >= k) break;
        q.pop();
        if (!alive[now.second]) continue;
        --res;
        alive[now.second] = 0;
        for (int &v : g[now.second]) {
          if (!adj[now.second][v]) continue;
          --deg[v];
          if (alive[v]) q.push(make_pair(deg[v], v));
        }
      }
    }
    ans[i - 1] = res;
  }
  for (int i = 1; i <= m; i++) printf("%d\n ", ans[i]);
}
int main() {
  scanf("%d %d %d ", &n, &m, &k);
  for (int i = 1; i <= m; i++) {
    scanf("%d %d ", &s[i], &t[i]);
    deg[s[i]]++;
    deg[t[i]]++;
    adj[s[i]][t[i]] = adj[t[i]][s[i]] = 1;
    g[s[i]].push_back(t[i]);
    g[t[i]].push_back(s[i]);
  }
  solve();
}
