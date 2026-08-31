#include <bits/stdc++.h>
using namespace std;
const int dx[] = {0, 0, 1, -1, 1, 1, -1, -1};
const int dy[] = {1, -1, 0, 0, 1, -1, 1, -1};
struct node {
  int x, y;
  int d;
};
int bfs(int n, int x0, int y0, int x1, int y1) {
  node st, nd;
  node now, next;
  int i, r, a, b;
  map<int, map<int, int> > myMap;
  scanf("%d", &n);
  while (n--) {
    scanf("%d%d%d", &r, &a, &b);
    for (i = a; i <= b; i++) myMap[r][i] = 1;
  }
  st.x = x0, st.y = y0, st.d = 0;
  nd.x = x1, nd.y = y1;
  queue<node> que;
  que.push(st);
  myMap[st.x][st.y] = 0;
  while (!que.empty()) {
    now = que.front();
    if (now.x == nd.x && now.y == nd.y) return now.d;
    que.pop();
    for (i = 0; i < 8; i++) {
      next.x = now.x + dx[i];
      next.y = now.y + dy[i];
      next.d = now.d + 1;
      if (myMap[next.x][next.y] == 1) {
        myMap[next.x][next.y] = 0;
        que.push(next);
      }
    }
  }
  return -1;
}
int main() {
  int x0, y0, x1, y1;
  int n;
  while (scanf("%d%d%d%d", &x0, &y0, &x1, &y1) != EOF) {
    printf("%d\n", bfs(n, x0, y0, x1, y1));
  }
  return 0;
}
