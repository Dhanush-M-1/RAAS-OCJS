#include <bits/stdc++.h>
using namespace std;
const int INF = (-1u) / 2;
const long long int INF2 = (-1ull) / 2;
int a, b, i, j, k, n, m, timer = 0, l, r, x, y;
int c[1011000], cnt = 0, fl = 0, a2, a3 = -1000000, ans = 0;
int t[3][200110];
void update(int idx, int id, int ad) {
  while (idx <= n) {
    t[id][idx] += ad;
    idx += (idx & -idx);
  }
}
int take(int idx, int id) {
  int sm = 0;
  while (idx > 0) {
    sm += t[id][idx];
    idx -= (idx & -idx);
  }
  return sm;
}
int main() {
  ios_base::sync_with_stdio(0);
  scanf("%d%d%d%d%d", &n, &k, &a, &b, &m);
  for (i = 0; i < m; i++) {
    scanf("%d", &x);
    if (x == 1) {
      scanf("%d%d", &x, &y);
      if (c[x] + y <= a) {
        update(x, 0, y);
      } else {
        if (a - c[x] > 0) update(x, 0, a - c[x]);
      }
      if (c[x] + y <= b) {
        update(x, 1, y);
      } else {
        if (b - c[x] > 0) update(x, 1, b - c[x]);
      }
      if (c[x] <= a) c[x] += y;
    } else {
      scanf("%d", &x);
      l = take(x - 1, 1);
      r = take(n, 0) - take(x + k - 1, 0);
      printf("%d\n", l + r);
    }
  }
  return 0;
}
