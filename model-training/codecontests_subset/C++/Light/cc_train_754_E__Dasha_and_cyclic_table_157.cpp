#include <bits/stdc++.h>
using namespace std;
int s[405][405];
bitset<405> ans[405], f[28][405];
int n, m, r, c;
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 0; i <= n - 1; i++)
    for (int j = 0; j <= m - 1; j++) {
      char c = getchar();
      while (c < 'a' || c > 'z') c = getchar();
      ans[i][j] = 1;
      f[c - 'a'][i][j] = 1;
    }
  scanf("%d%d", &r, &c);
  for (int i = 0; i <= r - 1; i++)
    for (int j = 0; j <= c - 1; j++) {
      char c = getchar();
      while ((c < 'a' || c > 'z') && c != '?') c = getchar();
      if (c != '?')
        s[i][j] = c - 'a';
      else
        s[i][j] = -1;
    }
  for (int i = 0; i <= c - 1; i++) {
    for (int j = 0; j <= r - 1; j++) {
      if (s[j][i] == -1) continue;
      for (int k = 0; k <= n - 1; k++)
        ans[k] = ans[k] & f[s[j][i]][(k + j) % n];
    }
    for (int j = 0; j <= n - 1; j++) {
      for (int k = 0; k <= 25; k++) {
        int tmp = f[k][j][0];
        f[k][j] >>= 1;
        f[k][j][m - 1] = tmp;
      }
    }
  }
  for (int i = 0; i <= n - 1; i++) {
    for (int j = 0; j <= m - 1; j++)
      if (ans[i][j])
        putchar('1');
      else
        putchar('0');
    puts("");
  }
  return 0;
}
