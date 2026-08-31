#include <bits/stdc++.h>
using namespace std;
vector<pair<long long, long long> > v[300010], w[300010];
long long tt[300010], lg[300010], lvl[300010];
priority_queue<pair<long long, long long> > h;
long long dist[300010];
pair<long long, long long> fth[20][300010];
pair<long long, pair<long long, long long> > mch[300010];
long long n;
long long rad(long long x) {
  while (tt[x] > 0) x = tt[x];
  return x;
}
void dfs(long long nod, long long tata, long long cost) {
  long long i;
  fth[0][nod] = make_pair(tata, cost);
  for (i = 0; i < w[nod].size(); i++) {
    if (w[nod][i].first != tata) {
      lvl[w[nod][i].first] = 1 + lvl[nod];
      dfs(w[nod][i].first, nod, w[nod][i].second);
    }
  }
}
long long path(long long x, long long y) {
  long long dif, p2;
  long long sol;
  sol = 0;
  if (lvl[x] < lvl[y]) swap(x, y);
  dif = lvl[x] - lvl[y];
  while (dif && x != 0) {
    sol = max(sol, fth[lg[dif]][x].second);
    x = fth[lg[dif]][x].first;
    dif = dif - (1 << lg[dif]);
  }
  if (x == y) {
    return sol;
  }
  for (p2 = lg[n]; p2 >= 0; p2--) {
    if (fth[p2][x].first != fth[p2][y].first) {
      sol = max(sol, max(fth[p2][x].second, fth[p2][y].second));
      x = fth[p2][x].first;
      y = fth[p2][y].first;
    }
  }
  p2 = 0;
  sol = max(sol, max(fth[p2][x].second, fth[p2][y].second));
  return sol;
}
int main() {
  FILE *fin = stdin;
  FILE *fout = stdout;
  long long m, k, q, x, y, i, nod, vecin, rx, ry, elem, j;
  long long z, cost, c;
  fscanf(fin, "%lld%lld%lld%lld", &n, &m, &k, &q);
  for (i = 1; i <= m; i++) {
    fscanf(fin, "%lld%lld%lld", &x, &y, &z);
    v[x].push_back(make_pair(y, z));
    v[y].push_back(make_pair(x, z));
  }
  for (i = 2; i <= n; i++) {
    lg[i] = lg[i / 2] + 1;
  }
  for (i = 1; i <= n; i++) {
    dist[i] = 2000000000000000000;
    tt[i] = -1;
  }
  for (i = 1; i <= k; i++) {
    h.push(make_pair(0, i));
    dist[i] = 0;
  }
  while (!h.empty()) {
    cost = -h.top().first;
    nod = h.top().second;
    h.pop();
    if (dist[nod] != cost) {
      continue;
    }
    for (i = 0; i < v[nod].size(); i++) {
      vecin = v[nod][i].first;
      c = v[nod][i].second;
      if (dist[vecin] > dist[nod] + c) {
        dist[vecin] = dist[nod] + c;
        h.push(make_pair(-dist[vecin], vecin));
      }
    }
  }
  elem = 0;
  for (i = 1; i <= n; i++) {
    for (j = 0; j < v[i].size(); j++) {
      v[i][j].second += dist[i] + dist[v[i][j].first];
      if (v[i][j].first > i) {
        elem++;
        mch[elem].first = v[i][j].second;
        mch[elem].second.first = i;
        mch[elem].second.second = v[i][j].first;
      }
    }
  }
  sort(mch + 1, mch + elem + 1);
  for (i = 1; i <= elem; i++) {
    x = mch[i].second.first;
    y = mch[i].second.second;
    rx = rad(x);
    ry = rad(y);
    if (rx != ry) {
      w[x].push_back(make_pair(y, mch[i].first));
      w[y].push_back(make_pair(x, mch[i].first));
      if (tt[rx] < tt[ry]) {
        tt[rx] += tt[ry];
        tt[ry] = rx;
      } else {
        tt[ry] += tt[rx];
        tt[rx] = ry;
      }
    }
  }
  dfs(1, 0, 0);
  k = 1;
  while ((1 << k) <= n) {
    for (i = 1; i <= n; i++) {
      fth[k][i].first = fth[k - 1][fth[k - 1][i].first].first;
      fth[k][i].second =
          max(fth[k - 1][i].second, fth[k - 1][fth[k - 1][i].first].second);
    }
    k++;
  }
  for (; q; q--) {
    fscanf(fin, "%lld%lld", &x, &y);
    fprintf(fout, "%lld\n", path(x, y));
  }
  return 0;
}
