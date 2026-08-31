#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 5;
const long long inf = 1e18;
long long a[N], ans[N];
struct node {
  int l, r;
  long long lazy;
  long long v;
};
node e[N * 5];
void build(int root, int l, int r) {
  e[root].l = l;
  e[root].r = r;
  e[root].lazy = e[root].v = 0;
  if (l == r) {
    e[root].v = a[l];
    return;
  }
  build(root * 2, l, (l + r) / 2);
  build(root * 2 + 1, (l + r) / 2 + 1, r);
  e[root].v = min(e[root * 2].v, e[root * 2 + 1].v);
}
void updown(int root) {
  if (e[root].lazy) {
    e[root * 2].lazy += e[root].lazy;
    e[root * 2 + 1].lazy += e[root].lazy;
    e[root * 2].v -= e[root].lazy;
    e[root * 2 + 1].v -= e[root].lazy;
    e[root].lazy = 0;
  }
}
int que(int root, int x) {
  if (e[root].l == e[root].r) return e[root].l;
  updown(root);
  if (e[root * 2 + 1].v == x)
    return que(root * 2 + 1, x);
  else
    return que(root * 2, x);
}
void update1(int root, int x) {
  if (e[root].l == e[root].r) {
    e[root].v = inf;
    return;
  }
  int mid = (e[root].l + e[root].r) / 2;
  if (x <= mid)
    update1(root * 2, x);
  else
    update1(root * 2 + 1, x);
  e[root].v = min(e[root * 2].v, e[root * 2 + 1].v);
}
void update2(int root, int l, int r, int x) {
  if (e[root].l == l && e[root].r == r) {
    e[root].v -= x;
    e[root].lazy += x;
    return;
  }
  updown(root);
  int mid = (e[root].l + e[root].r) / 2;
  if (l > mid)
    update2(root * 2 + 1, l, r, x);
  else {
    if (r <= mid)
      update2(root * 2, l, r, x);
    else {
      update2(root * 2, l, mid, x);
      update2(root * 2 + 1, mid + 1, r, x);
    }
  }
  e[root].v = min(e[root * 2].v, e[root * 2 + 1].v);
}
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%lld", &a[i]);
  build(1, 1, n);
  for (int i = 1; i <= n; i++) {
    int k = que(1, 0);
    ans[k] = i;
    update1(1, k);
    if (k != n) update2(1, k + 1, n, i);
  }
  for (int i = 1; i <= n; i++) printf("%d ", ans[i]);
  printf("\n");
  return 0;
}
