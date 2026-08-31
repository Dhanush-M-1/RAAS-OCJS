#include <bits/stdc++.h>
using namespace std;
char s[100];
int main() {
  int i, j;
  int n;
  while (scanf("%s", s) != EOF) {
    scanf("%d", &n);
    for (i = 0; i < strlen(s); i++)
      if (s[i] >= 'A' && s[i] <= 'Z') s[i] = s[i] + 'a' - 'A';
    for (i = 0; i < strlen(s); i++)
      if (s[i] < n + 97) {
        if (s[i] >= 'a' && s[i] <= 'z') s[i] = s[i] + 'A' - 'a';
      }
    printf("%s\n", s);
  }
  return 0;
}
