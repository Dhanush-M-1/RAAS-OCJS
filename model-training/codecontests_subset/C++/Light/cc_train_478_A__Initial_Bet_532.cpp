#include <bits/stdc++.h>
int cmp(const int *a, const int *b) {
  if (*a > *b) return 1;
  if (*a < *b) return -1;
  return 0;
}
int gcd(int a, int b) {
  int t = a % b;
  while (t) {
    a = b;
    b = t;
    t = a % b;
  }
  return b;
}
int main() {
  int i, j, t = 0;
  for (i = 0; i < 5; ++i) {
    scanf("%d", &j);
    t += j;
  }
  if (t % 5 == 0 && t >= 5)
    printf("%d\n", t / 5);
  else
    puts("-1");
  return 0;
}
