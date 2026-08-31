#include <bits/stdc++.h>
using namespace std;
long long MOD = 1e9 + 7;
vector<int> isPrime(20, 1);
void seive(int range) {
  isPrime[0] = isPrime[1] = 0;
  for (int i = 2; i * i <= range; i++)
    if (isPrime[i])
      for (int j = i * i; j <= range; j += i) isPrime[j] = i;
}
long long mod_expo(long long n, long long exp, long long p = MOD) {
  long long res = 1;
  while (exp > 0) {
    if (exp & 1) {
      res = ((res % p) * (n % p)) % p;
      exp--;
    };
    n = ((n % p) * (n % p)) % p;
    exp >>= 1;
  }
  return res;
}
int checkPrime(int n) {
  if (n == 1 or n == 0) return -1;
  for (int i = 2; i * i <= n; i++) {
    if (n % i == 0) {
      return -1;
    }
  }
  return 1;
}
void solve() {
  int l, r, d;
  cin >> l >> r >> d;
  if (d < l || d > r) {
    cout << (d) << '\n';
  } else {
    cout << ((r / d) * d + d) << '\n';
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int ts = 1;
  cin >> ts;
  std::chrono::time_point<std::chrono::system_clock> start, end;
  start = std::chrono::system_clock::now();
  while (ts--) {
    solve();
  }
  end = std::chrono::system_clock::now();
  std::chrono::duration<double> elapsed_seconds = end - start;
  std::time_t end_time = std::chrono::system_clock::to_time_t(end);
  return 0;
}
