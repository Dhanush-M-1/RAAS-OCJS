#include <bits/stdc++.h>
using namespace std;
long n, m, a, b;
vector<long> g[200000];
set<pair<long, long> > done;
vector<pair<long, pair<long, long> > > ans;
long ptr[300000];
long dfs(long v) {
  vector<long> dd;
  dd.reserve(16);
  for (; ptr[v] < g[v].size(); ptr[v]++) {
    long q = g[v][ptr[v]];
    pair<long, long> p = make_pair(min(v, q), max(v, q));
    if (done.find(p) != done.end()) continue;
    if (p.first > p.second) swap(p.first, p.second);
    done.insert(p);
    long t = dfs(q);
    if (t == 0)
      dd.push_back(q);
    else {
      ans.push_back(make_pair(v, make_pair(q, t)));
    }
  }
  long t = dd.size() % 2;
  for (int i = t; i < dd.size(); i += 2) {
    long a, b;
    a = dd[i];
    b = dd[i + 1];
    ans.push_back(make_pair(a, make_pair(v, b)));
    done.insert(make_pair(min(a, v), max(a, v)));
    done.insert(make_pair(min(b, v), max(b, v)));
  }
  if (dd.size() % 2 == 0) return 0;
  done.insert(make_pair(min(dd[0], v), max(dd[0], v)));
  return dd[0];
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> m;
  if (m % 2) {
    cout << "No solution" << endl;
    return 0;
  }
  for (int i = 1; i <= m; i++) {
    cin >> a >> b;
    g[a].push_back(b);
    g[b].push_back(a);
  }
  dfs(1);
  for (int i = 0; i < ans.size(); i++) {
    cout << ans[i].first << " " << ans[i].second.first << " "
         << ans[i].second.second << endl;
  }
  cin.get();
  cin.get();
  return 0;
}
