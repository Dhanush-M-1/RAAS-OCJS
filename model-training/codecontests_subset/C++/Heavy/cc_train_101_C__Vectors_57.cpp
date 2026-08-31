#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5 + 50;
const int inf = 0x3f3f3f3f;
const int MOD = 1e9 + 7;
bool divis(complex<long long> a, complex<long long> b) {
  complex<long long> c = a / b;
  return (b * c == a);
}
int main() {
  long long a, b;
  cin >> a >> b;
  complex<long long> A(a, b);
  cin >> a >> b;
  complex<long long> B(a, b);
  cin >> a >> b;
  complex<long long> C(a, b);
  complex<long long> I(0, 1);
  bool flag = 0;
  if (C.real() == 0 && C.imag() == 0) {
    if (A == B)
      flag = 1;
    else if (-A == B)
      flag = 1;
    else if (B == -A * I)
      flag = 1;
    else if (B == A * I)
      flag = 1;
  } else {
    if (divis(B - A, C)) flag = 1;
    if (divis(B + A, C)) flag = 1;
    if (divis(B + A * I, C)) flag = 1;
    if (divis(B - A * I, C)) flag = 1;
  }
  cout << (flag ? "YES\n" : "NO\n");
  return 0;
}
