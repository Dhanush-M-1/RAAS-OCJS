#include <bits/stdc++.h>
char c[99];
int n;
int main() {
  scanf("%s%d", c, &n);
  for (int i = 0; c[i]; i++) {
    if (c[i] < 'a') c[i] += 'a' - 'A';
    if (c[i] < 'a' + n) c[i] += 'A' - 'a';
  }
  puts(c);
}
