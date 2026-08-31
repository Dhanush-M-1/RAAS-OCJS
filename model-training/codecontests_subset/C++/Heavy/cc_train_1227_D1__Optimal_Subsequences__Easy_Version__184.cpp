#include <bits/stdc++.h>
using namespace std;
bool cmp(pair<int, int> a, pair<int, int> b) {
  if (a.first > b.first)
    return true;
  else if (a.first == b.first) {
    if (a.second < b.second) return true;
    return false;
  }
  return false;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int i, j, k, l, m, n, p, x, t;
  vector<pair<int, int> > v, c;
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> x;
    v.push_back({x, i});
  }
  sort(v.begin(), v.end(), cmp);
  cin >> m;
  for (i = 1; i <= m; i++) {
    cin >> k >> p;
    for (j = 0; j < k; j++) c.push_back({v[j].second, v[j].first});
    sort(c.begin(), c.end());
    cout << c[p - 1].second << endl;
    c.clear();
  }
  return 0;
}
