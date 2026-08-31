#include <bits/stdc++.h>
int main() {
  int d;
  char s[55];
  scanf("%s%d", s, &d);
  for (int i = 0; s[i]; i++)
    if (tolower(s[i]) < d + 97)
      s[i] = toupper(s[i]);
    else
      s[i] = tolower(s[i]);
  puts(s);
  return 0;
}
