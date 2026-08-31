#include <bits/stdc++.h>
using namespace std;
long long n, nn, ans = 1;
bool isprime(long long n) {
  for (long long i = 2; i * i <= n; i++)
    if (n % i == 0) return 0;
  return 1;
}
int main() {
  ios::sync_with_stdio(), cin.tie(0), cout.tie(0);
  cin >> n, nn = n;
  for (int i = 2; i < 1e5; i++) {
    while (n % i == 0 && ans * i < nn) {
      n /= i, ans *= i;
      if (!isprime(ans)) return cout << 1 << endl << ans, 0;
    }
  }
  if (isprime(nn)) return cout << 1 << endl << 0, 0;
  cout << 2, 0;
  return 0;
}
