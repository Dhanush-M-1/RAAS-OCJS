#include <bits/stdc++.h>
using namespace std;
const int Maxn = 3010;
struct Edge {
  int to, nxt;
} edge[Maxn << 1];
int anc[12][Maxn];
int fa[Maxn];
int first[Maxn];
int ring[Maxn];
int dep[Maxn];
int tree[Maxn];
int te = 1, n, tp;
int ringlen, ban1, ban2;
int ringst;
void adde(int x, int y) {
  edge[++te] = Edge{y, first[x]};
  first[x] = te;
}
int getfa(int x) { return fa[x] == x ? x : fa[x] = getfa(fa[x]); }
void getring(int x, int pre) {
  ring[++tp] = x;
  for (int i = first[x]; i && !ringlen; i = edge[i].nxt) {
    if (i == (pre ^ 1)) continue;
    int to = edge[i].to;
    if (to == ringst) {
      ringlen = tp;
      return;
    }
    getring(to, i);
  }
  --tp;
}
void dfs_tree(int x, int id) {
  tree[x] = id;
  dep[x] = dep[anc[0][x]] + 1;
  for (int i = first[x]; i; i = edge[i].nxt) {
    int to = edge[i].to;
    if (to == anc[0][x] || to == ban1 || to == ban2) continue;
    anc[0][to] = x;
    dfs_tree(to, id);
  }
}
int getlca(int x, int y) {
  if (dep[x] < dep[y]) swap(x, y);
  for (int k = 11; k >= 0; k--)
    if (dep[anc[k][x]] >= dep[y]) x = anc[k][x];
  if (x == y) return x;
  for (int k = 11; k >= 0; k--)
    if (anc[k][x] != anc[k][y]) x = anc[k][x], y = anc[k][y];
  return anc[0][x];
}
int main() {
  ios::sync_with_stdio(false);
  cin >> n;
  for (int i = 1; i <= n; i++) fa[i] = i;
  for (int x, y, i = 1; i <= n; ++i) {
    cin >> x >> y;
    x++;
    y++;
    adde(x, y);
    adde(y, x);
    int pa = getfa(x), pb = getfa(y);
    if (pa == pb) ringst = x;
    fa[pa] = pb;
  }
  getring(ringst, 0);
  ring[0] = ring[ringlen];
  ring[ringlen + 1] = ring[1];
  for (int i = 1; i <= ringlen; ++i) {
    int x = ring[i];
    ban1 = ring[i - 1], ban2 = ring[i + 1];
    dfs_tree(x, i);
  }
  for (int k = 1; k <= 11; k++)
    for (int i = 1; i <= n; i++) anc[k][i] = anc[k - 1][anc[k - 1][i]];
  double ans = 0;
  for (int i = 1; i <= n; ++i)
    for (int j = 1; j <= n; ++j)
      if (i != j) {
        if (tree[i] == tree[j]) {
          int lca = getlca(i, j);
          int len = dep[i] + dep[j] - (dep[lca] << 1);
          ans += 1.0 / (len + 1);
        } else {
          int len = dep[i] + dep[j];
          int nd1 = tree[i], nd2 = tree[j];
          int lenx =
              nd1 - nd2 + ringlen > ringlen ? nd1 - nd2 : nd1 - nd2 + ringlen;
          int leny =
              nd2 - nd1 + ringlen > ringlen ? nd2 - nd1 : nd2 - nd1 + ringlen;
          ans += 1.0 / (len + lenx - 1) + 1.0 / (len + leny - 1) -
                 1.0 / (len + lenx - 1 + leny - 1);
        }
      }
  cout << fixed << setprecision(10) << ans + n << endl;
  return 0;
}
