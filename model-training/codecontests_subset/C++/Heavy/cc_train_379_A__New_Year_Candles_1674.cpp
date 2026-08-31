#include <bits/stdc++.h>
using namespace std;
mt19937_64 rang(
    chrono::high_resolution_clock::now().time_since_epoch().count());
int mpow(int base, int exp);
template <class T>
T npow(T base, T exp);
const int mod = 1e9 + 7;
const int N = 3e5, M = N;
void Solve_main() {
  int i, j, n, m, k;
  cin >> n >> m;
  int res = n;
  while (n >= m) {
    res += (n / m);
    n = n / m + n % m;
  }
  cout << res << '\n';
}
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  srand(chrono::high_resolution_clock::now().time_since_epoch().count());
  int t = 1;
  while (t--) {
    Solve_main();
  }
  return 0;
}
int mpow(int base, int exp) {
  base %= mod;
  int result = 1;
  while (exp > 0) {
    if (exp & 1) result = ((long long)result * base) % mod;
    base = ((long long)base * base) % mod;
    exp >>= 1;
  }
  return result;
}
template <class T>
T npow(T base, T exp) {
  T result = 1;
  while (exp > 0) {
    if (exp & 1) result = (result * base);
    base = (base * base);
    exp >>= 1;
  }
  return result;
}
