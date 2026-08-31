#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 10;
int n, k, a, b, q;
struct T {
  int L, R;
  int sum[3];
} dat[maxn << 2];
void pushUp(int root) {
  for (int i = 0; i < 3; i++)
    dat[root].sum[i] = dat[root << 1].sum[i] + dat[root << 1 | 1].sum[i];
}
void update(int pos, int val, int root) {
  if (dat[root].L == dat[root].R) {
    int add = dat[root].sum[2] + val;
    dat[root].sum[0] = min(b, add);
    dat[root].sum[1] = min(a, add);
    dat[root].sum[2] = add;
    return;
  }
  int m = (dat[root].L + dat[root].R) >> 1;
  if (pos <= m)
    update(pos, val, root << 1);
  else
    update(pos, val, root << 1 | 1);
  pushUp(root);
}
int query(int a, int b, int root, int flag) {
  if (a > b) return 0;
  if (a == dat[root].L && dat[root].R == b) return dat[root].sum[flag];
  int m = (dat[root].L + dat[root].R) >> 1;
  if (b <= m)
    return query(a, b, root << 1, flag);
  else if (a > m)
    return query(a, b, root << 1 | 1, flag);
  else
    return query(a, m, root << 1, flag) + query(m + 1, b, root << 1 | 1, flag);
}
void build(int root, int l, int r) {
  dat[root].L = l;
  dat[root].R = r;
  for (int i = 0; i < 3; i++) dat[root].sum[i] = 0;
  if (l == r) return;
  int m = (l + r) >> 1;
  build(root << 1, l, m);
  build(root << 1 | 1, m + 1, r);
}
int main() {
  while (~scanf("%d%d%d%d%d", &n, &k, &a, &b, &q)) {
    build(1, 1, n);
    while (q--) {
      int cmd;
      scanf("%d", &cmd);
      if (cmd == 1) {
        int day, cnt;
        scanf("%d%d", &day, &cnt);
        update(day, cnt, 1);
      } else {
        int from;
        scanf("%d", &from);
        int ans = query(1, from - 1, 1, 0) + query(from + k, n, 1, 1);
        printf("%d\n", ans);
      }
    }
  }
  return 0;
}
