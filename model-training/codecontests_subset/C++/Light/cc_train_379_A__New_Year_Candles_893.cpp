#include <bits/stdc++.h>
using namespace std;
const unsigned long long P = 239017, MaxN = 2100000, INF = 1000000000;
int main() {
  int a, b;
  scanf("%d%d", &a, &b);
  int ans = 0;
  int bank = 0;
  while (a) {
    ans += a;
    bank += a;
    a = bank / b;
    bank = bank % b;
  }
  printf("%d", ans);
  return 0;
}
