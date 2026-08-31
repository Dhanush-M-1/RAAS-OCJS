#include <bits/stdc++.h>
using namespace std;
const long long int inf = 1e18, M = 1e9 + 7;
const long long int N = 2e5 + 10;
vector<pair<long long int, long long int> > tree(4 * N, make_pair(0, 0));
map<long long int, long long int> mp;
pair<long long int, long long int> combine(
    pair<long long int, long long int> a,
    pair<long long int, long long int> b) {
  pair<long long int, long long int> z;
  z.first = a.first + b.first;
  z.second = a.second + b.second;
  return z;
}
void update(long long int node, long long int start, long long int en,
            long long int idx, long long int val) {
  if (start == en) {
    tree[node].first += val;
    tree[node].second++;
    return;
  }
  long long int mid = (start + en) / 2;
  if (start <= idx and idx <= mid)
    update(2 * node, start, mid, idx, val);
  else
    update(2 * node + 1, mid + 1, en, idx, val);
  tree[node] = combine(tree[2 * node], tree[2 * node + 1]);
}
pair<long long int, long long int> query(long long int node,
                                         long long int start, long long int en,
                                         long long int l, long long int r) {
  if (r < start || en < l) return {0, 0};
  if (l <= start && en <= r) return tree[node];
  long long int mid = (start + en) / 2;
  pair<long long int, long long int> q1 = query(2 * node, start, mid, l, r);
  pair<long long int, long long int> q2 =
      query(2 * node + 1, mid + 1, en, l, r);
  return combine(q1, q2);
}
void solve() {
  long long int n;
  cin >> n;
  vector<pair<long long int, long long int> > v(n);
  for (long long int i = 0; i < n; ++i) cin >> v[i].first;
  for (long long int i = 0; i < n; ++i) cin >> v[i].second, mp[v[i].second];
  long long int cnt = 0;
  for (auto& c : mp) c.second = cnt++;
  sort(v.begin(), v.end());
  pair<long long int, long long int> p;
  long long int ans = 0;
  for (long long int i = 0; i < n; ++i) {
    p = query(1, 0, n, 0, mp[v[i].second]);
    ans += p.first * -1ll + v[i].first * p.second;
    update(1, 0, n, mp[v[i].second], v[i].first);
  }
  cout << ans;
}
int32_t main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  long long int t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
