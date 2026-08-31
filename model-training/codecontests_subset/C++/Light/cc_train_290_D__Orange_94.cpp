#include <bits/stdc++.h>
using namespace std;
int main() {
  char c[51];
  int n;
  scanf("%s", c);
  scanf("%d", &n);
  for (int i = 0; i < strlen(c); i++) {
    if (c[i] < 'a') c[i] += 'a' - 'A';
    if (c[i] < 97 + n) c[i] += 'A' - 'a';
  }
  printf("%s", c);
  return 0;
}
