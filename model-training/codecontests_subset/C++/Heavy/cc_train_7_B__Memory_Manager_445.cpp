#include <bits/stdc++.h>
int main() {
  int n, m, id;
  int memory[105];
  while (scanf("%d%d", &n, &m) == 2) {
    memset(memory, 0, sizeof(memory)), id = 1;
    while (n--) {
      char cmd[20];
      scanf("%s", cmd);
      if (cmd[0] == 'a') {
        int size, start, ok;
        scanf("%d", &size);
        start = ok = 0;
        for (int i = 1; i <= m; i++)
          if (memory[i])
            start = i;
          else if (i - start == size) {
            ok = 1;
            break;
          }
        if (ok == 0)
          puts("NULL");
        else {
          for (int i = start + 1; i <= start + size; i++) memory[i] = id;
          printf("%d\n", id);
          id++;
        }
      } else if (cmd[0] == 'e') {
        int temp, ok = 0;
        scanf("%d", &temp);
        for (int i = 1; i <= m; i++)
          if (memory[i] == temp) ok = 1, memory[i] = 0;
        if (ok == 0 || temp <= 0) puts("ILLEGAL_ERASE_ARGUMENT");
      } else {
        int now = 1;
        for (int i = 1; i <= m; i++)
          if (memory[i] > 0) memory[now++] = memory[i];
        for (int i = now; i <= m; i++) memory[i] = 0;
      }
    }
  }
}
