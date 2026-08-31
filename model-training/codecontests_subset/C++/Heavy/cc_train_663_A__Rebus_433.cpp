#include <bits/stdc++.h>
using namespace std;
int a[110], b[110];
char s[10];
int n, m, cnt, num;
void calc() {
  n = 0;
  int len = strlen(s);
  for (int i = 0; i < len; i++) n = n * 10 + s[i] - '0';
}
int main() {
  int cnt = 1;
  b[1] = 0;
  while (scanf("%s", s) != EOF) {
    if (s[0] == '?')
      cnt++;
    else if (s[0] == '+')
      b[cnt] = 0;
    else if (s[0] == '-')
      b[cnt] = 1, num++;
    else if (s[0] != '=')
      calc();
  }
  cnt--;
  m = n + num;
  if (num == 0 && cnt > m) {
    printf("Impossible\n");
    return 0;
  }
  int av = m / (cnt - num), q = m % (cnt - num), t = 0, Cnt = 0, k = 0;
  if (av == 0) Cnt = cnt - num - q;
  if (Cnt && 1 + (Cnt % num == 0 ? Cnt / num : Cnt / num + 1) > n) {
    printf("Impossible\n");
    return 0;
  }
  for (int i = 1; i <= cnt; i++)
    if (b[i] == 1) {
      if (!Cnt)
        a[i] = 1;
      else if (k < Cnt % num)
        a[i] = 1 + (Cnt % num == 0 ? Cnt / num : Cnt / num + 1), k++;
      else
        a[i] = 1 + Cnt / num;
    } else {
      if (t < q)
        a[i] = av + 1, t++;
      else if (av == 0)
        a[i] = 1;
      else
        a[i] = av;
    }
  for (int i = 1; i <= cnt; i++)
    if (a[i] > n) {
      printf("Impossible\n");
      return 0;
    }
  printf("Possible\n");
  printf("%d", a[1]);
  for (int i = 2; i <= cnt; i++) {
    printf(" ");
    if (b[i] == 0)
      printf("+");
    else
      printf("-");
    printf(" %d", a[i]);
  }
  printf(" = %d\n", n);
  return 0;
}
