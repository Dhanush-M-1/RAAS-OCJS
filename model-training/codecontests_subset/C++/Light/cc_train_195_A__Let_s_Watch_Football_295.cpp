#include <bits/stdc++.h>
int a, b, c;
int main() {
  scanf("%d %d %d", &a, &b, &c);
  int answer;
  for (answer = 0;; answer++) {
    if (b * (answer + c) >= a * c) break;
  }
  printf("%d\n", answer);
  return 0;
}
