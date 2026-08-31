#include <bits/stdc++.h>
using namespace std;
long long GCD(long long x, long long y) {
  if (y == 0) return x;
  return GCD(y, x % y);
}
long long LCM(long long x, long long y) { return (x * y) / (GCD(x, y)); }
long long LOGK(long long x, long long k) {
  if (x >= k) return 1 + LOGK(x / k, k);
  return 0;
}
long long MPOW(long long a, long long b, long long m) {
  if (b == 0) return 1;
  long long x = MPOW(a, b / 2, m);
  x = (x * x) % m;
  if (b % 2 == 1) x = (x * a) % m;
  return x;
}
long long MINV(long long a, long long m) { return MPOW(a, m - 2, m); }
class pnc {
  long long FACT_MAX, MODU;
  vector<long long> fact;

 public:
  pnc(long long n, long long m) {
    FACT_MAX = n;
    fact.resize(FACT_MAX);
    MODU = m;
    MFACT_INIT(MODU);
  }
  void MFACT_INIT(long long m) {
    fact[0] = 1;
    for (long long i = 1; i < FACT_MAX; ++i) fact[i] = (i * fact[i - 1]) % MODU;
  }
  long long MFACT(long long n) { return fact[n]; }
  long long PERM(long long n, long long r) {
    return (fact[n] * ::MINV(fact[n - r], MODU)) % MODU;
  }
  long long COMB(long long n, long long r) {
    return (PERM(n, r) * ::MINV(fact[r], MODU)) % MODU;
  }
};
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long test = 1;
  cin >> test;
  while (test--) {
    long long n;
    cin >> n;
    long long ar[n];
    for (long long i = 0; i < n; i++) cin >> ar[i];
    if (ar[0] + ar[1] <= ar[n - 1]) {
      cout << 1 << ' ' << 2 << ' ' << n;
      cout << "\n";
      continue;
    }
    if (ar[n - 1] - ar[n - 2] >= ar[0]) {
      cout << 1 << ' ' << n - 1 << ' ' << n;
      cout << "\n";
      continue;
    }
    cout << -1 << "\n";
  }
}
