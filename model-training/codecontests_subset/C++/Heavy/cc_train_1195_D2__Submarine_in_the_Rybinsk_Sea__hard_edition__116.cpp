#include <bits/stdc++.h>
using namespace std;
long long mod = 998244353;
long long n;
vector<int> d[100005];
long long min(long long a, long long b) {
  if (a < b)
    return a;
  else
    return b;
}
void sol() {
  cin >> n;
  int c[11] = {0};
  for (int i = 0; i < n; ++i) {
    long long x;
    cin >> x;
    while (x) {
      d[i].push_back(x % 10);
      x /= 10;
    }
    c[d[i].size()]++;
  }
  long long sum = 0;
  for (int i = 0; i < n; ++i) {
    for (int j = 1; j <= 10; ++j) {
      long long f = 0;
      if (c[j] > 0) {
        long long limit = min(j, d[i].size());
        long long k = d[i].size() - 1;
        while (k + 1 > limit) {
          f = f * 10 + d[i][k];
          --k;
        }
        long long f1 = f;
        long long k1 = k;
        f1 = f1 * 10 + d[i][k1];
        --k1;
        for (; k1 >= 0; --k1) {
          f1 = (f1 * 100 + d[i][k1]) % mod;
        }
        f1 = (f1 * 10) % mod;
        for (; k >= 0; --k) {
          f = (f * 100 + d[i][k]) % mod;
        }
        sum = (sum + ((f + f1) * c[j]) % mod) % mod;
      }
    }
  }
  cout << sum;
}
int main() {
  int t = 1;
  while (t--) {
    sol();
  }
}
