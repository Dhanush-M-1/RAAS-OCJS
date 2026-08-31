#include <bits/stdc++.h>
using namespace std;
int c[10];
int main() {
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  int x1, x2, x3, x4;
  x2 = (c2 - r2 + d2) / 2;
  x3 = (r2 - c2 + d2) / 2;
  x1 = r1 - x2;
  x4 = c2 - x2;
  int flag = 0;
  if (x1 + x2 == r1 && x3 + x4 == r2 && x1 + x3 == c1 && x2 + x4 == c2 &&
      x1 + x4 == d1 && x2 + x3 == d2)
    flag = 1;
  c[x1]++;
  c[x2]++;
  c[x3]++;
  c[x4]++;
  int sum = 0;
  for (int i = 1; i < 10; i++) {
    sum += c[i];
    if (c[i] > 1) flag = 0;
  }
  if (sum != 4) flag = 0;
  if (flag) {
    cout << x1 << " " << x2 << endl;
    cout << x3 << " " << x4 << endl;
  } else
    cout << -1 << endl;
  return 0;
}
