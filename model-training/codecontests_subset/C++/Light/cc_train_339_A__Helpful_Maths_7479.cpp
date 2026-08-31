#include <bits/stdc++.h>
int main() {
  int i, n, j;
  char a, ch[100];
  gets(ch);
  n = strlen(ch);
  if (n == 1) {
    puts(ch);
    return 0;
  }
  for (i = 0; i < n - 1; i += 2) {
    for (j = 0; j < n - i - 1; j += 2) {
      if (ch[j] > ch[j + 2]) {
        a = ch[j + 2];
        ch[j + 2] = ch[j];
        ch[j] = a;
      }
    }
  }
  puts(ch);
}
