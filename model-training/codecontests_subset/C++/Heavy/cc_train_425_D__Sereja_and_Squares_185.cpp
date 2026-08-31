#include <bits/stdc++.h>
#pragma GCC optimize("-O3")
#pragma GCC optimize("-Ofast")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
#pragma GCC optimize("unroll-loops")
using namespace std;
const int N = 1e5 + 5;
int n, x, y, ans, px[N], py[N];
vector<int> sx[N], sy[N];
unordered_map<int, bool> Mx[N], My[N];
struct Point {
  int x, y;
  bool operator<(const Point& p) const {
    if (this->x + this->y != p.x + p.y) return (this->x + this->y < p.x + p.y);
    return this->x < p.x;
  }
};
vector<Point> p;
int32_t main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> x >> y, sx[x].push_back(y), sy[y].push_back(x), Mx[x][y] = true,
                                                           My[y][x] = true;
    Point pp;
    pp.x = x, pp.y = y;
    p.push_back(pp);
  }
  for (int i = 0; i < N; i++)
    sort(sx[i].begin(), sx[i].end()), sort(sy[i].begin(), sy[i].end());
  sort(p.begin(), p.end());
  for (int i = 0; i < p.size(); i++) {
    Point pp = p[i];
    x = pp.x, y = pp.y;
    px[x]++, py[y]++;
    if (sx[x].size() < sy[y].size()) {
      for (int i = px[x]; i < sx[x].size(); i++) {
        int y2 = sx[x][i];
        int x2 = x + y2 - y;
        if (x2 < N and Mx[x2][y] and Mx[x2][y2]) ans++;
      }
    } else {
      for (int i = py[y]; i < sy[y].size(); i++) {
        int x2 = sy[y][i];
        int y2 = y + x2 - x;
        if (y2 < N and My[y2][x] and My[y2][x2]) ans++;
      }
    }
  }
  cout << ans;
  return 0;
}
