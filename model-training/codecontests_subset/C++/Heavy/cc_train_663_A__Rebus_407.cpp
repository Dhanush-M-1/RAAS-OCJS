#include <bits/stdc++.h>
using namespace std;
int main() {
  int cnt = 0, num1 = 0, num2 = 0;
  char s[5], ss[105];
  while (~scanf("%s", s)) {
    if (s[0] == '=')
      break;
    else if (s[0] == '+') {
      num1++;
      ss[cnt++] = s[0];
    } else if (s[0] == '-') {
      num2++;
      ss[cnt++] = s[0];
    }
  }
  num1++;
  int n;
  scanf("%d", &n);
  int ans[105] = {0}, sum[105] = {0};
  if (n >= num1 - num2 * n && n <= num1 * n - num2) {
    printf("Possible\n");
    if (num1 - num2 > n) {
      int tot = (num1 - n) / num2;
      for (int i = 0; i < num1; i++) ans[i] = 1;
      for (int i = 0; i < num2; i++) {
        if (i < (num1 - n) % num2)
          sum[i] = tot + 1;
        else
          sum[i] = tot;
      }
    } else {
      int tot = (num2 + n) / num1;
      for (int i = 0; i < num2; i++) sum[i] = 1;
      for (int i = 0; i < num1; i++) {
        if (i < (num2 + n) % num1)
          ans[i] = tot + 1;
        else
          ans[i] = tot;
      }
    }
    printf("%d ", ans[0]);
    int c1 = 1, c2 = 0;
    for (int i = 0; i < cnt; i++) {
      printf("%c ", ss[i]);
      if (ss[i] == '+')
        printf("%d ", ans[c1++]);
      else
        printf("%d ", sum[c2++]);
    }
    printf("= %d\n", n);
  } else {
    printf("Impossible\n");
  }
  return 0;
}
