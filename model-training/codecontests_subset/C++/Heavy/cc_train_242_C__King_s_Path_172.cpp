#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1e6;
const int INF = 1e9;
int dx[] = {1, 1, 1, 0, 0, -1, -1, -1};
int dy[] = {-1, 0, 1, 1, -1, -1, 0, 1};
int Px0, Py0, Px1, Py1, n, l, r, a;
map<pair<int, int>, int> table, black;
pair<int, int> q[MAXN];
void bfs(pair<int, int> a) {
  int x = a.first, y = a.second;
  table[{x, y}] = 0;
  int h = 0, t = 0;
  q[t++] = a;
  while (t - h) {
    a = q[h++];
    x = a.first, y = a.second;
    for (int i = 0; i < 8; i++) {
      if (table.count({x + dx[i], y + dy[i]}) == 0 &&
          black[{x + dx[i], y + dy[i]}]) {
        table[{x + dx[i], y + dy[i]}] = table[{x, y}] + 1;
        q[t++] = {x + dx[i], y + dy[i]};
      }
    }
  }
}
int main() {
  cin >> Px0 >> Py0 >> Px1 >> Py1 >> n;
  for (int i = 0; i < n; i++) {
    cin >> a >> l >> r;
    for (int j = l; j <= r; j++) {
      black[{a, j}] = true;
    }
  }
  bfs({Px0, Py0});
  if (table.count({Px1, Py1}) == 0)
    return cout << -1 << '\n', 0;
  else
    return cout << table[{Px1, Py1}] << '\n', 0;
}
