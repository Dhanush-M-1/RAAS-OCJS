#include <bits/stdc++.h>
using namespace std;
int deg[200010];
vector<vector<int> > graph(200010);
map<pair<int, int>, int> edgeNum;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int tt = 1;
  while (tt--) {
    int n, m, k;
    cin >> n >> m >> k;
    int x[m], y[m];
    for (int i = 0; i < m; i++) {
      cin >> x[i] >> y[i];
      edgeNum[{x[i], y[i]}] = i;
      edgeNum[{y[i], x[i]}] = i;
      graph[x[i]].push_back(y[i]);
      graph[y[i]].push_back(x[i]);
      deg[x[i]]++;
      deg[y[i]]++;
    }
    set<pair<int, int> > s;
    for (int i = 1; i <= n; i++) {
      s.insert({deg[i], i});
    }
    set<int> removed;
    while (!s.empty()) {
      pair<int, int> tmp = *s.begin();
      s.erase(tmp);
      int ver = tmp.second;
      if (tmp.first >= k) {
        s.insert(tmp);
        break;
      }
      for (int i = 0; i < graph[ver].size(); i++) {
        if (removed.count(edgeNum[{graph[ver][i], ver}]) == 1) continue;
        removed.insert(edgeNum[{graph[ver][i], ver}]);
        s.erase({deg[graph[ver][i]], graph[ver][i]});
        deg[graph[ver][i]]--;
        s.insert({deg[graph[ver][i]], graph[ver][i]});
      }
    }
    int ans[m];
    for (int ii = m - 1; ii >= 0; --ii) {
      ans[ii] = s.size();
      if (s.count({deg[x[ii]], x[ii]}) == 0 ||
          s.count({deg[y[ii]], y[ii]}) == 0)
        continue;
      s.erase({deg[x[ii]], x[ii]});
      s.erase({deg[y[ii]], y[ii]});
      deg[x[ii]]--;
      deg[y[ii]]--;
      removed.insert(edgeNum[{x[ii], y[ii]}]);
      s.insert({deg[x[ii]], x[ii]});
      s.insert({deg[y[ii]], y[ii]});
      while (!s.empty() && ((*s.begin()).first) < k) {
        pair<int, int> tmp = *s.begin();
        s.erase(tmp);
        int ver = tmp.second;
        if (tmp.first >= k) {
          s.insert(tmp);
          break;
        }
        for (int i = 0; i < graph[ver].size(); i++) {
          if (removed.count(edgeNum[{graph[ver][i], ver}]) == 1) continue;
          s.erase({deg[graph[ver][i]], graph[ver][i]});
          removed.insert(edgeNum[{graph[ver][i], ver}]);
          deg[graph[ver][i]]--;
          s.insert({deg[graph[ver][i]], graph[ver][i]});
        }
      }
    }
    for (int i = 0; i < m; i++) {
      cout << ans[i] << '\n';
    }
  }
}
