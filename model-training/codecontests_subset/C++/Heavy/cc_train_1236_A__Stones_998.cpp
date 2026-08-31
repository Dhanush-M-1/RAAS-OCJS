#include <bits/stdc++.h>
using namespace std;
long long fast_exp(long long base, long long exp) {
  long long res = 1;
  while (exp > 0) {
    if (exp % 2 == 1) res = (res * base) % 1000000007;
    base = (base * base) % 1000000007;
    exp /= 2;
  }
  return res % 1000000007;
}
long long fib(long long n) {
  if (n < 2) return n;
  long long a = 0, b = 1, ans;
  int i = 1;
  while (i < n) {
    ans = (a + b) % 1000000007;
    a = b;
    b = ans;
    i++;
  }
  return ans;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    long long ans = 0;
    if (b < c / 2) {
      ans += 3 * b;
      cout << ans << "\n";
    } else {
      ans += 3 * (c / 2);
      b -= c / 2;
      int add = min(a, b / 2);
      ans += 3 * add;
      cout << ans << "\n";
    }
  }
}
