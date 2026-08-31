#include <bits/stdc++.h>
using namespace std;
template <typename T, typename U>
ostream& operator<<(ostream& os, const pair<T, U>& _p) {
  return os << "(" << _p.first << "," << _p.second << ")";
}
template <typename T>
ostream& operator<<(ostream& os, const vector<T>& _V) {
  bool f = true;
  os << "[";
  for (auto v : _V) {
    os << (f ? "" : ",") << v;
    f = false;
  }
  return os << "]";
}
template <typename T>
ostream& operator<<(ostream& os, const set<T>& _S) {
  bool f = true;
  os << "(";
  for (auto s : _S) {
    os << (f ? "" : ",") << s;
    f = false;
  }
  return os << ")";
}
template <typename T, typename U>
ostream& operator<<(ostream& os, const map<T, U>& _M) {
  return os << set<pair<T, U>>(_M.begin(), _M.end());
}
const signed long long INF = 1000000100;
const long double EPS = 1e-9;
signed long long ax, ay, bx, by, cx, cy;
void read_data() { cin >> ax >> ay >> bx >> by >> cx >> cy; }
bool solve() {
  if (cx == 0 and cy == 0) {
    return (ax == bx and ay == by);
  }
  signed long long det = cx * cx + cy * cy;
  signed long long d1 = bx - ax;
  signed long long d2 = by - ay;
  signed long long det_p = d1 * cx + d2 * cy;
  signed long long det_q = d2 * cx - d1 * cy;
  return (det_p % det == 0) and (det_q % det == 0);
}
int main() {
  read_data();
  bool ok = false;
  for (int(_) = (1); (_) <= (4); (_)++) {
    signed long long nx = -ay;
    signed long long ny = ax;
    ax = nx;
    ay = ny;
    ok |= solve();
  }
  cout << (ok ? "YES" : "NO") << endl;
}
