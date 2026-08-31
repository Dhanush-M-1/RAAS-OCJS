#include <bits/stdc++.h>
using namespace std;
const int MAXN = 100010;
const int INF = 0x3fffffff;
int a[MAXN], sum[MAXN], tr[MAXN << 2], tag[MAXN << 2];
void PushDown(int rt, int l, int r) {
  if (l < r) {
    tr[rt << 1] += tag[rt], tag[rt << 1] += tag[rt];
    tr[rt << 1 | 1] += tag[rt], tag[rt << 1 | 1] += tag[rt];
  }
  tag[rt] = 0;
}
void PushUp(int rt) { tr[rt] = max(tr[rt << 1], tr[rt << 1 | 1]); }
void BuildTree(int rt, int l, int r) {
  if (l == r) {
    tr[rt] = sum[l];
    return;
  }
  int mid = (l + r) / 2;
  BuildTree(rt << 1, l, mid), BuildTree(rt << 1 | 1, mid + 1, r);
  PushUp(rt);
}
int Query(int rt, int l, int r, int s, int t) {
  if (tag[rt]) PushDown(rt, l, r);
  if (s <= l && t >= r) return tr[rt];
  int mid = (l + r) / 2, ans = -INF;
  if (s <= mid) ans = Query(rt << 1, l, mid, s, t);
  if (t > mid) ans = max(ans, Query(rt << 1 | 1, mid + 1, r, s, t));
  PushUp(rt);
  return ans;
}
void Modify(int rt, int l, int r, int s, int t, int x) {
  if (tag[rt]) PushDown(rt, l, r);
  if (s <= l && t >= r) {
    tr[rt] += x;
    tag[rt] = x;
    return;
  }
  int mid = (l + r) / 2;
  if (s <= mid) Modify(rt << 1, l, mid, s, t, x);
  if (t > mid) Modify(rt << 1 | 1, mid + 1, r, s, t, x);
  PushUp(rt);
}
int main() {
  int n, d;
  scanf("%d%d", &n, &d);
  int mx = 0;
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
    sum[i] = sum[i - 1] + a[i];
    mx = max(mx, sum[i]);
  }
  if (mx > d) {
    printf("-1\n");
    return 0;
  }
  BuildTree(1, 1, n);
  int now = 0, cnt = 0;
  for (int i = 1; i <= n; i++) {
    if (a[i] == 0) {
      if (now >= 0) continue;
      int q = Query(1, 1, n, i, n);
      now += d - q, cnt++;
      if (now < 0) {
        printf("-1");
        return 0;
      }
      if (i < n) Modify(1, 1, n, i + 1, n, d - q);
    } else {
      now += a[i];
    }
  }
  printf("%d\n", cnt);
}
