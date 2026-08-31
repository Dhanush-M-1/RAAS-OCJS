#include <bits/stdc++.h>
#pragma GCC optimize("O3")
using namespace std;
const int N = 2e5 + 5, M = 2 * N + 5;
int n;
long long tree[1 << 19], a[N];
void build(int i, int l, int r) {
  if (l == r) {
    tree[i] = l;
    return;
  }
  int mid = (l + r) / 2;
  build(i * 2, l, mid);
  build(i * 2 + 1, mid + 1, r);
  tree[i] = tree[i * 2] + tree[i * 2 + 1];
}
void update(int i, int l, int r, int trgt, int val) {
  if (!(trgt >= l && trgt <= r)) return;
  if (l == r) {
    tree[i] = val;
    return;
  }
  int mid = (l + r) / 2;
  update(i * 2, l, mid, trgt, val);
  update(i * 2 + 1, mid + 1, r, trgt, val);
  tree[i] = tree[i * 2] + tree[i * 2 + 1];
}
long long getsum(int i, int l, int r, int a, int b) {
  if (a > r || b < l) return 0;
  if (a <= l && r <= b) return tree[i];
  int mid = (l + r) / 2;
  return getsum(i * 2, l, mid, a, b) + getsum(i * 2 + 1, mid + 1, r, a, b);
}
int bs(long long sum) {
  int l = 0, r = n - 1, mid, ans = -1;
  while (l <= r) {
    mid = (l + r) / 2;
    long long total = getsum(1, 0, n - 1, 0, mid);
    if (total > sum)
      r = mid - 1;
    else {
      ans = mid;
      l = mid + 1;
    }
  }
  assert(ans != -1);
  return ans;
}
int ans[N];
int main() {
  scanf("%d", &n);
  int nn = n;
  ++n;
  build(1, 0, n - 1);
  for (int i = 0; i < nn; ++i) scanf("%lld", a + i);
  for (int i = nn - 1; ~i; --i) {
    int idx = bs(a[i]) + 1;
    ans[i] = idx;
    update(1, 0, n - 1, idx, 0);
  }
  for (int i = 0; i < nn; ++i) printf("%d%c", ans[i], " \n"[i == nn - 1]);
  return 0;
}
