#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
using namespace std;
bool isPowerOfTwo(long long int x) { return x && (!(x & (x - 1))); }
long long int Modular_Exponentiation(long long int x, long long int n,
                                     long long int M) {
  if (n == 0) return 1;
  if (n % 2)
    return (x * Modular_Exponentiation((x * x) % M, n / 2, M)) % M;
  else
    return (Modular_Exponentiation((x * x) % M, n / 2, M)) % M;
}
bool isPrime(long long int n) {
  if (n <= 1) return false;
  if (n <= 3) return true;
  if (n % 2 == 0 || n % 3 == 0) return false;
  for (long long int i = 5; i * i <= n; i += 6)
    if (n % i == 0 || n % (i + 2) == 0) return false;
  return true;
}
void solve() {
  long long int n;
  cin >> n;
  string str[n];
  for (long long int i = 0; i < n; ++i) cin >> str[i];
  long long int a, b, c, d, one = 0, zero = 0;
  a = str[0][1] - '0';
  b = str[1][0] - '0';
  c = str[n - 2][n - 1] - '0';
  d = str[n - 1][n - 2] - '0';
  if (a == 0)
    zero++;
  else
    one++;
  if (b == 0)
    zero++;
  else
    one++;
  if (c == 0)
    zero++;
  else
    one++;
  if (d == 0)
    zero++;
  else
    one++;
  if (zero < one) {
    if (zero == 1) {
      cout << "1\n";
      if (a == 0)
        cout << "2 1\n";
      else if (b == 0)
        cout << "1 2\n";
      else if (c == 0)
        cout << n << " " << n - 1 << "\n";
      else
        cout << n - 1 << " " << n << "\n";
      return;
    } else {
      cout << "2\n";
      cout << "1 2\n2 1\n";
      return;
    }
  } else if (one < zero) {
    if (one == 1) {
      cout << "1\n";
      if (a == 1)
        cout << "2 1\n";
      else if (b == 1)
        cout << "1 2\n";
      else if (c == 1)
        cout << n << " " << n - 1 << "\n";
      else
        cout << n - 1 << " " << n << "\n";
      return;
    } else {
      cout << "2\n";
      cout << "1 2\n2 1\n";
      return;
    }
  } else {
    if (a != b) {
      cout << "2\n";
      cout << "1 2\n";
      if (a == c)
        cout << n << " " << n - 1 << "\n";
      else
        cout << n - 1 << " " << n << "\n";
      return;
    } else
      cout << "0\n";
  }
}
int32_t main() {
  std::ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int T = 1;
  cin >> T;
  while (T--) solve();
  cerr << "Time taken : " << fixed << setprecision(5)
       << ((float)clock() / CLOCKS_PER_SEC) * 1000 << " ms"
       << "\n";
  cerr << "My CLOCKS_PER_SEC= " << CLOCKS_PER_SEC << "\n";
  return 0;
}
