#include <bits/stdc++.h>
using namespace std;
int main(void) {
  int num, a, b, c;
  scanf("%d%d%d%d", &num, &a, &b, &c);
  int ans = 0;
  for (int i = 0; i <= c; i++) {
    if (i * 2 > num) break;
    for (int j = 0; j <= b; j++) {
      int sum = i * 2 + j * 1;
      int rest = num - sum;
      if (rest >= 0 && rest * 2 <= a) ans++;
    }
  }
  printf("%d\n", ans);
  return 0;
}
