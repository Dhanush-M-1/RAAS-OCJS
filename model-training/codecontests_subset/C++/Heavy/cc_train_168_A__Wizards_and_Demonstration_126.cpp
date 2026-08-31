#include <bits/stdc++.h>
using namespace std;
void c_p_c() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
}
bool prime(long long c) {
  for (long long i = 2; i * i <= c; i++) {
    if (c % i == 0) return 0;
  }
  return 1;
}
vector<long long> sievePrime(long long *p, long long n) {
  p[0] = p[1] = 0;
  p[2] = 1;
  for (long long i = 3; i <= n; i += 2) p[i] = 1;
  for (long long i = 3; i <= n; i += 2) {
    if (p[i]) {
      for (long long j = i * i; j <= n; j += 2) {
        p[j] = 0;
      }
    }
  }
  vector<long long> prime;
  prime.push_back(2);
  for (long long i = 3; i <= n; i += 2)
    if (p[i]) prime.push_back(i);
  return prime;
}
long long gcd(long long a, long long b) {
  if (b == 0)
    return a;
  else
    return (gcd(b, a % b));
}
int32_t main() {
  c_p_c();
  double n, x, y;
  cin >> n >> x >> y;
  long long k = ceil((y / 100) * n);
  if (k <= x)
    cout << 0;
  else
    cout << k - x;
}
