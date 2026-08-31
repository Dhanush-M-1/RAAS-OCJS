#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, cnt = 0;
  scanf("%d%d", &a, &b);
  cnt += a;
  while (a >= b) {
    cnt += a / b;
    a = a / b + a % b;
  }
  printf("%d", cnt);
  return 0;
}
