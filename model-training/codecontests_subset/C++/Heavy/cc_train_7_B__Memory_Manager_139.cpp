#include <bits/stdc++.h>
int main() {
  int n;
  int m;
  char op[20];
  int mem[1000];
  int r;
  int i;
  int j;
  int k;
  int num;
  int flag;
  int count;
  while (scanf("%d%d", &n, &m) != EOF) {
    num = 1;
    memset(mem, 0, sizeof(mem));
    while (n--) {
      scanf("%s", op);
      if (op[0] != 'd') {
        scanf("%d", &r);
      }
      if (op[0] == 'a') {
        k = 0;
        while (mem[k] != 0) {
          k++;
        }
        count = 0;
        flag = 0;
        for (i = k; i < m; i++) {
          if (mem[i] != 0) {
            if (count >= r) {
              k = i - count + 1;
              flag = 1;
              break;
            }
            count = 0;
          } else {
            count++;
          }
          if (count >= r) {
            k = i - count + 1;
            flag = 1;
            break;
          }
        }
        if (flag == 1) {
          for (i = k; i < k + r; i++) {
            mem[i] = num;
          }
          printf("%d\n", num);
          num++;
        } else {
          printf("NULL\n");
        }
      } else if (op[0] == 'e') {
        flag = 0;
        for (i = 0; i < m; i++) {
          if (mem[i] == r) {
            mem[i] = 0;
            flag = 1;
          }
        }
        if (flag != 1 || r == 0) {
          printf("ILLEGAL_ERASE_ARGUMENT\n");
        }
      } else if (op[0] == 'd') {
        k = 0;
        while (mem[k]) {
          k++;
        }
        j = k;
        for (i = k; i < m; i++) {
          if (mem[i] != 0) {
            mem[j] = mem[i];
            mem[i] = 0;
            j++;
          }
        }
      }
    }
  }
  return 0;
}
