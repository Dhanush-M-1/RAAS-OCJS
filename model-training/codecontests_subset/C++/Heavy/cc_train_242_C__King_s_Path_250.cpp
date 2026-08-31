#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 10;
int xa, ya, xb, yb;
int n;
map<pair<int, int>, int> mp, d;
int dx[] = {-1, -1, 0, 1, 1, 1, 0, -1}, dy[] = {0, 1, 1, 1, 0, -1, -1, -1};
int bfs(int x, int y) {
  queue<pair<int, int> > q;
  q.push(make_pair(x, y));
  d[make_pair(x, y)] = 0;
  while (!q.empty()) {
    pair<int, int> t = q.front();
    q.pop();
    if (t.first == xb && t.second == yb) {
      return d[t];
    }
    for (int i = 0; i < 8; i++) {
      int a = t.first + dx[i], b = t.second + dy[i];
      pair<int, int> now = make_pair(a, b);
      if (mp.count(now) != 0 && d.count(now) == 0) {
        d[now] = d[t] + 1;
        q.push(now);
      }
    }
  }
  pair<int, int> goal = make_pair(xb, yb);
  if (d.count(goal) == 0)
    return -1;
  else
    return d[goal];
}
int main() {
  cin >> xa >> ya >> xb >> yb;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int r, a, b;
    scanf("%d%d%d", &r, &a, &b);
    for (int j = a; j <= b; j++) mp[make_pair(r, j)] = 1;
  }
  int res = bfs(xa, ya);
  cout << res << '\n';
  return 0;
}
