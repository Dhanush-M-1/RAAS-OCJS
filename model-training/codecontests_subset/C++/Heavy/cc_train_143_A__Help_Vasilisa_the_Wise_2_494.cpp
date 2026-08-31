#include <bits/stdc++.h>
using namespace std;
int r1, r2, c1, c2, d1, d2;
void fun() {
  int val1, val2, val3, val4;
  for (int i = 1; i < 10; i++) {
    val1 = i;
    val2 = r1 - val1;
    val3 = c1 - val1;
    val4 = c2 - val2;
    if (val1 == val2 || val1 == val3 || val1 == val4 || val2 == val3 ||
        val3 == val4 || val3 == val4 || val2 == val4 || val1 < 1 || val2 < 1 ||
        val3 < 1 || val4 < 1 || val1 > 9 || val2 > 9 || val3 > 9 || val4 > 9)
      continue;
    if (val1 + val2 == r1 && val1 + val3 == c1 && val1 + val4 == d1 &&
        val2 + val3 == d2 && val2 + val4 == c2 && val3 + val4 == r2) {
      cout << val1 << " " << val2 << endl << val3 << " " << val4 << endl;
      return;
    }
  }
  cout << -1 << endl;
  return;
}
int main() {
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  fun();
  return 0;
}
