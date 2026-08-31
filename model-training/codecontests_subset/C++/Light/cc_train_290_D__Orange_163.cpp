#include <bits/stdc++.h>
char str[11111];
int N;
int main() {
  scanf("%s%d", str, &N);
  for (char* p = str; *p; ++p) {
    if (*p < 'a') *p += 'a' - 'A';
    if (*p < 97 + N) *p += 'A' - 'a';
  }
  printf("%s\n", str);
}
