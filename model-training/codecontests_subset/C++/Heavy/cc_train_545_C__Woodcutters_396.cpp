#include <bits/stdc++.h>
using namespace std;
long long binpow(long long base, long long exp) {
  long long mod = 1000000007LL;
  long long res = 1;
  while (exp > 0) {
    if (exp % 2 == 1) res = (res * base) % mod;
    exp = exp >> 1;
    base = (base * base) % mod;
  }
  return res;
}
long long mod(long long x) {
  return ((x % 1000000007LL + 1000000007LL) % 1000000007LL);
}
long long add(long long a, long long b) { return mod(mod(a) + mod(b)); }
long long mul(long long a, long long b) { return mod(mod(a) * mod(b)); }
bool isPrime(long long n) {
  if (n <= 1) return false;
  for (long long i = 2; i * i <= n; i++)
    if (n % i == 0) return false;
  return true;
}
const long long N = (long long)1e6;
void sieve(long long N) {
  bool prime[N + 1];
  memset(prime, true, sizeof(prime));
  for (long long p = 2; p * p <= N; p++) {
    if (prime[p] == true) {
      for (long long i = p * p; i <= N; i += p) prime[i] = false;
    }
  }
}
long long fact(long long n) {
  long long res = 1;
  for (long long i = 1; i <= n; i++) {
    res = res * 1ll * i % 1000000007LL;
  }
  return res;
}
long long C(long long n, long long k) {
  return fact(n) * 1ll * binpow(fact(k), 1000000007LL - 2) % 1000000007LL *
         1ll * binpow(fact(n - k), 1000000007LL - 2) % 1000000007LL;
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long n, i, c = 1, prev = INT_MIN;
  cin >> n;
  vector<pair<long long, long long> > v(n);
  for (i = 0; i < n; i++) {
    cin >> v[i].first >> v[i].second;
  }
  for (i = 0; i < n - 1; i++) {
    if (v[i].second < abs(prev - v[i].first)) {
      c++;
      prev = v[i].first;
    } else if (v[i].first + v[i].second < v[i + 1].first) {
      c++;
      prev = v[i].first + v[i].second;
    } else {
      prev = v[i].first;
    }
  }
  cout << c << "\n";
  return 0;
}
