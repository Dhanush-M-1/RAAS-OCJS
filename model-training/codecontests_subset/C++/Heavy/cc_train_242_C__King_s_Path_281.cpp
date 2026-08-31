#include <bits/stdc++.h>
using namespace std;
const int INF = 2000000000;
const double EPS = 1e-9;
int mods(int a, int b) { return (b + (a % b)) % b; }
int n, r, a, b, sx, sy, ex, ey;
int dr[8] = {-1, -1, 0, 1, 1, 1, 0, -1};
int dc[8] = {0, 1, 1, 1, 0, -1, -1, -1};
bool finish;
map<pair<int, int>, int> dist;
pair<int, int> u, v;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> sx >> sy >> ex >> ey >> n;
  for (int i = 0; i < n; i++) {
    cin >> r >> a >> b;
    for (int j = a; j <= b; j++) dist[pair<int, int>(r, j)] = -1;
  }
  if (!dist.count(pair<int, int>(ex, ey))) {
    cout << -1 << '\n';
    return 0;
  }
  dist[pair<int, int>(sx, sy)] = 0;
  queue<pair<int, int> > q;
  q.push(pair<int, int>(sx, sy));
  while (!q.empty() && !finish) {
    u = q.front();
    q.pop();
    for (int i = 0; i < 8; i++) {
      v.first = u.first + dr[i];
      v.second = u.second + dc[i];
      if (dist.count(v)) {
        if (dist[v] != -1) continue;
        dist[v] = dist[u] + 1;
        if (v == pair<int, int>(ex, ey)) {
          finish = 1;
          break;
        }
        q.push(v);
      }
    }
  }
  cout << dist[pair<int, int>(ex, ey)] << '\n';
  return 0;
}
