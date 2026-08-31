#include <bits/stdc++.h>
const int N = 200005;
using namespace std;
int n, m, k, deg[N], ans[N];
set<pair<int, int> > st;
vector<pair<int, int> > g[N], h;
int main() {
  ios_base::sync_with_stdio(0);
  cout.tie(0);
  cin.tie(0);
  cin >> n >> m >> k;
  for (int i = 0; i < m; i++) {
    int u, v;
    cin >> u >> v;
    h.push_back({u, v});
    g[u].push_back({v, i});
    g[v].push_back({u, i});
    deg[u]++;
    deg[v]++;
  }
  for (int i = 1; i <= n; i++) st.insert({deg[i], i});
  while (st.size() && (*(st.begin())).first < k) {
    pair<int, int> e = *st.begin();
    st.erase(e);
    int u = e.second;
    for (auto E : g[u]) {
      int el = E.first;
      if (st.count({deg[el], el})) {
        st.erase({deg[el], el});
        deg[el]--;
        st.insert({deg[el], el});
      }
    }
  }
  for (int i = m - 1; i >= 0; i--) {
    ans[i] = st.size();
    int u = h[i].first, v = h[i].second;
    if (st.count({deg[u], u}) && st.count({deg[v], v})) {
      st.erase({deg[u], u});
      deg[u]--;
      st.insert({deg[u], u});
      st.erase({deg[v], v});
      deg[v]--;
      st.insert({deg[v], v});
      while (st.size() && (*(st.begin())).first < k) {
        pair<int, int> e = *st.begin();
        st.erase(e);
        int u = e.second;
        for (auto E : g[u]) {
          int el = E.first;
          if (E.second >= i) continue;
          if (st.count({deg[el], el})) {
            st.erase({deg[el], el});
            deg[el]--;
            st.insert({deg[el], el});
          }
        }
      }
    }
  }
  for (int i = 0; i < m; i++) cout << ans[i] << '\n';
  return 0;
}
