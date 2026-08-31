#include <bits/stdc++.h>
int main() {
  char str[100], ans[100];
  int n;
  scanf("%s%d", str, &n);
  for (int i = 0; str[i]; i++) str[i] = tolower(str[i]);
  for (int i = 0; str[i]; i++) {
    char ch = str[i];
    if (ch < n + 97)
      ans[i] = toupper(ch);
    else
      ans[i] = tolower(ch);
  }
  for (int i = 0; str[i]; i++) putchar(ans[i]);
  puts("");
  return 0;
}
