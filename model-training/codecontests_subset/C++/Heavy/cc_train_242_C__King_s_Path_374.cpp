#include <bits/stdc++.h>
using namespace std;
int sx, sy, dx, dy, n, dis[100004];
map<pair<int, int>, int> mp;
int main() {
  cin >> sx >> sy >> dx >> dy;
  cin >> n;
  int i, j, cnt = 1;
  for (i = 0; i < n; i++) {
    int r, c1, c2;
    cin >> r >> c1 >> c2;
    for (j = c1; j <= c2; j++) {
      mp[{r, j}] = cnt;
      dis[cnt] = 1000000000;
      cnt++;
    }
  }
  mp[{dx, dy}] = cnt;
  dis[cnt] = 1000000000;
  queue<pair<int, int> > q;
  q.push({sx, sy});
  dis[mp[{sx, sy}]] = 0;
  while (!q.empty()) {
    int x = q.front().first;
    int y = q.front().second;
    q.pop();
    if (mp.find({x + 1, y}) != mp.end() &&
        dis[mp[{x + 1, y}]] > dis[mp[{x, y}]] + 1) {
      dis[mp[{x + 1, y}]] = dis[mp[{x, y}]] + 1;
      q.push({x + 1, y});
    }
    if (mp.find({x - 1, y}) != mp.end() &&
        dis[mp[{x - 1, y}]] > dis[mp[{x, y}]] + 1) {
      dis[mp[{x - 1, y}]] = dis[mp[{x, y}]] + 1;
      q.push({x - 1, y});
    }
    if (mp.find({x, y + 1}) != mp.end() &&
        dis[mp[{x, y + 1}]] > dis[mp[{x, y}]] + 1) {
      dis[mp[{x, y + 1}]] = dis[mp[{x, y}]] + 1;
      q.push({x, y + 1});
    }
    if (mp.find({x, y - 1}) != mp.end() &&
        dis[mp[{x, y - 1}]] > dis[mp[{x, y}]] + 1) {
      dis[mp[{x, y - 1}]] = dis[mp[{x, y}]] + 1;
      q.push({x, y - 1});
    }
    if (mp.find({x + 1, y + 1}) != mp.end() &&
        dis[mp[{x + 1, y + 1}]] > dis[mp[{x, y}]] + 1) {
      dis[mp[{x + 1, y + 1}]] = dis[mp[{x, y}]] + 1;
      q.push({x + 1, y + 1});
    }
    if (mp.find({x - 1, y - 1}) != mp.end() &&
        dis[mp[{x - 1, y - 1}]] > dis[mp[{x, y}]] + 1) {
      dis[mp[{x - 1, y - 1}]] = dis[mp[{x, y}]] + 1;
      q.push({x - 1, y - 1});
    }
    if (mp.find({x + 1, y - 1}) != mp.end() &&
        dis[mp[{x + 1, y - 1}]] > dis[mp[{x, y}]] + 1) {
      dis[mp[{x + 1, y - 1}]] = dis[mp[{x, y}]] + 1;
      q.push({x + 1, y - 1});
    }
    if (mp.find({x - 1, y + 1}) != mp.end() &&
        dis[mp[{x - 1, y + 1}]] > dis[mp[{x, y}]] + 1) {
      dis[mp[{x - 1, y + 1}]] = dis[mp[{x, y}]] + 1;
      q.push({x - 1, y + 1});
    }
  }
  if (dis[mp[{dx, dy}]] == 1000000000) {
    cout << -1 << "\n";
  } else {
    cout << dis[mp[{dx, dy}]] << "\n";
  }
}
