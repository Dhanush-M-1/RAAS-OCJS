#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 10;
struct Node {
  int x, v;
  bool operator<(const Node &rhs) const { return x < rhs.x; }
} p[maxn];
int b[maxn], n, to;
long long t[maxn], tt[maxn];
inline int lowbit(int x) { return x & -x; }
void update(long long *t, int x, int v) {
  for (; x <= n; x += lowbit(x)) {
    t[x] += v;
  }
}
long long query(long long *t, int x) {
  long long sum = 0;
  for (; x; x -= lowbit(x)) {
    sum += t[x];
  }
  return sum;
}
int find(int x) { return lower_bound(b + 1, b + to + 1, x) - b; }
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) scanf("%d", &p[i].x);
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &p[i].v);
    b[i] = p[i].v;
  }
  sort(p + 1, p + n + 1);
  sort(b + 1, b + n + 1);
  to = unique(b + 1, b + n + 1) - b - 1;
  long long ans = 0;
  for (int i = 1; i <= n; ++i) {
    int v = find(p[i].v);
    ans += 1LL * query(tt, v) * p[i].x - query(t, v);
    update(t, v, p[i].x);
    update(tt, v, 1);
  }
  printf("%lld\n", ans);
}
