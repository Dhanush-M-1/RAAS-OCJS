#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  while (~scanf("%d%d", &a, &b)) {
    int t = 0;
    while (a != 0) {
      if (a >= b)
        t += b;
      else {
        t += a;
        break;
      }
      a = a - b + 1;
    }
    printf("%d\n", t);
  }
  return 0;
}
