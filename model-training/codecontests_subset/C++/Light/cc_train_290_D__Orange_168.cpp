#include <bits/stdc++.h>
char s[100];
int n;
int main() {
  scanf(" %s %d", s, &n);
  int x = strlen(s);
  for (int i = 0; i < x; i++) s[i] = tolower(s[i]);
  for (int i = 0; i < x; i++) {
    if (s[i] < 97 + n)
      s[i] = toupper(s[i]);
    else
      s[i] = tolower(s[i]);
  }
  printf("%s\n", s);
  return 0;
}
