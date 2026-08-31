#include <bits/stdc++.h>
using namespace std;
const int N = 12550;
const int M = 1000050;
int n, m, u[M], v[M], w[M], val[N], sum[N], ord[N];
vector<pair<int, int> > E[N];
int main() {
  scanf("%i %i", &n, &m);
  for (int i = 1; i <= m; i++) scanf("%i %i", &u[i], &v[i]);
  for (int i = 1; i <= m; w[i] = 1, i++)
    E[u[i]].push_back({v[i], i}), E[v[i]].push_back({u[i], i});
  for (int i = 1; i <= n; i++) {
    sum[i] = E[i].size();
    vector<pair<int, int> > cns;
    set<int> bad;
    cns.push_back({i, -1});
    for (pair<int, int> e : E[i])
      if (e.first < i) {
        if (!val[e.first]) {
          val[e.first] = 1;
          w[e.second] = 0;
          sum[i]--;
        }
        cns.push_back(e);
        bad.insert(sum[e.first]);
      }
    while (cns.size()) {
      if (!bad.count(sum[i])) {
        break;
      }
      pair<int, int> o = cns.back();
      cns.pop_back();
      sum[i]++;
      if (o.second == -1)
        val[i] = 1;
      else
        val[o.first] = 0, w[o.second]++;
    }
  }
  vector<int> ans;
  for (int i = 1; i <= n; i++)
    if (val[i]) ans.push_back(i);
  printf("%i\n", ans.size());
  for (int i : ans) printf("%i ", i);
  printf("\n");
  for (int i = 1; i <= m; i++) printf("%i %i %i\n", u[i], v[i], w[i]);
  return 0;
}
