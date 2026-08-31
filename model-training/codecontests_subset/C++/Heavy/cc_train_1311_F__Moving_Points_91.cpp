#include <bits/stdc++.h>
using namespace std;
int b[200005], m;
long long c[200005][2];
struct node {
  int x, v;
  bool operator<(const node t) const { return x < t.x; }
} a[200005];
int lsh(long long x) { return lower_bound(b + 1, b + 1 + m, x) - b; }
long long query(int x, int k) {
  long long ret = 0;
  for (int i = x; i >= 1; i -= i & -i) ret += c[i][k];
  return ret;
}
void update(int x, int y) {
  for (int i = x; i <= m; i += i & -i) {
    c[i][0]++;
    c[i][1] += y;
  }
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
    int t = lsh(a[i].v);
    ans += query(t, 0) * a[i].x - query(t, 1);
    update(t, a[i].x);
  }
  printf("%lld", ans);
  return 0;
}
