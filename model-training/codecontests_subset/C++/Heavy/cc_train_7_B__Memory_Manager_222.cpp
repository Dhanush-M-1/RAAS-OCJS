#include <bits/stdc++.h>
int main() {
  int t, m;
  int mem[105] = {};
  char s[105];
  int x;
  int c = 1;
  scanf("%d%d", &t, &m);
  while (t--) {
    scanf("%s %d", s, &x);
    if (strcmp(s, "alloc") == 0) {
      if (0) printf("%s is alloc\n", s);
      int i = 0;
      while (i + x - 1 < m) {
        int flag = 0;
        for (int j = i; j < i + x; j++) {
          if (mem[j] != 0) {
            flag = 1;
            break;
          }
        }
        if (flag == 0) {
          break;
        }
        i++;
      }
      if (i + x - 1 >= m) {
        printf("NULL\n");
      } else {
        for (int j = i; j < i + x; j++) {
          mem[j] = c;
        }
        printf("%d\n", c);
        c++;
      }
    } else if (strcmp(s, "erase") == 0) {
      if (0) printf("%s is erase\n", s);
      int flag = 0;
      for (int i = 0; i < m; i++) {
        if (mem[i] == x) {
          flag = 1;
          mem[i] = 0;
        }
      }
      if (!flag || x == 0) {
        printf("ILLEGAL_ERASE_ARGUMENT\n");
      }
    } else {
      if (0) printf("%s is defragment\n", s);
      int i = 0;
      int j = 0;
      while (i < m) {
        while (i < m && (mem[i] == -1 || mem[i] == 0)) {
          i++;
        }
        while (i < m && (mem[i] != -1 && mem[i] != 0)) {
          mem[j] = mem[i];
          if (j != i) mem[i] = 0;
          j++;
          i++;
        }
      }
    }
    if (0) {
      for (int i = 0; i < m; i++) {
        printf("%d ", mem[i]);
      }
      printf("\n");
    }
  }
  return 0;
}
