#include <bits/stdc++.h>
const long long int INF = 1ll << 60;
using namespace std;
namespace number_theory {
bool prime[15000105];
void sieve(int n) {
  for (long long int i = 0; i <= n; i++) prime[i] = 1;
  for (long long int p = 2; p * p <= n; p++) {
    if (prime[p] == true) {
      for (long long int i = p * p; i <= n; i += p) prime[i] = false;
    }
  }
  prime[1] = prime[0] = 0;
}
vector<long long int> primelist;
bool __primes_generated__ = 0;
void genprimes(int n) {
  __primes_generated__ = 1;
  sieve(n + 1);
  for (long long int i = 2; i <= n; i++)
    if (prime[i]) primelist.push_back(i);
}
vector<long long int> factors(long long int n) {
  if (!__primes_generated__) {
    cerr << "Bruh, Call genprimes" << '\n';
    exit(1);
  }
  vector<long long int> facs;
  for (long long int i = 0;
       primelist[i] * primelist[i] <= n && i < primelist.size(); i++) {
    if (n % primelist[i] == 0) {
      while (n % primelist[i] == 0) {
        n /= primelist[i];
        facs.push_back(primelist[i]);
      }
    }
  }
  if (n > 1) {
    facs.push_back(n);
  }
  return facs;
}
}  // namespace number_theory
using namespace number_theory;
long long int n, m, k, q, l, r, x, y, z;
const long long int template_array_size = 1e6 + 3862;
long long int a[template_array_size];
long long int b[template_array_size];
long long int c[template_array_size];
string s, t;
long long int ans = 0;
long long int bp(long long int a, long long int b) {
  long long int res = 1;
  while (b > 0) {
    if (b & 1) {
      res = (res * a);
      b--;
    }
    a = (a * a);
    b >>= 1;
  }
  return res;
}
long long int ncr(long long int n, long long int k) {
  long long int ans = 1;
  if (k > n - k) k = n - k;
  for (long long int i = 1; i <= k; i++) ans *= (n - i + 1), ans /= i;
  return ans;
}
long long int power(long long int x, long long int y, long long int p) {
  long long int res = 1;
  x = x % p;
  while (y > 0) {
    if (y & 1) res = (res * x) % p;
    y = y >> 1;
    x = (x * x) % p;
  }
  return res;
}
long long int modInverse(long long int n, long long int p) {
  return power(n, p - 2, p);
}
long long int ncrModPFermat(long long int n, long long int r, long long int p) {
  if (r == 0) return 1;
  long long int fac[n + 1];
  fac[0] = 1;
  for (long long int i = 1; i <= n; i++) fac[i] = (fac[i - 1] * i) % p;
  return (fac[n] * modInverse(fac[r], p) % p * modInverse(fac[n - r], p) % p) %
         p;
}
long long int gcd(long long int a, long long int b) {
  return (b == 0) ? a : gcd(b, a % b);
}
bool isprime(long long int x) {
  long long int i = 2;
  bool f = false;
  for (i = 2; i * i <= x; i++) {
    if (x % i == 0) {
      return false;
    }
  }
  return true;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long int n;
  cin >> n;
  if (n == 1) {
    cout << 1 << '\n';
    cout << 0 << '\n';
  } else {
    genprimes(10000000);
    vector<long long int> v = factors(n);
    if (v.size() == 1) {
      cout << 1 << '\n';
      cout << 0 << '\n';
    } else {
      if (v.size() == 2) {
        cout << 2 << '\n';
      } else {
        cout << 1 << '\n';
        ans = v[0] * v[1];
        cout << ans << '\n';
      }
    }
  }
  return 0;
}
