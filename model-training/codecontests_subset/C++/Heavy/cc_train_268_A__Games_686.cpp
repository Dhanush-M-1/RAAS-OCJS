#include <bits/stdc++.h>
using namespace std;
const long long int mod = 1000000007ll;
const long long int MOD = 1000000009ll;
int local_debug = 0;
long long int bit_count(long long int _x) {
  long long int _ret = 0;
  while (_x) {
    if (_x % 2 == 1) _ret++;
    _x /= 2;
  }
  return _ret;
}
long long int bit(long long int _mask, long long int _i) {
  long long int x = 1;
  return (_mask & (x << _i)) == 0 ? 0 : 1;
}
long long int powermod(long long int _a, long long int _b,
                       long long int _m = mod) {
  long long int _r = 1;
  while (_b) {
    if (_b % 2 == 1) _r = (_r * _a) % _m;
    _b /= 2;
    _a = (_a * _a) % _m;
  }
  return _r;
}
long long int power(long long int _a, long long int _b) {
  long long int _r = 1;
  while (_b) {
    if (_b % 2 == 1) _r = (_r * _a);
    _b /= 2;
    _a = (_a * _a);
  }
  return _r;
}
long long int add(long long int a, long long int b, long long int m = mod) {
  a %= m;
  b %= m;
  long long int x = a + b;
  while (x >= m) x -= m;
  return x;
}
long long int sub(long long int a, long long int b, long long int m = mod) {
  long long int x = a - b;
  while (x < 0) x += m;
  return x;
}
long long int mul(long long int a, long long int b, long long int m = mod) {
  a %= m;
  b %= m;
  long long int x = a * b;
  x %= m;
  return x;
}
long long int gcd(long long int a, long long int b) {
  if (a < b) {
    a = a ^ b;
    b = a ^ b;
    a = a ^ b;
  }
  if (b == 0) return a;
  long long int t;
  while (b) {
    t = b;
    b = a % b;
    a = t;
  }
  return a;
}
long long int lcm(long long int a, long long int b) {
  return (a * b) / gcd(a, b);
}
long long int maxSubArraySum(vector<long long int> a, long long int size) {
  long long int max_so_far = a[0];
  long long int curr_max = a[0];
  for (long long int i = 1; i < size; i++) {
    curr_max = max(a[i], curr_max + a[i]);
    max_so_far = max(max_so_far, curr_max);
  }
  return max_so_far;
}
int main() {
  long long int n;
  scanf("%lld", &n);
  ;
  vector<long long> hrr(n);
  vector<long long> grr(n);
  for (int i = 0; i < n; i++) {
    scanf("%lld", &hrr[i]);
    ;
    scanf("%lld", &grr[i]);
    ;
  }
  int count = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j <= n; j++) {
      if (hrr[i] == grr[j]) {
        count++;
      }
    }
  }
  cout << count << endl;
  return 0;
}
