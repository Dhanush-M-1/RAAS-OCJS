#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, k;
  while (cin >> n >> m >> k) {
    set<pair<int, int> > st;
    vector<vector<int> > G(n + 1);
    vector<int> deg(n + 1), vis(n + 1), x(m), y(m), ans(m);
    for (int i = 0; i < m; i++) {
      cin >> x[i] >> y[i];
      deg[x[i]]++;
      deg[y[i]]++;
      G[x[i]].push_back(y[i]);
      G[y[i]].push_back(x[i]);
    }
    queue<int> q;
    for (int i = 1; i <= n; i++) {
      if (deg[i] < k) {
        vis[i] = true;
        q.push(i);
      }
    }
    for (int cnt = n, day = m - 1; day >= 0; day--) {
      if (day != m - 1) {
        int u = x[day + 1], v = y[day + 1];
        if (!st.count(make_pair(u, v))) {
          st.insert(make_pair(u, v));
          st.insert(make_pair(v, u));
          if (--deg[u] < k && !vis[u]) {
            vis[u] = true;
            q.push(u);
          }
          if (--deg[v] < k && !vis[v]) {
            vis[v] = true;
            q.push(v);
          }
        }
      }
      while (!q.empty()) {
        int u = q.front();
        q.pop();
        cnt--;
        for (int i = 0; i < G[u].size(); i++) {
          int v = G[u][i];
          if (!st.count(make_pair(u, v))) {
            st.insert(make_pair(u, v));
            st.insert(make_pair(v, u));
            if (--deg[v] < k && !vis[v]) {
              vis[v] = true;
              q.push(v);
            }
          }
        }
      }
      ans[day] = cnt;
    }
    for (int i = 0; i < m; i++) {
      cout << ans[i] << endl;
    }
  }
  return 0;
}
