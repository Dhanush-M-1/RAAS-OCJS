#include <bits/stdc++.h>
using namespace std;
const int maxn = 1005;
int n, m, q;
pair<pair<int, int>, pair<int, int> > edges[maxn * maxn];
pair<int, int> par[maxn];
pair<int, int> getpar(int a) {
  if (par[a].first == a) return par[a];
  pair<int, int> p = getpar(par[a].first);
  return par[a] = make_pair(p.first, p.second ^ par[a].second);
}
int main() {
  scanf("%d %d %d", &n, &m, &q);
  for (int i = 0; i < m; i++) {
    scanf("%d %d %d", &edges[i].second.first, &edges[i].second.second,
          &edges[i].first.first);
    edges[i].first.second = i;
  }
  sort(edges, edges + m);
  reverse(edges, edges + m);
  for (int i = 0; i < q; i++) {
    int l, r;
    cin >> l >> r;
    l--;
    for (int j = 1; j <= n; j++) par[j] = make_pair(j, 0);
    bool b = 0;
    for (int j = 0; j < m; j++)
      if (l <= edges[j].first.second && edges[j].first.second < r) {
        pair<int, int> x = getpar(edges[j].second.first),
                       y = getpar(edges[j].second.second);
        if (x.first == y.first) {
          if (x.second == y.second) {
            printf("%d\n", edges[j].first.first);
            b = 1;
            break;
          }
        } else {
          par[x.first] = make_pair(y.first, x.second ^ y.second ^ 1);
        }
      }
    if (!b) printf("-1\n");
  }
}
