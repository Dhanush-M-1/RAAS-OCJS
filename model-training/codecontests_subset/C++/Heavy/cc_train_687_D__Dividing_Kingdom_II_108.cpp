#include <bits/stdc++.h>
using namespace std;
struct road {
  int start, end, len, id;
} rd[500005];
int fa[2005];
bool cmp(road x, road y) { return x.len > y.len; }
inline int getf(int x) {
  if (fa[x] == x) return fa[x];
  return fa[x] = getf(fa[x]);
}
inline void con(int x, int y) {
  int f1, f2;
  f1 = getf(x), f2 = getf(y);
  if (f1 != f2) fa[f1] = f2;
}
int main() {
  int n, m, q;
  cin >> n >> m >> q;
  for (int i = 1; i <= m; i++) {
    cin >> rd[i].start >> rd[i].end >> rd[i].len;
    rd[i].id = i;
  }
  sort(rd + 1, rd + 1 + m, cmp);
  while (q--) {
    int ans = -1, l, r;
    cin >> l >> r;
    for (int i = 1; i <= n * 2; i++) {
      fa[i] = i;
    }
    for (int i = 1; i <= m; i++) {
      if (rd[i].id >= l && rd[i].id <= r) {
        if (getf(rd[i].start) == getf(rd[i].end)) {
          ans = rd[i].len;
          break;
        } else {
          con(rd[i].start + n, rd[i].end);
          con(rd[i].start, rd[i].end + n);
        }
      }
    }
    printf("%d\n", ans);
  }
  return 0;
}
