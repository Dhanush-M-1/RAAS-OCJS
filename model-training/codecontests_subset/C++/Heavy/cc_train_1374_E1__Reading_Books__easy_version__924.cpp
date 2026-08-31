#include <bits/stdc++.h>
using namespace std;
const int NR = 4e5 + 10;
void Min(int& x, int y) { x = min(x, y); }
void Max(int& x, int y) { x = max(x, y); }
int read() {
  int x = 0, f = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    x = (x << 3) + (x << 1) + (ch ^ 48);
    ch = getchar();
  }
  return x * f;
}
int n, m, k, mx;
struct PPP {
  int x, id;
  bool operator<(const PPP& A) const { return x < A.x; }
} xx[4][NR];
int a[4][NR], tt[4];
int id[4][NR];
int sum[4][NR];
bool Flag;
struct Segment {
  int tr[NR], sz[NR];
  void clear() {
    memset(tr, 0, sizeof(tr));
    memset(sz, 0, sizeof(sz));
  }
  void update(int rt) {
    tr[rt] = tr[(rt << 1)] + tr[(rt << 1 | 1)],
    sz[rt] = sz[(rt << 1)] + sz[(rt << 1 | 1)];
  }
  void change(int rt, int l, int r, int pos, int val) {
    if (l == r) {
      sz[rt] += val;
      tr[rt] += val * pos;
      return;
    }
    int mid = (l + r >> 1);
    if (pos <= mid)
      change((rt << 1), l, mid, pos, val);
    else
      change((rt << 1 | 1), mid + 1, r, pos, val);
    update(rt);
  }
  int query(int rt, int l, int r, int x) {
    if (sz[rt] < x) return -1;
    if (l == r) return (sz[rt]) ? tr[rt] / sz[rt] * x : 0;
    int mid = (l + r >> 1);
    if (sz[(rt << 1)] > x)
      return query((rt << 1), l, mid, x);
    else
      return query((rt << 1 | 1), mid + 1, r, x - sz[(rt << 1)]) +
             tr[(rt << 1)];
  }
} T;
int ans = 0x3f3f3f3f * 2, ansid;
int Ans[NR << 2], all;
struct Nd {
  int x, d;
  bool operator<(const Nd& A) const { return d < A.d; }
} b[NR << 2];
int tot;
Nd md(int x, int d) {
  Nd tmp;
  tmp.x = x, tmp.d = d;
  return tmp;
}
int main() {
  n = read(), m = read(), k = read();
  for (int i = 1; i <= n; i++) {
    int x = read(), p = read(), q = read();
    xx[p * 2 + q][++tt[p * 2 + q]].x = x;
    xx[p * 2 + q][tt[p * 2 + q]].id = i;
    Max(mx, x);
  }
  for (int i = 0; i < 4; i++) sort(xx[i] + 1, xx[i] + tt[i] + 1);
  for (int i = 0; i < 4; i++)
    for (int j = 1; j <= tt[i]; j++) {
      id[i][j] = xx[i][j].id;
      a[i][j] = xx[i][j].x;
    }
  for (int t = 0; t < 4; t++)
    for (int i = 1; i <= tt[t]; i++) T.change(1, 1, mx, a[t][i], 1);
  for (int t = 0; t < 4; t++)
    for (int i = 1; i <= tt[t]; i++) sum[t][i] = sum[t][i - 1] + a[t][i];
  int num = min(tt[1], tt[2]);
  if (num + tt[3] < k || tt[1] + tt[2] + tt[0] + tt[3] < m ||
      min(k, tt[3]) + min(num, k - tt[3]) * 2 > m) {
    puts("-1");
    return 0;
  }
  num = k - min(k, tt[3]);
  for (int i = 1; i <= num; i++)
    for (int j = 1; j <= 2; j++) T.change(1, 1, mx, a[j][i], -1);
  for (int i = 1; i <= min(k, tt[3]); i++) T.change(1, 1, mx, a[3][i], -1);
  for (int i = min(k, tt[3]); i >= 0; i--) {
    int sy = T.query(1, 1, mx, m - i - num * 2);
    if (m < i + num * 2 || sy == -1) {
      num++;
      if (num > min(tt[1], tt[2])) break;
      T.change(1, 1, mx, a[3][i], 1);
      T.change(1, 1, mx, a[1][num], -1);
      T.change(1, 1, mx, a[2][num], -1);
      continue;
    }
    if (ans > sy + sum[3][i] + sum[1][num] + sum[2][num])
      ans = sy + sum[3][i] + sum[1][num] + sum[2][num], ansid = i;
    num++;
    if (num > min(tt[1], tt[2])) break;
    T.change(1, 1, mx, a[3][i], 1);
    T.change(1, 1, mx, a[1][num], -1);
    T.change(1, 1, mx, a[2][num], -1);
  }
  num = k - ansid;
  for (int i = 1; i <= num; i++) Ans[++all] = id[1][i], Ans[++all] = id[2][i];
  for (int i = 1; i <= ansid; i++) Ans[++all] = id[3][i];
  for (int i = ansid + 1; i <= tt[3]; i++) b[++tot] = md(id[3][i], a[3][i]);
  for (int i = num + 1; i <= tt[1]; i++) b[++tot] = md(id[1][i], a[1][i]);
  for (int i = num + 1; i <= tt[2]; i++) b[++tot] = md(id[2][i], a[2][i]);
  for (int i = 1; i <= tt[0]; i++) b[++tot] = md(id[0][i], a[0][i]);
  sort(b + 1, b + tot + 1);
  for (int i = 1; i <= m - ansid - num * 2; i++) Ans[++all] = b[i].x;
  if (ans == 0x3f3f3f3f * 2) {
    puts("-1");
    return 0;
  }
  printf("%d\n", ans);
  for (int i = 1; i <= all; i++) printf("%d ", Ans[i]);
  return 0;
}
