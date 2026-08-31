#include <bits/stdc++.h>
using namespace std;
template <typename T, typename TT>
ostream &operator<<(ostream &s, pair<T, TT> t) {
  return s << "(" << t.first << "," << t.second << ")";
}
template <typename T>
ostream &operator<<(ostream &s, vector<T> t) {
  s << "{";
  for (int i = 0; i < t.size(); i++)
    s << t[i] << (i == t.size() - 1 ? "" : ",");
  return s << "}" << endl;
}
bool div(complex<long long> q, complex<long long> p) {
  q *= complex<long long>(p.real(), -p.imag());
  long long pm = p.real() * p.real() + p.imag() * p.imag();
  return (q.real() % pm == 0 && q.imag() % pm == 0);
}
int main() {
  ios_base::sync_with_stdio(0);
  long long a1, a2, b1, b2, c1, c2;
  cin >> a1 >> a2 >> b1 >> b2 >> c1 >> c2;
  complex<long long> C(c1, c2), A(a1, a2), B(b1, b2);
  complex<long long> i(0, 1);
  if (C == complex<long long>(0, 0)) {
    for (int j = 0; j < 9; j++) {
      A *= i;
      if (A == B) {
        cout << "YES";
        return 0;
      }
    }
    cout << "NO";
    return 0;
  }
  for (int j = 0; j < 9; j++) {
    A *= i;
    if (div(B - A, C)) {
      cout << "YES";
      return 0;
    }
  }
  cout << "NO";
  return 0;
}
