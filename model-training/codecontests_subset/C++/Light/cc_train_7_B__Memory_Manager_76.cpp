#include <bits/stdc++.h>
using namespace std;
int mem[110];
int main() {
  int n, m;
  char str[15];
  int x, cnt;
  while (~scanf("%d%d", &n, &m)) {
    memset(mem, 0xff, sizeof(mem));
    cnt = 0;
    for (int i = 0; i < n; i++) {
      scanf(" %s", str);
      if (str[0] == 'a') {
        scanf("%d", &x);
        bool f = false;
        for (int j = 0; j <= m - x; j++) {
          bool flag = true;
          for (int k = 0; k < x; k++) {
            if (mem[j + k] != -1) {
              flag = false;
              break;
            }
          }
          if (flag) {
            f = true;
            cnt++;
            for (int k = 0; k < x; k++) mem[j + k] = cnt;
            break;
          }
        }
        if (f)
          printf("%d\n", cnt);
        else
          puts("NULL");
      } else if (str[0] == 'e') {
        scanf("%d", &x);
        if (x <= 0) {
          puts("ILLEGAL_ERASE_ARGUMENT");
          continue;
        }
        bool f = false;
        for (int j = 0; j < m; j++) {
          if (mem[j] == x) {
            f = true;
            mem[j] = -1;
          }
        }
        if (!f) puts("ILLEGAL_ERASE_ARGUMENT");
      } else {
        int tm = 0;
        for (int j = 0; j < m; j++) {
          if (mem[j] != -1) mem[tm++] = mem[j];
        }
        for (int j = tm; j < m; j++) mem[j] = -1;
      }
    }
  }
  return 0;
}
