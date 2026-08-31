#include <bits/stdc++.h>
int main() {
  int a, i, count = 0, k;
  scanf("%d", &a);
  char b[a];
  scanf("%s", &b);
  for (i = 0; i < a; i++) {
    if (b[i] == '8') {
      count++;
    }
  }
  k = a / 11;
  if (count < k) {
    k = count;
  }
  printf("%d", k);
}
