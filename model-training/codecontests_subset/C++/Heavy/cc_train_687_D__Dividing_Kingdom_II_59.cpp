#include <bits/stdc++.h>
using namespace std;
int n, m, q;
struct bian {
  int from, to, w, i;
} b[2000000];
int cmp(const bian &a, const bian &b) {
  if (a.w > b.w)
    return 1;
  else
    return 0;
}
int l[10000], r[10000];
int father[10000], path[10000];
int findd(int x) {
  if (father[x] == x) return x;
  int t = father[x];
  father[x] = findd(father[x]);
  path[x] = (path[t] + path[x]) % 2;
  return father[x];
}
int fx, fy;
int main() {
  cin >> n >> m >> q;
  for (int i = 1; i <= m; i++) {
    scanf("%d%d%d", &b[i].from, &b[i].to, &b[i].w);
    b[i].i = i;
  }
  sort(b + 1, b + m + 1, cmp);
  for (int i = 1; i <= q; i++) scanf("%d%d", &l[i], &r[i]);
  for (int i = 1; i <= q; i++) {
    int ans = 0;
    for (int j = 1; j <= n; j++) {
      path[j] = 0;
      father[j] = j;
    }
    for (int j = 1; j <= m; j++)
      if (b[j].i <= r[i] && b[j].i >= l[i]) {
        fx = findd(b[j].from);
        fy = findd(b[j].to);
        if (fx != fy) {
          father[fx] = fy;
          path[fx] = (1 + path[b[j].from] + path[b[j].to]) % 2;
        } else if (path[b[j].from] == path[b[j].to]) {
          cout << b[j].w << endl;
          ans = 1;
          break;
        }
      }
    if (!ans) cout << -1 << endl;
    ;
  }
  return 0;
}
