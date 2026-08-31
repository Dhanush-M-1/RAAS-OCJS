#include <bits/stdc++.h>
using namespace std;
int v1[1000010], l, q[1000010], comp[1000010], d[1000010], k, nr;
vector<int> v[1000010], vt[1000010], ctc[1000010];
char vaz[1000010], leaf[1000010];
const int inf = 1e9;
void dfs(int nod, int nivel) {
  v1[nivel] = nod;
  int poz = max(1, nivel - k);
  vaz[nod] = 1;
  if (!v[nod].size()) {
    leaf[nod] = 1;
    v[nod].push_back(v1[poz]);
    vt[v1[poz]].push_back(nod);
  }
  for (int i = 0; i < v[nod].size(); i++)
    if (!vaz[v[nod][i]]) dfs(v[nod][i], nivel + 1);
}
void dfs1(int nod) {
  vaz[nod] = 1;
  for (int i = 0; i < v[nod].size(); i++)
    if (!vaz[v[nod][i]]) dfs1(v[nod][i]);
  q[++l] = nod;
}
void dfs2(int nod) {
  vaz[nod] = 0;
  ctc[nr].push_back(nod);
  comp[nod] = nr;
  for (int i = 0; i < vt[nod].size(); i++)
    if (vaz[vt[nod][i]]) dfs2(vt[nod][i]);
}
int main() {
  int x, n, sol = 0;
  scanf("%d%d", &n, &k);
  for (int i = 2; i <= n; i++) {
    scanf("%d", &x);
    v[x].push_back(i);
    vt[i].push_back(x);
  }
  dfs(1, 1);
  memset(vaz, 0, sizeof(vaz));
  for (int i = 1; i <= n; i++)
    if (!vaz[i]) dfs1(i);
  for (int i = l; i >= 1; i--)
    if (vaz[q[i]]) {
      nr++;
      dfs2(q[i]);
    }
  for (int i = nr; i >= 1; i--) {
    int s = 0;
    for (int j = 0; j < ctc[i].size(); j++) {
      int nod = ctc[i][j];
      s += leaf[nod];
      for (int k = 0; k < v[nod].size(); k++) {
        int vec = v[nod][k];
        d[i] = max(d[i], d[comp[vec]]);
      }
    }
    d[i] += s;
    sol = max(sol, d[i]);
  }
  printf("%d", sol);
  return 0;
}
