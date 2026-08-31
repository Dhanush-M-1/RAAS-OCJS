#include <bits/stdc++.h>
using namespace std;
long long int power(long long int x, long long int y) {
  if (y == 0)
    return 1;
  else {
    long long int p = power(x, y / 2);
    if (y % 2 == 0)
      return (p * p) % 1000000007LL;
    else
      return (x * ((p * p) % 1000000007LL)) % 1000000007LL;
  }
}
long long int gcd(long long int x, long long int y) {
  if (y == 0)
    return x;
  else
    return gcd(y, x % y);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.precision(20);
  long long int n;
  cin >> n;
  long long int a[n];
  for (int i = 0; i < n; i++) cin >> a[i];
  long long int m = a[n - 1] - 1;
  m = min(m, 1000000 - a[0]);
  for (int i = 0; i < n - 1; i++) {
    long long int x = a[i] - 1;
    long long int y = 1000000 - a[i + 1];
    m = min(m, max(x, y));
  }
  cout << m;
}
