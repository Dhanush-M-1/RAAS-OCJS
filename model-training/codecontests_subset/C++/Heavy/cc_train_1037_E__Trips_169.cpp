#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int n, m, k;
  cin >> n >> m >> k;
  pair<int, int> vv[m];
  set<int> adj[n];
  int deg[n];
  for (int i = 0; i < n; i++) deg[i] = 0;
  for (int i = 0; i < m; i++) {
    int x, y;
    cin >> x >> y;
    x--;
    y--;
    vv[i] = make_pair(x, y);
    deg[x]++;
    deg[y]++;
    adj[x].insert(y);
    adj[y].insert(x);
  }
  int ans[m], good = n;
  bool done[n];
  for (int i = 0; i < n; i++) done[i] = 0;
  set<pair<int, int> > st;
  priority_queue<pair<int, int> > pq;
  for (int i = 0; i < n; i++) pq.push(make_pair(-deg[i], i));
  for (int i = m - 1; i >= 0; i--) {
    while (!pq.empty()) {
      pair<int, int> p = pq.top();
      pq.pop();
      if (-p.first >= k) {
        pq.push(p);
        break;
      }
      if (done[p.second]) continue;
      done[p.second] = true;
      good--;
      int ix = p.second;
      for (set<int>::iterator it = adj[ix].begin(); it != adj[ix].end(); it++) {
        deg[*it]--;
        adj[*it].erase(ix);
        pq.push(make_pair(-deg[*it], *it));
      }
      deg[ix] = 0;
      adj[ix].clear();
    }
    ans[i] = good;
    if (adj[vv[i].first].find(vv[i].second) != adj[vv[i].first].end()) {
      deg[vv[i].first]--;
      pq.push(make_pair(-deg[vv[i].first], vv[i].first));
      deg[vv[i].second]--;
      pq.push(make_pair(-deg[vv[i].second], vv[i].second));
      adj[vv[i].first].erase(vv[i].second);
      adj[vv[i].second].erase(vv[i].first);
    }
  }
  for (int i = 0; i < m; i++) cout << ans[i] << endl;
  return 0;
}
