#include <bits/stdc++.h>
using namespace std;
const int mxn = 1e5 + 10;
map<pair<int, int>, int> mp;
int pointCnt;
bool vis[mxn + 100];
int dis[mxn + 100];
pair<int, int> ar[mxn + 100];
int dr[] = {0, -1, -1, -1, 0, 1, 1, 1};
int dc[] = {1, 1, 0, -1, -1, -1, 0, 1};
void dfs(int u) {
  queue<int> q;
  q.push(u);
  dis[u] = 0;
  vis[u] = true;
  while (!q.empty()) {
    u = q.front();
    q.pop();
    for (int i = 0; i < 8; i++) {
      int x = ar[u].first + dr[i];
      int y = ar[u].second + dc[i];
      if (mp.find(make_pair(x, y)) != mp.end()) {
        int pos = mp[make_pair(x, y)];
        if (!vis[pos]) {
          dis[pos] = dis[u] + 1;
          vis[pos] = true;
          q.push(pos);
        }
      }
    }
  }
}
int main() {
  int sx, sy, ex, ey;
  int n;
  pointCnt = 0;
  cin >> sx >> sy >> ex >> ey;
  cin >> n;
  int r, c1, c2;
  for (int i = 0; i < n; i++) {
    cin >> r >> c1 >> c2;
    for (int j = c1; j <= c2; j++) {
      mp[make_pair(r, j)] = ++pointCnt;
      ar[pointCnt] = make_pair(r, j);
    }
  }
  if (mp.find(make_pair(sx, sy)) == mp.end()) {
    mp[make_pair(sx, sy)] = ++pointCnt;
    ar[pointCnt] = make_pair(sx, sy);
  }
  if (mp.find(make_pair(ex, ey)) == mp.end()) {
    mp[make_pair(ex, ey)] = ++pointCnt;
    ar[pointCnt] = make_pair(ex, ey);
  }
  memset(vis, false, sizeof vis);
  dfs(mp[make_pair(sx, sy)]);
  if (vis[mp[make_pair(ex, ey)]]) {
    cout << dis[mp[make_pair(ex, ey)]] << endl;
  } else
    cout << -1 << endl;
  return 0;
}
