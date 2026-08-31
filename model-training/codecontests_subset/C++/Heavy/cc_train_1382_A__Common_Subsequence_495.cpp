#include <bits/stdc++.h>
using namespace std;
void c_p_c() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
}
long long me(long long x, long long y, long long p) {
  long long res = 1;
  x = x % p;
  if (x == 0) return 0;
  while (y > 0) {
    if (y & 1) res = (res * x) % p;
    y = y >> 1;
    x = (x * x) % p;
  }
  return res;
}
void solve() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long n, m;
  cin >> n >> m;
  long long a[n];
  unordered_map<long long, long long> hash;
  unordered_map<long long, long long> hash1;
  for (long long i = 0; i < n; i++) {
    cin >> a[i];
    hash[a[i]]++;
  }
  long long b[m];
  for (long long i = 0; i < m; i++) {
    cin >> b[i];
    hash1[b[i]]++;
  }
  for (auto it = hash.begin(); it != hash.end(); it++) {
    if (it->second >= 1 && hash1[it->first] >= 1) {
      cout << "YES\n" << 1 << " " << it->first << endl;
      return;
    }
  }
  cout << "NO\n";
}
int main() {
  c_p_c();
  long long t;
  cin >> t;
  while (t--) {
    solve();
  }
  return 0;
}
