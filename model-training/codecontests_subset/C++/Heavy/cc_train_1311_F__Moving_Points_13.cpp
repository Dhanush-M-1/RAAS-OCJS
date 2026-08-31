#include <bits/stdc++.h>
using namespace std;
int n, c[200005];
long long ans;
struct t {
  long long x, y;
  int z;
} a[200005];
int lowbit(int x) { return x & (-x); }
void update(int x) {
  for (int i = x; i <= n; i += lowbit(i)) c[i]++;
}
int query(int x) {
  int s = 0;
  for (int i = x; i >= 1; i -= lowbit(i)) s += c[i];
  return s;
}
bool cmp(t x, t y) { return x.y < y.y || x.y == y.y && x.x < y.x; }
bool cmp1(t x, t y) { return x.x < y.x; }
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%lld", &a[i].x);
  for (int i = 1; i <= n; i++) scanf("%lld", &a[i].y);
  sort(a + 1, a + 1 + n, cmp1);
  for (int i = 1; i <= n; i++) a[i].z = i;
  sort(a + 1, a + 1 + n, cmp);
  memset(c, 0, sizeof(c));
  ans = 0;
  for (int i = 1; i <= n; i++) {
    long long x;
    x = query(a[i].z - 1);
    ans += a[i].x * x;
    update(a[i].z);
  }
  memset(c, 0, sizeof(c));
  for (int i = n; i >= 1; i--) {
    long long x = query(n) - query(a[i].z);
    ans -= a[i].x * x;
    update(a[i].z);
  }
  printf("%lld\n", ans);
}
