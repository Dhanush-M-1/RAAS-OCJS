#include <bits/stdc++.h>
int me[103];
int mak[300];
int main() {
  int i, j, t, m, h, d, st, cas, y, ii;
  char qu[100];
  scanf("%d%d", &t, &m);
  memset(me, 0, sizeof(me));
  memset(mak, 0, sizeof(mak));
  cas = 1;
  for (ii = 0; ii < t; ii++) {
    scanf("%s", qu);
    if (qu[0] != 'd') scanf("%d", &d);
    if (qu[0] == 'a') {
      h = 0;
      if (d <= 0 || d > m) {
        printf("NULL\n");
        continue;
      }
      for (i = 1; i <= m; i++) {
        if (me[i] == 0) {
          h++;
          if (h == d) break;
        } else
          h = 0;
      }
      if (h == d) {
        printf("%d\n", cas);
        mak[cas] = i - d + 1;
        for (i = i - d + 1; h; h--, i++) {
          me[i] = cas;
        }
        cas++;
      } else
        printf("NULL\n");
    } else if (qu[0] == 'e') {
      if (d <= 0 || d >= cas || !mak[d])
        printf("ILLEGAL_ERASE_ARGUMENT\n");
      else {
        for (i = mak[d];; i++)
          if (me[i] == d)
            me[i] = 0;
          else
            break;
        mak[d] = 0;
      }
    } else {
      st = 1;
      for (i = 1; i <= m; i++) {
        if (me[i] && i != st) {
          mak[me[i]] = st;
          h = me[i];
          for (i; i <= m; i++)
            if (h == me[i]) {
              me[st++] = me[i];
              me[i] = 0;
            } else {
              i--;
              break;
            }
        } else if (me[i]) {
          me[st++] = me[i];
        }
      }
    }
  }
}
