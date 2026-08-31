#include <bits/stdc++.h>
using namespace std;
long long power(long long x, long long y, long long p) {
  long long res = 1;
  x = x % p;
  while (y > 0) {
    if (y & 1) res = (res * x) % p;
    y = y >> 1;
    x = (x * x) % p;
  }
  return res;
}
int main() {
  long long n;
  cin >> n;
  long long ans = 0;
  while (n--) {
    long long temp;
    cin >> temp;
    ans = max(ans, min(temp - 1, 1000000LL - temp));
  }
  cout << ans << endl;
}
