#include <bits/stdc++.h>
using namespace std;
const int N = 404;
int n, m, r, c, vis[N][N];
char a[N][N], b[N][N];
bitset<N> bs[26][N], ans[N];
int get(int x) { return (x % m + m - 1) % m + 1; }
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1, iE = n; i <= iE; i++) scanf("%s", a[i] + 1);
  for (int i = 1, iE = n; i <= iE; i++)
    for (int j = 1, jE = m; j <= jE; j++) bs[a[i][j] - 'a'][i][j] = 1;
  scanf("%d%d", &r, &c);
  for (int i = 1, iE = r; i <= iE; i++) scanf("%s", b[i] + 1);
  for (int i = 1, iE = n; i <= iE; i++)
    for (int j = 1, jE = m; j <= jE; j++) ans[i][j] = 1;
  for (int x = 1, xE = r; x <= xE; x++)
    for (int y = 1, yE = c; y <= yE; y++)
      if (b[x][y] != '?')
        for (int i = 1, iE = n; i <= iE; i++)
          ans[(i - x % n + n) % n + 1] &=
              ((bs[b[x][y] - 'a'][i] >> ((y - 1) % m)) |
               (bs[b[x][y] - 'a'][i] << (m - (y - 1) % m)));
  for (int i = 1, iE = n; i <= iE; i++)
    for (int j = 1, jE = m; j <= jE; j++)
      printf("%d%s", (int)ans[i][j], j == m ? "\n" : "");
  return 0;
}
