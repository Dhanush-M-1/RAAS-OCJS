#include <bits/stdc++.h>
using namespace std;
mt19937 genrand(chrono::system_clock::now().time_since_epoch().count());
string inttostr(long long str) {
  stringstream stream;
  stream << str;
  return stream.str();
}
string numtobin(long long n) {
  string r = "";
  while (n) r = ((n & 1) ? '1' : '0') + r, n >>= 1;
  return r;
}
long long bintonum(string s) {
  long long n = 0, p = 1 << (s.length() - 1);
  for (char i : s) n += (i - '0') * p, p >>= 1;
  return n;
}
long long modexpo(long long a, long long b, long long n) {
  long long d = 1;
  while (b) {
    if (b & 1) d = (d * a) % n;
    b >>= 1;
    a = (a * a) % n;
  }
  return d;
}
long long expo(long long a, long long b) {
  long long d = 1;
  while (b) {
    if (b & 1) d = d * a;
    b >>= 1;
    a = a * a;
  }
  return d;
}
inline long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
inline long long lcm(long long a, long long b) { return (a * b) / gcd(a, b); }
long long inv(long long a, long long m) { return modexpo(a, m - 2, m); }
void take_input_and_output_from_file() {}
inline long long scan_int() {
  long long NR = 0, sign = 1;
  char c = getchar();
  while (c < 48 || c > 57) {
    if (c == '-') sign = 0;
    c = getchar();
  }
  while (c > 47 && c < 58) {
    NR = (NR << 3) + (NR << 1) + (c - 48);
    c = getchar();
  }
  return (sign ? NR : (-NR));
}
int main() {
  int n = scan_int();
  int a[n], i;
  for (i = 0; i < n; i++) a[i] = scan_int();
  int k, ma = 0;
  for (i = 0; i < n; i++) ma = max(ma, a[i]);
  int sm = 0;
  for (i = 0; i < n; i++) sm += a[i];
  k = ma;
  while (1) {
    int sma = 0;
    for (i = 0; i < n; i++) sma += k - a[i];
    if (sma > sm) break;
    k++;
  }
  cout << k << endl;
  return 0;
}
