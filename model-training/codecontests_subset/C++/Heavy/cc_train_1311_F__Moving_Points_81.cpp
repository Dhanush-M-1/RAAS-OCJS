#include <bits/stdc++.h>
using namespace std;
const int N = 200009;
int n, b[N], p[N], tot;
long long c1[N], c2[N];
struct P {
  int x, v;
  bool operator<(const P &A) const { return x < A.x; }
} a[N];
int lowbit(int x) { return x & (x ^ (x - 1)); }
void add(int x, int k, long long c[]) {
  while (x <= tot) {
    c[x] += k;
    x += lowbit(x);
  }
}
long long getsum(int x, long long c[]) {
  long long ans = 0;
  while (x) {
    ans += c[x];
    x -= lowbit(x);
  }
  return ans;
}
void init() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d", &a[i].x);
  for (int i = 1; i <= n; i++) scanf("%d", &a[i].v);
  sort(a + 1, a + 1 + n);
}
void work() {
  for (int i = 1; i <= n; i++) p[i] = a[i].v;
  sort(p + 1, p + 1 + n);
  tot = unique(p + 1, p + 1 + n) - (p + 1);
  for (int i = 1; i <= n; i++)
    b[i] = lower_bound(p + 1, p + 1 + tot, a[i].v) - p;
  long long ans = 0;
  for (int i = 1; i <= n; i++) {
    ans += getsum(b[i], c1) * a[i].x - getsum(b[i], c2);
    add(b[i], 1, c1), add(b[i], a[i].x, c2);
  }
  printf("%lld\n", ans);
}
int main() {
  init();
  work();
  return 0;
}
