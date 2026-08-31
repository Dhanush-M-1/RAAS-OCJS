#include <bits/stdc++.h>
using namespace std;
long long d[100010];
vector<int> e[100010], ec[100010];
int u[300010], v[300010], w[300010], qu[300010], qv[300010], qk[300010],
    be[100010];
long long ans[300010];
int par[100010];
int find(int x) { return par[x] == x ? x : (par[x] = find(par[x])); }
const int C = 340;
vector<int> qd[C];
int main() {
  int n, m, k, q;
  scanf("%d%d%d%d", &n, &m, &k, &q);
  for (int i = 0; i < m; i++) {
    scanf("%d%d%d", &u[i], &v[i], &w[i]);
    --u[i];
    --v[i];
    e[u[i]].push_back(v[i]);
    ec[u[i]].push_back(w[i]);
    e[v[i]].push_back(u[i]);
    ec[v[i]].push_back(w[i]);
  }
  for (int i = 0; i < q; i++) {
    scanf("%d%d", &qu[i], &qv[i]);
    --qu[i], --qv[i];
  }
  for (int i = 0; i < n; i++) {
    d[i] = 1ll << 60;
  }
  priority_queue<pair<long long, int> > qq;
  for (int i = 0; i < k; i++) {
    d[i] = 0;
    be[i] = i;
    par[i] = i;
    qq.push(make_pair(0, i));
  }
  vector<pair<long long, pair<int, int> > > fvv;
  while (qq.size()) {
    long long co = -qq.top().first;
    int tv = qq.top().second;
    qq.pop();
    if (d[tv] != co) continue;
    for (int i = 0; i < e[tv].size(); i++) {
      int to = e[tv][i];
      if (d[to] > co + ec[tv][i]) {
        d[to] = co + ec[tv][i];
        be[to] = be[tv];
        qq.push(make_pair(-co - ec[tv][i], to));
      }
    }
  }
  for (int i = 0; i < m; i++) {
    if (be[u[i]] != be[v[i]]) {
      fvv.push_back(pair<long long, pair<int, int> >(
          d[u[i]] + d[v[i]] + w[i], make_pair(be[u[i]], be[v[i]])));
    }
  }
  sort(fvv.begin(), fvv.end());
  vector<long long> f;
  vector<vector<pair<int, int> > > fv;
  for (int i = 0; i < fvv.size(); i++) {
    if (!f.size() || f.back() != fvv[i].first) {
      if (fv.size() && !fv.back().size()) {
        f.pop_back();
        fv.pop_back();
      }
      f.push_back(fvv[i].first);
      fv.push_back(vector<pair<int, int> >());
    }
    int su = find(fvv[i].second.first), sv = find(fvv[i].second.second);
    if (su == sv) continue;
    fv.back().push_back(fvv[i].second);
    par[su] = sv;
  }
  for (int i = 0; i < k; i++) {
    par[i] = i;
  }
  int la = 0;
  for (int i = 0; i <= f.size(); i++) {
    if (i && i % C == 0) {
      for (int j = 0; j < q; j++) {
        if (qk[j]) continue;
        if (find(qu[j]) == find(qv[j])) {
          qd[i / C - 1].push_back(j);
          qk[j] = 1;
        }
      }
      la = i / C;
    }
    if (i == f.size()) continue;
    for (int j = 0; j < fv[i].size(); j++) {
      int tu = fv[i][j].first, tv = fv[i][j].second;
      tu = find(tu);
      tv = find(tv);
      par[tu] = tv;
    }
  }
  for (int i = 0; i < q; i++) {
    if (!qk[i]) qd[la].push_back(i);
  }
  for (int i = 0; i < k; i++) {
    par[i] = i;
  }
  for (int i = 0; i < f.size(); i++) {
    for (int j = 0; j < fv[i].size(); j++) {
      int tu = fv[i][j].first, tv = fv[i][j].second;
      tu = find(tu);
      tv = find(tv);
      par[tu] = tv;
    }
    for (int j = 0; j < qd[i / C].size(); j++) {
      int z = qd[i / C][j];
      if (ans[z]) continue;
      if (find(qu[z]) == find(qv[z])) {
        ans[z] = f[i];
      }
    }
  }
  for (int i = 0; i < q; i++) {
    printf("%I64d\n", ans[i]);
  }
  return 0;
}
