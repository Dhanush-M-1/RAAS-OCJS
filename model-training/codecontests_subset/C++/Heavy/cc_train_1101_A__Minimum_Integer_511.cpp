#include <bits/stdc++.h>
using namespace std;
template <typename P, typename Q>
ostream& operator<<(ostream& os, pair<P, Q> p) {
  os << "(" << p.first << "," << p.second << ")";
  return os;
}
template <typename P, typename Q>
istream& operator>>(istream& is, pair<P, Q>& p) {
  is >> p.first >> p.second;
  return is;
}
template <typename T>
ostream& operator<<(ostream& os, vector<T> v) {
  os << "(";
  for (auto& i : v) os << i << ",";
  os << ")";
  return os;
}
template <typename T>
istream& operator>>(istream& is, vector<T>& v) {
  for (auto& i : v) is >> i;
  return is;
}
template <typename T>
inline T setmax(T& a, T b) {
  return a = std::max(a, b);
}
template <typename T>
inline T setmin(T& a, T b) {
  return a = std::min(a, b);
}
int main(int argc, char* argv[]) {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int q;
  while (cin >> q) {
    while (q--) {
      long long int a, b, c;
      cin >> a >> b >> c;
      if (c < a) {
        cout << c << endl;
      } else {
        cout << (b + c) / c * c << endl;
      }
    }
  }
  return 0;
}
