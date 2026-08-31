#include <bits/stdc++.h>
using namespace std;
int d[5100], n, m, was[5100], a[5100];
vector<pair<pair<int, int>, pair<int, int> > > q;
int main() {
  cin >> n >> m;
  for (int i = 1; i <= m; i++) {
    int type;
    cin >> type;
    if (type == 1) {
      int l, r, add;
      cin >> l >> r >> add;
      for (int j = l; j <= r; j++) d[j] += add;
      q.push_back(make_pair(make_pair(1, l), make_pair(r, add)));
    } else {
      int l, r, mx, w = 0;
      cin >> l >> r >> mx;
      for (int j = l; j <= r; j++) {
        if (was[j] == 0) {
          was[j] = 1;
          a[j] = mx - d[j];
          w = 1;
        } else {
          if (a[j] + d[j] >= mx) {
            a[j] = mx - d[j];
            w = 1;
          }
        }
      }
      if (w == 0) {
        for (int j = l; j <= r; j++) a[j] = mx - d[j];
      }
      q.push_back(make_pair(make_pair(2, l), make_pair(r, mx)));
    }
  }
  for (int i = 1; i <= n; i++) d[i] = 0;
  for (int i = 0; i < q.size(); i++) {
    if (q[i].first.first == 1) {
      for (int j = q[i].first.second; j <= q[i].second.first; j++)
        d[j] += q[i].second.second;
    } else {
      int mx = -(1 << 30);
      for (int j = q[i].first.second; j <= q[i].second.first; j++)
        mx = max(mx, a[j] + d[j]);
      if (mx != q[i].second.second) {
        cout << "NO" << endl;
        return 0;
      }
    }
  }
  cout << "YES" << endl;
  for (int i = 1; i <= n; i++) cout << a[i] << " ";
  return 0;
}
