#include <bits/stdc++.h>
using namespace std;
const double pi = acos(-1.0);
const double eps = 1e-9;
const int INF = 1E9;
const int MAXN = 1111;
const int MAXM = 1000500;
int n, q, m, a, b, c, u;
pair<pair<int, int>, pair<int, int> > edges[MAXM];
int color[MAXN], setId[MAXN];
int sets[MAXN][MAXN];
int sz[MAXN];
int id;
int idu, idv, f;
void mergeTo(int from, int to, int x) {
  for (int i = 0; i < (int)(sz[from]); i++) {
    u = sets[from][i];
    setId[u] = to;
    color[u] ^= x;
    sets[to][sz[to]++] = u;
  }
  sz[from] = 0;
}
bool add(int u, int v) {
  if (color[u] == -1 && color[v] == -1) {
    color[u] = 0;
    color[v] = 1;
    id = setId[u];
    setId[v] = id;
    sets[id][sz[id]++] = v;
    return 1;
  }
  if (color[u] == -1) return add(v, u);
  if (color[v] == -1) {
    color[v] = color[u] ^ 1;
    id = setId[u];
    setId[v] = setId[u];
    sets[id][sz[id]++] = v;
    return 1;
  }
  idu = setId[u];
  idv = setId[v];
  if (idu == idv) return color[u] != color[v];
  f = color[u] == color[v];
  if (sz[idu] <= sz[idv]) {
    mergeTo(idu, idv, f);
  } else {
    mergeTo(idv, idu, f);
  }
  return 1;
}
int main() {
  scanf("%d%d%d", &n, &m, &q);
  for (int i = 0; i < (int)(m); i++) {
    scanf("%d%d%d", &a, &b, &c);
    a--, b--;
    edges[i] = {{c, i}, {a, b}};
  }
  sort(edges, edges + m);
  reverse(edges, edges + m);
  for (int iii = 0; iii < (int)(q); iii++) {
    int L, R;
    scanf("%d%d", &L, &R);
    L--, R--;
    for (int i = 0; i < (int)(n); i++) {
      color[i] = -1;
      setId[i] = i;
      sets[i][0] = i;
      sz[i] = 1;
    }
    int ans = -1;
    for (int i = 0; i < (int)(m); i++)
      if (L <= edges[i].first.second && edges[i].first.second <= R) {
        if (!add(edges[i].second.first, edges[i].second.second)) {
          ans = edges[i].first.first;
          break;
        }
      }
    printf("%d\n", ans);
  }
  return 0;
}
