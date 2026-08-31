#include <bits/stdc++.h>
using namespace std;
bool verify(pair<long long, long long> b, pair<long long, long long> c) {
  long long num1 = b.first * c.second - b.second * c.first,
            den1 = c.first * c.first + c.second * c.second;
  if (den1 == 0) return b == c;
  if (num1 % den1 != 0) return 0;
  long long k2 = num1 / den1;
  long long num2 = b.first - k2 * c.second, den2 = c.first;
  long long num2a = b.second + k2 * c.first, den2a = c.second;
  if (den2 == 0) {
    if (den2a == 0) {
      return (num2 == 0 and num2a == 0);
    } else {
      return num2a % den2a == 0;
    }
  }
  if (num2 % den2 != 0) return 0;
  long long k1 = num2 / den2;
  return 1;
}
int main() {
  pair<long long, long long> a, b, c;
  cin >> a.first >> a.second >> b.first >> b.second >> c.first >> c.second;
  bool ret = verify(make_pair(b.first - a.first, b.second - a.second), c);
  ret |= verify(make_pair(b.first - a.second, b.second + a.first), c);
  ret |= verify(make_pair(b.first + a.first, b.second + a.second), c);
  ret |= verify(make_pair(b.first + a.second, b.second - a.first), c);
  if (ret)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
}
