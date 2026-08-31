#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, i, s = 0, d;
  for (i = 1; i <= 5; i++) {
    scanf("%d", &a);
    s = s + a;
  }
  d = s / 5;
  if (s == 0)
    printf("-1");
  else if (s % 5 == 0)
    printf("%d", d);
  else
    printf("-1");
  return 0;
}
