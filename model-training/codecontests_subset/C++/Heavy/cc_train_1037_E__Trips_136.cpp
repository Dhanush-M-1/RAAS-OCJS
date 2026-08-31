#include <bits/stdc++.h>
using namespace std;
const int MN = 2e5 + 5;
int n, m, k, x, y;
set<int> al[MN], t;
vector<pair<int, int> > el;
void del(int u) {
  if (!t.count(u) || al[u].size() >= k) return;
  t.erase(u);
  for (int v : al[u]) al[v].erase(u);
  for (int v : al[u])
    if (al[v].size() < k) del(v);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cin >> n >> m >> k;
  for (int i = 0; i < m; i++) {
    cin >> x >> y;
    el.push_back(pair<int, int>(x, y));
    al[x].insert(y);
    al[y].insert(x);
  }
  for (int i = 1; i <= n; i++) t.insert(i);
  for (int i = 1; i <= n; i++) del(i);
  int res[m + 1];
  for (int i = el.size() - 1; i >= 0; i--) {
    res[i] = t.size();
    pair<int, int> e = el[i];
    int x = e.first, y = e.second;
    al[x].erase(y);
    al[y].erase(x);
    del(x);
    del(y);
  }
  for (int i = 0; i < m; i++) {
    cout << res[i] << "\n";
  }
  return 0;
}
