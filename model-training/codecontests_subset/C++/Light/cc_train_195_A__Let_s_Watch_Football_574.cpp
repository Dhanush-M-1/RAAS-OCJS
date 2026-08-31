#include <bits/stdc++.h>
const double pi = 3.1415926535897932384626433832795;
int gcd(int a, int b) {
  if (a == 0) return b;
  return gcd(b % a, a);
}
using namespace std;
void ifd() {}
void tme() {}
int a, b, c;
int main() {
  ifd();
  cin >> a >> b >> c;
  cout << ((a - b) * c + b - 1) / b << endl;
  tme();
  return 0;
}
