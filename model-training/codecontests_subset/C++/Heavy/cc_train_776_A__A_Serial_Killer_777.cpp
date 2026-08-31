#include <bits/stdc++.h>
using namespace std;
long long md = 1000000007;
long long ma = 998244353;
long long pw(long long a, long long b) {
  long long c = 1, m = a;
  while (b) {
    if (b & 1) c = (c * m);
    m = (m * m);
    b /= 2;
  }
  return c;
}
long long pwmd(long long a, long long b) {
  long long c = 1, m = a;
  while (b) {
    if (b & 1) c = ((c * m)) % md;
    m = (m * m) % md;
    b /= 2;
  }
  return c;
}
long long modinv(long long n) { return pwmd(n, md - 2); }
long long min(long long a, long long b) {
  if (a >= b) return b;
  return a;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  long long n;
  string s1, s2, s3, s4;
  cin >> s1 >> s2 >> n;
  cout << s1 << " " << s2 << "\n";
  for (long long i = 0; i < n; i++) {
    cin >> s3 >> s4;
    if (s3 == s1)
      s1 = s4;
    else
      s2 = s4;
    cout << s1 << " " << s2 << "\n";
  }
  return 0;
}
