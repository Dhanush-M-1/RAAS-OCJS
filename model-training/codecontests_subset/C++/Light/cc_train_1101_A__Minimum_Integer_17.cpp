#include <bits/stdc++.h>
using namespace std;
long long gcd(long long a, long long b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
int main() {
  int q;
  cin >> q;
  while (q--) {
    long long a, b, c;
    cin >> a >> b >> c;
    long long ans;
    if (b % c == 0)
      ans = b + c;
    else {
      ans = ((b / c) + 1) * c;
    }
    if (c < a && c > 0) ans = min(ans, c);
    cout << ans << "\n";
  }
}
