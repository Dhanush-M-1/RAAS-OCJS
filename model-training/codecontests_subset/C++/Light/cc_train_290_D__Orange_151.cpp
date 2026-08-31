#include <bits/stdc++.h>
using namespace std;
char str[55];
int len, num;
int main() {
  while (scanf("%s%d", str, &num) != EOF) {
    len = strlen(str);
    char ans[55];
    for (int i = 0; i < len; i++) {
      int x = str[i];
      if (x >= 'a')
        x -= 'a';
      else
        x -= 'A';
      x += 'a';
      if (x < 97 + num)
        ans[i] = x - 'a' + 'A';
      else
        ans[i] = x - 'a' + 'a';
    }
    ans[len] = '\0';
    printf("%s\n", ans);
  }
  return 0;
}
