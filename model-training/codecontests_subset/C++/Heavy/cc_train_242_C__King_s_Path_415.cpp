#include <bits/stdc++.h>
using namespace std;
const int MOD = 1000000007;
const int N = 1000005;
const double PI = 4 * atan(1);
long long m, x, n, p, k, q, l, r;
long long a, b;
long long x0, y, x2, y2;
map<pair<long long, long long>, bool> isbehy;
map<pair<long long, long long>, bool> vis;
map<pair<long long, long long>, long long> dist;
int dx[] = {1, -1, 1, -1, 0, 0, 1, -1};
int dy[] = {1, -1, -1, 1, 1, -1, 0, 0};
bool ingrid(long long x, long long y) {
  return isbehy[make_pair(x, y)] == 1 && vis[make_pair(x, y)] == 0 && x >= 1 &&
         x <= 1e9 && y >= 1 && y <= 1e9 && dist[make_pair(x, y)] == 0;
}
long long bfs() {
  queue<pair<long long, long long> > q;
  q.push(make_pair(x0, y));
  pair<long long, long long> ras;
  while (!q.empty()) {
    ras = q.front();
    q.pop();
    if (vis[ras]) continue;
    vis[ras] = 1;
    for (int i = 0; i < 8; i++) {
      if (ingrid(ras.first + dx[i], ras.second + dy[i])) {
        dist[make_pair(ras.first + dx[i], ras.second + dy[i])] = dist[ras] + 1;
        q.push(make_pair(ras.first + dx[i], ras.second + dy[i]));
      }
    }
  }
  if (dist[make_pair(x2, y2)] == 0) return -1;
  return dist[make_pair(x2, y2)];
}
int main() {
  ios::sync_with_stdio(0);
  cin >> x0 >> y >> x2 >> y2;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> r >> a >> b;
    for (int j = a; j <= b; j++) {
      isbehy[make_pair(r, j)] = 1;
    }
  }
  long long ans = bfs();
  cout << ans;
  return 0;
}
