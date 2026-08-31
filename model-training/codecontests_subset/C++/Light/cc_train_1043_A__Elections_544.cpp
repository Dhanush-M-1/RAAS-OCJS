#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, i, s = 0, j = 0;
  scanf("%d", &n);
  for (i = 0; i < n; i++) {
    scanf("%d", &a);
    if (a > j) {
      j = a;
    }
    s = s + a;
  }
  s = s * 2;
  s = s + n;
  s = s / n;
  if (s > j)
    printf("%d", s);
  else
    printf("%d", j);
  return 0;
}
