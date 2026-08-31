#include <bits/stdc++.h>
using namespace std;
const int MaxN = 55 * 55;
int g[55][55], Set[55 * 55], mx[MaxN][2], my[MaxN][2], n, m, K;
int nxt[MaxN][8];
char s[55];
int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};
bool check(int x, int y) {
  if (x < 0 || y < 0 || x >= n || y >= m || g[x][y] == 0) return 0;
  return 1;
}
int find(int x) {
  if (x == Set[x]) return x;
  return Set[x] = find(Set[x]);
}
int main() {
  scanf("%d%d", &n, &K);
  for (int i = 0; i < n; i++) {
    scanf("%s", s);
    m = strlen(s);
    for (int j = 0; j < m; j++) {
      Set[i * m + j] = i * m + j;
      g[i][j] = s[j] - '0';
    }
  }
  for (int i = 0; i < n; i++)
    for (int j = 0; j < m; j++)
      if (g[i][j]) {
        for (int d = 0; d < 2; d++) {
          int x = i + dx[d], y = j + dy[d];
          if (check(x, y) && g[x][y] == g[i][j])
            Set[find(x * m + y)] = find(i * m + j);
        }
      }
  for (int i = 0; i < n * m; i++) {
    mx[i][0] = MaxN;
    mx[i][1] = -MaxN;
  }
  for (int i = 0; i < n; i++)
    for (int j = 0; j < m; j++)
      if (g[i][j]) {
        int s = find(i * m + j);
        if (i < mx[s][0] || i == mx[s][0] && j < my[s][0])
          mx[s][0] = i, my[s][0] = j;
        if (i > mx[s][1] || i == mx[s][1] && j > my[s][1])
          mx[s][1] = i, my[s][1] = j;
      }
  memset(nxt, -1, sizeof(nxt));
  for (int i = 0; i < n * m; i++)
    if (i == find(i)) {
      int x, y;
      x = mx[i][0], y = my[i][1] + 1;
      if (check(x, y)) nxt[i][0] = find(x * m + y);
      x = mx[i][1], y = my[i][1] + 1;
      if (check(x, y)) nxt[i][1] = find(x * m + y);
      x = mx[i][1] + 1, y = my[i][1];
      if (check(x, y)) nxt[i][2] = find(x * m + y);
      x = mx[i][1] + 1, y = my[i][0];
      if (check(x, y)) nxt[i][3] = find(x * m + y);
      x = mx[i][1], y = my[i][0] - 1;
      if (check(x, y)) nxt[i][4] = find(x * m + y);
      x = mx[i][0], y = my[i][0] - 1;
      if (check(x, y)) nxt[i][5] = find(x * m + y);
      x = mx[i][0] - 1, y = my[i][0];
      if (check(x, y)) nxt[i][6] = find(x * m + y);
      x = mx[i][0] - 1, y = my[i][1];
      if (check(x, y)) nxt[i][7] = find(x * m + y);
    }
  int D = 0, pos = find(0);
  for (int i = 0; i < K; i++) {
    if (nxt[pos][D] == -1)
      D = (D + 1) % 8;
    else
      pos = nxt[pos][D];
  }
  printf("%d\n", g[pos / m][pos % m]);
  return 0;
}
