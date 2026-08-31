#include <bits/stdc++.h>
using namespace std;
const long long N = 2e5 + 5, MOD = 1e9 + 7;
pair<long long, long long> a[N];
pair<long long, long long> tree[4 * N];
bool compare(pair<long long, long long> p1, pair<long long, long long> p2) {
  return p1.first < p2.first;
}
void update(long long node, long long st, long long en, long long ccidx,
            long long val, long long cnt) {
  if (st == en) {
    tree[node].first += val;
    tree[node].second += cnt;
    return;
  }
  long long mid = (st + en) / 2;
  if (ccidx <= mid)
    update(2 * node, st, mid, ccidx, val, cnt);
  else
    update(2 * node + 1, mid + 1, en, ccidx, val, cnt);
  tree[node].first = tree[2 * node].first + tree[2 * node + 1].first;
  tree[node].second = tree[2 * node].second + tree[2 * node + 1].second;
}
pair<long long, long long> query(long long node, long long st, long long en,
                                 long long l, long long r) {
  if (l > en || r < st) return {0, 0};
  if (l <= st && en <= r) return tree[node];
  long long mid = (st + en) / 2;
  pair<long long, long long> p1 = query(2 * node, st, mid, l, r);
  pair<long long, long long> p2 = query(2 * node + 1, mid + 1, en, l, r);
  return {p1.first + p2.first, p1.second + p2.second};
}
void solve() {
  long long n;
  cin >> n;
  set<long long> s;
  for (long long i = 0; i < n; i++) cin >> a[i].first;
  for (long long i = 0; i < n; i++) {
    cin >> a[i].second;
    s.insert(a[i].second);
  }
  map<long long, long long> cc;
  long long j = 1;
  for (auto x : s) {
    cc[x] = j;
    j++;
  }
  sort(a, a + n, compare);
  pair<long long, long long> tem = {0ll, 0ll};
  for (long long i = 0; i < 4 * N; i++) tree[i] = tem;
  for (long long i = 0; i < n; i++) {
    update(1, 1, j - 1, cc[a[i].second], a[i].first, 1);
  }
  long long ans = 0;
  for (long long i = n - 1; i >= 0; i--) {
    update(1, 1, j - 1, cc[a[i].second], -a[i].first, -1);
    pair<long long, long long> x = query(1, 1, j - 1, 1, cc[a[i].second]);
    ans += abs(x.second * a[i].first - x.first);
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
