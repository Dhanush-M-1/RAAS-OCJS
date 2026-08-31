#include <bits/stdc++.h>
using namespace std;
int a[1000000], b[1000000];
int main() {
  int n, m, i, j, k, l, ct = 0, s = 0, x, y;
  cin >> n >> m;
  vector<pair<int, int> > v, vx;
  for (i = 0; i < n; i++) {
    cin >> x;
    v.push_back(make_pair(x, i + 1));
  }
  for (i = 0; i < m; i++) cin >> a[i];
  for (i = 0; i < m; i++) {
    if (b[a[i]] == 0) {
      b[a[i]] = 1;
      for (j = 0; j < n; j++) {
        if (v[j].second == a[i]) {
          vx.push_back(v[j]);
          break;
        }
      }
    }
    if (vx.size() == n) break;
  }
  pair<int, int> p;
  y = a[0];
  for (i = 0; i < n; i++) {
    if (y == vx[i].second) {
      p = vx[i];
      vx.erase(vx.begin() + i);
      vx.insert(vx.begin(), p);
      break;
    }
  }
  for (i = 1; i < m; i++) {
    y = a[i];
    for (j = 0; j < vx.size(); j++) {
      if (vx[j].second == y) {
        p = vx[j];
        vx.erase(vx.begin() + j);
        vx.insert(vx.begin(), p);
        break;
      } else
        s += vx[j].first;
    }
  }
  cout << s << endl;
  return 0;
}
