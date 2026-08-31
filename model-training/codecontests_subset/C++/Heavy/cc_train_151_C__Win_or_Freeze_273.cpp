#include <bits/stdc++.h>
using namespace std;
int const MX = 1e7;
bool is_prime[MX];
int main() {
  long long q;
  cin >> q;
  vector<long long> primes;
  memset(is_prime, 1, sizeof is_prime);
  for (long long i = 2; i * i <= q; i++) {
    if (is_prime[i]) {
      for (long long j = i * i; j < MX; j += i) {
        is_prime[j] = 0;
      }
      if (q % i == 0) primes.emplace_back(i);
      if (primes.size() == 2) break;
    }
  }
  if (primes.size() == 0)
    cout << 1 << '\n' << 0;
  else {
    long long nxt = primes[0] * primes[0];
    if (nxt < q) {
      if (q % nxt == 0)
        cout << 1 << '\n' << nxt;
      else if (primes.size() == 2)
        cout << 1 << '\n' << primes[0] * primes[1];
      else
        cout << 2;
    } else
      cout << 2;
  }
}
