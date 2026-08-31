#include <bits/stdc++.h>
using namespace std;
const int MAXN = 100005;
vector<int> p[MAXN];
vector<int> q[MAXN];
vector<pair<int, int> > points;
int n;
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    int x, y;
    scanf("%d %d", &x, &y);
    p[x].push_back(y);
    q[y].push_back(x);
    points.push_back({x, y});
  }
  for (int i = 0; i < MAXN; i++) {
    sort(p[i].begin(), p[i].end());
    sort(q[i].begin(), q[i].end());
  }
  long long ans = 0;
  for (auto point : points) {
    int x = point.first;
    int y = point.second;
    if (p[x].size() <= q[y].size()) {
      for (auto concha : p[x]) {
        if (concha == y)
          break;
        else if (x - y + concha < 0)
          continue;
        int r =
            upper_bound(p[x - y + concha].begin(), p[x - y + concha].end(), y) -
            lower_bound(p[x - y + concha].begin(), p[x - y + concha].end(), y);
        int s = upper_bound(p[x - y + concha].begin(), p[x - y + concha].end(),
                            concha) -
                lower_bound(p[x - y + concha].begin(), p[x - y + concha].end(),
                            concha);
        if (r > 0 && s > 0) ans++;
      }
    } else {
      for (auto x1 : q[y]) {
        if (x1 == x)
          break;
        else if (y - x + x1 < 0)
          continue;
        int r = upper_bound(q[y - x + x1].begin(), q[y - x + x1].end(), x) -
                lower_bound(q[y - x + x1].begin(), q[y - x + x1].end(), x);
        int s = upper_bound(q[y - x + x1].begin(), q[y - x + x1].end(), x1) -
                lower_bound(q[y - x + x1].begin(), q[y - x + x1].end(), x1);
        if (r > 0 && s > 0) ans++;
      }
    }
  }
  printf("%lld\n", ans);
}
