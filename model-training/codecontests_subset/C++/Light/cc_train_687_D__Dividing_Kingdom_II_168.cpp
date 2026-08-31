#include <bits/stdc++.h>
const int N = 2005;
using namespace std;
vector<pair<int, int>> es;
vector<int> par(N, 1), U(N*N), V(N*N), A1(N*N), A2(N*N);
int F(int u) {
  if (u == par[u]) return u;
  return par[u] = F(par[u]);
}
int n, m, q, el, l, r;
int main() {
  ios_base::sync_with_stdio(0);
  cout.tie(0);
  cin.tie(0);
  cin >> n >> m >> q;
  for (int i = 1; i <= m; i++) {
    cin >> U[i] >> V[i] >> el;
    es.push_back({el, i});
  }
  sort(es.begin(), es.end());
  reverse(es.begin(), es.end());
  for (int i = 1; i <= m; i++) {
    A1[i] = es[i - 1].second;
    A2[i] = es[i - 1].first;
  }
  while (q--) {
    cin >> l >> r;
    for (int i = 1; i <= 2 * n; i++) par[i] = i;
    int ans = -1;
    for (int i = 1; i <= m; i++) {
      if (l <= A1[i] && A1[i] <= r) {
        int u = U[A1[i]], v = V[A1[i]];
        if (F(u) == F(v)) {
          ans = A2[i];
          break;
        }
        par[F(u + n)] = F(v);
        par[F(v + n)] = F(u);
      }
    }
    cout << ans << '\n';
  }
  return 0;
}
