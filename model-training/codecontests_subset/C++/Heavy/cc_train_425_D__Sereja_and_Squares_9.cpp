#include <bits/stdc++.h>
using namespace std;
struct Tpoint {
  int x, y;
} p[100500];
inline bool operator<(Tpoint a, Tpoint b) {
  return a.x < b.x || a.x == b.x && a.y < b.y;
}
inline bool operator==(Tpoint a, Tpoint b) { return a.x == b.x && a.y == b.y; }
int n;
inline bool check(Tpoint a) {
  int l = 0, r = n - 1;
  while (r - l > 1) {
    int mid = (l + r) >> 1;
    if (p[mid] < a)
      l = mid;
    else
      r = mid;
  }
  if (p[l] == a || p[r] == a) return true;
  return false;
}
int main() {
  int i, j, k, m;
  scanf("%d", &n);
  for (i = 0; i < n; i++) {
    scanf("%d%d", &p[i].x, &p[i].y);
  }
  sort(p, p + n);
  int pre = 0;
  int ma = 1;
  while (ma * ma <= n) ma++;
  ma--;
  int ans = 0;
  int ans1, ans2;
  ans1 = ans2 = 0;
  for (i = 0; i < n; i++) {
    int now = i;
    while (now != n - 1 && p[now].x == p[now + 1].x) now++;
    if (now - pre + 1 >= ma) {
      for (j = now; j < n; j++) {
        if (p[j].x == p[i].x) continue;
        Tpoint a, b, c;
        int len = abs(p[i].x - p[j].x);
        a.x = p[i].x;
        a.y = p[j].y;
        b.x = p[i].x;
        b.y = p[j].y - len;
        c.x = p[j].x;
        c.y = p[j].y - len;
        if (check(a) && check(b) && check(c)) ans++;
      }
    } else {
      for (j = pre; j <= now; j++) {
        for (k = j + 1; k <= now; k++) {
          int len = abs(p[k].y - p[j].y);
          Tpoint a, b;
          a.x = p[k].x + len;
          a.y = p[j].y;
          b.x = p[k].x + len;
          b.y = p[k].y;
          if (check(a) && check(b)) ans++;
        }
      }
    }
    pre = now + 1;
    i = now;
  }
  printf("%d\n", ans);
}
