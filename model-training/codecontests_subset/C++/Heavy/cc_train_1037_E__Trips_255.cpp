#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  long long int n, m, k;
  cin >> n >> m >> k;
  vector<pair<long long int, long long int> > edges(m);
  set<long long int> adj[n];
  for (int i = 0; i < m; ++i) {
    long long int u, v;
    cin >> u >> v;
    u--;
    v--;
    adj[u].insert(v);
    adj[v].insert(u);
    edges[i].first = u;
    edges[i].second = v;
  }
  set<pair<long long int, long long int> > myset;
  set<pair<long long int, long long int> >::iterator it;
  for (int i = 0; i < n; ++i) {
    myset.insert({adj[i].size(), i});
  }
  set<long long int>::iterator itt;
  vector<long long int> ans(m, 0);
  for (int i = m - 1; i > -1; --i) {
    while (!myset.empty() && myset.begin()->first < k) {
      long long int ind = myset.begin()->second;
      myset.erase(myset.begin());
      for (auto v : adj[ind]) {
        it = myset.find({adj[v].size(), v});
        itt = adj[v].find(ind);
        if (it != myset.end() && itt != adj[v].end()) {
          myset.erase(it);
          adj[v].erase(itt);
          myset.insert({adj[v].size(), v});
        }
      }
    }
    ans[i] = myset.size();
    long long int u = edges[i].first, v = edges[i].second;
    it = myset.find({adj[u].size(), u});
    itt = adj[u].find(v);
    if (it != myset.end() && itt != adj[u].end()) {
      myset.erase(it);
      adj[u].erase(itt);
      myset.insert({adj[u].size(), u});
    }
    it = myset.find({adj[v].size(), v});
    itt = adj[v].find(u);
    if (it != myset.end() && itt != adj[v].end()) {
      myset.erase(it);
      adj[v].erase(itt);
      myset.insert({adj[v].size(), v});
    }
  }
  for (int i = 0; i < m; ++i) {
    cout << ans[i] << "\n";
  }
  return 0;
}
