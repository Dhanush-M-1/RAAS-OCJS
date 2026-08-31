#include <bits/stdc++.h>
using namespace std;
const long long MX = 100000;
const long long MOD = 1000000007;
const int inf = 222222222;
long long fast_exp(long long base, long long exp, long long mod) {
  long long res = 1;
  while (exp > 0) {
    if (exp % 2 == 1) res = (res * base) % mod;
    base = (base * base) % mod;
    exp /= 2;
  }
  return res;
}
long long temp;
bool isprime(long long q) {
  for (long long i = 2; i * i <= q; i++) {
    if (!(q % i)) {
      temp = i;
      return false;
    }
  }
  return true;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long q;
  cin >> q;
  if (isprime(q)) {
    cout << 1 << "\n" << 0;
    return 0;
  } else {
    long long t = temp;
    if (isprime(q / temp))
      cout << 2 << "\n";
    else
      cout << 1 << "\n" << (t * temp) << "\n";
  }
  return 0;
}
