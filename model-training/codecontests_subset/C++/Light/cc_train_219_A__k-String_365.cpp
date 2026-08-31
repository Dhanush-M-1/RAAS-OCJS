#include <bits/stdc++.h>
int main() {
  int k, i, j, len, count[30] = {0};
  char str[1005];
  scanf("%d", &k);
  getchar();
  gets(str);
  len = strlen(str);
  if (k == 1)
    puts(str);
  else if (len % k)
    puts("-1");
  else {
    for (i = 0; i < len; i++) count[(str[i] - 97)]++;
    for (i = 0; i < 26; i++) {
      if (count[i] && (count[i] % k)) {
        puts("-1");
        return 0;
      }
    }
    for (j = 0; j < k; j++) {
      for (i = 0; i < 26; i++) {
        int rep = count[i] / k;
        while (rep--) putchar(i + 97);
      }
    }
    putchar('\n');
  }
  return 0;
}
