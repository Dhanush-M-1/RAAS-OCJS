#include <bits/stdc++.h>
using namespace std;
const int maxn = 200200;
long long mn[4 * maxn], ps[4 * maxn], ls[4 * maxn];
void push(int i, int l, int r) {
  if (ls[i]) {
    mn[i] += ls[i];
    if (l != r) {
      ls[2 * i] += ls[i];
      ls[2 * i + 1] += ls[i];
    }
    ls[i] = 0;
  }
}
void pull(int i) {
  long long m = min(mn[2 * i], mn[2 * i + 1]);
  mn[i] = m;
  ps[i] = m == mn[2 * i + 1] ? ps[2 * i + 1] : ps[2 * i];
}
long long arr[maxn];
void build(int i, int l, int r) {
  if (l == r) {
    mn[i] = arr[l];
    ps[i] = l;
  } else {
    int m = (l + r) / 2;
    build(2 * i, l, m);
    build(2 * i + 1, m + 1, r);
    pull(i);
  }
}
void add(int i, int l, int r, int x, int y, long long v) {
  push(i, l, r);
  if (l > y || r < x) return;
  if (x <= l && r <= y) {
    ls[i] += v;
    push(i, l, r);
    return;
  }
  int m = (l + r) / 2;
  add(2 * i, l, m, x, y, v);
  add(2 * i + 1, m + 1, r, x, y, v);
  pull(i);
}
int ans[maxn];
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) scanf("%lld", arr + i);
  build(1, 0, n - 1);
  for (int i = 1; i <= n; i++) {
    int p = ps[1];
    ans[p] = i;
    if (p != n - 1) {
      add(1, 0, n - 1, p + 1, n - 1, -i);
    }
    add(1, 0, n - 1, p, p, 1ll << 50);
  }
  for (int i = 0; i < n; i++) printf("%d ", ans[i]);
  return 0;
}
