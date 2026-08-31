#include <bits/stdc++.h>
using namespace std;
long long int N = 1e13 + 7;
long long int n;
vector<long long int> s(200004), p(200004), lazy(800004);
vector<long long int> tree(800004);
void build(long long int node, long long int l, long long int r) {
  if (l == r) {
    tree[node] = s[l];
    return;
  }
  long long int mid = (l + r) / 2;
  build(2 * node, l, mid);
  build(2 * node + 1, mid + 1, r);
  tree[node] = min(tree[2 * node], tree[2 * node + 1]);
}
void update(long long int node, long long int l, long long int r,
            long long int st, long long int en, long long int val) {
  if (l > en || r < st) {
    return;
  }
  if (l >= st && r <= en) {
    lazy[node] += val;
    return;
  }
  long long int mid = (l + r) / 2;
  update(2 * node, l, mid, st, en, val);
  update(2 * node + 1, mid + 1, r, st, en, val);
  tree[node] = min(tree[2 * node] + lazy[2 * node],
                   tree[2 * node + 1] + lazy[2 * node + 1]);
}
long long int query(long long int node, long long int l, long long int r,
                    long long int tot) {
  if (l == r) {
    return l;
  }
  long long int mid = (l + r) / 2;
  tot += lazy[node];
  if (tree[2 * node + 1] + tot + lazy[2 * node + 1] == 0) {
    return query(2 * node + 1, mid + 1, r, tot);
  }
  return query(2 * node, l, mid, tot);
}
void solve() {
  cin >> n;
  for (long long int i = 1; i <= n; i++) {
    cin >> s[i];
  }
  build(1, 1, n);
  long long int i = 1;
  while (i <= n) {
    long long int u = query(1, 1, n, 0);
    p[u] = i;
    i++;
    update(1, 1, n, u, u, N);
    update(1, 1, n, u + 1, n, -i + 1);
  }
  for (long long int i = 1; i <= n; i++) {
    cout << p[i] << " ";
  }
  cout << endl;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int t = 1;
  while (t--) {
    solve();
  }
}
