#include <bits/stdc++.h>
int main() {
  char s[100];
  int n;
  gets(s);
  scanf("%d", &n);
  for (int i = 0; i < strlen(s); i++) {
    if (s[i] >= 65 && s[i] <= 90) s[i] += 32;
  }
  for (int i = 0; i < strlen(s); i++) {
    if (s[i] < n + 97) s[i] += -32;
  }
  puts(s);
}
