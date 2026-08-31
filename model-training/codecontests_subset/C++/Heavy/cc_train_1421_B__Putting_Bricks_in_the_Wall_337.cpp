#include <bits/stdc++.h>
using namespace std;
bool check(vector<vector<int>> &a, int n, int x) {
  deque<pair<int, int>> q;
  map<pair<int, int>, bool> was;
  q.push_back({1, 1});
  was[{1, 1}] = true;
  int dx[] = {1, 0, -1, 0};
  int dy[] = {0, 1, 0, -1};
  while (!q.empty()) {
    auto u = q.front();
    q.pop_front();
    for (int i = 0; i < 4; i++) {
      int xx = u.first + dx[i];
      int yy = u.second + dy[i];
      if (xx == n && yy == n) return false;
      if (a[xx][yy] == x && !was[{xx, yy}]) {
        q.push_back({xx, yy});
        was[{xx, yy}] = true;
      }
    }
  }
  return true;
}
void v(vector<vector<int>> &a, int n) {
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      cout << a[i][j];
    }
    cout << endl;
  }
}
void solve() {
  vector<vector<int>> a;
  int n;
  cin >> n;
  a = vector<vector<int>>(n + 2, vector<int>(n + 2, 2));
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      char x;
      cin >> x;
      if (x != 'S' && x != 'F') {
        a[i][j] = x - '0';
      }
    }
  }
  vector<pair<int, int>> c = {
      {n - 1, n - 1}, {n - 1, n}, {n, n - 1}, {n - 2, n}, {n, n - 2}};
  if (check(a, n, 1) && check(a, n, 0)) {
    cout << 0 << endl;
    return;
  }
  for (int i = 0; i < c.size(); i++) {
    a[c[i].first][c[i].second] = 1 - a[c[i].first][c[i].second];
    if (check(a, n, 1) && check(a, n, 0)) {
      cout << 1 << '\n';
      cout << c[i].first << ' ' << c[i].second << endl;
      return;
    }
    a[c[i].first][c[i].second] = 1 - a[c[i].first][c[i].second];
  }
  for (int i = 0; i < c.size(); i++) {
    for (int j = i + 1; j < c.size(); j++) {
      a[c[i].first][c[i].second] = 1 - a[c[i].first][c[i].second];
      a[c[j].first][c[j].second] = 1 - a[c[j].first][c[j].second];
      if (check(a, n, 1) && check(a, n, 0)) {
        cout << 2 << '\n';
        cout << c[i].first << ' ' << c[i].second << endl;
        cout << c[j].first << ' ' << c[j].second << endl;
        return;
      }
      a[c[i].first][c[i].second] = 1 - a[c[i].first][c[i].second];
      a[c[j].first][c[j].second] = 1 - a[c[j].first][c[j].second];
    }
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int t = 1;
  cin >> t;
  for (int i = 1; i <= t; i++) {
    solve();
  }
}
