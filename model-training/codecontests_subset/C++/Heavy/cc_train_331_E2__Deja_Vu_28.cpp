#include <bits/stdc++.h>
using namespace std;
const int MAXN = 100 * 2 + 10, MOD = (int)1e9 + 7;
int n, m, Tohka[MAXN], f[MAXN][2][MAXN];
bool g[MAXN][MAXN];
vector<int> e[MAXN][MAXN];
vector<pair<int, pair<int, int> > > a[4];
pair<int, int> Ext(vector<int> v, int ty) {
  int p = 0, len = 0;
  for (; p < ((int)(v).size()) - 1 && len <= n * 2 &&
         ((int)(v).size()) <= n * 2 + 1;
       ++len, ++p) {
    int first = v[p], second = v[p + 1];
    if (!ty) swap(first, second);
    if (!g[first][second]) return make_pair(-1, 0);
    vector<int> t = e[first][second];
    if (!ty) reverse((t).begin(), (t).end());
    v.insert(v.end(), (t).begin(), (t).end());
  }
  if (p == ((int)(v).size()) - 1 && len <= n * 2) return make_pair(len, v[p]);
  return make_pair(-1, 0);
}
void Work(vector<int> &v, int first, int second) {
  int p = 0;
  for (; p < ((int)(v).size()) - 1; ++p)
    if (v[p] == first && v[p + 1] == second) break;
  if (p < ((int)(v).size()) - 1) {
    vector<int> l, r;
    l.insert(l.end(), v.begin(), v.begin() + p + 1);
    reverse((l).begin(), (l).end());
    r.insert(r.end(), v.begin() + p + 1, v.end());
    pair<int, int> fl = Ext(l, 0), fr = Ext(r, 1);
    if (fl.first == -1 || fr.first == -1) return;
    a[3].push_back(
        make_pair(fl.first + fr.first + 1, make_pair(fl.second, fr.second)));
    return;
  }
  if (v[((int)(v).size()) - 1] == first) {
    vector<int> w = v;
    reverse((w).begin(), (w).end());
    pair<int, int> fl = Ext(w, 0);
    if (fl.first != -1)
      a[2].push_back(make_pair(fl.first + 1, make_pair(fl.second, second)));
  }
  if (v[0] == second) {
    vector<int> w = v;
    pair<int, int> fr = Ext(w, 1);
    if (fr.first != -1)
      a[1].push_back(make_pair(fr.first + 1, make_pair(first, fr.second)));
  }
}
void Plus(int &a, int b) {
  a += b;
  if (a >= MOD) a -= MOD;
}
void Dp() {
  memset(f, 0, sizeof(f));
  for (int i = 1; i <= n; ++i) f[0][0][i] = 1;
  for (int i = 0; i <= n * 2; ++i) {
    for (int k = 0; k < 2; ++k)
      for (int p = 0; p <= 3; ++p)
        if ((k ^ (p >> 1)) == 1)
          for (int j = 0; j < ((int)(a[p]).size()); ++j) {
            pair<int, pair<int, int> > t = a[p][j];
            if (f[i][k][t.second.first] && i + t.first <= n * 2)
              Plus(f[i + t.first][p & 1][t.second.second],
                   f[i][k][t.second.first]);
          }
    for (int j = 1; j <= n; ++j) {
      Plus(Tohka[i], f[i][1][j]);
    }
  }
}
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= m; ++i) {
    int first, second, k, z;
    scanf("%d%d%d", &first, &second, &k);
    g[first][second] = 1;
    vector<int> v;
    for (int j = 1; j <= k; ++j) scanf("%d", &z), v.push_back(z);
    e[first][second] = v;
  }
  for (int i = 1; i <= n; ++i)
    for (int j = 1; j <= n; ++j)
      if (((int)(e[i][j]).size()))
        Work(e[i][j], i, j);
      else if (g[i][j])
        a[0].push_back(make_pair(1, make_pair(i, j)));
  Dp();
  for (int i = 1; i <= n * 2; ++i) printf("%d\n", Tohka[i]);
  fclose(stdin);
  fclose(stdout);
  return 0;
}
