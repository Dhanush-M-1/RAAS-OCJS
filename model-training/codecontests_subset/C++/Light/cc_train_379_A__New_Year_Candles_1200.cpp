#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, sum = 0, leave = 0;
  scanf("%d %d", &a, &b);
  while (a) {
    sum += a;
    leave += a;
    a = leave / b;
    leave %= b;
  }
  printf("%d\n", sum);
  return 0;
}
