#include <bits/stdc++.h>
using namespace std;
struct node {
  int row;
  int col;
  bool operator==(const node& p) const {
    return (row == p.row && col == p.col);
  }
  bool operator<(const node& p) const { return (row < p.row && col < p.col); }
};
map<pair<int, int>, int> allow;
map<pair<int, int>, int> level;
map<pair<int, int>, int> visit;
int frow[8] = {1, -1, 1, -1, 1, -1, 0, 0};
int fcol[8] = {0, 0, 1, 1, -1, -1, 1, -1};
void bfs(pair<int, int> source) {
  queue<pair<int, int> > q;
  pair<int, int> top, novo;
  int i;
  q.push(source);
  visit[source] = 1;
  level[source] = 1;
  while (!q.empty()) {
    top = q.front();
    q.pop();
    for (i = 0; i < 8; i++) {
      novo.first = top.first + frow[i];
      novo.second = top.second + fcol[i];
      if (visit[novo] == 1 || allow[novo] == 0) continue;
      if (novo.first > 0 && novo.first <= 1000000000 && novo.second > 0 &&
          novo.second <= 1000000000) {
        visit[novo] = 1;
        level[novo] = level[top] + 1;
        q.push(novo);
      }
    }
  }
}
int main() {
  allow.clear();
  level.clear();
  visit.clear();
  pair<int, int> source;
  pair<int, int> dest;
  int n, i, j, a, b;
  scanf("%d%d%d%d", &source.first, &source.second, &dest.first, &dest.second);
  scanf("%d", &n);
  for (i = 0; i < n; i++) {
    pair<int, int> g;
    scanf("%d%d%d", &g.first, &a, &b);
    for (j = a; j <= b; j++) {
      g.second = j;
      allow[g] = 1;
    }
  }
  bfs(source);
  printf("%d", level[dest] - 1);
  return 0;
}
