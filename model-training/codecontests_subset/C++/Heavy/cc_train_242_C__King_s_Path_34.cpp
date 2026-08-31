#include <bits/stdc++.h>
using namespace std;
int dx[] = {0, 1, 0, -1, -1, 1, 1, -1};
int dy[] = {1, 0, -1, 0, 1, 1, -1, -1};
int xx[] = {-1, 1, 2, 2, 1, -1, -2, -2};
int yy[] = {2, 2, 1, -1, -2, -2, -1, 1};
map<pair<int, int>, int> mp;
pair<int, int> u, v;
int sx, sy, ex, ey;
void BFS() {
  queue<pair<int, int> > q;
  u.first = sx;
  u.second = sy;
  q.push(u);
  mp[u] = 0;
  while (!q.empty()) {
    u = q.front();
    q.pop();
    for (int i = 0; i < 8; i++) {
      int x = u.first + dx[i];
      int y = u.second + dy[i];
      v.first = x, v.second = y;
      if (mp.find(v) != mp.end() && mp[v] == -1) {
        mp[v] = mp[u] + 1;
        q.push(v);
      }
    }
  }
}
int main() {
  int n, r, a, b, i;
  while (scanf("%d %d %d %d", &sx, &sy, &ex, &ey) == 4) {
    scanf("%d", &n);
    mp.clear();
    while (n--) {
      scanf("%d %d %d", &r, &a, &b);
      for (i = a; i <= b; i++) mp[make_pair(r, i)] = -1;
    }
    BFS();
    printf("%d\n", mp[make_pair(ex, ey)]);
  }
  return 0;
}
