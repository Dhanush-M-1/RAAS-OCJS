#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f;
const double eps = 1e-8;
const int mod = 1000000007;
const double pi = acos(-1.0);
inline void gn(long long& x) {
  int sg = 1;
  char c;
  while (((c = getchar()) < '0' || c > '9') && c != '-')
    ;
  c == '-' ? (sg = -1, x = 0) : (x = c - '0');
  while ((c = getchar()) >= '0' && c <= '9') x = x * 10 + c - '0';
  x *= sg;
}
inline void gn(int& x) {
  long long t;
  gn(t);
  x = t;
}
inline void gn(unsigned long long& x) {
  long long t;
  gn(t);
  x = t;
}
long long gcd(long long a, long long b) { return a ? gcd(b % a, a) : b; }
long long powmod(long long a, long long x, long long mod) {
  long long t = 1ll;
  while (x) {
    if (x & 1) t = t * a % mod;
    a = a * a % mod;
    x >>= 1;
  }
  return t;
}
int main() {
  string a, b;
  cin >> a >> b;
  int n;
  cin >> n;
  for (int i = (1); i <= (n); i++) {
    cout << a << " " << b << endl;
    string ol, ne;
    cin >> ol >> ne;
    if (a == ol)
      a = ne;
    else
      b = ne;
  }
  cout << a << " " << b << endl;
  return 0;
}
