#include <bits/stdc++.h>
using namespace std;
int n, op;
pair<long long, int> tree[201000];
pair<long long, int> q[201000];
long long a[201000];
int lowbits(int x) { return x & (-x); }
void add(long long x, int pos) {
  while (pos <= n) {
    tree[pos].first += x;
    tree[pos].second++;
    pos += lowbits(pos);
  }
}
pair<long long, int> getsum(int x) {
  pair<long long, int> res;
  while (x > 0) {
    res.first += tree[x].first;
    res.second += tree[x].second;
    x -= lowbits(x);
  }
  return res;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%lld", &q[i].first);
  for (int i = 1; i <= n; i++) scanf("%d", &q[i].second), a[++op] = q[i].second;
  sort(a + 1, a + 1 + n), sort(q + 1, q + 1 + n);
  long long ans = 0;
  for (int i = 1; i <= n; i++) {
    int pos = lower_bound(a + 1, a + 1 + n, q[i].second) - a;
    pair<long long, int> now = getsum(pos);
    ans += now.second * q[i].first - now.first;
    add(q[i].first, pos);
  }
  cout << ans << endl;
}
