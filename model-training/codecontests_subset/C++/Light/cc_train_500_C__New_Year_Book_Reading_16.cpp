#include <bits/stdc++.h>
using namespace std;
vector<bool> sieve(long long n) {
  vector<bool> prime(n + 1, true);
  prime[0] = prime[1] = false;
  for (long long i = 2; i <= n; ++i) {
    if (prime[i] && (i * i) <= n)
      for (long long j = i * i; j <= n; j += i) prime[j] = false;
  }
  return prime;
}
long long power(long long a, long long b, long long m = 1000000007) {
  a %= m;
  long long res = 1;
  while (b > 0) {
    if (b & 1) res = res * a % m;
    a = a * a % m;
    b >>= 1;
  }
  return res;
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long n, m;
  cin >> n >> m;
  vector<long long> b(m);
  map<long long, long long> wt;
  for (long long i = 0; i < n; ++i) {
    long long val;
    cin >> val;
    wt[i + 1] = val;
  }
  for (long long i = 0; i < m; ++i) cin >> b[i];
  vector<long long> a, vis(n + 1, false);
  for (long long i = 0; i < m; ++i) {
    if (!vis[b[i]]) {
      vis[b[i]] = 1;
      a.push_back(b[i]);
      long long len = a.size();
      if (len == n) break;
    }
  }
  long long res = 0;
  for (long long i = 0; i < m; ++i) {
    long long temp = 0;
    long long idx = 0;
    for (long long j = 0; j < n; ++j) {
      if (a[j] == b[i]) {
        idx = j;
        break;
      } else {
        temp += wt[a[j]];
      }
    }
    res += temp;
    for (long long j = idx; j >= 1; --j) {
      a[j] = a[j - 1];
    }
    a[0] = b[i];
  }
  cout << res << '\n';
  return 0;
}
