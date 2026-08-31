#include <bits/stdc++.h>
using namespace std;
const int maxn = 210;
char s[maxn][maxn];
bool vis[maxn][maxn];
int d[][2] = {1, 0, -1, 0, 0, 1, 0, -1};
int n;
bool dfs(int x, int y, char ch) {
  for (int i = 0; i < 4; ++i) {
    int nx = x + d[i][0], ny = y + d[i][1];
    if (nx == n && ny == n) return 1;
    if (nx < 1 || nx > n || ny < 1 || ny > n || vis[nx][ny] || s[nx][ny] != ch)
      continue;
    vis[nx][ny] = 1;
    if (dfs(nx, ny, ch)) return 1;
  }
  return 0;
}
bool check() {
  memset(vis, 0, sizeof(vis));
  return !dfs(1, 1, '0') && !dfs(1, 1, '1');
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int t;
  cin >> t;
  while (t--) {
    cin >> n;
    for (int i = 1; i <= n; ++i) cin >> (s[i] + 1);
    s[1][2] = ((s[1][2] - '0') ^ 1) + '0';
    s[2][1] = ((s[2][1] - '0') ^ 1) + '0';
    if (check()) {
      cout << 2 << '\n';
      cout << "1 2\n2 1\n";
      continue;
    }
    s[1][2] = ((s[1][2] - '0') ^ 1) + '0';
    s[2][1] = ((s[2][1] - '0') ^ 1) + '0';
    s[n][n - 1] = ((s[n][n - 1] - '0') ^ 1) + '0';
    s[n - 1][n] = ((s[n - 1][n] - '0') ^ 1) + '0';
    if (check()) {
      cout << 2 << '\n';
      cout << n << ' ' << n - 1 << '\n';
      cout << n - 1 << ' ' << n << '\n';
      continue;
    }
    s[n][n - 1] = ((s[n][n - 1] - '0') ^ 1) + '0';
    s[n - 1][n] = ((s[n - 1][n] - '0') ^ 1) + '0';
    pair<int, int> a[3] = {make_pair(0, 0), make_pair(1, 2), make_pair(2, 1)};
    pair<int, int> b[3] = {make_pair(0, 0), make_pair(n, n - 1),
                           make_pair(n - 1, n)};
    for (int i = 0; i <= 2; ++i) {
      int x = a[i].first, y = a[i].second;
      if (x) s[x][y] = ((s[x][y] - '0') ^ 1) + '0';
      for (int j = 0; j <= 2; ++j) {
        int xx = b[j].first, yy = b[j].second;
        if (xx) s[xx][yy] = ((s[xx][yy] - '0') ^ 1) + '0';
        if (check()) {
          if (x && xx) {
            cout << 2 << '\n';
            cout << x << ' ' << y << '\n';
            cout << xx << ' ' << yy << '\n';
          } else if (x) {
            cout << 1 << '\n';
            cout << x << ' ' << y << '\n';
          } else if (xx) {
            cout << 1 << '\n';
            cout << xx << ' ' << yy << '\n';
          } else {
            cout << 0 << '\n';
          }
          goto done;
        }
        if (xx) s[xx][yy] = ((s[xx][yy] - '0') ^ 1) + '0';
      }
      if (x) s[x][y] = ((s[x][y] - '0') ^ 1) + '0';
    }
  done:
    continue;
  }
  return 0;
}
