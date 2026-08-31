#include <bits/stdc++.h>
using namespace std;
template <class T>
inline T Get_Max(const T& a, const T& b) {
  return a < b ? b : a;
}
template <class T>
inline T Get_Min(const T& a, const T& b) {
  return a < b ? a : b;
}
bool divisible(const complex<long long>& a, const complex<long long>& b) {
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
  bool flag = false;
  if (C.real() == 0 && C.imag() == 0) {
    if (A == B)
      flag = true;
    else if (B == -A)
      flag = true;
    else if (B == A * I)
      flag = true;
    else if (B == -A * I)
      flag = true;
  } else {
    if (divisible(B - A, C))
      flag = true;
    else if (divisible(B + A, C))
      flag = true;
    else if (divisible(B - A * I, C))
      flag = true;
    else if (divisible(B + A * I, C))
      flag = true;
  }
  if (flag)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
  return 0;
}
