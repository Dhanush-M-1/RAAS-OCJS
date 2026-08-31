#include <bits/stdc++.h>
using namespace std;
const int INF = numeric_limits<int>::max();
const long long LLINF = numeric_limits<long long>::max();
const unsigned long long ULLINF = numeric_limits<unsigned long long>::max();
const double PI = acos(-1.0);
map<int, set<int>> good;
map<int, map<int, int>> used;
int dx[] = {0, 0, 1, 1, 1, -1, -1, -1};
int dy[] = {1, -1, 0, 1, -1, 0, 1, -1};
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  long long x0, y0, x1, y1;
  cin >> x0 >> y0 >> x1 >> y1;
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int r, a, b;
    cin >> r >> a >> b;
    for (int j = a; j <= b; j++) good[r].insert(j);
  }
  queue<pair<int, int>> q;
  q.push(make_pair(x0, y0));
  used[x0][y0] = 1;
  while (!q.empty()) {
    int x = q.front().first, y = q.front().second;
    q.pop();
    for (int i = 0; i < 8; i++) {
      int nx = x + dx[i], ny = y + dy[i];
      if (good[nx].find(ny) != good[nx].end() && !used[nx][ny]) {
        used[nx][ny] = used[x][y] + 1;
        q.push(make_pair(nx, ny));
      }
    }
  }
  cout << used[x1][y1] - 1;
  return 0;
}
