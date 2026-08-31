#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, sum = 0, max = 0;
  scanf("%d %d", &a, &b);
  for (int i = 0; i < a; ++i) {
    scanf("%d", &c);
    if (i < a) sum = sum - c;
    if (sum > max) {
      max = sum;
    }
    sum = c;
  }
  max = max - b;
  if (max > 0)
    printf("%d\n", max);
  else
    printf("%s\n", "0");
  return 0;
}
