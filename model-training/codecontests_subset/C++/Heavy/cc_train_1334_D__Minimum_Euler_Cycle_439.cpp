#include <bits/stdc++.h>
using namespace std;
const int MOD = 1e9 + 7, MAX = 1e5 + 5;
long long powN(long long a, long long p) {
  if (p == 0) return 1;
  long long z = powN(a, p / 2);
  z = (z * z) % MOD;
  if (p % 2) z = (z * a) % MOD;
  return z;
}
vector<bool> is_prime(MAX + 1, true);
void Sieve() {
  is_prime[0] = is_prime[1] = false;
  int i, j;
  for (i = 2; i * i <= MAX; i++) {
    if (is_prime[i]) {
      for (j = i * i; j <= MAX; j += i) {
        is_prime[j] = false;
      }
    }
  }
}
int main() {
  int t;
  cin >> t;
  while (t--) {
    long long n;
    long long l, r;
    cin >> n >> l >> r;
    long long st = n - 1;
    for (long long k = 1; k <= n; k++) {
      if ((n * 2 - k - 1) * k >= l) {
        st = k - 1;
        break;
      }
    }
    long long ex = (2 * n - st - 1) * (st);
    l -= ex;
    r -= ex;
    st++;
    vector<int> V = {0};
    long long some = st + 1;
    long long tot = 0;
    for (int i = 1; i <= r; i++) {
      if (st == n) {
        V.push_back(1);
        break;
      }
      if (i % 2)
        V.push_back(st);
      else {
        V.push_back(some);
        some++;
      }
      if (i == tot + 2 * (n - st)) {
        tot += 2 * (n - st);
        st++;
        some = st + 1;
      }
    }
    for (int i = l; i <= r; i++) {
      printf("%d ", V[i]);
    }
    cout << endl;
  }
}
