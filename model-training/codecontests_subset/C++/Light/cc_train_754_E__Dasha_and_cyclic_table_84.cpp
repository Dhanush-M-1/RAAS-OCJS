#include <bits/stdc++.h>
int n, m, x, y;
std::bitset<810> ans[410];
std::bitset<810> g[810][26];
char s[410];
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 0; i < n; i++) {
    scanf("%s", s);
    ans[i].set();
    for (int j = 0; j < m; j++) {
      int d = s[j] - 'a';
      for (int b = i; b <= 800; b += n)
        for (int z = j; z <= 800; z += m) g[b][d].set(z);
    }
  }
  scanf("%d%d", &x, &y);
  for (int i = 0; i < x; i++) {
    scanf("%s", s);
    for (int j = 0; j < y; j++) {
      if (s[j] == '?') continue;
      int d = s[j] - 'a';
      for (int k = 0; k < n; k++) ans[k] &= (g[(k + i) % n][d] >> j);
    }
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) printf("%d", ans[i].test(j));
    printf("\n");
  }
  return 0;
}
