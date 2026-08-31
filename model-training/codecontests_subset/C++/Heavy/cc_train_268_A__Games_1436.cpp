#include <bits/stdc++.h>
using namespace std;
long long gcd(long long a, long long b) {
  if (b > a) return gcd(b, a);
  if (a % b == 0) return b;
  return gcd(b, a % b);
}
void sieve() {
  int primes[10];
  memset(primes, true, sizeof(primes));
  primes[0] = false;
  primes[1] = false;
  for (int i = 2; i <= 10000; i++) {
    if (primes[i] == 1) {
      for (int j = i * i; j <= 10000; j += i) primes[j] = false;
    }
  }
}
long long power(long long x, long long y, long long p) {
  long long res = 1;
  x = x % p;
  while (y > 0) {
    if (y & 1) res = (res * x) % p;
    y = y >> 1;
    x = (x * x) % p;
  }
  return res;
}
long long modInverse(long long n, long long p) { return power(n, p - 2, p); }
long long nCrModP(long long n, long long r, long long p) {
  if (n < r) return 0;
  if (r == 0) return 1;
  long long fac[n + 1];
  fac[0] = 1;
  for (int i = 1; i <= n; i++) fac[i] = (fac[i - 1] * i) % p;
  return (fac[n] * modInverse(fac[r], p) % p * modInverse(fac[n - r], p) % p) %
         p;
}
void solve(vector<pair<int, int> >::iterator start,
           vector<pair<int, int> >::iterator end, int &count);
long long modFact(long long n, long long p) {
  if (n >= p) return 0;
  long long result = 1;
  for (long long i = 1; i <= n; i++) result = (result * i) % p;
  return result;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long t;
  t = 1;
  for (int loop = 0; loop < (int)(t); ++loop) {
    long long n;
    cin >> n;
    vector<pair<int, int> > arr(n);
    for (int i = 0; i < (int)(n); ++i) {
      cin >> arr[i].first >> arr[i].second;
    }
    int count = 0;
    for (int i = 0; i < (int)(n); ++i) {
      for (int j = 0; j < n; j++) {
        if (i != j)
          if (arr[i].first == arr[j].second) count++;
      }
    }
    cout << count;
  }
  return 0;
}
