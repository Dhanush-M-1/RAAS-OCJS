#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 5;
int n;
int b[maxn];
struct node {
  int x, v;
} a[maxn];
bool cmp(node q1, node q2) { return q1.v == q2.v ? q1.x < q2.x : q1.v < q2.v; }
struct BIT {
  long long c[maxn][2];
  void init() { memset(c, 0, sizeof(c)); }
  int lowbit(int x) { return x & (-x); }
  void update(int k, int x, int y) {
    for (int i = k; i <= n; i += lowbit(i)) {
      c[i][0] += x;
      c[i][1] += y;
    }
  }
  pair<long long, long long> query(int k) {
    long long ans1 = 0, ans2 = 0;
    for (int i = k; i; i -= lowbit(i)) {
      ans1 += c[i][0];
      ans2 += c[i][1];
    }
    return make_pair(ans1, ans2);
  }
  pair<long long, long long> ask(int l, int r) {
    pair<long long, long long> tmp1 = query(r);
    pair<long long, long long> tmp2 = query(l - 1);
    pair<long long, long long> tmp =
        make_pair(tmp1.first - tmp2.first, tmp1.second - tmp2.second);
    return tmp;
  }
} T[2];
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d", &a[i].x);
  int cnt = 0;
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i].v);
    b[++cnt] = a[i].x;
  }
  sort(b + 1, b + cnt + 1);
  sort(a + 1, a + n + 1, cmp);
  cnt = unique(b + 1, b + cnt + 1) - b - 1;
  for (int i = 1; i <= n; i++) {
    a[i].x = lower_bound(b + 1, b + cnt + 1, a[i].x) - b;
    T[1].update(a[i].x, 1, b[a[i].x]);
  }
  long long ans = 0;
  pair<long long, long long> tmp;
  for (int i = 1; i <= n; i++) {
    T[0].update(a[i].x, 1, b[a[i].x]);
    T[1].update(a[i].x, -1, -b[a[i].x]);
    tmp = T[0].ask(1, a[i].x);
    ans += tmp.first * b[a[i].x] - tmp.second;
    tmp = T[1].ask(a[i].x, n);
    ans += tmp.second - tmp.first * b[a[i].x];
  }
  printf("%lld\n", ans / 2);
  return 0;
}
