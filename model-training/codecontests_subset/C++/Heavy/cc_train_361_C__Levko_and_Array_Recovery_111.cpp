#include <bits/stdc++.h>
using namespace std;
const long long M = 1e5 + 15;
const long long Q = 1e9;
int zn[M], ans[M], d[M];
vector<pair<pair<int, int>, pair<int, int> > > po;
int main() {
  srand(time(NULL));
  int n, m, i, j, t, mi, l, r, q;
  scanf("%d%d", &n, &m);
  for (i = 1; i <= n; i++) {
    zn[i] = Q;
  }
  for (i = 0; i < m; i++) {
    scanf("%d%d%d%d", &t, &l, &r, &q);
    if (t == 1) {
      for (j = l; j <= r; j++) d[j] += q;
    }
    if (t == 2) {
      for (j = l; j <= r; j++) zn[j] = min(zn[j], q - d[j]);
    }
    po.push_back(make_pair(make_pair(t, l), make_pair(r, q)));
  }
  for (i = 1; i <= n; i++) ans[i] = zn[i];
  for (i = 0; i < m; i++) {
    t = po[i].first.first;
    l = po[i].first.second;
    r = po[i].second.first;
    q = po[i].second.second;
    if (t == 1) {
      for (j = l; j <= r; j++) zn[j] += q;
    }
    if (t == 2) {
      mi = -Q;
      for (j = l; j <= r; j++) mi = max(zn[j], mi);
      if (mi != q) {
        printf("NO");
        return 0;
      }
    }
  }
  printf("YES\n");
  for (i = 1; i <= n; i++) printf("%d ", ans[i]);
  return 0;
}
