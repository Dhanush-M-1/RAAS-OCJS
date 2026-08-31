#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 10;
int n, tot;
long long ans, ans1, ans2;
struct dot {
  long long x, v, nv;
} a[maxn];
struct node {
  long long cnt, d;
} T[maxn * 4];
bool cmp1(dot x, dot y) { return x.v < y.v; }
bool cmp2(dot x, dot y) { return x.x < y.x; }
void pushup(int x) {
  T[x].cnt = T[(x << 1)].cnt + T[(x << 1 | 1)].cnt;
  T[x].d = T[(x << 1)].d + T[(x << 1 | 1)].d;
}
void insert(int x, int l, int r, int pos, int p) {
  if (l == r) {
    T[x].cnt++;
    T[x].d += a[p].x;
    return;
  }
  int mid = (l + r) >> 1;
  if (pos <= mid)
    insert((x << 1), l, mid, pos, p);
  else
    insert((x << 1 | 1), mid + 1, r, pos, p);
  pushup(x);
}
void query(int x, int l, int r, int sj, int tj) {
  if (sj <= l && r <= tj) {
    ans1 += T[x].cnt;
    ans2 += T[x].d;
    return;
  }
  int mid = (l + r) >> 1;
  if (sj <= mid) query((x << 1), l, mid, sj, tj);
  if (mid + 1 <= tj) query((x << 1 | 1), mid + 1, r, sj, tj);
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%lld", &a[i].x);
  for (int i = 1; i <= n; i++) scanf("%lld", &a[i].v);
  sort(a + 1, a + n + 1, cmp1);
  tot = 0;
  a[1].nv = ++tot;
  for (int i = 2; i <= n; i++) {
    if (a[i].v == a[i - 1].v)
      a[i].nv = tot;
    else
      a[i].nv = ++tot;
  }
  sort(a + 1, a + n + 1, cmp2);
  ans = 0;
  for (int i = 1; i <= n; i++) {
    ans1 = ans2 = 0;
    query(1, 1, tot, 1, a[i].nv);
    ans += ans1 * a[i].x - ans2;
    insert(1, 1, tot, a[i].nv, i);
  }
  printf("%lld", ans);
  return 0;
}
