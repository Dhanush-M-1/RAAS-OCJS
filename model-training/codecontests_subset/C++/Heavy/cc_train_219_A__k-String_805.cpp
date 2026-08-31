#include <bits/stdc++.h>
using namespace std;
const long long N = 2e5 + 7;
long long power(long long x, long long y) {
  long long res = 1;
  x = x;
  while (y > 0) {
    if (y & 1) res = (res * x);
    y = y >> 1;
    x = (x * x);
  }
  return res;
}
template <typename T>
T gcd(T a, T b) {
  if (a == 0) return b;
  return gcd(b % a, a);
}
template <typename T>
T powm(T a, T b, long long m) {
  T cnt = 1;
  while (b > 0) {
    if (b % 2 == 1) cnt = (cnt * a) % m;
    b /= 2;
    a = (a * a) % m;
  }
  return cnt % m;
}
long long ncr(long long n, long long r) {
  long long res = 1;
  if (r > n) return 0;
  if (r > n - r) r = n - r;
  for (long long i = 0; i < r; i++) {
    res *= (n - i);
    res /= (i + 1);
  }
  return res;
}
int n, k;
string s;
map<char, int> m;
void solve() {
  cin >> k >> s;
  n = (long long)s.size();
  for (int i = 0; i < n; i++) m[s[i]]++;
  string ans = "";
  for (auto &it : m) {
    if (it.second % k) {
      cout << "-1";
      return;
    }
    for (int j = 1; j <= it.second / k; j++) ans += it.first;
  }
  string ks = "";
  for (int i = 1; i <= k; i++) ks += ans;
  cout << ks;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int t;
  t = 1;
  while (t--) solve();
  return 0;
}
