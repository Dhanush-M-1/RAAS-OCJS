#include <bits/stdc++.h>
using namespace std;
int dx[] = {1, -1, 0, 0, 1, 1, -1, -1};
int dy[] = {0, 0, 1, -1, 1, -1, 1, -1};
int x, y, x2, y2, n, row, l, r;
map<int, vector<pair<int, int> > > mp;
map<pair<int, int>, bool> vis;
bool okay(int fi, int se) {
  for (int i = 0; i < mp[fi].size(); i++) {
    if (mp[fi][i].first <= se && mp[fi][i].second >= se) return 1;
  }
  return 0;
}
int bfs() {
  queue<pair<int, int> > q;
  pair<int, int> cur;
  q.push({x, y});
  int steps = 0, siz = 1;
  while (!q.empty()) {
    siz = q.size();
    while (siz--) {
      cur = q.front();
      q.pop();
      for (int i = 0; i < 8; i++) {
        int tox = cur.first + dx[i];
        int toy = cur.second + dy[i];
        if (okay(tox, toy)) {
          if (tox == x2 && toy == y2) return steps + 1;
          if (!vis[{tox, toy}]) q.push({tox, toy});
          vis[{tox, toy}] = 1;
        }
      }
    }
    steps++;
  }
  return -1;
}
int main() {
  ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  ;
  cin >> x >> y >> x2 >> y2 >> n;
  for (int i = 0; i < n; i++) {
    cin >> row >> l >> r;
    mp[row].push_back({l, r});
  }
  int ans = bfs();
  if (ans == -1)
    cout << -1 << endl;
  else
    cout << ans << endl;
  return 0;
}
