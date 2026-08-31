#include <bits/stdc++.h>
using namespace std;
long long A[300001];
long long tree[300001 * 4 + 2], prop[4 * 300001 + 2], ans[300001];
void create(long long node, long long b, long long e) {
  if (b == e) {
    tree[node] = A[b];
    return;
  }
  long long l = 2 * node;
  long long r = l + 1;
  long long m = (b + e) / 2;
  create(l, b, m);
  create(r, m + 1, e);
  tree[node] = min(tree[l], tree[r]);
}
void update(long long node, long long b, long long e, long long i, long long j,
            long long val) {
  if (b > j || e < i) return;
  if (i <= b && e <= j) {
    if (val == ((long long)1 << 62)) {
      tree[node] = ((long long)1 << 62);
      return;
    }
    prop[node] += val;
    tree[node] -= val;
    return;
  }
  long long l = 2 * node;
  long long r = l + 1;
  long long m = (b + e) / 2;
  if (prop[node]) {
    prop[l] += prop[node];
    prop[r] += prop[node];
    tree[l] = -prop[node];
    tree[r] -= prop[node];
    prop[node] = 0;
  }
  update(l, b, m, i, j, val);
  update(r, m + 1, e, i, j, val);
  tree[node] = min(tree[l], tree[r]);
}
long long query(long long node, long long b, long long e) {
  if (b == e) return b;
  long long l = 2 * node;
  long long r = l + 1;
  long long m = (b + e) / 2;
  if (prop[node]) {
    prop[l] += prop[node];
    prop[r] += prop[node];
    tree[l] -= prop[node];
    tree[r] -= prop[node];
    prop[node] = 0;
  }
  if (tree[r] == 0)
    return query(r, m + 1, e);
  else
    return query(l, b, m);
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(nullptr);
  memset(prop, 0, sizeof prop);
  ;
  long long n;
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> A[i];
  create(1, 1, n);
  for (int i = 1; i <= n; i++) {
    long long p = query(1, 1, n);
    ans[p] = i;
    update(1, 1, n, p, p, ((long long)1 << 62));
    update(1, 1, n, p + 1, n, i);
  }
  for (int i = 1; i <= n; i++) cout << ans[i] << " ";
  cout << "\n";
}
