#include <bits/stdc++.h>
using namespace std;
const int inf = 1e9 + 7;
const long long longinf = 1LL << 60;
const long long mod = 998244353;
const long double eps = 1e-10;
template <typename T1, typename T2>
inline void chmin(T1 &a, T2 b) {
  if (a > b) a = b;
}
template <typename T1, typename T2>
inline void chmax(T1 &a, T2 b) {
  if (a < b) a = b;
}
int main() {
  cin.tie(0);
  ios::sync_with_stdio(false);
  int n;
  cin >> n;
  vector<long long> A(n);
  for (int i = (int)(0); i < (int)(n); i++) cin >> A[i];
  vector<int> id(n);
  iota(id.begin(), id.end(), 0);
  sort(id.begin(), id.end(),
       [&](int i, int j) { return log10(A[i]) < log10(A[j]); });
  int d = 15;
  vector<long long> pw(2 * d + 1);
  pw[0] = 1;
  for (int i = (int)(0); i < (int)(2 * d + 1); i++)
    if (i) pw[i] = pw[i - 1] * 10 % mod;
  long long ans = 0;
  vector<int> cnt(d + 1);
  for (int i : id) {
    int rem = n;
    long long a = A[i];
    long long sum = 0;
    for (int j = (int)(0); j < (int)(log10(A[i]) + 1); j++) {
      (sum += (a % 10) * pw[2 * j]) %= mod;
      a /= 10;
      (ans += (sum * 11 + a * pw[2 * (j + 1)] * 2) * cnt[j + 1] % mod) %= mod;
      rem -= cnt[j + 1];
    }
    (ans += (sum * 11) * rem % mod) %= mod;
    cnt[log10(A[i]) + 1]++;
  }
  cout << ans << '\n';
  return 0;
}
