#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
int n, m, f[2 * 55][2 * 55];
bool g[55][55];
vector<int> G[55][55], Path;
vector<pair<int, int>> tr[2 * 55][2 * 55];
int find_cross(vector<int>& a, int x, int y) {
  for (int i = 0, lim = a.size(); i < lim - 1; i++)
    if (a[i] == x && a[i + 1] == y) return i;
  return -1;
}
int walk(vector<int>& a, int x, bool rev) {
  for (int i = 0; a.size() < 2 * n && i < a.size(); x = a[i], i++) {
    if ((!rev && !g[x][a[i]]) || (rev && !g[a[i]][x])) return -1;
    if (!rev)
      a.insert(a.end(), G[x][a[i]].begin(), G[x][a[i]].end());
    else
      a.insert(a.end(), G[a[i]][x].rbegin(), G[a[i]][x].rend());
  }
  if (a.size() >= 2 * n) return -1;
  return x;
}
void add_trans(int x, int y, int len) {
  for (int i = 0; i + len <= 2 * n; i++)
    tr[i][x].push_back(make_pair(i + len, y));
}
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1, x, y, k, t; i <= m; i++) {
    scanf("%d%d%d", &x, &y, &k), g[x][y] = 1;
    while (k--) scanf("%d", &t), G[x][y].push_back(t);
  }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++)
      if (g[i][j]) {
        int pos;
        if (~(pos = find_cross(G[i][j], i, j))) {
          vector<int> L(G[i][j].begin(), G[i][j].begin() + pos);
          reverse(L.begin(), L.end());
          int pL = walk(L, i, 1);
          if (~pL) {
            vector<int> R(G[i][j].begin() + pos + 2, G[i][j].end());
            int pR = walk(R, j, 0);
            if (~pR && L.size() + R.size() + 1 <= 2 * n) {
              if (Path.empty()) {
                Path.insert(Path.end(), L.rbegin(), L.rend());
                Path.push_back(i), Path.push_back(j);
                Path.insert(Path.end(), R.begin(), R.end());
              }
              add_trans(pL, pR + n, L.size() + R.size() + 1);
            }
          }
        }
        if (G[i][j].empty())
          add_trans(i + n, j, 1);
        else {
          if (G[i][j].front() == j) {
            vector<int> R(G[i][j].begin() + 1, G[i][j].end());
            int pR = walk(R, j, 0);
            if (~pR) add_trans(i + n, pR + n, R.size() + 1);
          }
          if (G[i][j].back() == i) {
            vector<int> L(G[i][j].rbegin() + 1, G[i][j].rend());
            int pL = walk(L, i, 1);
            if (~pL) add_trans(pL, j, L.size() + 1);
          }
        }
      }
  for (int i = 1; i <= n; i++) f[0][i] = 1;
  for (int l = 0; l <= 2 * n; l++)
    for (int i = 1; i <= 2 * n; i++)
      if (f[l][i])
        for (auto w : tr[l][i]) (f[w.first][w.second] += f[l][i]) %= mod;
  for (int l = 1; l <= 2 * n; l++) {
    int s = 0;
    for (int i = 1; i <= n; i++) (s += f[l][i + n]) %= mod;
    printf("%d\n", s);
  }
}
