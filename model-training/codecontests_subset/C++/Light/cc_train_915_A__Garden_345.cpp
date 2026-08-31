#include <bits/stdc++.h>
int main() {
  int a, b;
  int length, max = 0, ans;
  scanf("%d%d", &a, &b);
  for (int i = 0; i < a; i++) {
    scanf("%d", &length);
    if (b % length == 0 && length > max) max = length;
  }
  printf("%d\n", b / max);
}
