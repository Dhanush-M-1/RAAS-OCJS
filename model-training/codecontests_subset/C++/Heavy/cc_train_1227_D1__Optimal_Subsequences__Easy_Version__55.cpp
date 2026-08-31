#include <bits/stdc++.h>
using namespace std;
const int MAX = 1e5 + 9;
const long long mod = 1e9 + 7;
vector<bool> prime(MAX, 1);
vector<int> spf(MAX, 1);
vector<int> primes;
void sieve() {
  prime[0] = prime[1] = 0;
  spf[2] = 2;
  for (long long i = 4; i < MAX; i += 2) {
    spf[i] = 2;
    prime[i] = 0;
  }
  primes.push_back(2);
  for (long long i = 3; i < MAX; i += 2) {
    if (prime[i]) {
      primes.push_back(i);
      spf[i] = i;
      for (long long j = i * i; j < MAX; j += i) {
        prime[j] = 0;
        if (spf[j] == 1) {
          spf[j] = i;
        }
      }
    }
  }
}
long long power(long long a, long long b) {
  long long res = 1;
  while (b) {
    if (b & 1) {
      res = res * a;
    }
    a = a * a;
    b = b >> 1;
  }
  return res;
}
long long power(long long a, long long b, long long m) {
  long long res = 1;
  while (b) {
    if (b & 1) {
      res = (res * a) % m;
    }
    a = (a * a) % m;
    b = b >> 1;
  }
  return res % m;
}
void virtual_main() {}
void real_main() {
  int n;
  cin >> n;
  vector<int> v(n), a(n);
  for (int i = 0; i < n; i++) {
    cin >> v[i];
    a[i] = v[i];
  }
  sort(v.begin(), v.end());
  int m;
  cin >> m;
  while (m--) {
    int k, pos;
    cin >> k >> pos;
    vector<int> values;
    for (int i = n - 1; i >= n - k; i--) {
      values.push_back(v[i]);
    }
    reverse(values.begin(), values.end());
    vector<int> ans;
    vector<bool> mark(n, 0);
    int last = 0;
    for (int i = 0; i < (int)values.size(); i++) {
      int x = values[i];
      bool say = 0;
      for (int j = last; j < n; j++) {
        if (a[j] == x && !mark[j]) {
          say = 1;
          ans.push_back(j);
          mark[j] = 1;
          last = j;
          break;
        }
      }
      if (!say) {
        for (int j = 0; j <= last; j++) {
          if (a[j] == x && !mark[j]) {
            say = 1;
            mark[j] = 1;
            last = j;
            ans.push_back(j);
            break;
          }
        }
      }
    }
    sort(ans.begin(), ans.end());
    cout << a[ans[pos - 1]] << "\n";
  }
}
signed main() {
  ios_base::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);
  virtual_main();
  int test_cases = 1;
  for (int i = 1; i <= test_cases; i++) {
    real_main();
  }
  return 0;
}
