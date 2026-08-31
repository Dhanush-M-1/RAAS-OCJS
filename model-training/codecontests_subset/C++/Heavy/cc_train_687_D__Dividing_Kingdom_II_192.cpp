#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using pii = pair<int, int>;
using pll = pair<ll, ll>;
template <typename T>
int sz(const T &a) {
  return int(a.size());
}
const int MAXN = 1e6 + 1;
pair<int, pair<pii, int>> edges[MAXN];
pair<pii, bool> dsu[MAXN];
int find(int a) {
  if (dsu[a].first.first == a) return a;
  int rt = find(dsu[a].first.first);
  dsu[a].second = !(dsu[a].second ^ dsu[dsu[a].first.first].second);
  return dsu[a].first.first = rt;
}
bool sameasparent(int a) {
  find(a);
  return dsu[a].second;
}
bool uni(int a, int b) {
  int ap = find(a), bp = find(b);
  if (ap == bp) return false;
  if (dsu[ap].first.second < dsu[bp].first.second) swap(ap, bp);
  dsu[bp].second = sameasparent(a) ^ sameasparent(b);
  dsu[ap].first.second += dsu[bp].first.second;
  dsu[bp].first.first = ap;
  return true;
}
int main() {
  cin.tie(NULL);
  ios_base::sync_with_stdio(false);
  int n, q, m;
  cin >> n >> m >> q;
  for (int i = 1; i <= m; i++) {
    cin >> edges[i].second.first.first >> edges[i].second.first.second >>
        edges[i].first,
        edges[i].second.second = i;
  }
  sort(edges + 1, edges + m + 1);
  int l, r;
  while (q--) {
    cin >> l >> r;
    for (int i = 1; i <= n; i++) dsu[i] = {{i, 1}, 1};
    int ans = -1;
    for (int i = m; i >= 1; i--) {
      if (edges[i].second.second < l || edges[i].second.second > r) continue;
      if (!uni(edges[i].second.first.first, edges[i].second.first.second) &&
          sameasparent(edges[i].second.first.first) ==
              sameasparent(edges[i].second.first.second)) {
        ans = edges[i].first;
        break;
      }
    }
    printf("%d\n", ans);
  }
  return 0;
}
