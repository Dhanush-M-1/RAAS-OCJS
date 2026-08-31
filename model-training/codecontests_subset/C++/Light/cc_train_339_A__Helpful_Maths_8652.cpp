#include <bits/stdc++.h>
int main() {
  char st[100];
  int len = 0, i, j, temp = 0;
  scanf("%s", st);
  len = strlen(st);
  for (i = 0; i < len; i += 2) {
    for (j = 0; j < len - 1; j += 2) {
      if (st[j] > st[j + 2]) {
        temp = st[j];
        st[j] = st[j + 2];
        st[j + 2] = temp;
      }
    }
  }
  printf("%s", st);
  return 0;
}
