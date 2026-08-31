#include <bits/stdc++.h>
using namespace std;
int main() {
  int ans, x;
  ans = 0;
  for (int i = 1; i <= 5; i++) {
    scanf("%d", &x);
    ans += x;
  }
  if (ans > 0 && ans % 5 == 0) {
    printf("%d\n", ans / 5);
  } else
    printf("-1\n");
  return 0;
}
