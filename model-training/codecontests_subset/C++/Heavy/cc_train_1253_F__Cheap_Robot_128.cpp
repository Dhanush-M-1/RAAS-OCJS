#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ld = long double;
using pii = pair<int, int>;
using pll = pair<ll, ll>;
ll n, m, k, q, a, b, c;
ll p[300100], res[300100], d[300100];
vector<pll> E[300100];
map<int, bool> token[300100];
bool compare(const pll a, const pll b) { return a > b; }
int _find(int x) { return p[x] ? p[x] = _find(p[x]) : x; }
void dijkstra() {
  vector<pll> que;
  memset(d, 0x3f, sizeof(d));
  for (int i = 1; i <= k; i++) {
    d[i] = 0;
    for (auto it : E[i]) que.push_back({it.second, it.first});
  }
  make_heap(que.begin(), que.end(), compare);
  while (que.size()) {
    pll qw = que.front();
    pop_heap(que.begin(), que.end(), compare);
    que.pop_back();
    if (d[qw.second] <= qw.first) continue;
    d[qw.second] = qw.first;
    for (auto it : E[qw.second])
      que.push_back({qw.first + it.second, it.first}),
          push_heap(que.begin(), que.end(), compare);
  }
}
int main() {
  cin >> n >> m >> k >> q;
  for (int i = 1; i <= m; i++)
    cin >> a >> b >> c, E[a].push_back({b, c}), E[b].push_back({a, c});
  dijkstra();
  vector<pair<ll, pair<int, int> > > e;
  for (int i = 1; i <= n; i++)
    for (auto it : E[i])
      if (i < it.first)
        e.push_back({d[i] + d[it.first] + it.second, {i, it.first}});
  for (int i = 1; i <= q; i++)
    cin >> a >> b, token[a][i] = true, token[b][i] = true;
  sort(e.begin(), e.end());
  for (auto x : e) {
    if (_find(x.second.first) == _find(x.second.second)) continue;
    int pA = _find(x.second.first);
    int pB = _find(x.second.second);
    if (token[pA].size() > token[pB].size()) swap(pA, pB);
    p[pA] = pB;
    for (auto y : token[pA]) {
      if (token[pB][y.first]) {
        res[y.first] = x.first;
        token[pB].erase(y.first);
      } else
        token[pB][y.first] = true;
    }
  }
  for (int i = 1; i <= q; i++) cout << res[i] << '\n';
  return 0;
}
