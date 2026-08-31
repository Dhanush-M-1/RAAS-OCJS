#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1e5 + 1, sqr = 600;
int n, ans = 0;
unordered_set<int> cl[MAXN], rw[MAXN];
priority_queue<pair<int, pair<int, int>>> sz;
inline void calc_rw(int i) {
  for (int j : rw[i])
    for (int k : rw[i]) {
      if (k <= j) continue;
      int x1 = i, y1 = j, y2 = k, df = y2 - y1;
      if (x1 + df < MAXN && cl[y1].count(x1 + df) && cl[y2].count(x1 + df))
        ans++;
      if (x1 - df >= 0 && cl[y1].count(x1 - df) && cl[y2].count(x1 - df)) ans++;
    }
  for (int j : rw[i]) {
    cl[j].erase(i);
    if ((int)cl[j].size()) sz.push({-(int)cl[j].size(), {j, 1}});
  }
  rw[i].clear();
  return;
}
inline void calc_cl(int i) {
  for (int j : cl[i])
    for (int k : cl[i]) {
      if (k <= j) continue;
      int x1 = i, y1 = j, y2 = k, df = y2 - y1;
      if (x1 + df < MAXN && rw[y1].count(x1 + df) && rw[y2].count(x1 + df))
        ans++;
      if (x1 - df >= 0 && rw[y1].count(x1 - df) && rw[y2].count(x1 - df)) ans++;
    }
  for (int j : cl[i]) {
    rw[j].erase(i);
    if ((int)rw[j].size()) sz.push({-(int)rw[j].size(), {j, 1}});
  }
  cl[i].clear();
  return;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (int i = 0; i < n; i++) {
    int x, y;
    cin >> x >> y;
    rw[x].insert(y);
    cl[y].insert(x);
  }
  for (int i = 0; i < MAXN; i++) {
    if ((int)rw[i].size()) sz.push({-(int)rw[i].size(), {i, 0}});
    if ((int)cl[i].size()) sz.push({-(int)cl[i].size(), {i, 1}});
  }
  while (!sz.empty()) {
    int ind = sz.top().second.first, ty = sz.top().second.second,
        tt = sz.top().first;
    sz.pop();
    if (ty && -tt == (int)cl[ind].size())
      calc_cl(ind);
    else if (-tt == (int)rw[ind].size())
      calc_rw(ind);
  }
  cout << ans << endl;
  return 0;
}
