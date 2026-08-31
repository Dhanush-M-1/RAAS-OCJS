#include <bits/stdc++.h>
using namespace std;
long long mod = 1000000007;
long long power(long long a, long long b) {
  long long res = 1;
  a %= mod;
  assert(b >= 0);
  for (; b; b >>= 1) {
    if (b & 1) res = res * a % mod;
    a = a * a % mod;
  }
  return res;
}
long long min(long long a, long long b) {
  if (a > b)
    return b;
  else
    return a;
}
long long max(long long a, long long b) {
  if (a > b)
    return a;
  else
    return b;
}
long long gcd(long long a, long long b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
vector<long long> div(long long n) {
  vector<long long> v;
  for (int i = 1; i * i <= n; i++) {
    if ((n % i) == 0) {
      if (i == n / i)
        v.push_back(i);
      else {
        v.push_back(i);
        v.push_back(n / i);
      }
    }
  }
  return v;
}
long long isPrime(long long n) {
  if (n <= 1) return false;
  if (n <= 3) return true;
  if (n % 2 == 0 || n % 3 == 0) return false;
  for (int i = 5; i * i <= n; i = i + 6)
    if (n % i == 0 || n % (i + 2) == 0) return false;
  return true;
}
bool isPowerOfTwo(long long n) {
  if (n == 0) return false;
  return (ceil(log2(n)) == floor(log2(n)));
}
long long power1(long long x, long long y) {
  long long temp;
  if (y == 0) return 1LL;
  temp = power(x, y / 2);
  if (y % 2 == 0)
    return temp * temp;
  else
    return x * temp * temp;
}
bool cmp(pair<long long, long long> a, pair<long long, long long> b) {
  if (a.first > b.first)
    return true;
  else if (a.first < b.first)
    return false;
  else {
    if (a.second < b.second)
      return true;
    else
      return false;
  }
}
const int N = 1000;
char s[N];
void solve() {
  long long n, ca = 0, ci = 0, cf = 0;
  char in;
  cin >> n;
  for (long long i = 0; i < n; i++) {
    cin >> in;
    if (in == 'A')
      ca += 1;
    else if (in == 'I')
      ci += 1;
    else if (in == 'F')
      cf += 1;
  }
  if (ci >= 2)
    cout << 0 << "\n";
  else if (ci == 1)
    cout << 1 << "\n";
  else
    cout << ca << "\n";
}
int main() {
  int T;
  T = 1;
  while (T--) {
    solve();
  }
  cerr << "Time : " << 1000 * ((double)clock()) / (double)CLOCKS_PER_SEC
       << "ms\n";
}
