#include <bits/stdc++.h>
using namespace std;
pair<pair<int, int>, pair<int, int> > E[1000000];
int p[1002], d[1002];
pair<int, int> find(int u, int cur) {
  if (p[u] != u) {
    pair<int, int> res = find(p[u], (cur + d[u]) % 2);
    int pp = res.first;
    int dd = res.second;
    p[u] = pp;
    d[u] = (cur + dd) % 2;
    return make_pair(pp, dd);
  } else {
    return make_pair(u, cur);
  }
}
int main() {
  ios::sync_with_stdio(0);
  int n, m, q;
  cin >> n >> m >> q;
  for (int i = 1; i <= m; i++) {
    int u, v, w;
    cin >> E[i].second.first >> E[i].second.second >> E[i].first.first;
    E[i].first.second = i;
  }
  sort(E + 1, E + m + 1);
  for (int i = 0; i < q; i++) {
    for (int i = 1; i <= n; i++) {
      p[i] = i;
      d[i] = 0;
    }
    int l, r;
    cin >> l >> r;
    bool found = false;
    int w = 12341234;
    for (int j = m; j >= 1; j--) {
      int ind = E[j].first.second;
      if (ind < l || ind > r) continue;
      w = E[j].first.first;
      int u = E[j].second.first;
      int v = E[j].second.second;
      pair<int, int> res = find(u, 0);
      int r = res.first;
      int d1 = res.second;
      res = find(v, 0);
      int s = res.first;
      int d2 = res.second;
      if (r != s) {
        p[s] = r;
        d[s] = (d1 + d2 + 1) % 2;
      } else if (d1 == d2) {
        found = true;
        break;
      }
    }
    if (found) {
      cout << w << endl;
    } else {
      cout << -1 << endl;
    }
  }
}
