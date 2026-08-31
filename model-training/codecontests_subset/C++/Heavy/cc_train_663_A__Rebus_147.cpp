#include <bits/stdc++.h>
using namespace std;
char s[1000000];
int ss[200];
int main() {
  int i, jia = 1, jian = 0, n = 0, k, left, t, j;
  gets(s);
  k = strlen(s);
  for (i = 0; i < k; i++) {
    if (s[i] == '+') jia++;
    if (s[i] == '-') jian++;
    if (s[i] >= '0' && s[i] <= '9') n = s[i] - '0' + n * 10;
  }
  for (i = 0; i < jia; ++i) {
    ss[i] = n;
  }
  for (i = 0; i < jian; ++i) {
    ss[i + jia] = 1;
  }
  if (n * jia - jian < n || jia - n * jian > n)
    printf("Impossible\n");
  else {
    printf("Possible\n");
    left = n * jia - jian - n;
    for (i = 0; i < jia; i++) {
      if (left == 0) break;
      if (left > n - 1) {
        ss[i] = 1;
        left -= n - 1;
      } else {
        ss[i] = n - left;
        left = 0;
      }
    }
    for (i = 0; i < jian; i++) {
      if (left == 0) break;
      if (left > n - 1) {
        ss[i + jia] = n;
        left -= n - 1;
      } else {
        ss[i + jia] = left + 1;
        left = 0;
      }
    }
    t = 0;
    j = jia;
    printf("%d", ss[t++]);
    for (i = 0; i < k; i++) {
      if (s[i] == '+') {
        printf(" + %d", ss[t++]);
      }
      if (s[i] == '-') printf(" - %d", ss[j++]);
      if (s[i] == '=') {
        printf(" = %d\n", n);
        break;
      }
    }
  }
  return 0;
}
