#include <bits/stdc++.h>
const int maxn = 100 + 7;
char op[1729];
int cc[maxn];
int main() {
  int n, m, cnt = 1, t, i, j;
  scanf("%d%d", &n, &m);
  while (n--) {
    scanf("%s", op);
    if (op[0] == 'a') {
      scanf("%d", &t);
      for (i = 0; i <= m - t; ++i) {
        for (j = i; j < i + t; ++j)
          if (cc[j]) break;
        if (j == i + t) break;
      }
      if (i <= m - t) {
        printf("%d\n", cnt);
        for (j = i; j < i + t; ++j) cc[j] = cnt;
        cnt++;
      } else {
        puts("NULL");
      }
    } else if (op[0] == 'e') {
      scanf("%d", &t);
      bool ok = false;
      for (i = 0; i < m; ++i)
        if (cc[i] && cc[i] == t) {
          ok = true;
          cc[i] = 0;
        }
      if (!ok) puts("ILLEGAL_ERASE_ARGUMENT");
    } else {
      for (i = 0, j = 0; i < m; ++i)
        if (cc[i]) {
          cc[j++] = cc[i];
        }
      for (; j < m; ++j) cc[j] = 0;
    }
  }
}
