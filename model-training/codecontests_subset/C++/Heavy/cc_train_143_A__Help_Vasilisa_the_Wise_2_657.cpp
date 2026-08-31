#include <bits/stdc++.h>
using namespace std;
bool comp(int n) { return n > 0 && n < 10; }
bool noteq(int a, int b, int c, int d) {
  return a != b && a != c && a != d && b != c && b != d && c != d;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  int k = r1 - c2 + d1;
  if (k & 1) {
    cout << "-1";
  } else {
    int a, b, c, d;
    a = k / 2;
    b = r1 - a;
    c = c1 - a;
    d = r2 - c;
    if ((comp(a) && comp(b) && comp(c) && comp(d) && noteq(a, b, c, d)) &&
        ((a + b == r1) && (c + d == r2) && (a + c == c1) && (b + d == c2) &&
         (a + d == d1) && (b + c == d2))) {
      cout << a << " " << b << "\n" << c << " " << d;
    } else {
      cout << "-1";
    }
  }
  return 0;
}
