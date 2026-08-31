#include <bits/stdc++.h>
using namespace std;
map<pair<int, int>, int> mp;
int xs, ys, xe, ye, n;
int d[8][2] = {-1, 0, 1, 0, 0, -1, 0, 1, -1, -1, -1, 1, 1, -1, 1, 1};
int main() {
  std::ios::sync_with_stdio(false);
  cin >> xs >> ys >> xe >> ye >> n;
  mp.clear();
  for (int i = 1; i <= n; i++) {
    int r, a, b;
    cin >> r >> a >> b;
    for (int i = a; i <= b; i++) {
      mp[make_pair(r, i)] = -1;
    }
  }
  queue<pair<int, int> > q;
  while (!q.empty()) q.pop();
  q.push(make_pair(xs, ys));
  mp[make_pair(xs, ys)] = 0;
  while (!q.empty()) {
    int x = q.front().first;
    int y = q.front().second;
    q.pop();
    for (int i = 0; i < 8; i++) {
      int nx = x + d[i][0];
      int ny = y + d[i][1];
      if (mp[make_pair(nx, ny)] == -1) {
        q.push(make_pair(nx, ny));
        mp[make_pair(nx, ny)] = mp[make_pair(x, y)] + 1;
      }
    }
  }
  cout << mp[make_pair(xe, ye)] << endl;
  return 0;
}
