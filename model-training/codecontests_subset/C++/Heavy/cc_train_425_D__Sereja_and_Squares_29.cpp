#include <bits/stdc++.h>
using namespace std;
int n, i, j, AN, A, B, o, SZ;
struct P {
  int x, y;
} p[111111];
bool mp[77777777], pm[77777777];
bool cmp(P a, P b) { return a.x + a.y < b.x + b.y; }
int Hash(int x, int y) {
  int w = (1ll * x * 100007 + 100000 - y) % 77777777;
  return w;
}
int Hash2(int x, int y) {
  int w = (1ll * x * 1000007 + y) % 77777777;
  return w;
}
int main() {
  scanf("%d", &n);
  SZ = 300;
  for (i = 1; i <= n; i++)
    scanf("%d%d", &p[i].x, &p[i].y),
        mp[Hash(p[i].x, p[i].y)] = 1, pm[Hash2(p[i].x, p[i].y)] = 1;
  sort(p + 1, p + n + 1, cmp);
  for (i = 1; i <= n; i = j) {
    for (j = i; p[j].x + p[j].y == p[i].x + p[i].y && j <= n; j++)
      ;
    if (j - i > SZ) {
      for (A = 1; A < i; A++) {
        o = p[i].x + p[i].y - p[A].x - p[A].y;
        if (mp[Hash(p[A].x + o, p[A].y + o)])
          if (mp[Hash(p[A].x + o, p[A].y)])
            if (mp[Hash(p[A].x, p[A].y + o)])
              if (pm[Hash2(p[A].x + o, p[A].y + o)])
                if (pm[Hash2(p[A].x + o, p[A].y)])
                  if (pm[Hash2(p[A].x + o, p[A].y)]) AN++;
      }
    } else {
      for (A = i; A < j; A++)
        for (B = A + 1; B < j; B++) {
          if (mp[Hash(p[A].x, p[B].y)])
            if (mp[Hash(p[B].x, p[A].y)])
              if (pm[Hash2(p[A].x, p[B].y)])
                if (pm[Hash2(p[B].x, p[A].y)]) AN++;
        }
    }
  }
  printf("%d", AN);
}
