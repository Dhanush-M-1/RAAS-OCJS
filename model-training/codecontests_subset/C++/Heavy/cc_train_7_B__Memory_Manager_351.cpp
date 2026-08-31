#include <bits/stdc++.h>
using namespace std;
inline long long read() {
  char ch = getchar();
  long long x = 0, f = 1;
  while (ch < '0' || ch > '9') f = ch == '-' ? -1 : 1, ch = getchar();
  while (ch >= '0' && ch <= '9') x = x * 10 + ch - '0', ch = getchar();
  return x * f;
}
const int MAXN = 110;
char opt[MAXN];
long long memory[MAXN];
int main(int argc, char *argv[]) {
  ios::sync_with_stdio(false);
  cin.tie(0);
  long long t = read(), m = read();
  int tot = 0;
  for (int _ = (1); _ <= (t); _ += (1)) {
    scanf("%s", opt + 1);
    if (opt[1] == 'a') {
      long long len = read();
      bool find = false;
      for (int i = (1); i <= (m - len + 1); i += (1)) {
        bool ok = true;
        for (int j = (i); j <= (i + len - 1); j += (1))
          if (memory[j]) ok = false;
        if (ok) {
          tot++;
          for (int j = (i); j <= (i + len - 1); j += (1)) memory[j] = tot;
          find = true;
          break;
        }
      }
      if (find)
        printf("%d\n", tot);
      else
        puts("NULL");
    } else if (opt[1] == 'e') {
      long long id = read();
      if (id < 1 || id > tot) {
        puts("ILLEGAL_ERASE_ARGUMENT");
        continue;
      }
      bool find = false;
      for (int i = (1); i <= (m); i += (1))
        if (memory[i] == id) memory[i] = 0, find = true;
      if (!find) puts("ILLEGAL_ERASE_ARGUMENT");
    } else {
      for (int i = 1, j = 1; j <= m; j++) {
        while (memory[i]) i++;
        j = max(j, i + 1);
        if (memory[j]) memory[i] = memory[j], memory[j] = 0;
      }
    }
  }
  return 0;
}
