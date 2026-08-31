#include <bits/stdc++.h>
using namespace std;
int T, a, b, c, sum;
int main() {
  scanf("%d", &T);
  while (T--) {
    sum = 0;
    scanf("%d%d%d", &a, &b, &c);
    int num = c / 2;
    if (b >= num) {
      sum += num * 2;
      sum += num;
      b -= num;
      num = b / 2;
      if (a >= num) {
        sum += num * 2;
        sum += num;
      } else {
        sum += a * 2;
        sum += a;
      }
    } else {
      sum += b * 2;
      sum += b;
    }
    printf("%d\n", sum);
  }
  return 0;
}
