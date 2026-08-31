#include <bits/stdc++.h>
using namespace std;
int ar[1000009], pr[1000009], ap[1000009], par[1002], color[1002];
pair<int, pair<int, int> > NOW[1000009];
vector<int> vec[1002];
pair<pair<int, int>, pair<int, int> > NOWW[1000009];
int get_parent(int r) {
  if (par[r] != r) par[r] = get_parent(par[r]);
  return par[r];
}
int main() {
  int i, j, k, l, m, n, q, ind = 0, low, high, mid, left, right, ans, pos, flag,
                           u, v, jor, par_u, par_v, z, x, node;
  cin >> n >> m >> q;
  pos = 0;
  for (i = 1; i <= m; i++) {
    scanf("%d%d%d", &ar[i], &pr[i], &ap[i]);
    NOWW[++pos] = make_pair(make_pair(ap[i], i), make_pair(ar[i], pr[i]));
  }
  sort(NOWW + 1, NOWW + 1 + pos);
  reverse(NOWW + 1, NOWW + 1 + pos);
  while (q--) {
    cin >> left >> right;
    pos = 0;
    for (i = 1; i <= m; i++) {
      if (NOWW[i].first.second >= left && NOWW[i].first.second <= right)
        NOW[++pos] =
            make_pair(NOWW[i].first.first,
                      make_pair(NOWW[i].second.first, NOWW[i].second.second));
    }
    for (i = 1; i <= n; i++) {
      par[i] = i;
      color[i] = 0;
      vec[i].clear();
      vec[i].push_back(i);
    }
    flag = 0;
    for (i = 1; i <= pos; i++) {
      u = NOW[i].second.first;
      v = NOW[i].second.second;
      jor = (color[u] == color[v]);
      par_u = get_parent(u);
      par_v = get_parent(v);
      if (par_u == par_v) {
        if (jor == 1) {
          ans = NOW[i].first;
          flag = 1;
          break;
        }
      } else {
        z = vec[par_u].size();
        x = vec[par_v].size();
        if (z > x) {
          for (j = 0; j < x; j++) {
            node = vec[par_v][j];
            vec[par_u].push_back(node);
            color[node] ^= jor;
          }
          par[par_v] = par_u;
        } else {
          for (j = 0; j < z; j++) {
            node = vec[par_u][j];
            vec[par_v].push_back(node);
            color[node] ^= jor;
          }
          par[par_u] = par_v;
        }
      }
    }
    if (flag == 0) ans = -1;
    cout << ans << endl;
  }
}
