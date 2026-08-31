#include <bits/stdc++.h>
using namespace std;
const double pi = acos(-1.0);
const double eps = 1E-7;
char s[105];
int x;
int main() {
  scanf("%s", s);
  scanf("%d", &x);
  int n = strlen(s);
  for (int i = 0; i < n; ++i)
    if ('A' <= s[i] && s[i] <= 'Z') s[i] = 'a' + s[i] - 'A';
  for (int i = 0; i < n; ++i)
    if ((int)s[i] < x + 97) {
      putchar(s[i] - 'a' + 'A');
    } else
      putchar(s[i]);
  return 0;
}
