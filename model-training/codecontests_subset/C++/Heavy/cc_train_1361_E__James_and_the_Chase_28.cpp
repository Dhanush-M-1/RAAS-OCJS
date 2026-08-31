#include <bits/stdc++.h>
#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")
const long long INF = 0x3f3f3f3f3f3f3f3f;
const long long llinf = (1LL << 62);
const int inf = (1 << 30);
const int nmax = 1e5 + 50;
const long long mod = 1e9 + 7;
using namespace std;
int n, m, viz[nmax], bd[nmax], x, y, i, j, t, bl, insert[nmax], out[nmax], tt,
    lvl[nmax], rs, ts, nd[nmax];
pair<int, int> vl[nmax];
vector<int> a[nmax], vec, rd;
void dfs(int x, int p) {
  viz[x] = 1;
  lvl[x] = lvl[p] + 1;
  insert[x] = ++tt;
  for (int i = 0; i < (int)a[x].size(); i++) {
    int y = a[x][i];
    if (viz[y]) continue;
    dfs(y, x);
  }
  out[x] = ++tt;
}
void asd(int x) {
  viz[x] = 1;
  vl[x] = make_pair(inf, inf);
  vector<int> vc;
  for (int i = 0; i < (int)a[x].size(); i++) {
    int y = a[x][i];
    vc.push_back(lvl[y]);
    if (!viz[y]) {
      asd(y);
      vc.push_back(vl[y].first), vc.push_back(vl[y].second);
    }
    sort(vc.begin(), vc.end());
    while ((int)vc.size() > 2) vc.pop_back();
  }
  if ((int)vc.size() == 1)
    vl[x].first = vc[0];
  else if ((int)vc.size() == 2)
    vl[x] = make_pair(vc[0], vc[1]);
  if (vl[x].first < lvl[x] && vl[x].second < lvl[x]) bd[x] = 1;
}
void sdf(int x) {
  viz[x] = 1;
  nd[lvl[x]] = x;
  if (vl[x].first != inf) bd[x] |= bd[nd[vl[x].first]];
  for (int i = 0; i < (int)a[x].size(); i++) {
    int y = a[x][i];
    if (viz[y]) continue;
    sdf(y);
  }
}
int main() {
  mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cerr.tie(0);
  cout.tie(0);
  cin >> ts;
  while (ts--) {
    cin >> n >> m;
    for (i = 1; i <= n; i++) a[i].clear();
    while (m--) {
      cin >> x >> y;
      a[x].push_back(y);
    }
    rd.clear();
    for (i = 1; i <= n; i++) rd.push_back(i);
    shuffle(rd.begin(), rd.end(), rng);
    rs = 0, vec.clear();
    for (i = 0; i < min(200, n); i++) {
      x = rd[i];
      tt = 0;
      for (j = 1; j <= n; j++) {
        viz[j] = 0;
        lvl[j] = 0;
      }
      dfs(x, x);
      bl = 0;
      for (j = 1; j <= n; j++) {
        for (t = 0; t < (int)a[j].size(); t++) {
          y = a[j][t];
          if (!(insert[y] <= insert[j] && out[j] <= out[y]) &&
              !(insert[j] <= insert[y] && out[y] <= out[j])) {
            bl = 1;
            break;
          }
          if (insert[j] <= insert[y] && out[y] <= out[j] &&
              lvl[y] != lvl[j] + 1) {
            bl = 1;
            break;
          }
        }
        if (bl) break;
      }
      if (bl) continue;
      for (j = 1; j <= n; j++) viz[j] = bd[j] = 0;
      asd(x);
      for (j = 1; j <= n; j++) viz[j] = 0;
      sdf(x);
      for (j = 1; j <= n; j++)
        if (!bd[j]) rs++, vec.push_back(j);
      break;
    }
    if (rs <= (n - 1) / 5)
      cout << -1 << '\n';
    else {
      for (j = 0; j < rs; j++) cout << vec[j] << " ";
      cout << '\n';
    }
  }
  return 0;
}
