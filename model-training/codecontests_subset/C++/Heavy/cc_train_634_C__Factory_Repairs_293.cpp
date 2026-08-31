#include <bits/stdc++.h>
using namespace std;
const int N = 2 * 1e5 + 100;
long long it1[6 * N];
long long it2[6 * N];
long long now[N];
int n;
long long a, b;
int q;
int t;
void update1(int node, int u, int l, int r, int cost) {
  if (l == u && r == u) {
    now[u] += 1LL * cost;
    it1[node] = min(now[u], b);
    return;
  }
  if (l > u || r < u) return;
  int mid = (l + r) / 2;
  update1(2 * node, u, l, mid, cost);
  update1(2 * node + 1, u, mid + 1, r, cost);
  it1[node] = it1[2 * node] + it1[2 * node + 1];
}
void update2(int node, int u, int l, int r, int cost) {
  if (l == u && r == u) {
    it2[node] = min(now[u], a);
    return;
  }
  if (l > u || r < u) return;
  int mid = (l + r) / 2;
  update2(2 * node, u, l, mid, cost);
  update2(2 * node + 1, u, mid + 1, r, cost);
  it2[node] = it2[2 * node] + it2[2 * node + 1];
}
long long get1(int node, int u, int v, int l, int r) {
  if (u <= l && r <= v) return it1[node];
  if (l > v || r < u) return 0;
  int mid = (l + r) / 2;
  return (get1(2 * node, u, v, l, mid) + get1(2 * node + 1, u, v, mid + 1, r));
}
long long get2(int node, int u, int v, int l, int r) {
  if (u <= l && r <= v) return it2[node];
  if (l > v || r < u) return 0;
  int mid = (l + r) / 2;
  return (get2(2 * node, u, v, l, mid) + get2(2 * node + 1, u, v, mid + 1, r));
}
int main() {
  ios_base::sync_with_stdio(false);
  cin >> n >> t >> a >> b >> q;
  while (q--) {
    int k;
    cin >> k;
    if (k == 1) {
      int u, v;
      cin >> u >> v;
      update1(1, u, 1, n, v);
      update2(1, u, 1, n, v);
    } else {
      int u;
      cin >> u;
      long long ans = 0;
      if (u - 1 > 0) ans += get1(1, 1, u - 1, 1, n);
      if (u + t <= n) ans += get2(1, u + t, n, 1, n);
      cout << ans << endl;
    }
  }
}
