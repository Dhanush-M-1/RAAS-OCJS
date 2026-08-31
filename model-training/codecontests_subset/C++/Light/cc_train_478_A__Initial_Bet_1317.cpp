#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, a, sum = 0;
  for (i = 0; i < 5; i++) {
    scanf("%d", &a);
    sum += a;
  }
  if (sum % 5 == 0 && sum != 0) {
    printf("%d\n", sum / 5);
  } else
    printf("-1\n");
  return 0;
}
