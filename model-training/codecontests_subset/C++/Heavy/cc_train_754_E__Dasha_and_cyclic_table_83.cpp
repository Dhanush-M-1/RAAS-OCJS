#include <bits/stdc++.h>
using namespace std;
char mat[405][405], pat[405][405];
int main() {
  int n, m, r, c;
  scanf("%d%d", &n, &m);
  bitset<405> ans[n], G[30][n];
  for (int i = 0; i < n; i++) scanf(" %s", mat[i]);
  scanf("%d%d", &r, &c);
  for (int i = 0; i < r; i++) scanf(" %s", pat[i]);
  for (int i = 0; i < n; i++)
    for (int j = 0; j < m; j++)
      G[mat[i][j] - 'a'][i][m - 1 - j] = ans[i][j] = 1;
  for (int i = 0; i < r; i++) {
    for (int j = 0; j < c; j++) {
      char x = pat[i][j];
      if (x == '?') continue;
      x -= 'a';
      for (int k = 0; k < n; k++) {
        int y = j % m;
        ans[k] &= ((G[x][(k + i) % n] << y) | G[x][(k + i) % n] >> (m - y));
      }
    }
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) printf("%d", (ans[i][m - j - 1] == 1 ? 1 : 0));
    puts("");
  }
  return 0;
}
