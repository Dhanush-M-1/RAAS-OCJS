#include <bits/stdc++.h>
#pragma warning(disable : 4996)
using namespace std;
int n;
vector<set<int> > g(200000);
vector<int> used(200000);
int main() {
  int n, m, k;
  cin >> n >> m >> k;
  vector<int> x(m);
  vector<int> y(m);
  for (int i = 0; i < m; i++) {
    cin >> x[i] >> y[i];
    x[i]--;
    y[i]--;
    g[x[i]].insert(y[i]);
    g[y[i]].insert(x[i]);
  }
  set<pair<int, int> > s;
  vector<int> v(n);
  for (int i = 0; i < n; i++) {
    s.insert(make_pair(g[i].size(), i));
    v[i] = g[i].size();
  }
  while (s.size()) {
    int a = s.begin()->first;
    int b = s.begin()->second;
    if (a < k) {
      s.erase(make_pair(a, b));
      v[b] = 0;
      for (auto i = g[b].begin(); i != g[b].end(); i++)
        if (v[*i] >= k) {
          s.erase(make_pair(v[*i], *i));
          v[*i]--;
          s.insert(make_pair(v[*i], *i));
        }
    } else
      break;
  }
  vector<int> ans(m);
  ans[m - 1] = s.size();
  for (int i = m - 1; i >= 1; i--) {
    int fl = 0;
    if (s.find(make_pair(v[x[i]], x[i])) != s.end()) fl++;
    if (s.find(make_pair(v[y[i]], y[i])) != s.end()) fl++;
    if (fl != 2)
      ans[i - 1] = ans[i];
    else {
      s.erase(make_pair(v[x[i]], x[i]));
      s.erase(make_pair(v[y[i]], y[i]));
      v[x[i]]--;
      v[y[i]]--;
      s.insert(make_pair(v[x[i]], x[i]));
      s.insert(make_pair(v[y[i]], y[i]));
      g[x[i]].erase(y[i]);
      g[y[i]].erase(x[i]);
      while (s.size()) {
        int a = s.begin()->first;
        int b = s.begin()->second;
        if (a < k) {
          s.erase(make_pair(a, b));
          v[b] = 0;
          for (auto i = g[b].begin(); i != g[b].end(); i++)
            if (v[*i] >= k) {
              s.erase(make_pair(v[*i], *i));
              v[*i]--;
              s.insert(make_pair(v[*i], *i));
            }
        } else
          break;
      }
      ans[i - 1] = s.size();
    }
  }
  for (int i = 0; i < m; i++) cout << ans[i] << " ";
  return 0;
}
