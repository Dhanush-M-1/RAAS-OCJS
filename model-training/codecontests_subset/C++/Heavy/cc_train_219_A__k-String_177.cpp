#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("O0")
#pragma GCC optimize("Ofast")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
#pragma GCC optimize("-ffloat-store")
void get(long long arr[], long long n) {
  for (long long i = 0; i < n; i++) cin >> arr[i];
}
long long gcd(long long a, long long b);
long long binpow(long long a, long long b);
void solve() {
  long long k;
  cin >> k;
  string x;
  cin >> x;
  long long n = x.length();
  map<long long, long long> m;
  if (n % k != 0) {
    cout << "-1";
    return;
  }
  set<char> s;
  for (int i = 0; i < n; i++) {
    s.insert(x[i]);
    m[x[i]]++;
  }
  bool f = true;
  for (auto &y : s) {
    if ((m[y]) % k != 0) f = false;
    if (!f) break;
  }
  if (!f) {
    cout << "-1";
    return;
  }
  string ans = "";
  for (auto &y : s) {
    long long add = m[y] / k;
    for (int i = 0; i < add; i++) ans += y;
  }
  string fans = "";
  for (int i = 0; i < k; i++) fans += ans;
  cout << fans;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long t;
  t = 1;
  while (t--) {
    solve();
  }
}
long long binpow(long long a, long long b) {
  long long res = 1;
  while (b > 0) {
    if (b & 1) res = res * a;
    a = a * a;
    b >>= 1;
  }
  return res;
}
long long gcd(long long a, long long b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
