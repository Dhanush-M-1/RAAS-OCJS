#include <bits/stdc++.h>
using namespace std;
int ans[101000], mark[101000];
char s[101000];
int n, top, now, n_;
int main() {
  do s[++n_] = getchar();
  while (s[n_] != '=');
  scanf("%d", &n);
  mark[1] = 0;
  top = 1;
  for (int i = 3; i < n_; i += 4) mark[++top] = (s[i] == '-');
  now = 0;
  for (int i = 1; i <= top; i++) ans[i] = 1;
  for (int i = 1; i <= top; i++)
    if (mark[i])
      now--;
    else
      now++;
  while (now != n) {
    if (now < n) {
      int q = 0;
      for (int i = 1; i <= top; i++)
        if (!mark[i] && ans[i] < n) {
          q = i;
          break;
        }
      if (!q) {
        printf("Impossible");
        return 0;
      }
      int inc = min(n - ans[q], n - now);
      ans[q] += inc;
      now += inc;
    } else {
      int q = 0;
      for (int i = 1; i <= top; i++)
        if (mark[i] && ans[i] < n) {
          q = i;
          break;
        }
      if (!q) {
        printf("Impossible");
        return 0;
      }
      int inc = min(n - ans[q], now - n);
      ans[q] += inc;
      now -= inc;
    }
  }
  printf("Possible\n");
  printf("%d", ans[1]);
  for (int i = 2; i <= top; i++) {
    putchar(' ');
    if (mark[i])
      putchar('-');
    else
      putchar('+');
    putchar(' ');
    printf("%d", ans[i]);
  }
  printf(" = %d", n);
  return 0;
}
