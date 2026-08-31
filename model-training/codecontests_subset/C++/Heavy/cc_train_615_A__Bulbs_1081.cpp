#include <bits/stdc++.h>
using namespace std;
long long powmod(long long a, long long b, long long mod) {
  if (b == 0 || a == 1) {
    if (mod == 1)
      return 0;
    else
      return 1;
  }
  if (b % 2 == 0) {
    long long k = powmod(a, b / 2, mod);
    return (k * k) % mod;
  } else {
    long long k = powmod(a, b / 2, mod);
    return ((k * k) % mod * a) % mod;
  }
}
long long gcd(long long a, long long b) {
  if (a == 0) return b;
  if (b == 0) return a;
  if (a > b)
    return gcd(a % b, b);
  else
    return gcd(b % a, a);
}
long long prime(long long p) {
  for (long long i = 2; i * i <= p; i++) {
    if (p % i == 0 && i < p) return i;
  }
  return 1;
}
long long sqr(long long i) { return i * i; }
void solve(long long ppppppppp = 1) {
  long long n, m;
  cin >> n >> m;
  bool used[m];
  for (long long i = 0; i < m; i++) used[i] = false;
  for (long long i = 0; i < n; i++) {
    long long a;
    cin >> a;
    long long m1[a];
    map<long long, long long> mp;
    for (long long j = 0; j < a; j++) {
      cin >> m1[j];
      mp[m1[j]]++;
    }
    for (long long j = 0; j < a; j++) {
      if (mp[m1[j]] % 2 == 1) used[m1[j] - 1] = true;
    }
  }
  for (long long i = 0; i < m; i++)
    if (used[i] == false) {
      cout << "NO";
      return;
    }
  cout << "YES";
  return;
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long tututu;
  tututu = 1;
  for (long long qwerty = 0; qwerty < tututu; qwerty++) solve();
  return 0;
}
