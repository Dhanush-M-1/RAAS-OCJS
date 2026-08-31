#include <bits/stdc++.h>
using namespace std;
const long long OO = (long long)1e9 + 7;
using namespace std;
long long inv(long long a, long long b) {
  return 1 < a ? b - inv(b % a, a) * b / a : 1;
}
long long Pow(long long B, long long P) {
  long long R = 1;
  while (P > 0) {
    if (P & 1) R = (R * B);
    P /= 2;
    B = (B * B);
  }
  return R;
}
long long GCD(long long a, long long b) {
  while (b) {
    b ^= a ^= b ^= a %= b;
  }
  return a;
}
long long LCM(long long a, long long b) { return (a / GCD(a, b) * b); }
long long BigMod(long long B, long long P, long long M) {
  long long R = 1;
  while (P > 0) {
    if (P & 1) {
      R = (R * B) % M;
    }
    P /= 2;
    B = (B * B) % M;
  }
  return (long long)R;
}
vector<long long> primes;
void factorization(long long n) {
  for (long long i = 2; i * i <= n; ++i)
    while (n % i == 0) primes.push_back(i), n /= i;
  if (n > 1) primes.push_back(n);
}
int main() {
  ios::sync_with_stdio(0);
  long long n;
  cin >> n;
  factorization(n);
  if (primes.size() == 2) {
    cout << 2;
  } else {
    if (n == 1 || primes.size() == 1) {
      cout << "1\n0";
    } else {
      cout << 1 << endl;
      cout << primes[0] * primes[1];
    }
  }
  return 0;
}
