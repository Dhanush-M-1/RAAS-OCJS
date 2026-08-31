#include <bits/stdc++.h>
using namespace std;
long long power(long long n, long long p, long long mod) {
  if (p == 0) return 1;
  if (p % 2 == 0) {
    long long c = power(n, p / 2, mod);
    return (c % mod * c % mod) % mod;
  }
  return (n % mod * power(n, p - 1, mod) % mod) % mod;
}
unsigned long long gcd(unsigned long long a, unsigned long long b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
int n, i;
string s;
int cnt[11] = {0};
int main() {
  ios_base::sync_with_stdio(false);
  cin >> n >> s;
  for (i = 0; i < n; i++) cnt[s[i] - '0']++;
  if (n < 11) return cout << 0, 0;
  int num = n / 11;
  cout << min(num, cnt[8]);
  return 0;
}
