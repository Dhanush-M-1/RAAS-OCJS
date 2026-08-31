#include <bits/stdc++.h>
using namespace std;
char s[100];
int main() {
  int i, x, l;
  scanf("%s", s);
  scanf("%d", &x);
  l = strlen(s);
  for (i = 0; i < l; i++)
    if (s[i] < 'a') s[i] = s[i] - 'A' + 'a';
  for (i = 0; i < l; i++)
    if (s[i] < x + 'a') s[i] = s[i] - 'a' + 'A';
  printf("%s\n", s);
}
