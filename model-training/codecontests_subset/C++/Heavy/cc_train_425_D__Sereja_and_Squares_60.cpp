#include <bits/stdc++.h>
using namespace std;
struct point {
  int x, y;
};
point d[222222], e[222222];
int n, m, ans = 0, sum[222222];
bool cmp(point u, point v) {
  return (u.x < v.x) || ((u.x == v.x) && (u.y < v.y));
}
bool found(point u) {
  int low = 1, high = n, mid;
  while (low + 1 < high) {
    mid = (low + high) / 2;
    if ((u.x < d[mid].x) || ((u.x == d[mid].x) && (u.y <= d[mid].y)))
      high = mid;
    else
      low = mid;
  }
  if ((u.x == d[low].x) && (u.y == d[low].y)) return true;
  if ((u.x == d[high].x) && (u.y == d[high].y)) return true;
  return false;
}
void solve(int tp) {
  sort(d + 1, d + n + 1, cmp);
  int p = 1, last, edge;
  memset(sum, 0, sizeof(sum));
  for (int i = 1; i <= n; i++) sum[d[i].x]++;
  point u;
  while (p <= n) {
    for (int i = p; i <= n; i++)
      if (d[i].x == d[p].x)
        last = i;
      else
        break;
    if ((tp) || (last - p + 1 <= m)) {
      for (int i = p; i <= last; i++)
        for (int j = i + 1; j <= last; j++) {
          edge = d[j].y - d[i].y;
          u.x = d[i].x + edge;
          u.y = d[i].y;
          if (found(u)) {
            u.x = d[j].x + edge;
            u.y = d[j].y;
            if (found(u)) ans++;
          }
          if (!tp)
            if ((d[i].x - edge >= 0) && (sum[d[i].x - edge] > m)) {
              u.x = d[i].x - edge;
              u.y = d[i].y;
              if (found(u)) {
                u.x = d[j].x - edge;
                u.y = d[j].y;
                if (found(u)) ans++;
              }
            }
        }
    }
    p = last + 1;
  }
}
void init() {
  int p = 1, last, ne = 0;
  while (p <= n) {
    for (int i = p; i <= n; i++)
      if (d[i].x == d[p].x)
        last = i;
      else
        break;
    if (last - p + 1 > m)
      for (int i = p; i <= last; i++) e[++ne] = d[i];
    p = last + 1;
  }
  n = ne;
  for (int i = 1; i <= n; i++) d[i] = e[i];
  for (int i = 1; i <= n; i++) swap(d[i].x, d[i].y);
}
int main() {
  cin >> n;
  m = trunc(sqrt((double)n)) + 3;
  for (int i = 1; i <= n; i++) scanf("%d%d", &d[i].x, &d[i].y);
  ans = 0;
  solve(0);
  init();
  solve(1);
  cout << ans;
  return 0;
}
