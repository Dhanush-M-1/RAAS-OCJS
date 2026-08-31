#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 5;
int n;
pair<int, int> a[maxn];
int m;
vector<int> v;
struct fenwick {
  long long val[maxn];
  void init() { fill(begin(val), end(val), 0); }
  void upd(int x, int k) {
    for (; x < maxn; x += x & -x) val[x] += k;
  }
  long long get(int x) {
    long long res = 0;
    for (; x > 0; x -= x & -x) res += val[x];
    return res;
  }
  long long get(int l, int r) {
    if (l > r) return 0;
    return get(r) - get(l - 1);
  }
} tree_tot, tree_cnt;
void read_input() {
  cin >> n;
  for (int i = 1; i <= n; ++i) cin >> a[i].first;
  for (int i = 1; i <= n; ++i) cin >> a[i].second;
}
void init() {
  sort(a + 1, a + n + 1);
  for (int i = 1; i <= n; ++i) v.push_back(a[i].second);
  sort(v.begin(), v.end());
  v.erase(unique(v.begin(), v.end()), v.end());
  m = v.size();
  for (int i = 1; i <= n; ++i)
    a[i].second = lower_bound(v.begin(), v.end(), a[i].second) - v.begin() + 1;
  tree_tot.init();
  tree_cnt.init();
  for (int i = 1; i <= n; ++i) {
    tree_tot.upd(a[i].second, a[i].first);
    tree_cnt.upd(a[i].second, 1);
  }
}
void solve() {
  long long ans = 0;
  for (int i = 1; i <= n; ++i) {
    tree_tot.upd(a[i].second, -a[i].first);
    tree_cnt.upd(a[i].second, -1);
    ans += tree_tot.get(a[i].second, m) -
           a[i].first * 1LL * tree_cnt.get(a[i].second, m);
  }
  cout << ans << '\n';
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  read_input();
  init();
  solve();
}
