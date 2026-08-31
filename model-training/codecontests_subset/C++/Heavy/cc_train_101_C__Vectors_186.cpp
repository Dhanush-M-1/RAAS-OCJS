#include <bits/stdc++.h>
using namespace std;
bool div(const complex<long long>& a, const complex<long long>& b) {
  complex<long long> c(0, 0);
  c = a / b;
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
    else if (B == -A)
      flag = 1;
    else if (B == A * I)
      flag = 1;
    else if (B == -A * I)
      flag = 1;
  } else {
    if (div(B - A, C))
      flag = 1;
    else if (div(B + A, C))
      flag = 1;
    else if (div(B - A * I, C))
      flag = 1;
    else if (div(B + A * I, C))
      flag = 1;
  }
  if (flag)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
  return 0;
}
