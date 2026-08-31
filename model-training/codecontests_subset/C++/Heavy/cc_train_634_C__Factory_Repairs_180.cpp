#include <bits/stdc++.h>
using namespace std;
long long oo = (long long)1e9 + 7;
int n, k, a, b, q;
int fuck[6 * 100008] = {0}, lol[6 * 100008] = {0};
void input() {
  scanf("%d%d", &n, &k);
  scanf("%d%d", &a, &b);
  scanf("%d", &q);
}
void updat(int p, int l, int r, int day, int val) {
  if (day > r || day < l) return;
  if (l == r && l == day) {
    fuck[p] += val;
    fuck[p] = min(fuck[p], a);
    return;
  }
  int son = p << 1, midd = (l + r) >> 1;
  updat(son, l, midd, day, val);
  updat(son + 1, midd + 1, r, day, val);
  fuck[p] = fuck[son] + fuck[son + 1];
}
void update(int p, int l, int r, int day, int val) {
  if (day > r || day < l) return;
  if (l == r && l == day) {
    lol[p] += val;
    lol[p] = min(lol[p], b);
    return;
  }
  int son = p << 1, midd = (l + r) >> 1;
  update(son, l, midd, day, val);
  update(son + 1, midd + 1, r, day, val);
  lol[p] = lol[son] + lol[son + 1];
}
int sum(int p, int l, int r, int st, int nd) {
  if (st > r || nd < l) return 0;
  if (l >= st && r <= nd) return fuck[p];
  int son = p << 1, midd = (l + r) >> 1;
  return sum(son, l, midd, st, nd) + sum(son + 1, midd + 1, r, st, nd);
}
int get(int p, int l, int r, int st, int nd) {
  if (st > r || nd < l) return 0;
  if (l >= st && r <= nd) return lol[p];
  int son = p << 1, midd = (l + r) >> 1;
  return get(son, l, midd, st, nd) + get(son + 1, midd + 1, r, st, nd);
}
int main() {
  input();
  for (int i = 0; i < q; i++) {
    int typ;
    scanf("%d", &typ);
    if (typ == 1) {
      int ai, di;
      scanf("%d%d", &di, &ai);
      updat(1, 1, n, di, ai);
      update(1, 1, n, di, ai);
    } else {
      int p;
      scanf("%d", &p);
      int ans = 0;
      if (p > 1) ans += get(1, 1, n, 1, p - 1);
      if (p + k <= n) ans += sum(1, 1, n, p + k, n);
      printf("%d\n", ans);
    }
  }
}
