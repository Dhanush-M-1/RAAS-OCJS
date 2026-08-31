#include <bits/stdc++.h>
using namespace std;
int X[4], Y[4];
map<pair<int, int>, bool> m_p, visit;
int dr8[8] = {1, -1, 0, 0, 1, -1, -1, 1};
int dc8[8] = {0, 0, -1, 1, 1, 1, -1, -1};
int bfs() {
  queue<pair<pair<int, int>, int> > q;
  q.push(make_pair(make_pair(X[0], Y[0]), 0));
  visit[make_pair(X[0], Y[0])] = 1;
  while (!q.empty()) {
    pair<pair<int, int>, int> tmp = q.front();
    q.pop();
    for (int i = 0; i < 8; i++) {
      int x = tmp.first.first + dr8[i];
      int y = tmp.first.second + dc8[i];
      if (m_p.find(make_pair(x, y)) != m_p.end() && !visit[make_pair(x, y)]) {
        visit[make_pair(x, y)] = 1;
        q.push(make_pair(make_pair(x, y), tmp.second + 1));
        if (x == X[1] && y == Y[1]) return tmp.second + 1;
      }
    }
  }
  return -1;
}
int main() {
  cin >> X[0] >> Y[0] >> X[1] >> Y[1];
  int n;
  scanf("%d", &n);
  while (n--) {
    int r, l, ro;
    scanf("%d %d %d", &ro, &l, &r);
    for (int i = l; i <= r; i++) m_p[make_pair(ro, i)] = 1;
  }
  cout << bfs();
}
