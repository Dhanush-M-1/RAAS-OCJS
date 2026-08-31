#include <bits/stdc++.h>
using namespace std;
const int N = 3e5 + 5;
int n, m, k, deg[N], ans[N];
pair<int, int> edges[N];
set<int> adj[N];
set<pair<int, int> > st;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m >> k;
  for (int i = 1; i <= m; i++) {
    int x, y;
    cin >> x >> y;
    edges[i] = {x, y};
    adj[x].insert(y);
    adj[y].insert(x);
  }
  for (int i = 1; i <= n; i++) {
    st.insert({(int)adj[i].size(), i});
  }
  for (int i = m; i >= 1; i--) {
    while (!st.empty() && (*st.begin()).first < k) {
      int node = (*st.begin()).second;
      st.erase(st.begin());
      for (auto ch : adj[node]) {
        st.erase(st.find({(int)adj[ch].size(), ch}));
        adj[ch].erase(node);
        st.insert({(int)adj[ch].size(), ch});
      }
      adj[node].clear();
    }
    ans[i] = (int)st.size();
    if (adj[edges[i].first].find(edges[i].second) !=
        adj[edges[i].first].end()) {
      int v = edges[i].first, u = edges[i].second;
      pair<int, int> pr = {(int)adj[v].size(), v},
                     pr2 = {(int)adj[u].size(), u};
      st.erase(pr);
      st.erase(pr2);
      adj[v].erase(u), adj[u].erase(v);
      pr = {(int)adj[v].size(), v}, pr2 = pr2 = {(int)adj[u].size(), u};
      st.insert(pr);
      st.insert(pr2);
    }
  }
  for (int i = 1; i <= m; i++) cout << ans[i] << '\n';
  return 0;
}
