#include <bits/stdc++.h>
using namespace std;
pair<long long, long long> tree[4 * 200005 + 1];
long long lo[4 * 200005 + 1], hi[4 * 200005 + 1], a[200005],
    delta[4 * 200005 + 1], ans[200005];
void init(long long i, long long a, long long b) {
  lo[i] = a;
  hi[i] = b;
  if (a == b) return;
  long long m = (a + b) / 2;
  init(2 * i, a, m);
  init(2 * i + 1, m + 1, b);
}
void merge(long long i0, long long i1, long long i2) {
  if (tree[i1].first + delta[i1] == tree[i2].first + delta[i2])
    tree[i0] = {tree[i1].first + delta[i1],
                max(tree[i1].second, tree[i2].second)};
  else if (tree[i1].first + delta[i1] < tree[i2].first + delta[i2])
    tree[i0] = {tree[i1].first + delta[i1], tree[i1].second};
  else
    tree[i0] = {tree[i2].first + delta[i2], tree[i2].second};
}
void build(long long i) {
  long long l = lo[i];
  long long r = hi[i];
  if (l == r) {
    tree[i] = {a[l], l};
    return;
  }
  build(2 * i);
  build(2 * i + 1);
  merge(i, 2 * i, 2 * i + 1);
}
void prop(long long i) {
  delta[2 * i] += delta[i];
  delta[2 * i + 1] += delta[i];
  delta[i] = 0;
}
void range_update(long long i, long long a, long long b, long long val) {
  if (b < lo[i] || hi[i] < a) return;
  if (a <= lo[i] && hi[i] <= b) {
    delta[i] += val;
    return;
  }
  prop(i);
  range_update(2 * i, a, b, val);
  range_update(2 * i + 1, a, b, val);
  merge(i, 2 * i, 2 * i + 1);
}
pair<long long, long long> query(long long i, long long l, long long r) {
  if (r < lo[i] || hi[i] < l) {
    return {(long long)1e12, (long long)1e12};
  }
  if (l <= lo[i] && hi[i] <= r) {
    return {tree[i].first + delta[i], tree[i].second};
  }
  prop(i);
  pair<long long, long long> minr = query(2 * i, l, r);
  pair<long long, long long> minl = query(2 * i + 1, l, r);
  merge(i, 2 * i, 2 * i + 1);
  return tree[i];
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  long long n;
  cin >> n;
  for (long long i = 1; i <= n; i++) cin >> a[i];
  init(1, 1, n);
  build(1);
  for (long long i = 1; i <= n; i++) {
    long long t = query(1, 1, n).second;
    ans[t] = i;
    range_update(1, t + 1, n, -i);
    range_update(1, t, t, (long long)1e12);
  }
  for (long long i = 1; i <= n; i++) cout << ans[i] << " ";
  cout << "\n";
}
