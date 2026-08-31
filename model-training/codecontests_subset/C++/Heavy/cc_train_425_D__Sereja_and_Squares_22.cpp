#include <bits/stdc++.h>
using namespace std;
const int MX = 100010;
set<pair<int, int> > s;
set<int> x[MX], y[MX];
int xc[MX] = {}, yc[MX] = {};
int main() {
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int xx, yy;
    scanf("%d %d", &xx, &yy);
    s.insert(pair<int, int>(xx, yy));
  }
  long long r = 0;
  for (pair<int, int> p : s) {
    if (xc[p.first] < yc[p.second]) {
      int u = min(p.second, MX + p.second - p.first);
      for (int d : x[p.first]) {
        if (d >= u) break;
        if (d < p.second - p.first) continue;
        if (x[p.first + d - p.second].count(d) &&
            x[p.first + d - p.second].count(p.second)) {
          r++;
        }
      }
    } else {
      int u = min(p.first, MX + p.first - p.second);
      for (int d : y[p.second]) {
        if (d >= u) break;
        if (d < p.first - p.second) continue;
        if (y[p.second + d - p.first].count(d) &&
            y[p.second + d - p.first].count(p.first)) {
          r++;
        }
      }
    }
    x[p.first].insert(p.second);
    xc[p.first]++;
    y[p.second].insert(p.first);
    yc[p.second]++;
  }
  cout << r << endl;
  return 0;
}
