#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  cin >> n;
  vector<long long> primes;
  if (n == 1) {
    cout << 1 << endl << 0;
    return 0;
  }
  while (n % 2 == 0) {
    primes.push_back(2);
    n = n / 2;
  }
  for (int i = 3; i <= sqrt(n); i += 2) {
    while (n % i == 0) {
      primes.push_back(i);
      n = n / i;
    }
  }
  if (n > 2) primes.push_back(n);
  if (primes.size() == 1) {
    cout << 1 << endl << 0;
  } else {
    if (primes.size() == 2) {
      cout << 2 << endl;
    } else {
      cout << 1 << endl << primes[0] * primes[1] << endl;
    }
  }
  return 0;
}
