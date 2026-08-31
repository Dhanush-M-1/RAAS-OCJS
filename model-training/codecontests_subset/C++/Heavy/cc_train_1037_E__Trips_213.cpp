#include <bits/stdc++.h>
using namespace std;
set<int> v[200005];
int x[200005];
int y[200005];
int an[200005];
set<pair<int, int> > s;
void r(int i, int k) {
  if (v[x[i]].size() >= k && v[y[i]].size() >= k) {
    s.erase(pair<int, int>(v[x[i]].size(), x[i]));
    s.erase(pair<int, int>(v[y[i]].size(), y[i]));
    v[x[i]].erase(y[i]);
    v[y[i]].erase(x[i]);
    s.insert(pair<int, int>(v[x[i]].size(), x[i]));
    s.insert(pair<int, int>(v[y[i]].size(), y[i]));
  }
}
void solve(int k) {
  if (s.empty() || s.begin()->first >= k) return;
  int x = s.begin()->second;
  s.erase(s.begin());
  for (auto it = v[x].begin(); it != v[x].end(); it++)
    if (v[*it].size() >= k) {
      s.erase(pair<int, int>(v[*it].size(), *it));
      v[*it].erase(x);
      s.insert(pair<int, int>(v[*it].size(), *it));
    }
  solve(k);
}
int main() {
  ios::sync_with_stdio(false);
  int n, m, k;
  cin >> n >> m >> k;
  for (int i = 0; i < m; i++) {
    cin >> x[i] >> y[i];
    v[x[i]].insert(y[i]);
    v[y[i]].insert(x[i]);
  }
  for (int i = 0; i < n; i++) {
    s.insert(pair<int, int>(v[i + 1].size(), i + 1));
  }
  for (int i = m - 1; i >= 0; i--) {
    solve(k);
    an[i] = s.size();
    r(i, k);
  }
  for (int i = 0; i < m; i++) cout << an[i] << endl;
}
