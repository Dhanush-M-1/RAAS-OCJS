#include <bits/stdc++.h>
using namespace std;
set<pair<int, int> > S;
set<pair<int, int> > bio;
int n;
int px, py, ex, ey;
queue<int> Q;
const int dx[] = {0, 0, 1, -1, 1, 1, -1, -1};
const int dy[] = {1, -1, 0, 0, -1, 1, 1, -1};
inline void bfs() {
  Q.push(px);
  Q.push(py);
  bio.insert(make_pair(px, py));
  Q.push(0);
  while (!Q.empty()) {
    int x = Q.front();
    Q.pop();
    int y = Q.front();
    Q.pop();
    int dist = Q.front();
    Q.pop();
    for (int i = 0; i < 8; i++) {
      int X = x + dx[i];
      int Y = y + dy[i];
      if (X < 1 || X > 1000000000 || Y < 1 || Y > 1000000000) continue;
      if (!bio.empty() && bio.find(make_pair(X, Y)) != bio.end()) continue;
      if (!S.empty() && S.find(make_pair(X, Y)) == S.end()) continue;
      if (X == ex && Y == ey) {
        printf("%d\n", dist + 1);
        return;
      }
      Q.push(X);
      Q.push(Y);
      Q.push(dist + 1);
      bio.insert(make_pair(X, Y));
    }
  }
  printf("-1\n");
}
int main(void) {
  scanf("%d %d %d %d", &px, &py, &ex, &ey);
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    int r, a, b;
    scanf("%d %d %d", &r, &a, &b);
    for (int j = a; j <= b; j++) S.insert(make_pair(r, j));
  }
  bfs();
  return 0;
}
