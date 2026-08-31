#include <bits/stdc++.h>
using namespace std;
int a, b, c;
bool cheak(long long x) {
  if (x * b + b * c >= c * a) return true;
  return false;
}
int main() {
  scanf("%d%d%d", &a, &b, &c);
  long long l = 0, r = 1e9, ans = 1e7;
  while (l <= r) {
    if (cheak((l + r) / 2)) {
      ans = min(ans, (l + r) / 2);
      r = (l + r) / 2 - 1;
    } else
      l = (l + r) / 2 + 1;
  }
  printf("%d", ans);
  return 0;
}
