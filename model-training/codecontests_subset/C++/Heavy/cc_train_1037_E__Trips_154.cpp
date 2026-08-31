#include <bits/stdc++.h>
int dr[] = {2, 2, -2, -2, 1, -1, 1, -1};
int dc[] = {1, -1, 1, -1, 2, 2, -2, -2};
int dr1[] = {0, 0, 1, 1, 1, -1, -1, -1};
int dc1[] = {1, -1, 1, 0, -1, 0, 1, -1};
int dr2[] = {0, 0, 1, -1};
int dc2[] = {1, -1, 0, 0};
using namespace std;
long long a[200005], b[200005], deg[200005];
vector<long long> adj[200005];
long long ans[200005], mark[200005];
int main() {
  long long n, m, k, i, j;
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  while (cin >> n >> m >> k) {
    set<pair<long long, long long> > s;
    set<pair<long long, long long> >::iterator it;
    for (i = 1; i <= m; i++) {
      cin >> a[i] >> b[i];
      deg[a[i]]++;
      deg[b[i]]++;
      adj[a[i]].push_back(b[i]);
      adj[b[i]].push_back(a[i]);
    }
    for (i = 1; i <= n; i++) {
      mark[i] = 1;
      s.insert(make_pair(deg[i], i));
    }
    map<pair<long long, long long>, long long> mp;
    for (i = m; i >= 1; i--) {
      for (j = 1;; j++) {
        if (s.size() == 0) break;
        it = s.begin();
        long long x = it->first;
        long long y = it->second;
        if (x >= k) break;
        mark[y] = 0;
        s.erase(s.find({deg[y], y}));
        for (j = 0; j < adj[y].size(); j++) {
          long long p = adj[y][j];
          if (mp[{y, p}] == 1) continue;
          s.erase(s.find({deg[p], p}));
          deg[p]--;
          s.insert({deg[p], p});
          mp[{y, p}] = mp[{p, y}] = 1;
        }
      }
      ans[i] = s.size();
      long long x = a[i];
      long long y = b[i];
      if (mp[{x, y}] == 1) continue;
      mp[{x, y}] = mp[{y, x}] = 1;
      s.erase(s.find({deg[x], x}));
      deg[x]--;
      s.insert({deg[x], x});
      s.erase(s.find({deg[y], y}));
      deg[y]--;
      s.insert({deg[y], y});
    }
    for (i = 1; i <= m; i++) cout << ans[i] << endl;
  }
  return 0;
}
