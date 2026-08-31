#include <bits/stdc++.h>
using namespace std;
int main() {
  int xs, ys, xe, ye;
  map<int, map<int, int> > ada, dist, visited;
  scanf("%d%d%d%d", &xs, &ys, &xe, &ye);
  int n;
  scanf("%d", &n);
  while (n--) {
    int x, dari, ke;
    scanf("%d%d%d", &x, &dari, &ke);
    for (int(i) = (dari); (i) <= (ke); (i)++) {
      ada[x][i] = 1;
      dist[x][i] = INT_MAX;
    }
  }
  ada[xe][ye] = 1;
  queue<pair<int, int> > pq;
  dist[xs][ys] = 0;
  pq.push(make_pair(xs, ys));
  while (!pq.empty()) {
    pair<int, int> now = pq.front();
    pq.pop();
    int x = now.first, y = now.second;
    for (int(i) = (-1); (i) <= (1); (i)++)
      for (int(j) = (-1); (j) <= (1); (j)++) {
        int xx = x + i, yy = y + j;
        if (ada[xx][yy]) {
          if (dist[xx][yy] > dist[x][y] + 1) {
            dist[xx][yy] = dist[x][y] + 1;
            pq.push(make_pair(xx, yy));
          }
        }
      }
  }
  if (dist[xe][ye] != INT_MAX)
    printf("%d", dist[xe][ye]);
  else
    printf("-1");
  return 0;
}
