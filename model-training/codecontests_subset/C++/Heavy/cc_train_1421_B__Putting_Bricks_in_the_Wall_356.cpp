#include <bits/stdc++.h>
using namespace std;
const double pi = acos(-1.0);
const double pii = 2 * pi;
const double eps = 1e-6;
const long long MOD = 1e9 + 7;
vector<pair<int, int>> del{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
bool dfsf(int n, vector<string>& g) {
  vector<vector<bool>> v(n, vector<bool>(n, true));
  queue<pair<int, int>> q;
  q.push({0, 0});
  while (!q.empty()) {
    auto tp = q.front();
    q.pop();
    if (v[tp.first][tp.second]) {
      v[tp.first][tp.second] = false;
      for (auto x : del) {
        int xx = x.first + tp.first, yy = x.second + tp.second;
        if (xx >= 0 && yy >= 0 && xx < n && yy < n && v[xx][yy] &&
            g[xx][yy] == '.')
          q.push({xx, yy});
      }
    }
  }
  return !v[n - 1][n - 1];
}
bool f(int n, vector<string> g) {
  vector<string> g1(n, string(n, '.')), g2(n, string(n, '.'));
  for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++)
      if (g[i][j] == '1')
        g1[i][j] = '#';
      else if (g[i][j] == '0')
        g2[i][j] = '#';
  return dfsf(n, g1) || dfsf(n, g2);
}
void solve() {
  int n;
  cin >> n;
  vector<string> g(n);
  for (int i = 0; i < n; i++) cin >> g[i];
  if (!f(n, g)) {
    cout << "0\n";
    return;
  }
  vector<pair<int, int>> nodes{{1, 0}, {0, 1}, {n - 1, n - 2}, {n - 2, n - 1}};
  for (auto x : nodes) {
    g[x.first][x.second] = (g[x.first][x.second] == '1' ? '0' : '1');
    if (!f(n, g)) {
      cout << "1\n";
      cout << x.first + 1 << " " << x.second + 1 << "\n";
      return;
    }
    g[x.first][x.second] = (g[x.first][x.second] == '1' ? '0' : '1');
  }
  for (auto x : nodes)
    for (auto y : nodes) {
      g[x.first][x.second] = (g[x.first][x.second] == '1' ? '0' : '1');
      g[y.first][y.second] = (g[y.first][y.second] == '1' ? '0' : '1');
      if (!f(n, g)) {
        cout << "2\n";
        cout << x.first + 1 << " " << x.second + 1 << " " << y.first + 1 << " "
             << y.second + 1 << "\n";
        return;
      }
      g[x.first][x.second] = (g[x.first][x.second] == '1' ? '0' : '1');
      g[y.first][y.second] = (g[y.first][y.second] == '1' ? '0' : '1');
    }
}
int main() {
  std::ios::sync_with_stdio(false);
  std::cin.tie(NULL);
  std::cout.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    solve();
  }
  return 0;
}
