#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, a, b, c;
  scanf("%d", &t);
  while (t--) {
    scanf("%d%d%d", &a, &b, &c);
    int d = 0;
    while (b >= 1 && c >= 2) {
      b -= 1;
      c -= 2;
      d += 3;
    }
    while (a >= 1 && b >= 2) {
      a -= 1;
      b -= 2;
      d += 3;
    }
    printf("%d\n", d);
  }
  return 0;
}
