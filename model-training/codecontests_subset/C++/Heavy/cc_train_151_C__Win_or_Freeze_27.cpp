#include <bits/stdc++.h>
using namespace std;
const long long mod = 1000000007;
const long long mxi = 200005;
bool isprime(long long n) {
  for (long long i = 2; i * i <= n; i++) {
    if (n % i == 0) return false;
  }
  return true;
}
bool check(long long n) {
  for (long long i = 2; i * i <= n; i++) {
    if (n % i == 0) {
      return !(isprime(i) && isprime(n / i));
    }
  }
  return true;
}
int main() {
  ios_base::sync_with_stdio(false), cin.tie(NULL);
  ;
  long long n;
  cin >> n;
  if (check(n)) {
    if (isprime(n)) return cout << 1 << "\n" << 0, 0;
    cout << "1\n";
    vector<long long> prime;
    for (long long i = 2; i * i <= n; i++) {
      while (n % i == 0) {
        prime.push_back(i);
        n /= i;
      }
    }
    long long x = prime[0], y = prime[1];
    cout << x * y << '\n';
    return 0;
  }
  cout << 2;
}
