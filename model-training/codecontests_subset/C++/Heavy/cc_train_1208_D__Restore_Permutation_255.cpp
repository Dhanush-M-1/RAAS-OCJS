#include <bits/stdc++.h>
using namespace std;
long long n, s[200005], tree[800005], lazy[800005], ans[200005];
void pushdown(long long ind, long long l, long long r) {
  if (l != r && lazy[ind] != 0) {
    lazy[2 * ind] += lazy[ind];
    tree[2 * ind] += lazy[ind];
    lazy[2 * ind + 1] += lazy[ind];
    tree[2 * ind + 1] += lazy[ind];
    lazy[ind] = 0;
  }
}
void build(long long ind, long long l, long long r) {
  if (l == r) {
    tree[ind] = s[l];
    return;
  }
  long long mid = (l + r) / 2;
  build(2 * ind, l, mid);
  build(2 * ind + 1, mid + 1, r);
  tree[ind] = min(tree[2 * ind], tree[2 * ind + 1]);
}
long long query(long long ind, long long l, long long r) {
  pushdown(ind, l, r);
  if (l == r) return l;
  tree[ind] = min(tree[2 * ind], tree[2 * ind + 1]);
  long long mid = (l + r) / 2;
  if (tree[2 * ind + 1] == 0)
    query(2 * ind + 1, mid + 1, r);
  else
    query(2 * ind, l, mid);
}
void update(long long ind, long long l, long long r, long long ll, long long rr,
            long long val) {
  pushdown(ind, l, r);
  if (r < ll || l > rr) return;
  if (ll <= l && r <= rr) {
    tree[ind] += val;
    lazy[ind] += val;
    return;
  }
  long long mid = (l + r) / 2;
  update(2 * ind, l, mid, ll, rr, val);
  update(2 * ind + 1, mid + 1, r, ll, rr, val);
  tree[ind] = min(tree[2 * ind], tree[2 * ind + 1]);
}
int32_t main() {
  cin >> n;
  for (long long i = 1; i <= n; ++i) cin >> s[i];
  build(1, 1, n);
  for (long long i = 1; i <= n; ++i) {
    long long t = query(1, 1, n);
    ans[t] = i;
    if (t < n) update(1, 1, n, t + 1, n, -i);
    update(1, 1, n, t, t, 1e18);
  }
  for (long long i = 1; i <= n; ++i) cout << ans[i] << " ";
  return 0;
}
