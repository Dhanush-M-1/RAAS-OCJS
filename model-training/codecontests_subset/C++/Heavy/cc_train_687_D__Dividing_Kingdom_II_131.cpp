#include <bits/stdc++.h>
using namespace std;
int id[600000], a[600000], b[600000], c[600000];
bool cmp(int i, int j) { return c[i] > c[j]; }
int adj[1010][1010], deg[1010], col[1010], root[1010];
int main() {
  int n, m, q;
  cin >> n >> m >> q;
  for (int i = 0; i < m; i++) {
    scanf("%d %d %d", a + i, b + i, c + i);
    id[i] = i;
  }
  sort(id, id + m, cmp);
  int L, R;
  while (q--) {
    scanf("%d %d", &L, &R);
    L--;
    R--;
    for (int i = 1; i <= n; i++) {
      root[i] = i;
      col[i] = deg[i] = 0;
      adj[i][deg[i]++] = i;
    }
    int ans = -1;
    for (int ii = 0; ii < m; ii++) {
      int i = id[ii];
      if (i > R || i < L) continue;
      int x = root[a[i]], y = root[b[i]];
      if (x == y) {
        if (col[a[i]] == col[b[i]]) {
          ans = c[i];
          break;
        }
      } else {
        if (deg[x] > deg[y]) swap(x, y);
        int inv = (col[a[i]] == col[b[i]]);
        for (int j = 0; j < deg[x]; j++) {
          int z = adj[x][j];
          adj[y][deg[y]++] = z;
          root[z] = y;
          col[z] ^= inv;
        }
      }
    }
    printf("%d\n", ans);
  }
  return 0;
}
