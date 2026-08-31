#include <bits/stdc++.h>
using namespace std;
int II() {
  int q;
  scanf("%d", &q);
  return q;
}
long long LII() {
  long long q;
  scanf("%lld", &q);
  return q;
}
const long long Mx = 200005;
long long N;
vector<long long> tree[Mx * 4], cum[Mx * 4];
vector<pair<long long, long long> > v(Mx + 1);
void update(long long node, long long b, long long e) {
  if (b == e) {
    tree[node].push_back(v[b].first);
    cum[node].push_back(v[b].first);
    return;
  }
  update((node * 2), b, (b + e) / 2);
  update((node * 2) + 1, (b + e) / 2 + 1, e);
  for (auto it : tree[(node * 2)]) tree[node].push_back(it);
  for (auto it : tree[(node * 2) + 1]) tree[node].push_back(it);
  sort(tree[node].begin(), tree[node].end());
  cum[node] = tree[node];
  for (long long i = cum[node].size() - 2; i >= 0; i--) {
    cum[node][i] += cum[node][i + 1];
  }
}
long long query(long long node, long long b, long long e, long long l,
                long long r, long long val) {
  if (r < l) return 0;
  if (b > r or e < l) return 0;
  if (b >= l and e <= r) {
    long long up = upper_bound(tree[node].begin(), tree[node].end(), val) -
                   tree[node].begin();
    if (up == tree[node].size()) return 0;
    long long q = tree[node].size() - up;
    return cum[node][up] - ((q * val));
  }
  return query((node * 2), b, (b + e) / 2, l, r, val) +
         query((node * 2) + 1, (b + e) / 2 + 1, e, l, r, val);
}
void solve() {
  cin >> N;
  for (long long i = 1; i <= N; i++) cin >> v[i].first;
  for (long long i = 1; i <= N; i++) cin >> v[i].second;
  sort(v.begin() + 1, v.begin() + 1 + N,
       [](pair<long long, long long> a, pair<long long, long long> b) {
         if (a.second == b.second) return a.first < b.first;
         return a.second < b.second;
       });
  update(1, 1, N);
  long long ans = 0;
  for (long long i = 1; i <= N; i++) {
    ans += query(1, 1, N, i + 1, N, v[i].first);
  }
  cout << ans << endl;
}
int32_t main() {
  long long tt;
  tt = 1;
  long long cas = 1;
  while (tt--) {
    solve();
  }
}
