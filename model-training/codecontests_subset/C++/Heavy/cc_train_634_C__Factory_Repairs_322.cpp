#include <bits/stdc++.h>
using namespace std;
long long sg[800100][2], a, b, k, n, q;
long long querry(int id, int l, int r, int x, int y, int t) {
  if (l > y || r < x) return 0;
  if (l >= x && r <= y) return sg[id][t];
  return querry(id * 2, l, (l + r) / 2, x, y, t) +
         querry(id * 2 + 1, (l + r) / 2 + 1, r, x, y, t);
}
void updt(int id, int l, int r, int x, long long v, int t) {
  if (l > x || r < x) return;
  if (l == x && r == x) {
    sg[id][t] = min(sg[id][t] + v, t ? a : b);
    return;
  }
  updt(id * 2, l, (l + r) / 2, x, v, t);
  updt(id * 2 + 1, (l + r) / 2 + 1, r, x, v, t);
  sg[id][t] = sg[id * 2][t] + sg[id * 2 + 1][t];
}
int main() {
  scanf("%lld %lld %lld %lld %lld", &n, &k, &a, &b, &q);
  for (int i = 0; i < q; i++) {
    int t;
    scanf(" %d", &t);
    if (t == 1) {
      int x;
      long long y;
      scanf(" %d %lld", &x, &y);
      updt(1, 1, n, x, y, 1);
      updt(1, 1, n, x, y, 0);
    } else {
      int x;
      scanf(" %d", &x);
      cout << querry(1, 1, n, 1, x - 1, 0) + querry(1, 1, n, x + k, n, 1)
           << endl;
      ;
    }
  }
  return 0;
}
