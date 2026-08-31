#include <bits/stdc++.h>
using namespace std;
struct Node {
  int r, c, dis;
};
int sr, sc, dr, dc, n;
int ri, ai, bi;
map<int, vector<pair<int, int> > > m;
map<int, map<int, bool> > visited;
bool isValid(int x, int y) {
  bool segOk = false;
  for (int i = 0; i < m[x].size(); i++) {
    if (m[x][i].first <= y && m[x][i].second >= y) {
      segOk = true;
      break;
    }
  }
  return x >= 1 && y >= 1 && x <= 1000000000 && y <= 1000000000 && segOk && y &&
         !visited[x][y];
}
int moveC[] = {1, -1, 0, 0, 1, -1, 1, -1};
int moveR[] = {0, 0, 1, -1, 1, 1, -1, -1};
int bfs() {
  queue<Node> q;
  Node s;
  s.r = sr;
  s.c = sc;
  s.dis = 0;
  q.push(s);
  while (!q.empty()) {
    Node t = q.front();
    if (t.r == dr && t.c == dc) return t.dis;
    for (int x = 0; x < 8; x++) {
      if (isValid(t.r + moveR[x], t.c + moveC[x])) {
        Node r;
        r.r = t.r + moveR[x];
        r.c = t.c + moveC[x];
        r.dis = t.dis + 1;
        visited[r.r][r.c] = true;
        q.push(r);
      }
    }
    q.pop();
  }
  return -1;
}
int main() {
  cin >> sr >> sc >> dr >> dc;
  cin >> n;
  for (int x = 0; x < n; x++) {
    cin >> ri >> ai >> bi;
    m[ri].push_back(make_pair(ai, bi));
  }
  cout << bfs();
}
