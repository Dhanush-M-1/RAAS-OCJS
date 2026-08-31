#include <bits/stdc++.h>
using namespace std;
const double pi = acos(-1.);
const double eps = 1e-15;
const int MOD = 1e9 + 7;
long long power(long long x, long long y) {
  if (y == 0) return 1;
  long long s = power(x, y / 2);
  s %= MOD;
  if (y & 1) s *= x;
  return s;
}
long long Ceil(long long x, long long y) { return (x + y - 1) / y; }
long long gcd(long long a, long long b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
bool isprime(int n) {
  for (int i = 2; i * i <= n; i++)
    if (n % i == 0) return 0;
  return 1;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  vector<pair<int, int> > a(n);
  for (int i = 0; i < n; i++) {
    int x, h;
    cin >> x >> h;
    a[i] = {x, h};
  }
  int res = min(2, n);
  int occupied = 0;
  for (int i = 1; i < n - 1; i++) {
    int x = a[i].first, h = a[i].second;
    int diff = x - a[i - 1].first;
    if (h < diff - occupied)
      res++, occupied = 0;
    else if (h < a[i + 1].first - x)
      res++, occupied = h;
    else
      occupied = 0;
  }
  cout << res;
}
