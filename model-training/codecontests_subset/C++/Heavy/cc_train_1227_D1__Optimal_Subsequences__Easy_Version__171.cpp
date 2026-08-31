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
  long long n;
  cin >> n;
  vector<long long> a(n);
  for (long long i = 0; i < (long long)n; ++i) cin >> a[i];
  map<long long, vector<long long> > mp;
  for (long long i = 0; i < (long long)n; ++i) mp[a[i]].push_back(i);
  long long t;
  cin >> t;
  while (t--) {
    long long k, idx;
    cin >> k >> idx;
    auto it = mp.rbegin();
    vector<long long> b;
    while (k > 0) {
      vector<long long> temp = it->second;
      if (k >= (long long)temp.size()) {
        k -= temp.size();
        for (long long i = 0; i < (long long)temp.size(); ++i) {
          b.push_back(temp[i]);
        }
      } else {
        long long i = 0;
        while (k--) {
          b.push_back(temp[i]);
          i++;
        }
      }
      it++;
    }
    sort(b.begin(), b.end());
    cout << a[b[idx - 1]] << '\n';
  }
  return 0;
}
