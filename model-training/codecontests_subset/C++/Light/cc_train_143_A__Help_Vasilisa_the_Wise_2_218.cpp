#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2;
  set<int> ani;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  int a11 = (r1 + c1 - d2) / 2;
  int a22 = d1 - a11;
  int a12 = r1 - a11;
  int a21 = c1 - a11;
  ani.insert(a11);
  ani.insert(a12);
  ani.insert(a21);
  ani.insert(a22);
  if (ani.size() == 4 && a11 >= 1 && a11 <= 9 && a12 >= 1 && a12 <= 9 &&
      a21 >= 1 && a21 <= 9 && a22 >= 1 && a22 <= 9 && a21 + a22 == r2 &&
      a12 + a22 == c2 && a12 + a21 == d2) {
    cout << a11 << " " << a12 << endl;
    cout << a21 << " " << a22 << endl;
  } else
    cout << "-1" << endl;
  return 0;
}
