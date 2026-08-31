#include <bits/stdc++.h>
using namespace std;
vector<long long> factorization(long long n) {
  vector<long long> first_primes;
  if (n == 1) return first_primes;
  for (long long i = 2; i * i <= n && first_primes.size() <= 3; i++) {
    while (n % i == 0) first_primes.push_back(i), n /= i;
  }
  if (n > 1) first_primes.push_back(n);
  return first_primes;
}
int main() {
  ios::sync_with_stdio(false), cin.tie(0);
  long long n;
  cin >> n;
  vector<long long> first_primes = factorization(n);
  if (first_primes.size() <= 1)
    cout << "1\n0\n";
  else if (first_primes.size() == 2)
    cout << "2\n";
  else
    cout << "1\n" << first_primes[0] * first_primes[1] << "\n";
  return 0;
}
