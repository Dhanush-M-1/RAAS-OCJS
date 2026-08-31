#include <bits/stdc++.h>
using namespace std;
int n, i, j, k;
char s[4];
int toBaseN(int x) {
  memset(s, '0', sizeof(s));
  k = 2;
  while (x / n) {
    s[k--] = '0' + x % n;
    x /= n;
  }
  s[k] = '0' + x % n;
  s[3] = '\0';
  return atoi(s);
}
int main() {
  scanf("%d", &n);
  for (i = 1; i < n; ++i) {
    for (j = 1; j < n; ++j) {
      printf("%4d", toBaseN(i * j));
    }
    printf("\n");
  }
  return 0;
}
