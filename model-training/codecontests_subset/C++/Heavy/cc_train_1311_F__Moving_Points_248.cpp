#include <bits/stdc++.h>
using namespace std;
int b[200005], m;
long long tr[800005][2];
struct node {
  int x, v;
  bool operator<(const node t) const { return x < t.x; }
} a[200005];
int lsh(long long x) { return lower_bound(b + 1, b + 1 + m, x) - b; }
long long query(int l, int r, int x, int y, int z, int p) {
  if (l == x && r == y) return tr[p][z];
  int mid = l + r >> 1;
  if (y <= mid)
    return query(l, mid, x, y, z, p << 1);
  else if (x > mid)
    return query(mid + 1, r, x, y, z, p << 1 | 1);
  else
    return query(l, mid, x, mid, z, p << 1) +
           query(mid + 1, r, mid + 1, y, z, p << 1 | 1);
}
void update(int l, int r, int x, int y, int p) {
  if (l == r) {
    tr[p][0]++;
    tr[p][1] += y;
    return;
  }
  int mid = l + r >> 1;
  if (x <= mid)
    update(l, mid, x, y, p << 1);
  else
    update(mid + 1, r, x, y, p << 1 | 1);
  tr[p][0] = tr[p << 1][0] + tr[p << 1 | 1][0];
  tr[p][1] = tr[p << 1][1] + tr[p << 1 | 1][1];
}
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d", &a[i].x);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i].v);
    b[i] = a[i].v;
  }
  sort(b + 1, b + 1 + n);
  m = unique(b + 1, b + 1 + n) - b - 1;
  sort(a + 1, a + 1 + n);
  long long ans = 0;
  for (int i = 1; i <= n; i++) {
    int x = lsh(a[i].v);
    ans += query(1, m, 1, x, 0, 1) * a[i].x - query(1, m, 1, x, 1, 1);
    update(1, m, x, a[i].x, 1);
  }
  printf("%lld", ans);
  return 0;
}
