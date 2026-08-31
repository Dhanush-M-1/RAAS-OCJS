#include <bits/stdc++.h>
using namespace std;
void solve() {
  long long n, l, r;
  cin >> n >> l >> r;
  if (l == n * (n - 1LL) + 1LL) {
    cout << 1 << '\n';
    return;
  }
  long long suma = 0LL;
  long long trenutni = (long long)n - 1LL;
  while (trenutni > 0) {
    if (suma + 2 * trenutni >= l) break;
    suma += 2 * trenutni;
    --trenutni;
  }
  trenutni = (n - trenutni);
  long long sledeci = trenutni;
  for (long long i = suma + 1; i <= r; ++i) {
    if (i == n * (n - 1) + 1) {
      cout << 1 << ' ';
      cout << '\n';
      return;
    }
    if (i % 2 == 1) {
      ++sledeci;
    }
    if (i >= l) {
      if (i % 2)
        cout << trenutni << ' ';
      else
        cout << sledeci << ' ';
    }
    if (sledeci == n && i % 2 == 0) sledeci = ++trenutni;
  }
  cout << '\n';
}
int main() {
  int t;
  cin >> t;
  while (t--) solve();
  return 0;
}
