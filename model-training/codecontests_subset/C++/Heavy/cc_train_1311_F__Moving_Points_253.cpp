#include <bits/stdc++.h>
using namespace std;
const int mxn = 2e5 + 100;
pair<int, long long> a[mxn];
long long r[mxn], b1[mxn], b2[mxn], ans;
void add(long long *b, int idx, int val, int n) {
  for (; idx <= n; idx += idx & -idx) b[idx] += val;
}
long long ask(long long *b, int idx) {
  long long ret = 0;
  for (; idx > 0; idx -= idx & -idx) ret += b[idx];
  return ret;
}
int main() {
  int n, m;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d", &a[i].first);
  for (int i = 1; i <= n; i++)
    scanf("%lld", &a[i].second), r[i - 1] = a[i].second;
  sort(r, r + n), m = unique(r, r + n) - r;
  for (int i = 1; i <= n; i++)
    a[i].second = lower_bound(r, r + m, a[i].second) - r + 1;
  sort(a + 1, a + n + 1);
  for (int i = 1; i <= n; ++i) {
    long long x = ask(b2, a[i].second), y = ask(b1, a[i].second);
    ans += 1LL * y * a[i].first - x;
    add(b2, a[i].second, a[i].first, n);
    add(b1, a[i].second, 1, n);
  }
  printf("%lld\n", ans);
}
