#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 5;
const long long mod = 998244353;
int T, n;
struct node {
  long long d, v;
  friend bool operator<(node a, node b) { return a.d < b.d; }
} a[maxn];
long long c[maxn], d[maxn];
int b[maxn];
void update(int x, int y) {
  for (int i = x; i <= n; i += (i & (-i))) c[i] += y, d[i]++;
}
long long query1(int x) {
  long long ans = 0;
  for (int i = x; i > 0; i -= (i & (-i))) ans += c[i];
  return ans;
}
long long query2(int x) {
  long long ans = 0;
  for (int i = x; i > 0; i -= (i & (-i))) ans += d[i];
  return ans;
}
int main() {
  cin >> n;
  for (int i = 1; i <= n; ++i) scanf("%lld", &a[i].d);
  for (int i = 1; i <= n; ++i) scanf("%lld", &a[i].v), b[i] = a[i].v;
  sort(b + 1, b + 1 + n);
  int m = unique(b + 1, b + 1 + n) - b - 1;
  for (int i = 1; i <= n; ++i) {
    a[i].v = lower_bound(b + 1, b + 1 + m, a[i].v) - b;
  }
  sort(a + 1, a + 1 + n);
  long long ans = 0;
  for (int i = 1; i <= n; ++i) {
    ans += (query2(a[i].v) * a[i].d - query1(a[i].v));
    update(a[i].v, a[i].d);
  }
  cout << ans;
  return 0;
}
