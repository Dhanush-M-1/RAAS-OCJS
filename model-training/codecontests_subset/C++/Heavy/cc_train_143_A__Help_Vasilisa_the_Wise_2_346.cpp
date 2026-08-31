#include <bits/stdc++.h>
using namespace std;
void exgcd(int a, int b, int *x, int *y) {
  if (b) {
    exgcd(b, a % b, y, x);
    (*y) = (*y) - (a / b) * (*x);
  } else
    *x = 1, *y = 0;
}
int main() {
  std::ios::sync_with_stdio(false);
  double r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  double a, b, c, d;
  b = (r1 + c2 - d1) / 2.0;
  a = r1 - b;
  d = c2 - b;
  c = d2 - b;
  if ((int)a == a && (int)b == b && (int)c == c && (int)d == d && a + b == r1 &&
      c + d == r2 && a + d == d1 && c + b == d2 && a + c == c1 && b + d == c2) {
    set<int> temp;
    temp.insert(a);
    temp.insert(b);
    temp.insert(c);
    temp.insert(d);
    if (temp.size() == 4 && *(temp.begin()) > 0 && *(temp.rbegin()) < 10) {
      cout << (int)a << " " << (int)b << endl;
      cout << (int)c << " " << (int)d << endl;
    } else
      cout << -1;
  } else
    cout << -1;
}
