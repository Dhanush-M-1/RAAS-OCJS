#include <bits/stdc++.h>
using namespace std;
template <typename T>
using V = vector<T>;
int gcdex(int a, int b, int &x, int &y) {
  if (a == 0) {
    x = 0;
    y = 1;
    return b;
  }
  int x1, y1;
  int g = gcdex(b % a, a, x1, y1);
  x = y1 - (b / a) * x1;
  y = x1;
  return g;
}
inline int ADD_MOD(int a, int b) { return (a + b) % 1000000007; }
inline int MUL_MOD(int a, int b) { return (int64_t(a) * b) % 1000000007; }
inline int SUB_MOD(int a, int b) { return a >= b ? a - b : a + 1000000007 - b; }
int DIV_MOD(int a, int b) {
  int x, y;
  gcdex(b, 1000000007, x, y);
  int b1 = (x % 1000000007 + 1000000007) % 1000000007;
  return MUL_MOD(a, b1);
}
const long double EPS = 1. / 1e9;
inline bool EPS_EQUAL(long double a, long double b) {
  return abs(a - b) <= EPS;
}
inline bool EPS_LESS(long double a, long double b) { return b - a > EPS; }
inline bool EPS_GREATER(long double a, long double b) { return a - b > EPS; }
const int INF = 1e9;
string brace(string s) { return "(" + s + ")"; }
string add(string a, string b) { return brace(a + "+" + b); }
string diff(string a, string b) { return brace(a + "-" + b); }
string mul(string a, string b) { return brace(a + "*" + b); }
string num(int n) {
  if (n < 0) {
    return diff("0", num(-n));
  }
  if (n > 50) {
    return add("50", num(n - 50));
  }
  return to_string(n);
}
string pmax(string a, string b) {
  return brace(add(a, b) + "+abs" + brace(diff(a, b)));
}
string pmin(string a, string b) {
  return brace(add(a, b) + "-abs" + brace(diff(a, b)));
}
string print_step(int val, int k) {
  return mul(diff(pmin(num(2 * k - 1), pmax("t", num(k - 1))), num(4 * k - 4)),
             num(val));
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.precision(15);
  int n;
  cin >> n;
  string fx, fy;
  int prevX = 0, prevY = 0;
  for (int i = 0; i < n; ++i) {
    int x, y, r;
    cin >> x >> y >> r;
    if (x % 2 != 0) {
      x += 1;
    }
    if (y % 2 != 0) {
      y += 1;
    }
    int dx = x - prevX;
    int dy = y - prevY;
    prevX = x, prevY = y;
    string stepX = print_step(dx / 2, i);
    string stepY = print_step(dy / 2, i);
    if (i > 0) {
      fx = add(fx, stepX);
      fy = add(fy, stepY);
    } else {
      fx = stepX;
      fy = stepY;
    }
  }
  cout << fx << endl;
  cout << fy << endl;
  return 0;
}
