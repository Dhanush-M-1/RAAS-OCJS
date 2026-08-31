#include <bits/stdc++.h>
using namespace std;
int main() {
  char s[55], put[55];
  int num, len;
  gets(s);
  scanf("%d", &num);
  len = strlen(s);
  for (int i = 0; i < len; i++) {
    if (s[i] >= 'A' && s[i] <= 'Z') s[i] = s[i] - 'A' + 'a';
  }
  for (int tmp = 0; tmp < len; tmp++) {
    int pp = s[tmp];
    if (pp < num + 'a')
      put[tmp] = s[tmp] - 'a' + 'A';
    else
      put[tmp] = s[tmp];
    printf("%c", put[tmp]);
  }
  printf("\n");
  return 0;
}
