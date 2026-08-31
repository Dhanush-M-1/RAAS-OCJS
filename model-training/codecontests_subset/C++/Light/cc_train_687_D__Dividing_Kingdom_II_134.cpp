#include <bits/stdc++.h>
using namespace std;
int n, m, Q;
pair<pair<int, int>, pair<int, int> > q[1000111];
int p[1111];
int d[1111];
vector<int> v[1111];
int main() {
  cin >> n >> m >> Q;
  for (int i = 0; i < m; i++) {
    scanf("%d%d%d", &q[i].second.first, &q[i].second.second, &q[i].first.first);
    q[i].second.first--;
    q[i].second.second--;
    q[i].first.second = i;
  }
  sort(q, q + m);
  reverse(q, q + m);
  for (int i = 0; i < Q; i++) {
    int l, r;
    cin >> l >> r;
    l--;
    r--;
    for (int i = 0; i < n; i++) v[i].clear();
    for (int i = 0; i < n; i++) {
      p[i] = i;
      d[i] = 0;
      v[i].push_back(i);
    }
    int ans = -1;
    for (int i = 0; i < m; i++)
      if (q[i].first.second >= l && q[i].first.second <= r) {
        int x = q[i].second.first;
        int y = q[i].second.second;
        if (p[x] == p[y]) {
          if (d[x] == d[y]) {
            ans = q[i].first.first;
            break;
          }
          continue;
        }
        int we = 1 ^ d[x] ^ d[y];
        if (v[p[x]].size() > v[p[y]].size()) swap(x, y);
        int c = p[x];
        for (int j = 0; j < v[c].size(); j++) {
          int t = v[c][j];
          d[t] = d[t] ^ we;
          p[t] = p[y];
          v[p[y]].push_back(t);
        }
      }
    cout << ans << endl;
  }
  return 0;
}
