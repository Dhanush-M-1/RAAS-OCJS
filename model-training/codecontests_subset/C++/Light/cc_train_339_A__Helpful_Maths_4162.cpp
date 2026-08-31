#include <bits/stdc++.h>
using namespace std;
char s[105];
int a[105];
int main() {
  gets(s);
  int len = strlen(s);
  s[len] = '+';
  s[len + 1] = '\0';
  int sum = 0, l = 0;
  for (int i = 0; s[i]; i++) {
    if (s[i] == '+')
      a[l++] = sum, sum = 0;
    else
      sum *= 10, sum += s[i] - '0';
  }
  sort(a, a + l);
  for (int i = 0; i < l; i++) {
    printf("%d", a[i]);
    if (i != l - 1) printf("+");
  }
  return 0;
}
