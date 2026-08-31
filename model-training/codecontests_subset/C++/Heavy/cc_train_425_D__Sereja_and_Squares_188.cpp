#include <bits/stdc++.h>
using namespace std;
long long hashval(const pair<int, int> &v) {
  return v.first * 239017LL + v.second;
}
int main() {
  unordered_map<int, vector<int> > by_x, by_y;
  unordered_set<long long> Hashes;
  int x, y, n;
  cin >> n;
  vector<pair<int, int> > pts(n);
  for (int i = 0; i < n; i++) {
    cin >> x >> y;
    by_x[x].push_back(y);
    by_y[y].push_back(x);
    pts[i] = make_pair(x, y);
    Hashes.insert(hashval(make_pair(x, y)));
  }
  int ans = 0;
  for (int i = 0; i < n; i++) {
    x = pts[i].first;
    y = pts[i].second;
    const vector<int> &xc = by_x[x];
    const vector<int> &yc = by_y[y];
    if (xc.size() < yc.size()) {
      for (int other_y : xc)
        if (other_y > y) {
          int len = other_y - y;
          if (Hashes.count(hashval(make_pair(x + len, y))) &&
              Hashes.count(hashval(make_pair(x + len, y + len))))
            ans++;
        }
    } else {
      for (int other_x : yc)
        if (other_x > x) {
          int len = other_x - x;
          if (Hashes.count(hashval(make_pair(x, y + len))) &&
              Hashes.count(hashval(make_pair(x + len, y + len))))
            ans++;
        }
    }
  }
  cout << ans << endl;
}
