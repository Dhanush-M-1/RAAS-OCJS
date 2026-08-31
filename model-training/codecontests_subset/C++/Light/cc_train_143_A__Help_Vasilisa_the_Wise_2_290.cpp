#include <bits/stdc++.h>
using namespace std;
int main(void) {
  double c1, c2, r1, r2, d1, d2, i, j, k, l;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  l = (r2 - d2 + c2) / 2;
  i = d1 - l;
  k = c1 - i;
  j = d2 - k;
  if ((i >= 1 && i <= 9) && (j >= 1 && j <= 9) && (k >= 1 && k <= 9) &&
      (l >= 1 && l <= 9) && (i != j) && (i != k) && (i != l) && (j != k) &&
      (j != l) && (k != l)) {
    cout << (int)i << " " << (int)j << endl;
    cout << (int)k << " " << (int)l << endl;
  } else {
    cout << "-1" << endl;
  }
  return 0;
}
