#include <bits/stdc++.h>
using namespace std;
struct Node {
  long long l, r, rt, lz, minn, maxx;
} node[1008611];
long long a[200861], sum[400861];
long long ans[200861];
void build(long long l, long long r, long long rt) {
  long long mid = (l + r) / 2;
  node[rt].l = l, node[rt].r = r;
  node[rt].lz = 0;
  if (l == r) {
    node[rt].minn = sum[l];
    node[rt].maxx = sum[l];
    return;
  }
  build(l, mid, rt * 2);
  build(mid + 1, r, rt * 2 + 1);
  node[rt].minn = min(node[rt * 2].minn, node[rt * 2 + 1].minn);
  node[rt].maxx = max(node[rt * 2].maxx, node[rt * 2 + 1].maxx);
}
void push_down(long long rt) {
  if (node[rt].lz) {
    node[rt * 2].minn -= node[rt].lz;
    node[rt * 2 + 1].minn -= node[rt].lz;
    node[rt * 2].maxx -= node[rt].lz;
    node[rt * 2 + 1].maxx -= node[rt].lz;
    node[rt * 2].lz += node[rt].lz;
    node[rt * 2 + 1].lz += node[rt].lz;
    node[rt].lz = 0;
  }
}
long long query(long long v, long long rt) {
  if (node[rt].l == node[rt].r) {
    return node[rt].r + 1;
  }
  push_down(rt);
  if (node[rt * 2 + 1].minn <= v) {
    return query(v, rt * 2 + 1);
  } else if (node[rt * 2].maxx >= v) {
    return query(v, rt * 2);
  }
  node[rt].minn = min(node[rt * 2].minn, node[rt * 2 + 1].minn);
  node[rt].maxx = max(node[rt * 2].maxx, node[rt * 2 + 1].maxx);
}
void update(long long l, long long r, long long v, long long rt) {
  long long mid = (node[rt].l + node[rt].r) / 2;
  if (node[rt].l == l && node[rt].r == r) {
    node[rt].lz += v;
    node[rt].minn -= v;
    node[rt].maxx -= v;
    return;
  }
  push_down(rt);
  if (r <= mid) {
    update(l, r, v, rt * 2);
  } else if (l > mid) {
    update(l, r, v, rt * 2 + 1);
  } else {
    update(l, mid, v, rt * 2);
    update(mid + 1, r, v, rt * 2 + 1);
  }
  node[rt].minn = min(node[rt * 2].minn, node[rt * 2 + 1].minn);
  node[rt].maxx = max(node[rt * 2].maxx, node[rt * 2 + 1].maxx);
}
int main() {
  long long n, i, j;
  scanf("%lld", &n);
  sum[0] = 0;
  for (i = 1; i <= n; i++) {
    scanf("%lld", &a[i]);
    sum[i] = sum[i - 1] + i;
  }
  build(0, n, 1);
  for (i = n; i >= 1; i--) {
    ans[i] = query(a[i], 1);
    update(ans[i], n, ans[i], 1);
  }
  for (i = 1; i <= n; i++) {
    if (i == n)
      printf("%lld\n", ans[i]);
    else if (i < n) {
      printf("%lld ", ans[i]);
    }
  }
  return 0;
}
