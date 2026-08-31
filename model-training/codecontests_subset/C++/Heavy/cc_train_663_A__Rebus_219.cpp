#include <bits/stdc++.h>
using namespace std;
const long long inf = (1ll << 62) - 1;
const long long mod = 1e9 + 7;
const long long N = 2e6 + 10;
const long double pi = 3.14159265358979323846;
long long bPow(long long a, long long b) {
  long long res = 1;
  while (b) {
    if (b & 1) {
      res = (res * a) % mod;
    }
    b >>= 1;
    a = (a * a) % mod;
  }
  return res % mod;
}
long long gcd(long long a, long long b) {
  if (a < b) swap(a, b);
  if (b == 0) return a;
  return gcd(b, a % b);
}
vector<long long> fact(N, 0ll);
void factorial() {
  fact[0] = 1, fact[1] = 1;
  for (long long i = 2; i < N; i++) {
    fact[i] = (fact[i - 1] * i) % mod;
  }
}
long long ncr(long long n, long long r) {
  if (r > n) return 0;
  long long ans = fact[n] % mod;
  ans *= bPow(fact[r], mod - 2) % mod;
  ans %= mod;
  ans *= bPow(fact[n - r], mod - 2) % mod;
  ans %= mod;
  return ans;
}
vector<long long> primes(N, -1);
void sieve() {
  iota(primes.begin(), primes.end(), 0);
  for (long long i = 2; i * i <= N; ++i) {
    if (primes[i] == i) {
      for (long long j = 2 * i; j < N; j += i) {
        primes[j] = i;
      }
    }
  }
}
void solve() {
  string nn;
  long long ctAdd = 0, ctNeg = 0;
  string seq;
  while (true) {
    string s;
    cin >> s;
    if (s == " " or s == "=" or s == "?") continue;
    if (s == "+") {
      seq += '+';
      ctAdd++;
    } else if (s == "-") {
      seq += '-';
      ctNeg++;
    } else {
      nn = s;
      break;
    }
  }
  long long n = 0, pow = 1;
  reverse(nn.begin(), nn.end());
  for (char c : nn) {
    long long temp = c - '0';
    n += temp * pow;
    pow *= 10;
  }
  reverse(nn.begin(), nn.end());
  vector<long long> add, neg;
  ctAdd++;
  long long diff = ctAdd - ctNeg;
  for (long long i = 0; i < ctAdd; ++i) {
    add.push_back(1);
  }
  for (long long i = 0; i < ctNeg; ++i) {
    neg.push_back(1);
  }
  if (diff < n) {
    for (long long i = 0; i < ctAdd and diff != n; ++i) {
      long long cur = min(n - diff, n - 1);
      add[i] += cur;
      diff += cur;
    }
  }
  if (diff > n) {
    for (long long i = 0; i < ctNeg and diff != n; ++i) {
      long long cur = min(diff - n, n - 1);
      neg[i] += cur;
      diff -= cur;
    }
  }
  if (diff != n) {
    cout << "Impossible"
         << " \n";
    return;
  }
  cout << "Possible"
       << " \n"
       << add[0] << " ";
  long long i = 1, j = 0;
  for (char c : seq) {
    if (c == '+') {
      cout << c << " " << add[i++] << " ";
    } else {
      cout << c << " " << neg[j++] << " ";
    }
  }
  cout << "= " << n << " \n";
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long tc = 1, test = 1;
  while (tc--) {
    solve();
  }
}
