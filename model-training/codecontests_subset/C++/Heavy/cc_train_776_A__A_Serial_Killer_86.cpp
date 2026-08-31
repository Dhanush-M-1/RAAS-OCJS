#include <bits/stdc++.h>
using namespace std;
const int block_size = 320;
const long long mod = 1e9 + 7;
const long double eps = 1e-9;
const int inf = mod;
const double PI = atan(1) * 4;
template <typename T>
inline int sign(const T &a) {
  if (a < 0) return -1;
  if (a > 0) return 1;
  return 0;
}
template <typename T>
inline void in(T &x) {
  x = 0;
  T f = 1;
  char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (isdigit(ch)) {
    x = x * 10 + ch - '0';
    ch = getchar();
  }
  x *= f;
}
template <typename A, typename B>
inline void in(A &x, B &y) {
  in(x);
  in(y);
}
template <typename A, typename B, typename C>
inline void in(A &x, B &y, C &z) {
  in(x);
  in(y);
  in(z);
}
template <typename A, typename B, typename C, typename D>
inline void in(A &x, B &y, C &z, D &xx) {
  in(x);
  in(y);
  in(z);
  in(xx);
}
template <class T>
void upd(T &a, T &b) {
  a = max(a, b);
}
set<string> s;
void pr() {
  for (auto i : s) cout << i << ' ';
  cout << endl;
}
int main() {
  string a, b;
  cin >> a >> b;
  s.insert(a);
  s.insert(b);
  pr();
  int n;
  cin >> n;
  for (long long i = 0; i < n; i++) {
    string a, b;
    cin >> a >> b;
    s.erase(a);
    s.insert(b);
    pr();
  }
  return 0;
}
