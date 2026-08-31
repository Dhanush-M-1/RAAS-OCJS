#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 5;
int n, m, k;
int du[maxn];
set<int> g[maxn];
vector<pair<int, int> > ar;
set<pair<int, int> > st;
set<int>::iterator it;
int ans[maxn];
void dfs() {
  if (st.size() == 0) return;
  if (st.begin()->first < k) {
    int u = st.begin()->second;
    st.erase(st.begin());
    for (it = g[u].begin(); it != g[u].end(); it++) {
      int v = *it;
      if (st.count(make_pair(du[v], v))) {
        st.erase(make_pair(du[v], v));
        du[v]--;
        st.insert(make_pair(du[v], v));
      }
    }
    dfs();
  }
}
int main() {
  int u, v;
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 0; i < m; i++) {
    scanf("%d%d", &u, &v);
    du[u]++;
    du[v]++;
    g[u].insert(v);
    g[v].insert(u);
    ar.push_back(make_pair(u, v));
  }
  for (int i = 1; i <= n; i++) {
    st.insert(make_pair(du[i], i));
  }
  dfs();
  for (int i = m - 1; i >= 0; i--) {
    ans[i] = st.size();
    u = ar[i].first;
    v = ar[i].second;
    if (st.count(make_pair(du[u], u)) && st.count(make_pair(du[v], v))) {
      st.erase(make_pair(du[u], u));
      st.erase(make_pair(du[v], v));
      du[u]--;
      du[v]--;
      st.insert(make_pair(du[u], u));
      st.insert(make_pair(du[v], v));
      g[u].erase(v);
      g[v].erase(u);
      dfs();
    }
  }
  for (int i = 0; i < m; i++) printf("%d\n", ans[i]);
  return 0;
}
