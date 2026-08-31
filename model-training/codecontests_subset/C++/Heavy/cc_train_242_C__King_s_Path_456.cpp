#include <bits/stdc++.h>
using namespace std;
int dx[] = {0, 0, 1, -1, 1, -1, 1, -1}, dy[] = {1, -1, 0, 0, 1, 1, -1, -1};
int main() {
  int x1, x2, y1, y2, i, j, k, l, m, n, r, a, b, x, y;
  map<pair<int, int>, int> mp, mp1;
  cin >> x1 >> y1 >> x2 >> y2 >> n;
  mp[{x1, y1}] = mp[{x2, y2}] = 1;
  for (i = 0; i < n; i++) {
    cin >> r >> a >> b;
    for (j = a; j <= b; j++) mp[{r, j}] = 1;
  }
  queue<pair<pair<int, int>, int> > q;
  q.push({{x1, y1}, 0}), mp1[{x1, y1}] = 1;
  while (!q.empty()) {
    a = q.front().first.first, b = q.front().first.second, r = q.front().second,
    q.pop();
    for (i = 0; i < 8; i++) {
      x = a + dx[i], y = b + dy[i];
      if (x == x2 && y == y2) {
        printf("%d\n", r + 1);
        return 0;
      }
      if (mp1[{x, y}] == 0 && mp[{x, y}] == 1) {
        mp1[{x, y}] = 1, q.push({{x, y}, r + 1});
      }
    }
  }
  printf("-1\n");
  return 0;
}
