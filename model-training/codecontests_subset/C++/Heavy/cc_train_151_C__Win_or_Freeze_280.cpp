#include <bits/stdc++.h>
using namespace std;
vector<int> primes;
void prime(long long n) {
  primes.push_back(2);
  long long k = 3;
  while (k * k <= n) {
    bool is_prime = true;
    for (int i = 0; i < primes.size() && primes[i] * primes[i] <= k && is_prime;
         i++)
      if (k % primes[i] == 0) is_prime = false;
    if (is_prime) primes.push_back(k);
    k += 2;
  }
}
int main() {
  long long int q, t;
  cin >> q;
  t = q;
  prime(q);
  vector<int> factors;
  for (int i = 0; i < primes.size() && q > 1; i++) {
    while (q % primes[i] == 0) {
      factors.push_back(primes[i]);
      q /= primes[i];
    }
  }
  if (q > 1) factors.push_back(q);
  if (factors.size() <= 1)
    cout << "1\n0" << endl;
  else if (factors.size() == 2)
    cout << "2" << endl;
  else
    cout << "1\n" << factors[0] * factors[1] << endl;
  return 0;
}
