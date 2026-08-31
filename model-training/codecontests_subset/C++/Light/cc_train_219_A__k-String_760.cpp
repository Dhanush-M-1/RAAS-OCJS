#include <bits/stdc++.h>
int main() {
  int n, max = 0, flag = 1;
  char s[1001];
  scanf("%d%s", &n, &s);
  int f[27] = {0};
  for (int i = 0; i < strlen(s); i++) {
    ++f[s[i] - 96];
  }
  for (int i = 1; i < 27; i++) {
    if (f[i] != 0 && f[i] % n != 0) {
      flag = 0;
      break;
    }
  }
  if (flag == 0)
    printf("%d", -1);
  else {
    for (int j = 0; j < n; j++) {
      for (int i = 1; i < 27; i++) {
        if (f[i] > 0) {
          int kkk = f[i] / n;
          for (int k = 0; k < kkk; k++) printf("%c", i + 96);
        }
      }
    }
  }
}
