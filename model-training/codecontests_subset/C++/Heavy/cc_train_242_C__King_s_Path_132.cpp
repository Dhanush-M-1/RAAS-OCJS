#include <bits/stdc++.h>
using namespace std;
const int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
const int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};
int main() {
  int a, b, c, d;
  scanf("%d %d %d %d", &a, &b, &c, &d);
  int m;
  scanf("%d", &m);
  map<pair<int, int>, int> mp;
  for (int i = 0; i < m; ++i) {
    int x, y1, y2;
    scanf("%d %d %d", &x, &y1, &y2);
    while (y1 <= y2) {
      mp[{x, y1}] = 1000000000;
      y1++;
    }
  }
  mp[{a, b}] = 0;
  queue<pair<int, int> > q;
  q.emplace(a, b);
  while (!q.empty()) {
    a = q.front().first, b = q.front().second;
    q.pop();
    for (int i = 0; i < 8; ++i) {
      int x = a + dx[i];
      int y = b + dy[i];
      if (x < 0 or y < 0 or x >= 1000000000 or y >= 1000000000) continue;
      if (!mp.count({x, y})) continue;
      if (mp[{x, y}] != 1000000000) continue;
      mp[{x, y}] = mp[{a, b}] + 1;
      q.emplace(x, y);
    }
  }
  if (mp[{c, d}] == 1000000000)
    puts("-1");
  else
    printf("%d\n", mp[{c, d}]);
}
