#include <bits/stdc++.h>
using namespace std;
const int maxn = 100010;
struct Point {
  int x, y;
  Point() {}
  Point(int _x, int _y) : x(_x), y(_y) {}
} a[maxn];
int srt;
vector<int> ver[maxn];
int has(vector<int> &a, int b) {
  auto it = lower_bound(a.begin(), a.end(), b);
  return it != a.end() && *it == b;
}
int work(int &n) {
  for (int i = 0; i <= 100000; i++) ver[i].clear();
  for (int i = 0; i < n; i++) ver[a[i].x].push_back(a[i].y);
  for (int i = 0; i <= 100000; i++) sort(ver[i].begin(), ver[i].end());
  int res = 0;
  for (int i = 0; i <= 100000; i++)
    if (ver[i].size() <= srt) {
      for (int u = 0; u < ver[i].size(); u++)
        for (int v = u + 1; v < ver[i].size(); v++) {
          int y0 = ver[i][u];
          int y1 = ver[i][v];
          int x0 = i - (y1 - y0);
          int x1 = i + (y1 - y0);
          if (x0 >= 0) res += has(ver[x0], y0) && has(ver[x0], y1);
          if (x1 <= 100000 && ver[x1].size() > srt)
            res += has(ver[x1], y0) && has(ver[x1], y1);
        }
    }
  n = 0;
  for (int x = 0; x <= 100000; x++)
    if (ver[x].size() > srt)
      for (auto y : ver[x]) a[n++] = Point(x, y);
  return res;
}
int main() {
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) cin >> a[i].x >> a[i].y;
  srt = (int)(sqrt(n) + 1e-9);
  int res = work(n);
  for (int i = 0; i < n; i++) swap(a[i].x, a[i].y);
  res += work(n);
  cout << res << endl;
  return 0;
}
