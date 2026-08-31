#include <bits/stdc++.h>
using namespace std;
int movX[] = {0, 0, 1, -1, 1, 1, -1, -1}, movY[] = {1, -1, 0, 0, 1, -1, -1, 1};
map<pair<int, int>, int> vis;
int shortest(int a, int b, int x, int y) {
  queue<pair<int, int> > q;
  vis[make_pair(a, b)] = 1;
  q.push(make_pair(a, b));
  while (!q.empty()) {
    int ch1 = q.front().first, ch2 = q.front().second;
    q.pop();
    if (ch1 == x && ch2 == y) return vis[make_pair(ch1, ch2)];
    for (int i = 0; i < 8; i++) {
      int nx = movX[i] + ch1, ny = movY[i] + ch2;
      if (vis.find(make_pair(nx, ny)) != vis.end()) {
        if (!vis[make_pair(nx, ny)])
          q.push(make_pair(nx, ny)),
              vis[make_pair(nx, ny)] = vis[make_pair(ch1, ch2)] + 1;
      }
    }
  }
  return 0;
}
int main() {
  int a, b, x, y, q;
  cin >> a >> b >> x >> y >> q;
  while (q--) {
    int r, c1, c2;
    scanf("%d%d%d", &r, &c1, &c2);
    for (int i = c1; i <= c2; i++) vis[make_pair(r, i)] = 0;
  }
  cout << shortest(a, b, x, y) - 1 << "\n";
}
