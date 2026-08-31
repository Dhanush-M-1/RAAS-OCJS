#include <bits/stdc++.h>
using namespace std;
const int N = int(200000) + 5;
int t, n, m, q, k, cnt, sum, x, y, l, r;
int a[N], b[N], ans[N];
pair<int, int> edge[N];
vector<pair<int, int> > v[N];
set<pair<int, int> > s;
set<pair<int, int> >::iterator it;
void update(int I) {
  while (!s.empty() && (s.begin()->first) < k) {
    it = s.begin();
    x = it->second;
    for (int i = 0; i < v[x].size(); i++) {
      y = v[x][i].first;
      if (v[x][i].second >= I) continue;
      if (b[y]) {
        s.erase({a[y], y});
        a[y]--;
        s.insert({a[y], y});
      }
    }
    b[x] = 0;
    s.erase(it);
  }
  return;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cin >> n >> m >> k;
  for (int i = 1; i <= m; i++) {
    cin >> x >> y;
    edge[i].first = x;
    edge[i].second = y;
    a[x]++;
    a[y]++;
    v[x].push_back({y, i});
    v[y].push_back({x, i});
  }
  for (int i = 1; i <= n; i++) {
    s.insert({a[i], i});
    b[i] = 1;
  }
  update(1e6);
  for (int i = m; i >= 1; i--) {
    ans[i] = s.size();
    l = edge[i].first;
    r = edge[i].second;
    if (b[l] && b[r]) {
      s.erase({a[l], l});
      a[l]--;
      s.insert({a[l], l});
      s.erase({a[r], r});
      a[r]--;
      s.insert({a[r], r});
      update(i);
    }
  }
  for (int i = 1; i <= m; i++) cout << ans[i] << '\n';
  return 0;
}
