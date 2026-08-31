#include <bits/stdc++.h>
using namespace std;
char s[100];
int d;
int main() {
  scanf("%s", s);
  scanf("%d", &d);
  for (int i = 0; s[i]; i++) {
    int tmp = s[i];
    if (tmp >= 'a') tmp = tmp - 'a' + 'A';
    if (tmp - 'A' + 'a' < d + 97)
      s[i] = tmp;
    else
      s[i] = tmp - 'A' + 'a';
  }
  puts(s);
  return 0;
}
