#include <bits/stdc++.h>
using namespace std;
bitset<405> ans[405], ok[26][405];
char maps1[405][405], maps2[405][405];
int main() {
  int n, m, r, c;
  cin >> n >> m;
  for (int i = 0; i < n; i++) scanf("%s", maps1[i]);
  cin >> r >> c;
  for (int i = 0; i < r; i++) scanf("%s", maps2[i]);
  for (int i = 0; i < n; i++)
    for (int j = 0; j < m; j++) {
      ans[i][j] = 1;
      ok[maps1[i][j] - 'a'][i][j] = 1;
    }
  for (int y = 0; y < c; y++) {
    for (int x = 0; x < r; x++) {
      if (maps2[x][y] != '?') {
        int now = maps2[x][y] - 'a';
        for (int i = 0, xx = x % n; i < n; i++, xx++) {
          if (xx >= n) xx -= n;
          ans[i] &= ok[now][xx];
        }
      }
    }
    for (int i = 0; i < n; i++) {
      for (int s = 0; s < 26; s++) {
        ok[s][i][m] = ok[s][i][0];
        ok[s][i] >>= 1;
      }
    }
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      if (ans[i][j])
        printf("1");
      else
        printf("0");
    }
    printf("\n");
  }
  return 0;
}
