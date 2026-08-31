#include <bits/stdc++.h>
using namespace std;
int conversion(string p) {
  int o;
  o = atoi(p.c_str());
  return o;
}
string toString(int h) {
  stringstream ss;
  ss << h;
  return ss.str();
}
long long gcd(long long a, long long b) { return (b == 0 ? a : gcd(b, a % b)); }
int lcm(int a, int b) { return (a * (b / gcd(a, b))); }
int main() {
  long long n, x, y;
  cin >> n >> x >> y;
  int por = (n * y) / 100;
  if (n * y % 100 == 0) {
    long long por = (n * y) / 100;
    if (por <= x) {
      cout << 0 << endl;
    } else {
      cout << abs(por - x) << endl;
    }
  } else {
    long long por = (n * y) / 100 + 1;
    if (por <= x) {
      cout << 0 << endl;
    } else {
      cout << abs(por - x) << endl;
    }
  }
}
