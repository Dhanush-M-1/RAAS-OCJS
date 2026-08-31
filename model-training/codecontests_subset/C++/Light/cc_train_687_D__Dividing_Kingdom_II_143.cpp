#include <bits/stdc++.h>
using namespace std;
int n, m, dad[1234567];
int q;
int l, r;
struct way {
  int l, r, val, id;
} w[1234567];
bool com(way x, way y) { return x.val < y.val; }
int finddad(int x) { return (x == dad[x]) ? x : dad[x] = finddad(dad[x]); }
void gop(int x, int y) {
  int xx = finddad(x), yy = finddad(y);
  if (xx != yy) dad[xx] = yy;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin >> n >> m >> q;
  for (int i = 1; i <= m; i++) {
    cin >> w[i].l >> w[i].r >> w[i].val;
    w[i].id = i;
  }
  sort(w + 1, w + m + 1, com);
  while (q--) {
    cin >> l >> r;
    int luu = 0;
    for (int i = 1; i <= 2 * n; i++) dad[i] = i;
    for (int j = m; j >= 1; j--) {
      if (l <= w[j].id && r >= w[j].id) {
        if (finddad(w[j].l) == finddad(w[j].r)) {
          cout << w[j].val << endl;
          luu = 1;
          break;
        }
        gop(w[j].l + n, w[j].r);
        gop(w[j].l, w[j].r + n);
      }
    }
    if (!luu) cout << -1 << endl;
  }
  return 0;
}
