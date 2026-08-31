#include <bits/stdc++.h>
using namespace std;
const long long N = 2e5 + 5, MOD = 1e9 + 7;
pair<long long, long long> a[N];
vector<pair<long long, long long> > tree[4 * N];
void build(long long node, long long st, long long en) {
  if (st == en) {
    tree[node].push_back({a[st].first, a[st].first});
    return;
  }
  long long mid = (st + en) / 2;
  build(2 * node, st, mid);
  build(2 * node + 1, mid + 1, en);
  long long x = tree[2 * node].size();
  long long y = tree[2 * node + 1].size();
  long long i = 0, j = 0;
  while (i < x && j < y) {
    if (tree[2 * node][i].first < tree[2 * node + 1][j].first) {
      tree[node].push_back(tree[2 * node][i]);
      i++;
    } else {
      tree[node].push_back(tree[2 * node + 1][j]);
      j++;
    }
  }
  while (i < x) {
    tree[node].push_back(tree[2 * node][i]);
    i++;
  }
  while (j < y) {
    tree[node].push_back(tree[2 * node + 1][j]);
    j++;
  }
  long long z = x + y;
  tree[node][z - 1].second = tree[node][z - 1].first;
  for (long long k = z - 2; k >= 0; k--) {
    tree[node][k].second = tree[node][k + 1].second + tree[node][k].first;
  }
}
pair<long long, long long> query(long long node, long long st, long long en,
                                 long long l, long long r, long long val) {
  if (l > en || r < st) return {0, 0};
  if (l <= st && en <= r) {
    long long lo = 0, hi = tree[node].size() - 1, idx = MOD;
    while (lo <= hi) {
      long long m = (lo + hi) / 2;
      if (tree[node][m].first > val) {
        idx = min(idx, m);
        hi = m - 1;
      } else
        lo = m + 1;
    }
    if (idx == MOD)
      return {0, 0};
    else
      return {tree[node][idx].second, tree[node].size() - idx};
  }
  long long mid = (st + en) / 2;
  long long ans = 0;
  pair<long long, long long> p1 = query(2 * node, st, mid, l, r, val);
  pair<long long, long long> p2 = query(2 * node + 1, mid + 1, en, l, r, val);
  pair<long long, long long> p;
  p.first = p1.first + p2.first;
  p.second = p1.second + p2.second;
  return p;
}
bool compare(pair<long long, long long> p1, pair<long long, long long> p2) {
  if (p1.second == p2.second) return p1.first > p2.first;
  return p1.second > p2.second;
}
void solve() {
  long long n;
  cin >> n;
  for (long long i = 0; i < n; i++) cin >> a[i].first;
  for (long long i = 0; i < n; i++) cin >> a[i].second;
  sort(a, a + n, compare);
  build(1, 0, n - 1);
  long long ans = 0;
  for (long long i = 1; i < n; i++) {
    pair<long long, long long> p = query(1, 0, n - 1, 0, i - 1, a[i].first);
    long long temp = abs(p.first - p.second * a[i].first);
    ans += temp;
  }
  cout << ans << "\n";
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  solve();
  return 0;
}
