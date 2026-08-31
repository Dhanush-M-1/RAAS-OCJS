#include <bits/stdc++.h>
using namespace std;
int n, m;
char s[420][420];
char st[420];
bitset<420> c[26][420], ans[420];
int main() {
  int r, p;
  scanf("%d%d", &n, &m);
  int M = 400, N = 400;
  for (int i = 0; i < n; i++) {
    scanf("%s", &s[i]);
  }
  for (int i = 0; i < n; i++)
    for (int j = 0; j < m; j++) c[s[i][j] - 'a'][i][j] = 1;
  for (int i = 0; i < n; i++) ans[i].set();
  scanf("%d%d", &r, &p);
  for (int i = 0; i < r; i++) {
    scanf("%s", &st);
    for (int j = 0; j < p; j++) {
      if (st[j] == '?') continue;
      for (int k = 0; k < n; k++) {
        int l = ((k - i) % n + n) % n;
        ans[l] &= ((c[st[j] - 'a'][k] >> (j % m)) |
                   (c[st[j] - 'a'][k] << (m - j % m)));
      }
    }
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) printf("%d", ans[i][j] ? 1 : 0);
    printf("\n");
  }
  return 0;
}
