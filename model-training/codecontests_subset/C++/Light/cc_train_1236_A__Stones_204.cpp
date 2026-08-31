#include <bits/stdc++.h>
using namespace std;
int main() {
  int T;
  scanf("%d", &T);
  while (T--) {
    int a, b, c;
    int ans = 0;
    scanf("%d %d %d", &a, &b, &c);
    int d = min(c / 2, b);
    ans += d * 3;
    b -= d;
    d = min(a, b / 2);
    ans += d * 3;
    printf("%d\n", ans);
  }
  return 0;
}
