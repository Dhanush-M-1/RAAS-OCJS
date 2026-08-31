#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  scanf("%d", &t);
  while (t--) {
    int a, b, c;
    scanf("%d%d%d", &a, &b, &c);
    int ans = 0;
    while (b >= 1 && c >= 2) {
      ans += 3;
      b--;
      c -= 2;
    }
    while (a >= 1 && b >= 2) {
      ans += 3;
      a--;
      b -= 2;
    }
    printf("%d\n", ans);
  }
  return 0;
}
