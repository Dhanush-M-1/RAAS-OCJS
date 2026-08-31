#include <bits/stdc++.h>
using namespace std;
const int INF = 1000 * 1000 * 1000 + 5;
const int MOD = 1000 * 1000 * 1000 + 7;
const long double EPS = 1e-9;
const int N = 55;
const int DX[] = {0, 1, 0, -1};
const int DY[] = {1, 0, -1, 0};
int n, m, k;
int a[N][N];
pair<pair<int, int>, pair<int, int> > f[N][N][4][2];
int g[N][N][4][2];
bool good(int x, int y) { return x >= 0 && x < n && y >= 0 && y < m; }
void next(int &x, int &y, int &u, int &v) {
  int nx = f[x][y][u][v].first.first;
  int ny = f[x][y][u][v].first.second;
  int nu = f[x][y][u][v].second.first;
  int nv = f[x][y][u][v].second.second;
  x = nx, y = ny, u = nu, v = nv;
}
void calc(int &pre, int &len) {
  int x = 0, y = 0, u = 0, v = 0;
  memset(g, 255, sizeof g);
  int c = 0;
  while (g[x][y][u][v] == -1) {
    g[x][y][u][v] = c++;
    next(x, y, u, v);
  }
  pre = g[x][y][u][v];
  len = c - g[x][y][u][v];
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cin >> n >> k;
  for (int i = 0; i < n; ++i) {
    string s;
    cin >> s;
    m = (int)s.size();
    for (int j = 0; j < m; ++j) {
      a[i][j] = s[j] - '0';
    }
  }
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < m; ++j) {
      if (a[i][j] == 0) {
        continue;
      }
      for (int u = 0; u < 4; ++u) {
        for (int v = 0; v < 2; ++v) {
          int x = i, y = j;
          while (good(x + DX[u], y + DY[u]) &&
                 a[x + DX[u]][y + DY[u]] == a[i][j]) {
            x += DX[u], y += DY[u];
          }
          int uu = (u + (v == 0 ? 3 : 1)) % 4;
          while (good(x + DX[uu], y + DY[uu]) &&
                 a[x + DX[uu]][y + DY[uu]] == a[i][j]) {
            x += DX[uu], y += DY[uu];
          }
          int p = u, q = v;
          if (good(x + DX[u], y + DY[u]) && a[x + DX[u]][y + DY[u]] != 0) {
            x += DX[u], y += DY[u];
          } else {
            if (v == 0) {
              q = 1;
            } else {
              p = (u + 1) % 4;
              q = 0;
            }
          }
          f[i][j][u][v] = make_pair(make_pair(x, y), make_pair(p, q));
        }
      }
    }
  }
  int pre, len;
  calc(pre, len);
  if (k < pre) {
    int x = 0, y = 0, u = 0, v = 0;
    for (int i = 0; i < k; ++i, next(x, y, u, v))
      ;
    cout << a[x][y] << '\n';
  } else {
    int l = (k - pre) % len;
    int x = 0, y = 0, u = 0, v = 0;
    for (int i = 0; i < pre + l; ++i, next(x, y, u, v))
      ;
    cout << a[x][y] << '\n';
  }
  return 0;
}
