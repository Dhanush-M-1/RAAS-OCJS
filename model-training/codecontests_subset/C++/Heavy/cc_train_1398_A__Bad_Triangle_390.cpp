#include <bits/stdc++.h>
using namespace std;
long long mod = 1e9 + 7;
long long C(int n, int r) {
  if (r > n) return 0;
  if (r > n - r) r = n - r;
  long long ans = 1;
  int i;
  for (i = 1; i <= r; i++) {
    ans *= n - r + i;
    ans /= i;
  }
  return ans;
}
vector<long long> sieve(long long n) {
  vector<long long> is_prime(n + 1, true);
  is_prime[0] = is_prime[1] = false;
  for (int i = 2; i <= n; i++) {
    if (is_prime[i] && (long long)i * i <= n) {
      for (int j = i * i; j <= n; j += i) is_prime[j] = false;
    }
  }
  return is_prime;
}
void test() {
  long long n;
  cin >> n;
  vector<long long> v(n);
  for (long long(i) = 0; (i) < n; ++(i)) cin >> v[i];
  long long i = 0, j = 1, k = n - 1;
  if (v[i] + v[j] <= v[k]) {
    cout << i + 1 << " " << j + 1 << " " << k + 1 << "\n";
    return;
  }
  cout << "-1\n";
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long t = 1;
  cin >> t;
  for (long long T = 0; T < t; T++) {
    test();
  }
  cerr << "Time : " << 1000 * ((double)clock()) / (double)CLOCKS_PER_SEC
       << "ms\n";
}
