#include <bits/stdc++.h>
using namespace std;
string getFunc(int x, int y) {
  y /= 2;
  string Y = "";
  Y += y % 10 + '0';
  string X = "";
  X += x % 10 + '0';
  if (y >= 10) {
    Y += y / 10 + '0';
    swap(Y[0], Y[1]);
  }
  if (x >= 10) {
    X += x / 10 + '0';
    swap(X[0], X[1]);
  }
  return "(" + Y + "*((1-abs((t-" + X + ")))+abs((abs((t-" + X + "))-1))))";
}
int main() {
  int n, x, y, r;
  string ansX, ansY;
  while (cin >> n) {
    for (int i = int(0); i < int(n); i++) {
      cin >> x >> y >> r;
      if (i) {
        ansY = '(' + ansY + '+' + getFunc(i, y) + ')';
        ansX = '(' + ansX + '+' + getFunc(i, x) + ')';
      } else {
        ansX = getFunc(i, x);
        ansY = getFunc(i, y);
      }
    }
    cout << ansX << endl;
    cout << ansY << endl;
  }
  return 0;
}
