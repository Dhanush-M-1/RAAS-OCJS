#include <bits/stdc++.h>
using namespace std;
int a, b, c;
bool ok(int m) {
  for (int i = 0; i <= c; i++) {
    if ((m + i) * b < i * a) return false;
  }
  return true;
}
int minWait() {
  int lo = 0, hi = a * c, mid;
  while (lo < hi) {
    mid = lo + (hi - lo) / 2;
    if (ok(mid))
      hi = mid;
    else
      lo = mid + 1;
  }
  return lo;
}
int main() {
  scanf("%d %d %d", &a, &b, &c);
  cout << minWait();
  return 0;
}
