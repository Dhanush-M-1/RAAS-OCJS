#include <bits/stdc++.h>
using namespace std;
const int M = 2e5 + 10;
const long long inf = 1e15 + 10;
const long long mod = 1e9 + 7;
set<int> s;
long long a[M], ans[M];
long long sum[4 * M], lazy[4 * M];
int v[M * 4];
void pushup(int x) { sum[x] = min(sum[x << 1], sum[x << 1 | 1]); }
void built(int l, int r, int i) {
  if (l == r) {
    sum[i] = a[l];
    return;
  }
  int mid = l + r >> 1;
  built(l, mid, i << 1);
  built(mid + 1, r, i << 1 | 1);
  pushup(i);
}
void pp(int i) {
  if (lazy[i]) {
    sum[i << 1] -= lazy[i];
    sum[i << 1 | 1] -= lazy[i];
    lazy[i << 1] += lazy[i];
    lazy[i << 1 | 1] += lazy[i];
    lazy[i] = 0;
  }
}
void add(int l, int r, int x, int y, long long va, int i) {
  if (l >= x && r <= y) {
    sum[i] -= va;
    lazy[i] += va;
    return;
  }
  pp(i);
  int mid = l + r >> 1;
  if (x <= mid) add(l, mid, x, y, va, i << 1);
  if (y > mid) add(mid + 1, r, x, y, va, i << 1 | 1);
  pushup(i);
}
long long query(int l, int r, int i) {
  if (l == r) {
    return l;
  }
  pp(i);
  int mid = l + r >> 1, k;
  if (sum[i << 1] < sum[i << 1 | 1])
    k = query(l, mid, i << 1);
  else
    k = query(mid + 1, r, i << 1 | 1);
  return k;
}
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%lld", &a[i]);
  }
  built(1, n, 1);
  for (int i = 1; i <= n; i++) {
    int pos = query(1, n, 1);
    ans[pos] = i;
    add(1, n, pos, pos, -inf, 1);
    add(1, n, pos + 1, n, i, 1);
  }
  for (int i = 1; i <= n; i++) {
    printf("%d ", ans[i]);
  }
  return 0;
}
