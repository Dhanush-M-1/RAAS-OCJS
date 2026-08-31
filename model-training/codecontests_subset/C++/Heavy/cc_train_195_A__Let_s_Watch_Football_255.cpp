#include <bits/stdc++.h>
using namespace std;
long long gcd(long long a, long long b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
string toBin(long long a) {
  string res = "";
  while (a) {
    res += char((a & 1) + '0');
    a >>= 1;
  }
  reverse(res.begin(), res.end());
  return res;
}
const int mod = 1e9 + 7;
long long expo(long long base, long long pow) {
  long long ans = 1;
  while (pow != 0) {
    if (pow & 1 == 1) {
      ans = ans * base;
      ans = ans % mod;
    }
    base *= base;
    base %= mod;
    pow /= 2;
  }
  return ans;
}
long long inv(long long x) { return expo(x, mod - 2); }
bool isPal(string ss) {
  int len = ss.length();
  for (int i = 0; i < len / 2; i++) {
    int comp = len - i - 1;
    if (ss[i] != ss[comp]) return false;
  }
  return true;
}
double pi = 3.141592653589793238462643;
double error = 0.0000001;
const int M = 100001;
int main() {
  int a, b, c;
  scanf("%d", &(a));
  scanf("%d", &(b));
  scanf("%d", &(c));
  int d = a * c;
  int dx = (int)ceil((d * 1.0) / b);
  int dy = (int)ceil((d * 1.0) / a);
  int ans = dx - dy;
  cout << max(ans, 0);
}
