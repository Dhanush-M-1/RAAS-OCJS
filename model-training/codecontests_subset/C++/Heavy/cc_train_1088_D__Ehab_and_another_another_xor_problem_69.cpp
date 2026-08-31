#include <bits/stdc++.h>
using namespace std;
template <class T>
void dbs(string str, T t) {
  cerr << str << " : " << t << "\n";
}
template <class T, class... S>
void dbs(string str, T t, S... s) {
  int idx = str.find(',');
  cerr << str.substr(0, idx) << " : " << t << ", ";
  dbs(str.substr(idx + 1), s...);
}
template <class S, class T>
ostream& operator<<(ostream& os, const pair<S, T>& p) {
  return os << "(" << p.first << ", " << p.second << ")";
}
template <class T>
ostream& operator<<(ostream& os, const vector<T>& p) {
  os << "[ ";
  for (auto& it : p) os << it << " ";
  return os << "]";
}
template <class T>
ostream& operator<<(ostream& os, const set<T>& p) {
  os << "[ ";
  for (auto& it : p) os << it << " ";
  return os << "]";
}
template <class S, class T>
ostream& operator<<(ostream& os, const map<S, T>& p) {
  os << "[ ";
  for (auto& it : p) os << it << " ";
  return os << "]";
}
template <class T>
void prc(T a, T b) {
  cerr << "[";
  for (T i = a; i != b; ++i) {
    if (i != a) cerr << ", ";
    cerr << *i;
  }
  cerr << "]\n";
}
void code() {
  long long a, b, x, c, d, y;
  a = b = 0;
  cout << "? " << a << " " << b << "\n";
  fflush(stdout);
  cin >> x;
  vector<long long> v;
  for (long long i = 29; i >= 0; i--) {
    if (x != 0) {
      c = a ^ (1 << i), d = b ^ (1 << i);
      cout << "? " << c << " " << d << "\n";
      fflush(stdout);
      cin >> y;
      if (y == -x) {
        long long bit = (x == 1) ? 1 : 0;
        a = a ^ (bit << i), b = b ^ ((1 - bit) << i);
        cout << "? " << a << " " << b << "\n";
        fflush(stdout);
        cin >> x;
        continue;
      } else
        v.push_back(i);
    } else
      v.push_back(i);
    x = y;
  }
  for (auto i : v) {
    c = a ^ (0 << i), d = b ^ (1 << i);
    cout << "? " << c << " " << d << "\n";
    fflush(stdout);
    cin >> y;
    long long bit = (y == 1) ? 1 : 0;
    a = a ^ (bit << i), b = b ^ (bit << i);
  }
  cout << "! " << a << " " << b << "\n";
  fflush(stdout);
}
int main() {
  int t = 1;
  for (auto i = (1); i != (t + 1); i++) {
    code();
  }
  return 0;
}
