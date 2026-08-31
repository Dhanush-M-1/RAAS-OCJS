#include <bits/stdc++.h>
using namespace std;
const int maxn = 1005;
char ss[maxn];
int n, tt[105];
int main() {
  gets(ss);
  int len = strlen(ss), i, j = 1, p = 1;
  tt[0] = 1;
  for (i = 0; i < len; i++) {
    if (ss[i] == '+') {
      p++;
      tt[j++] = 1;
    } else if (ss[i] == '-') {
      p--;
      tt[j++] = -1;
    } else if (ss[i] == '=') {
      break;
    }
  }
  i += 2;
  for (; i < len; i++) {
    n = n * 10 + (ss[i] - '0');
  }
  for (i = 0; i < j; i++) {
    if (tt[i] > 0) {
      while (p < n && tt[i] < n) {
        tt[i]++;
        p++;
      }
    } else if (tt[i] < 0) {
      while (p > n && tt[i] > -n) {
        tt[i]--;
        p--;
      }
    }
  }
  if (p != n) {
    printf("Impossible\n");
  } else {
    printf("Possible\n");
    for (i = 0, j = 0; i < len; i++) {
      if (ss[i] == '?') {
        printf("%d", abs(tt[j++]));
      } else {
        printf("%c", ss[i]);
      }
    }
    printf("\n");
  }
  return 0;
}
