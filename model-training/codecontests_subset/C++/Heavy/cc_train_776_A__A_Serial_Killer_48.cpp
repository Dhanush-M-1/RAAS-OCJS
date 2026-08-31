#include <bits/stdc++.h>
using namespace std;
long long powermod(long long _a, long long _b, long long _m) {
  long long _r = 1;
  while (_b) {
    if (_b % 2 == 1) _r = (_r * _a) % _m;
    _b /= 2;
    _a = (_a * _a) % _m;
  }
  return _r;
}
long long string_to_number(string s) {
  long long x = 0;
  stringstream convert(s);
  convert >> x;
  return x;
}
long long add(long long a, long long b) {
  long long x = (a + b) % 1000000007;
  return x;
}
long long mul(long long a, long long b) {
  long long x = (a * b) % 1000000007;
  return x;
}
long long sub(long long a, long long b) {
  long long x = (a - b + 1000000007) % 1000000007;
  return x;
}
long long divi(long long a, long long b) {
  long long x = a;
  long long y = powermod(b, 1000000007 - 2, 1000000007);
  long long res = (x * y) % 1000000007;
  return res;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  string s1, s2;
  cin >> s1 >> s2;
  int n;
  cin >> n;
  cout << s1 << " " << s2 << '\n';
  while (n--) {
    string a, b;
    cin >> a >> b;
    if (s1 == a)
      s1 = b;
    else
      s2 = b;
    cout << s1 << " " << s2 << '\n';
  }
  return 0;
}
