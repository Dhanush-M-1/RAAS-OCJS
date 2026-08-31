#include <bits/stdc++.h>
using namespace std;
long long q;
char prime[4000000 + 1000];
int input() {
  cin >> q;
  return 0;
}
int sieve(long long n) {
  for (long long i = 1; i < n; i++) prime[i] = 1;
  prime[1] = 0;
  for (long long i = 2; i * i <= n; i++) {
    if (!prime[i]) continue;
    for (long long j = i * 2; j < n; j += i) prime[j] = 0;
  }
  return 0;
}
bool isPrime(long long n) {
  if (n == 1) return false;
  if (n < 4000000) return prime[n];
  for (long long i = 2; i * i <= n; i++) {
    if (prime[i] && n % i == 0) return false;
  }
  return true;
}
int factor(long long n, long long &a, long long &b) {
  a = 1;
  b = n;
  for (long long i = 2; i * i <= n; i++) {
    if (prime[i] && n % i == 0) {
      a = i;
      b = n / i;
      break;
    }
  }
  return 0;
}
int solve() {
  sieve(4000000);
  if (q == 1 || isPrime(q)) {
    cout << 1 << endl << 0 << endl;
  } else {
    long long p1, p2;
    factor(q, p1, p2);
    if (isPrime(p2)) {
      cout << 2 << endl;
    } else {
      long long p3, p4;
      factor(p2, p3, p4);
      cout << 1 << endl << p1 * p3 << endl;
    }
  }
  return 0;
}
int main() {
  input();
  solve();
  return 0;
}
