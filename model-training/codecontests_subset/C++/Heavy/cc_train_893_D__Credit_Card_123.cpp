#include <bits/stdc++.h>
using namespace std;
const int N = 100100;
int n, d, a[N], sum[N];
int T[N << 2], tag[N << 2];
void Update(int o) {
  T[o] = max(T[o << 1], T[o << 1 | 1]);
  return;
}
void Build(int o, int l, int r) {
  tag[o] = 0;
  if (l == r) {
    T[o] = sum[l];
    return;
  }
  int mid = l + r >> 1;
  Build(o << 1, l, mid);
  Build(o << 1 | 1, mid + 1, r);
  Update(o);
  return;
}
void Pushdown(int o) {
  if (tag[o] == 0) return;
  T[o << 1] += tag[o], tag[o << 1] += tag[o];
  T[o << 1 | 1] += tag[o], tag[o << 1 | 1] += tag[o];
  tag[o] = 0;
  return;
}
void Modify(int o, int l, int r, int L, int R, int x) {
  if (L > R) return;
  if (L <= l && r <= R) {
    tag[o] += x;
    T[o] += x;
    return;
  }
  Pushdown(o);
  int mid = l + r >> 1;
  if (L <= mid) Modify(o << 1, l, mid, L, R, x);
  if (R > mid) Modify(o << 1 | 1, mid + 1, r, L, R, x);
  Update(o);
  return;
}
int Query(int o, int l, int r, int L, int R) {
  if (L > R) return 0;
  if (L <= l && r <= R) return T[o];
  Pushdown(o);
  int mid = l + r >> 1;
  if (R <= mid)
    return Query(o << 1, l, mid, L, R);
  else if (L > mid)
    return Query(o << 1 | 1, mid + 1, r, L, R);
  else
    return max(Query(o << 1, l, mid, L, R),
               Query(o << 1 | 1, mid + 1, r, L, R));
}
int main() {
  scanf("%d%d", &n, &d);
  for (int i = 1; i <= n; i++) scanf("%d", &a[i]), sum[i] = sum[i - 1] + a[i];
  Build(1, 1, n);
  int cnt = 0, cur, fix;
  for (int i = 1; i <= n; i++) {
    cur = Query(1, 1, n, i, i);
    if (cur > d) {
      cnt = -1;
      break;
    }
    if (a[i] == 0) {
      if (cur < 0) {
        fix = d - Query(1, 1, n, i, n);
        if (fix + cur >= 0)
          cnt++, Modify(1, 1, n, i, n, fix);
        else {
          cnt = -1;
          break;
        }
      }
    }
  }
  printf("%d\n", cnt);
  return 0;
}
