#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 1e4;
struct Point {
  int x, y;
  Point() {}
  Point(int x, int y) : x(x), y(y) {}
} point[N];
set<int> ss[N];
vector<Point> pp[N];
vector<Point>::iterator it;
int n, num[N], which[10000];
int cmp(const Point &a, const Point &b) {
  if (a.x != b.x) return a.x < b.x;
  return a.y < b.y;
}
bool check(int x, int y, int lower) {
  if (x < 0 || x > 100000) return 0;
  if (num[x] <= lower) return 0;
  if (ss[x].find(y) != ss[x].end())
    return 1;
  else
    return 0;
}
int main() {
  cin >> n;
  int maxn = sqrt(n);
  memset(num, 0, sizeof(num));
  for (int i = 1; i <= n; i++) {
    scanf("%d%d", &point[i].x, &point[i].y);
    ss[point[i].x].insert(point[i].y);
    num[point[i].x]++;
  }
  sort(point + 1, point + n + 1, cmp);
  point[0].x = -1;
  point[n + 1].x = 2e5;
  int l = 1;
  int ans = 0;
  for (int i = 1; i <= n + 1; i++) {
    if (i <= n && num[point[i].x] > maxn) pp[point[i].x].push_back(point[i]);
    if (point[i].x != point[i - 1].x) {
      int r = i - 1;
      if (num[point[i - 1].x] <= maxn) {
        for (int i = l; i < r; i++)
          for (int j = i + 1; j <= r; j++) {
            int len = point[j].y - point[i].y;
            if (check(point[i].x + len, point[i].y, 1) &&
                check(point[j].x + len, point[j].y, 1))
              ans++;
            if (check(point[i].x - len, point[i].y, maxn) &&
                check(point[j].x - len, point[j].y, maxn))
              ans++;
          }
      }
      l = i;
    }
  }
  int m = 0;
  for (int i = 0; i <= 100000; i++)
    if (num[i] > maxn) which[++m] = i;
  for (int i = 1; i <= m - 1; i++)
    for (int j = i + 1; j <= m; j++)
      for (it = pp[which[i]].begin(); it != pp[which[i]].end(); it++) {
        int len = which[j] - which[i];
        int x = (*it).x, y = (*it).y;
        if (check(x, y + len, 0) && check(x + len, y + len, 0) &&
            check(x + len, y, 0))
          ans++;
      }
  cout << ans << endl;
}
