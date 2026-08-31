#include <bits/stdc++.h>
using namespace std;
bool divisible(const complex<long long>& a, const complex<long long>& b) {
  complex<long long> c(0, 0);
  c = a / b;
  return (b * c == a);
}
int main() {
  long long a, b;
  cin >> a;
  cin >> b;
  complex<long long> A(a, b);
  cin >> a;
  cin >> b;
  complex<long long> B(a, b);
  cin >> a;
  cin >> b;
  complex<long long> C(a, b);
  complex<long long> I(0, 1);
  bool res = false;
  if (C.real() == 0 && C.imag() == 0) {
    if (B == A)
      res = true;
    else if (B == -A)
      res = true;
    else if (B == A * I)
      res = true;
    else if (B == -A * I)
      res = true;
  } else {
    if (divisible(B - A, C))
      res = true;
    else if (divisible(B + A, C))
      res = true;
    else if (divisible(B - A * I, C))
      res = true;
    else if (divisible(B + A * I, C))
      res = true;
  }
  if (res)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
  return 0;
}
