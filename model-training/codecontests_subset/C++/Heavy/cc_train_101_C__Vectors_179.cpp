#include <bits/stdc++.h>
const double eps = 1e-9;
const double pi = acos(-1);
using namespace std;
bool divis(const complex<long long>& a, const complex<long long>& b) {
  complex<long long> C(0, 0);
  C = a / b;
  return (b * C == a);
}
int main() {
  long long x, y;
  cin >> x >> y;
  complex<long long> A(x, y);
  cin >> x >> y;
  complex<long long> B(x, y);
  cin >> x >> y;
  complex<long long> C(x, y);
  complex<long long> I(0, 1);
  int ans = 0;
  if (C.real() == 0 && C.imag() == 0) {
    if (A == B)
      ans = 1;
    else if (-A == B)
      ans = 1;
    else if (B == A * I)
      ans = 1;
    else if (B == -A * I)
      ans = 1;
  } else {
    if (divis(B - A, C))
      ans = 1;
    else if (divis(B + A, C))
      ans = 1;
    else if (divis(B - A * I, C))
      ans = 1;
    else if (divis(B + A * I, C))
      ans = 1;
  }
  if (ans)
    cout << "YES\n";
  else
    cout << "NO\n";
  return 0;
}
