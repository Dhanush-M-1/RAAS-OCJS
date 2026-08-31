#include <bits/stdc++.h>
using namespace std;
int n, m, k, q;
int x[300100], y[300100], w[300100];
set<int> mp[300100];
int dsu[300100], sz[300100];
bool ch[300100];
long long d[300100], ans[300100];
vector<pair<int, long long>> v[300100];
vector<pair<long long, pair<int, int>>> p;
void multisource_dijkstra() {
  priority_queue<pair<long long, int>> q;
  for (int i = 1; i <= k; i++) {
    q.push({0, i});
  }
  while (!q.empty()) {
    long long a = q.top().first;
    int b = q.top().second;
    q.pop();
    if (ch[b]) continue;
    ch[b] = true;
    a = -a;
    d[b] = a;
    for (auto i : v[b]) {
      if (ch[i.first]) continue;
      q.push({-(a + i.second), i.first});
    }
  }
}
int root(int s) {
  while (s != dsu[s]) {
    dsu[s] = dsu[dsu[s]];
    s = dsu[s];
  }
  return s;
}
void spoj(int a, int b, long long wgh) {
  if (sz[a] > sz[b]) swap(a, b);
  dsu[a] = b;
  sz[b] += sz[a];
  for (auto i : mp[a]) {
    auto it = mp[b].find(i);
    if (it != mp[b].end()) {
      ans[i] = min(ans[i], wgh);
    }
    mp[b].insert(i);
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  for (int i = 0; i <= 3e5; i++) {
    dsu[i] = i;
    sz[i] = 1;
    ans[i] = 2e18;
  }
  memset((d), 0, sizeof((d)));
  cin >> n >> m >> k >> q;
  for (int i = 1; i <= m; i++) {
    cin >> x[i] >> y[i] >> w[i];
    v[x[i]].push_back({y[i], w[i]});
    v[y[i]].push_back({x[i], w[i]});
  }
  for (int i = 1; i <= q; i++) {
    int a, b;
    cin >> a >> b;
    mp[a].insert(i);
    mp[b].insert(i);
  }
  multisource_dijkstra();
  for (int i = 1; i <= m; i++) {
    long long u = w[i] + d[x[i]] + d[y[i]];
    p.push_back({u, {x[i], y[i]}});
  }
  sort((p).begin(), (p).end());
  for (auto i : p) {
    int a = root(i.second.first);
    int b = root(i.second.second);
    if (a == b) continue;
    spoj(a, b, i.first);
  }
  for (int i = 1; i <= q; i++) {
    cout << ans[i] << " ";
  }
  return 0;
}
