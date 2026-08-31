#include <bits/stdc++.h>
using namespace std;
const int MAX_N = 1000 + 10;
const int MAX_M = 1000000 + 10;
int n, m, q;
vector<pair<int, int> > e1;
int M[MAX_M][3];
int mark[MAX_N];
int par[MAX_N];
int size[MAX_N];
int l, r;
int findPar(int u) {
  if (par[u] == par[par[u]]) return par[u];
  int parent = par[u];
  par[u] = findPar(par[u]);
  mark[u] *= mark[parent];
  return par[u];
}
int findSet(int u) {
  findPar(u);
  if (u == par[u]) {
    return mark[u];
  }
  return mark[u] * mark[par[u]];
}
void solve() {
  for (int i = e1.size() - 1; i >= 0; i--)
    if (e1[i].second <= r && e1[i].second >= l) {
      int index = e1[i].second;
      int u = M[index][0];
      int v = M[index][1];
      int w = e1[i].first;
      int uPar = findPar(u);
      int vPar = findPar(v);
      if (uPar == vPar) {
        if (findSet(u) == findSet(v)) {
          cout << w << endl;
          return;
        }
      } else {
        if (size[uPar] > size[vPar]) {
          if (findSet(u) == findSet(v)) {
            mark[vPar] *= -1;
          }
          par[vPar] = uPar;
        } else {
          if (findSet(u) == findSet(v)) {
            mark[uPar] *= -1;
          }
          par[uPar] = vPar;
        }
      }
    }
  cout << -1 << endl;
  return;
}
void read() {
  scanf("%d%d%d", &n, &m, &q);
  for (int i = 1; i <= m; i++) {
    scanf("%d%d%d", &M[i][0], &M[i][1], &M[i][2]);
    e1.push_back(pair<int, int>(M[i][2], i));
  }
  sort(e1.begin(), e1.end());
  for (int i = 1; i <= q; i++) {
    scanf("%d%d", &l, &r);
    for (int j = 1; j <= n; j++) {
      mark[j] = 1;
      par[j] = j;
      size[j] = 1;
    }
    solve();
  }
}
int main() { read(); }
