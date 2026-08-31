#include <bits/stdc++.h>
using namespace std;
const int dx[4] = {0, 1, 0, -1};
const int dy[4] = {1, 0, -1, 0};
class state {
 public:
  int x, y, dp, cp;
  state() {
    x = 0;
    y = 0;
    dp = 0;
    cp = 3;
  }
  state(int _x, int _y, int _dp, int _cp) {
    x = _x;
    y = _y;
    dp = _dp;
    cp = _cp;
  }
};
int n, m, k;
string a[60];
state z[60][60][4][4];
bool valid(int x, int y) {
  if (x < 0 || y < 0 || x == n || y == m || a[x][y] == '0') return false;
  return true;
}
int main() {
  cin >> n >> k;
  for (int i = 0; i < n; ++i) cin >> a[i];
  m = a[0].size();
  for (int i = 0; i < n; ++i)
    for (int j = 0; j < m; ++j) {
      for (int d = 0; d < 4; ++d) {
        for (int it = 0; it < 2; ++it) {
          int c = (d + 1 + it * 2) % 4;
          int tekx = i, teky = j;
          while (a[tekx][teky] == a[i][j]) {
            tekx += dx[d];
            teky += dy[d];
            if (tekx == n || teky == m || tekx == -1 || teky == -1) break;
          }
          tekx -= dx[d];
          teky -= dy[d];
          while (a[tekx][teky] == a[i][j]) {
            tekx += dx[c];
            teky += dy[c];
            if (tekx == n || teky == m || tekx == -1 || teky == -1) break;
          }
          tekx -= dx[c];
          teky -= dy[c];
          if (!valid(tekx + dx[d], teky + dy[d])) {
            if (it == 1)
              z[i][j][d][c] = state(i, j, d, (d + 1 + 0 * 2) % 4);
            else
              z[i][j][d][c] = state(i, j, (d + 1) % 4, ((d + 1) % 4 + 3) % 4);
          } else {
            z[i][j][d][c] = state(tekx + dx[d], teky + dy[d], d, c);
          }
        }
      }
    }
  state tek;
  for (int i = 0; i < k; ++i) {
    tek = z[tek.x][tek.y][tek.dp][tek.cp];
  }
  cout << a[tek.x][tek.y] << endl;
  return 0;
}
