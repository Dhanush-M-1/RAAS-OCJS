#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e9;
long long gcd(long long a, long long b) { return (a ? gcd(b % a, a) : b); }
long long power(long long a, long long n) {
  long long p = 1;
  while (n > 0) {
    if (n % 2) {
      p = p * a;
    }
    n >>= 1;
    a *= a;
  }
  return p;
}
int main() {
  ios_base::sync_with_stdio(false);
  long long n, a, b, c, ans = 0, k;
  cin >> n >> a >> b >> c;
  for (int i = 0; i <= a; i += 2) {
    for (int j = 0; j <= b; j++) {
      ans += ((n - i / 2 - j) % 2 == 0 && (n - i / 2 - j) >= 0 &&
              (n - i / 2 - j) / 2 <= c);
    }
  }
  cout << ans;
  return 0;
}
