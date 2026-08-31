#include <bits/stdc++.h>
using namespace std;
const int N = 1001, M = 500000;
int n, m, q, fa[N * 2], l, r;
int qr() {
  int ans = 0, f = 1;
  char ch = getchar();
  while (!isdigit(ch)) f = ch == '-' ? -1 : 1, ch = getchar();
  while (isdigit(ch)) ans = ans * 10 + ch - '0', ch = getchar();
  return ans * f;
}
struct node {
  int x, y, w, num;
} p[M];
bool cmp(node a, node b) { return a.w > b.w; }
int getf(int u) {
  if (fa[u] == u)
    return u;
  else {
    fa[u] = getf(fa[u]);
    return fa[u];
  }
}
void ma(int u, int v) {
  int t1 = getf(u), t2 = getf(v);
  if (t1 == t2) return;
  fa[t1] = t2;
  return;
}
int main() {
  cin >> n >> m >> q;
  for (int i = 1; i <= m; i++) {
    p[i].x = qr();
    p[i].y = qr();
    p[i].w = qr();
    p[i].num = i;
  }
  sort(p + 1, p + 1 + m, cmp);
  int ans;
  while (q--) {
    ans = -1;
    l = qr(), r = qr();
    for (int i = 1; i <= 2 * n; i++) fa[i] = i;
    for (int i = 1; i <= m; i++) {
      if (p[i].num >= l && p[i].num <= r) {
        if (getf(p[i].x) == getf(p[i].y)) {
          ans = p[i].w;
          break;
        } else {
          ma(p[i].x, p[i].y + n);
          ma(p[i].y, p[i].x + n);
        }
      }
    }
    cout << ans << endl;
  }
  return 0;
}
