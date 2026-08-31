#include <bits/stdc++.h>
using namespace std;
int n, a, b, c;
int main() {
  scanf("%d%d%d%d", &n, &a, &b, &c);
  long long int ans = 0;
  for (int i = 0; i <= c; i++) {
    int rem = n - i * 2;
    if (rem < 0) break;
    if (rem > b + a / 2) continue;
    int lo = max(0, rem - a / 2);
    int hi = min(b, rem);
    ans += max(0, hi - lo + 1);
  }
  printf("%I64d\n", ans);
  return 0;
}
