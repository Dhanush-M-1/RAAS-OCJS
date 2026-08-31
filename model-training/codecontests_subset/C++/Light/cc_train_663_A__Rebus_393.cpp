#include <bits/stdc++.h>
using namespace std;
char a[1000];
int b[1000];
int main() {
  gets(a);
  int len = strlen(a);
  int cnt = 1;
  int pos;
  int now = 1;
  b[0] = 1;
  for (int i = 0; i < len; i++) {
    if (a[i] == '+') {
      b[cnt++] = 1;
      now++;
    }
    if (a[i] == '-') {
      b[cnt++] = -1;
      now--;
    }
    if (a[i] == '=') {
      pos = i;
      break;
    }
  }
  int n = 0;
  for (int i = pos + 1; i < len; i++)
    if (a[i] <= '9' && a[i] >= '0') n = n * 10 + a[i] - '0';
  for (int i = 0; i < cnt; i++) {
    while (now < n && b[i] < n && b[i] > 0) now++, b[i]++;
    while (now > n && b[i] > -n && b[i] < 0) now--, b[i]--;
  }
  if (now != n) {
    printf("Impossible\n");
    return 0;
  }
  printf("Possible\n");
  int j = 0;
  for (int i = 0; i < len; i++) {
    if (a[i] != '?')
      printf("%c", a[i]);
    else
      printf("%d", abs(b[j++]));
  }
  printf("\n");
  return 0;
}
