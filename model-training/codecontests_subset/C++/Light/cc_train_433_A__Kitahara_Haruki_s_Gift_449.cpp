#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, j, n, m, a = 0, b = 0;
  scanf("%d", &n);
  for (i = 0; i < n; i++) {
    scanf("%d", &m);
    if (m == 100) {
      a++;
    } else {
      b++;
    }
  }
  if (a == 0) {
    if (b % 2 == 0) {
      printf("YES");
    } else {
      printf("NO");
    }
  } else {
    if (a % 2 == 0) {
      printf("YES");
    } else {
      printf("NO");
    }
  }
  return 0;
}
