#include <bits/stdc++.h>
using namespace std;
const int N = 1e3 + 10;
map<pair<int, int>, int> mov, cost;
int sr, sc, er, ec;
int xp[] = {1, 1, 1, -1, -1, -1, 0, 0};
int yp[] = {-1, 0, 1, -1, 0, 1, 1, -1};
void bfs() {
  queue<pair<int, int>> q;
  q.push({sr, sc});
  cost[{sr, sc}] = 1;
  while (q.size()) {
    int y = q.front().first;
    int x = q.front().second;
    q.pop();
    for (int i = 0; i < 8; i++) {
      int nx = x + xp[i];
      int ny = y + yp[i];
      if (nx < 1 || ny < 1 || nx > 1e9 || ny > 1e9 || !mov[{ny, nx}] ||
          cost[{ny, nx}] != 0)
        continue;
      cost[{ny, nx}] = cost[{y, x}] + 1;
      q.push({ny, nx});
    }
  }
}
int main() {
  cin >> sr >> sc >> er >> ec;
  int n, r, cs, ce;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> r >> cs >> ce;
    for (int j = cs; j <= ce; j++) mov[{r, j}] = 1;
  }
  bfs();
  cout << cost[{er, ec}] - 1 << endl;
}
