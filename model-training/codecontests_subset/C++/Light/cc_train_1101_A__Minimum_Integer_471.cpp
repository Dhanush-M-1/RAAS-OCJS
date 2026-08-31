#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  scanf("%d", &t);
  while (t--) {
    int a, b, d;
    scanf("%d%d%d", &a, &b, &d);
    if (d < a)
      printf("%d\n", d);
    else {
      printf("%d\n", b + d - b % d);
    }
  }
  return 0;
}
