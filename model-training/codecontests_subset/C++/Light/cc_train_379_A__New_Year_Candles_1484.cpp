#include <bits/stdc++.h>
using namespace std;
long long fpow(long long x, long long y, long long p = 1000000007) {
  long long res = 1;
  x = x % p;
  while (y > 0) {
    if (y & 1) {
      y--;
      res *= x;
      res = res % p;
    }
    x = x * x;
    x = x % p;
    y >>= 1;
  }
  return res;
}
int main() {
  ios::sync_with_stdio(0);
  long long n, m;
  cin >> n >> m;
  long long ans = n;
  while (1) {
    if (n >= m) {
      n -= m;
      n += 1;
      ans++;
    } else
      break;
  }
  cout << ans << "\n";
}
