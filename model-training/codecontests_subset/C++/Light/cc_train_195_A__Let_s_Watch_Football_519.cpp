#include <bits/stdc++.h>
using namespace std;
long gcd(long a, long b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
int main() {
  long long i, a, b, c, l, r, mid;
  cin >> a >> b >> c;
  l = 0;
  r = 10000000;
  while (l < r) {
    mid = l + (r - l) / 2;
    if (mid * b + c * b >= c * a)
      r = mid;
    else
      l = mid + 1;
  }
  cout << l << endl;
  return 0;
}
