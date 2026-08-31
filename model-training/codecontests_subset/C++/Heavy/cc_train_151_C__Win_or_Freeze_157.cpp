#include <bits/stdc++.h>
using namespace std;
int sieve[10000007];
void computeSieve(int n) {
  for (int i = 4; i <= n; i += 2) {
    sieve[i] = 1;
  }
  for (int i = 3; i <= n; i += 2) {
    if (sieve[i] == 1) continue;
    for (int j = i + i; j <= n; j += i) {
      sieve[j] = 1;
    }
  }
}
long long n;
long long N;
vector<int> factors;
int main() {
  cin >> n;
  N = n;
  computeSieve(10000001);
  long long root = sqrt(n);
  for (int i = 2; i <= 10000000; i++) {
    while (sieve[i] == 0 && n % i == 0) {
      factors.push_back(i);
      n /= i;
    }
  }
  if (n > 1) factors.push_back(n);
  if (factors.size() <= 1) {
    cout << 1 << '\n';
    cout << 0 << '\n';
  } else if (factors.size() == 2) {
    cout << 2 << '\n';
  } else {
    cout << 1 << '\n';
    long long product = 1;
    for (int i = 0; i < factors.size() - 2; i++) {
      product *= (long long)factors[i];
    }
    N /= product;
    cout << N << '\n';
  }
  return 0;
}
