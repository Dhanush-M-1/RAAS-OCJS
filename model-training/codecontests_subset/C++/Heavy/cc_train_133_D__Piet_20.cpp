#include <bits/stdc++.h>
using namespace std;
const double eps = 1e-9;
const double PI = acos(-1.0);
const int INF = 1e9 + 7;
const int MAXN = int(2e5 + 7);
int n, m, cp, dp, t;
int dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0};
char c[55][55];
pair<int, int> d[55][55][4], cur = make_pair(0, 0);
void inc() {
  if (cp == 0)
    cp = 1;
  else
    dp = (dp + 1) % 4, cp = 0;
}
void go() {
  cur = d[cur.first][cur.second][dp];
  int to = (dp + 3) % 4;
  if (cp) to = (dp + 1) % 4;
  cur = d[cur.first][cur.second][to];
  int tox = cur.first + dx[dp], toy = cur.second + dy[dp];
  if (tox < n && tox >= 0 && toy < m && toy >= 0 && c[tox][toy] != '0')
    cur = make_pair(tox, toy);
  else
    inc();
}
int main() {
  scanf("%d%d", &n, &t);
  for (int i = 0; i < n; i++) scanf("%s", c[i]);
  m = strlen(c[0]);
  for (int i = 0; i < n; i++)
    for (int j = m - 1; j >= 0; j--)
      if (j != m - 1 && c[i][j] == c[i][j + 1])
        d[i][j][0] = d[i][j + 1][0];
      else
        d[i][j][0] = make_pair(i, j);
  for (int i = 0; i < n; i++)
    for (int j = 0; j < m; j++)
      if (j && c[i][j] == c[i][j - 1])
        d[i][j][2] = d[i][j - 1][2];
      else
        d[i][j][2] = make_pair(i, j);
  for (int i = 0; i < n; i++)
    for (int j = 0; j < m; j++)
      if (i && c[i][j] == c[i - 1][j])
        d[i][j][3] = d[i - 1][j][3];
      else
        d[i][j][3] = make_pair(i, j);
  for (int i = n - 1; i >= 0; i--)
    for (int j = 0; j < m; j++)
      if (i != n - 1 && c[i][j] == c[i + 1][j])
        d[i][j][1] = d[i + 1][j][1];
      else
        d[i][j][1] = make_pair(i, j);
  for (int i = 0; i < t; i++) go();
  printf("%c\n", c[cur.first][cur.second]);
  return 0;
}
