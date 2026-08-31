#include <bits/stdc++.h>
using namespace std;
struct data {
  int x, y;
} a[110001], b[110001];
int ans, i, j, k, n, m, px[110001], py[110001], t;
bool cmp1(data a, data b) { return a.x < b.x || a.x == b.x && a.y < b.y; }
bool cmp2(data a, data b) { return a.y < b.y || a.y == b.y && a.x < b.x; }
int bs(int x, int y) {
  int l, r, m;
  for (l = 1, r = n; l < r - 1;) {
    m = (l + r) >> 1;
    if (x == b[m].x && y == b[m].y) return m;
    if (y < b[m].y || y == b[m].y && x < b[m].x)
      r = m - 1;
    else
      l = m + 1;
  }
  if (x == b[l].x && y == b[l].y) return l;
  if (x == b[r].x && y == b[r].y) return r;
  return -1;
}
int main() {
  scanf("%d", &n);
  for (i = 1; i <= n; i++) scanf("%d%d", &a[i].x, &a[i].y), b[i] = a[i];
  sort(a + 1, a + 1 + n, cmp1);
  sort(b + 1, b + 1 + n, cmp2);
  for (i = n; i; i--) {
    if (i == n || a[i + 1].x != a[i].x)
      px[i] = i;
    else
      px[i] = px[i + 1];
    if (i == n || b[i + 1].y != b[i].y)
      py[i] = i;
    else
      py[i] = py[i + 1];
  }
  for (i = 1, ans = 0; i <= n; i++) {
    k = bs(a[i].x, a[i].y);
    if (px[i] - i < py[k] - k) {
      for (j = i + 1; j <= px[i]; j++) {
        t = a[j].y - a[i].y;
        if (bs(a[i].x + t, a[i].y) != -1 && bs(a[i].x + t, a[i].y + t) != -1)
          ans++;
      }
    } else {
      for (j = k + 1; j <= py[k]; j++) {
        t = b[j].x - b[k].x;
        if (bs(b[k].x, b[k].y + t) != -1 && bs(b[k].x + t, b[k].y + t) != -1)
          ans++;
      }
    }
  }
  printf("%d\n", ans);
  return 0;
}
