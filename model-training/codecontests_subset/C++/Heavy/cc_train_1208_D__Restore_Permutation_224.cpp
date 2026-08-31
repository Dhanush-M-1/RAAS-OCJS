#include <bits/stdc++.h>
using namespace std;
long long int a[200005];
pair<long long int, long long int> tree[4 * 200005];
long long int lazy[4 * 200005];
void build(long long int node, long long int st, long long int en) {
  if (st == en) {
    tree[node] = {a[st], st};
    return;
  }
  long long int mid = (st + en) / 2;
  build(2 * node, st, mid);
  build(2 * node + 1, mid + 1, en);
  if (tree[2 * node].first != tree[2 * node + 1].first)
    tree[node] = min(tree[2 * node], tree[2 * node + 1]);
  else {
    tree[node].first = min(tree[2 * node].first, tree[2 * node + 1].first);
    tree[node].second = max(tree[2 * node].second, tree[2 * node + 1].second);
  }
}
void update(long long int node, long long int st, long long int en,
            long long int l, long long int r, long long int v) {
  if (lazy[node] != 0) {
    tree[node].first += lazy[node];
    if (st != en) {
      lazy[2 * node] += lazy[node];
      lazy[2 * node + 1] += lazy[node];
    }
    lazy[node] = 0;
  }
  if (st > en || st > r || en < l) return;
  if (st >= l && en <= r) {
    tree[node].first += v;
    if (st != en) {
      lazy[2 * node] += v;
      lazy[2 * node + 1] += v;
    }
    return;
  }
  long long int mid = (st + en) / 2;
  update(2 * node, st, mid, l, r, v);
  update(2 * node + 1, mid + 1, en, l, r, v);
  if (tree[2 * node].first != tree[2 * node + 1].first)
    tree[node] = min(tree[2 * node], tree[2 * node + 1]);
  else {
    tree[node].first = min(tree[2 * node].first, tree[2 * node + 1].first);
    tree[node].second = max(tree[2 * node].second, tree[2 * node + 1].second);
  }
}
int32_t main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long int n;
  cin >> n;
  long long int i;
  long long int ans[n];
  for (i = 0; i < n; i++) {
    cin >> a[i];
  }
  build(1, 0, n - 1);
  for (i = 1; i <= n; i++) {
    long long int j = tree[1].second;
    update(1, 0, n - 1, j, j, 1e17);
    update(1, 0, n - 1, j + 1, n - 1, -i);
    ans[j] = i;
  }
  for (i = 0; i < n; i++) {
    cout << ans[i] << " ";
  }
}
