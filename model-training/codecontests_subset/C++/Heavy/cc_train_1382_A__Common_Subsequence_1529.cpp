#include <bits/stdc++.h>
using namespace std;
long long int xo(long long int x, long long int y) {
  return (x | y) & (~x | ~y);
}
long long int bin_Expo(long long int x, long long int n) {
  if (x == 0) return 0;
  if (n == 0)
    return 1;
  else if (n % 2 == 0)
    return bin_Expo(x * x, n / 2);
  else
    return x * bin_Expo(x * x, (n - 1) / 2);
}
long long int mod_Expo(long long int x, long long int n, long long int M) {
  if (x == 0) return 0;
  if (n == 0)
    return 1;
  else if (n % 2 == 0)
    return mod_Expo((x * x) % M, n / 2, M);
  else
    return (x * mod_Expo((x * x) % M, (n - 1) / 2, M)) % M;
}
bool prime_check(long long int x) {
  bool prime = (x >= 2);
  for (long long int i = 2; i * i <= x; i++) {
    if (x % i == 0) {
      prime = false;
      break;
    }
  }
  return prime;
}
long long int logg(long long int base, long long int x) {
  return (long long int)(log(x) / log(base));
}
map<long long int, long long int> mm;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int TESTS = 1;
  cin >> TESTS;
  while (TESTS--) {
    long long int k, i, j, l, h, w, q, n, m;
    cin >> n >> m;
    long long int a[n], b[m];
    for (long long int i = 0; i < n; i++) cin >> a[i];
    for (long long int i = 0; i < m; i++) cin >> b[i];
    for (long long int i = 0; i < n; i++) mm[a[i]] = 1;
    l = 1000000007;
    for (long long int i = 0; i < m; i++) {
      if (mm[b[i]] == 1) {
        l = b[i];
        break;
      }
    }
    if (l != 1000000007) {
      cout << "YES" << '\n';
      cout << 1 << " " << l << '\n';
    } else
      cout << "NO" << '\n';
    mm.clear();
  }
  return 0;
}
