#include <bits/stdc++.h>
using namespace std;
const int M = 1012;
const int Q = 1e9 + 7;
pair<int, int> pr[M];
int inv[M];
pair<pair<int, int>, pair<int, int> > e[M * M];
pair<int, int> get(int v) {
  if (v == pr[v].first) return make_pair(v, inv[v]);
  auto res = get(pr[v].first);
  return pr[v] = make_pair(res.first, res.second ^ pr[v].second);
}
bool un(int a, int b) {
  auto ai = get(a);
  auto bi = get(b);
  if (ai.first == bi.first) {
    return ai.second != bi.second;
  }
  if (ai.second == bi.second) inv[ai.first] ^= 1;
  pr[ai.first] = make_pair(bi.first, inv[ai.first]);
  return true;
}
int main() {
  srand(time(NULL));
  cin.tie(0);
  ios_base::sync_with_stdio(0);
  int n, m, q;
  cin >> n >> m >> q;
  for (int i = 0; i < m; i++) {
    int s, f, w;
    cin >> s >> f >> w;
    e[i] = make_pair(make_pair(-w, i + 1), make_pair(s, f));
  }
  sort(e, e + m);
  for (int it = 0; it < q; it++) {
    int l, r;
    cin >> l >> r;
    for (int i = 1; i <= n; i++) pr[i] = make_pair(i, 0), inv[i] = 0;
    int ans = -1;
    for (int i = 0; i < m; i++) {
      if (l <= e[i].first.second && e[i].first.second <= r) {
        if (!un(e[i].second.first, e[i].second.second)) {
          ans = -e[i].first.first;
          break;
        }
      }
    }
    cout << ans << "\n";
  }
  return 0;
}
