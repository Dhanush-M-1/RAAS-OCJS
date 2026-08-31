#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  stringstream ssx, ssy;
  for (int i = 0; i + 1 < n; i++) {
    ssx << "(";
    ssy << "(";
  }
  for (int i = 0; i < n; i++) {
    int x, y, r;
    cin >> x >> y >> r;
    ssx << "(" << x / 2 << "*((1-abs((t-" << i << ")))+abs((abs((t-" << i
        << "))-1))))" << (i > 0 ? ")" : "") << (i + 1 < n ? "+" : "");
    ssy << "(" << y / 2 << "*((1-abs((t-" << i << ")))+abs((abs((t-" << i
        << "))-1))))" << (i > 0 ? ")" : "") << (i + 1 < n ? "+" : "");
  }
  cout << ssx.str() << endl;
  cout << ssy.str() << endl;
  return 0;
}
