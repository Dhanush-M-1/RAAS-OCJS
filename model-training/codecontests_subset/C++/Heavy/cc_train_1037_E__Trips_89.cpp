#include <bits/stdc++.h>
using namespace std;
set<int> tt[200005];
set<int> ans;
vector<pair<int, int>> ve;
int n, m, k, x, y;
int temp[200005];
void del(int x) {
  if (tt[x].size() < k && ans.find(x) != ans.end()) {
    ans.erase(x);
    for (auto i : tt[x]) {
      tt[i].erase(x);
      del(i);
    }
  }
}
int main() {
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 1; i <= m; i++) {
    scanf("%d%d", &x, &y);
    tt[x].insert(y);
    tt[y].insert(x);
    ve.push_back(make_pair(x, y));
  }
  for (int i = 1; i <= n; i++) {
    ans.insert(i);
  }
  for (int i = 1; i <= n; i++) {
    del(i);
  }
  for (int i = m - 1; i >= 0; i--) {
    temp[i] = ans.size();
    tt[ve[i].first].erase(ve[i].second);
    tt[ve[i].second].erase(ve[i].first);
    del(ve[i].first);
    del(ve[i].second);
  }
  for (int i = 0; i < m; i++) {
    printf("%d\n", temp[i]);
  }
  return 0;
}
